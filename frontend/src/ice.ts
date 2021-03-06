import Vue from "vue";

import {
    IceContainerModule,
    FireContainerModule,
    dataFactory,
    NavListItem,
    IceComponentModule,
    IceBtnLoadingModule,BtnLoadRef,
    IceInnerRouterModule,
    IceInnerRouterPlugin,
    CacheComponentRef
} from "@condyyobeta/fire-ui";

// import "ztwx-fire-ui/src/ztwComponents/styles/index.scss";
window.Vue=Vue;
Vue.use(FireContainerModule);
Vue.use(IceContainerModule);
Vue.use(IceComponentModule);
Vue.use(IceBtnLoadingModule);

/**
 *
 */
const iceInnerRouterPlugin=new IceInnerRouterPlugin({
    history:false,
    visitByUrl:false
});
Vue.use(IceInnerRouterModule([
    iceInnerRouterPlugin
]));


export {
    dataFactory,
    NavListItem,
    BtnLoadRef,
    iceInnerRouterPlugin,
    CacheComponentRef
}
