import Vue from 'vue'
import Vuex, {Module} from 'vuex'
import {typeData} from "../NavData";
import {shopClassify} from "../ShopClassify";
Vue.use(Vuex);

export interface State {
    navLabel: string[];
    listType: string[];
    listId: string;
    listName:string;
}

const commonStore: Module<State, any> = {
    state: {
        navLabel: [],
        listType: [],
        listId: "",
        listName:""
    },
    mutations: {
        saveNav(state: State, p: any) {
            window.scrollTo(0,0);
            Object.assign(state, p);
        }
    },
    actions: {
        navList({commit}, navId: any) {
            const typeItem: any = shopClassify.classList.find((i: any) => i.id === navId);
            if (!typeItem) return;
            //
            commit("saveNav", {
                listId: navId,
                listTypes: typeItem.types,
                navLabel: typeItem.navLabel,
                listName:typeItem.name
            })
        },
        href(){}
    },
    modules: {}
};


const store = new Vuex.Store(commonStore);

(window as any).vueStore = store;
export default store;