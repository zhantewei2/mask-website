import {Vue,Component} from "vue-property-decorator";
import {mapState,mapActions} from "vuex";
@Component({
    render:function(h:any){
        const self:any=this;
        return (
        <cmIce-dropdown triggerType="click">
            <div class="core-header-avatar ">
                <i class="za za-user"></i>
            </div>
            <main slot="dropdown" class="yo-header-dropdown-main" >
                <div class="ice-line between core-header-dropdown-content" style={{padding:"2rem"}}>
                    <div class="ice-avatar medium">
                        <i class="fa fa-user"></i>
                    </div>
                    <div>
                        <div class="_name">{self.name}</div>
                        <div class="_position">{self.positionName}</div>
                    </div>
                </div>

                <div class="ice-line between" v-cm-ripple>
                    <i class="fa fa-changeKey"></i>
                    <b>修改密码</b>
                </div>
                <div onclick={self.exit} class="ice-line between" v-cm-ripple>
                    <i class="fa fa-exit"></i>
                    <b>退出</b>
                </div>
            </main>
        </cmIce-dropdown>
    )
    },
    computed:{
        ...mapState({
            "name":(state:any)=>state.user.name,
            "positionName":(state:any)=>state.user.positionName,
        })
    }
})
export class UserHeader extends Vue{
    username:string;
    positionName:string;
    created(){
    }
    exit(){
        this.$confirm("确认退出登录?","提示",{
            confirmButtonText:"确定",
            cancelButtonText:"取消",
            type:"info"
        }).then(()=>{
            this.$store.dispatch("user/logout");
        });
    }

}