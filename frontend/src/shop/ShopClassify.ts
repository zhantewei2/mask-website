import {findClassList} from "@/requests/manage/manage.requests";

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
        findClassList().subscribe((list:any[])=>{
            this.loaded=true;
            this.classList=list;
            this.getNavData(list);
            this.handleList(list);
            cb(false,list);
        },()=>{
            this.loaded=false;
            cb(true,[])
        })
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