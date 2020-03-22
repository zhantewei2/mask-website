import Vue from 'vue'
import Vuex, {Module} from 'vuex'
import {typeData} from "../NavData";

Vue.use(Vuex);

export interface State {
    navLabel: string[];
    listType: string[];
    listId: string;
}

const commonStore: Module<State, any> = {
    state: {
        navLabel: [],
        listType: [],
        listId: ""
    },
    mutations: {
        saveNav(state: State, p: any) {
            Object.assign(state, p);
        }
    },
    actions: {
        navList({commit}, navId: any) {
            const typeItem: any = typeData.find((i: any) => i.id === "navId");
            if (!typeItem) return;

            commit("saveNav", {
                listId: navId,
                listTypes: typeItem.types,
                navLabel: typeItem.navLabel
            })
        }
    },
    modules: {}
};


const store = new Vuex.Store(commonStore);

(window as any).vueStore = store;
export default store;