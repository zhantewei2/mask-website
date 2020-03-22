import Vue from 'vue'
import Vuex from 'vuex'
import user from "./user/user.store";
import common from "./common/common.store";

Vue.use(Vuex);

const store= new Vuex.Store({
  state: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    user,
    common
  }
});

(window as any).vueStore=store;
export default store;