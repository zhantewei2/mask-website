import {findClassList} from "@/requests/manage/manage.requests";
import {queryAllInfo} from "@/requests/shop/shop-base.request";

export interface ShopNavItem{
    href?:string;
    type?:"nav"|"carousel";
    toOrder:number;
    img?:string;
    id:number;
    name:string;
}


export interface NavDataItem{
    id:number;
    name:string;
    main:number;
    toOrder?:number;
    parentClass?:number;
    parentClassRef?:NavDataItem;
    children?:NavDataItem[];
    types:number[];  //对应的 id,子类为自己，父类为其下所有子类,
    href?:string;
}

export class ShopClassify{
    beforeNavData:NavDataItem[]=[{name:"Home",href:"/",main:0,id:0,types:[]}];
    afterNavData:NavDataItem[]=[{name: "Contact Us", href: "/concatUs",main:0,id:1,types:[]}];

    loaded:boolean=false;
    classList:any[]=[];
    _navData:NavDataItem[]=[];
    homeCarouselList:ShopNavItem[]=[];
    homeNavList:ShopNavItem[]=[];
    baseDict:Record<string,string>={};
    get navData(){
        return this.beforeNavData.concat(this._navData).concat(this.afterNavData);
    }
    set navData(v:NavDataItem[]){
        this._navData=v;
    }
    dictData:{[key:string]:NavDataItem}={};

    canEnter(cb:(err:boolean,data:NavDataItem[])=>void){
        if(this.loaded)return cb(true,this.classList);
        this.getClassify(cb);
    }

    getClassify(cb:(err:boolean,data:NavDataItem[])=>void){
        queryAllInfo().subscribe((res:any)=>{
            this.loaded=true;
            this.classList=res.shopClassList;
            this.getNavData(this.classList);
            this.handleList(this.classList);
            this.switchNavItem(res.shopHomeNavItemList);
            this.keyValueToDict(res.keyValueList);
            cb(false,this.classList);
        },()=>{
            this.loaded=false;
            cb(true,[])
        });
    }
    switchNavItem(list:ShopNavItem[]){
        this.homeCarouselList=[];
        this.homeNavList=[];
        list.forEach((i:ShopNavItem)=>{
            if(i.type==="nav"){
                this.homeNavList.push(i)
            }else if(i.type==="carousel"){
                this.homeCarouselList.push(i);
            }
        });
        this.homeCarouselList.sort((pre,next)=>pre.toOrder-next.toOrder);
        this.homeNavList.sort((pre,next)=>pre.toOrder-next.toOrder);
    }


    keyValueToDict(keyValueList:any[]){
        for(let i of keyValueList){
            this.baseDict[i.k]=i.v;
        }
    }


    handleList(list:any){
        this.getNavData(list);
        this.getNameDict(list);
    }
    getNameDict(list:any[]){
        const dict:{[key:string]:NavDataItem}={};
        list.forEach((i)=>{
            dict[i.name]=i;
        });
        this.dictData=dict;
    }

    getNavData(list:any[]){
        /**
         * to nav List
         */
        const navData:any[]=[];
        list.forEach(i=>{
            if(i.main){
                i.children=[];
                i.types=[];
                navData.push(i);
            }
        });
        navData.sort((pre,next)=>pre.toOrder-next.toOrder);
        let parentItem:any;
        list.forEach(i=>{
            if(!i.main){
                i.types=[i.id];
                parentItem=list.find(parent=>parent.id==i.parentClass);
                if(!parentItem)return;
                parentItem.children.push(i);
                parentItem.types.push(i.id);
            }
        });
        //auto sort children;
        navData.forEach(i=>{
            i.children.sort();
        });
        this.navData=navData;
    }
}
export const shopClassify=new ShopClassify();