import Vue from "vue";
import Cell from "../components/cell-component/cell-component.vue";
import Row from "../components/row-component/row-component.vue";
import Content from "../components/content-component/content-component.vue";
import Label from "../components/label-component/label-component.vue";
import Aside from "../components/card-aside-component/card-aside-component.vue";
import PaginationTablePackage from "../components/table-package-for-el-component/pagination-table-package";
import MiniLoader from "../components/mini-loader-component/mini-loader-component.vue";
import From from "../components/form-component/form-component.vue";
import {formControlDirective} from "../components/form-component/form-control.directive";
import {ShowImagePlugin} from "../components/showImage-plugin/showImage.plugin";
import ShopItem from "./components/shop-item-component/shop-item-component.vue";
import LazyImage from "./components/lazy-image-component/lazy-image-component.vue";
import ShopItd from "./components/itd-component/itd-component.vue";
import SvgLoader from "../components/svg-loader-component/svg-loader-component.vue";

Vue.use(ShowImagePlugin);

Vue.component("Row", Row);
Vue.component("Value", Content);
Vue.component("Label", Label);
Vue.component("Cell", Cell);
Vue.component("Aside", Aside);
Vue.component("Table", PaginationTablePackage);
Vue.component("yo-mini-loader", MiniLoader);

Vue.component("Form", From);
Vue.directive("form-controller", formControlDirective);

Vue.component("shop-item", ShopItem);
Vue.component("lazy-image", LazyImage);
Vue.component("shop-itd", ShopItd);
Vue.component("svg-loader", SvgLoader);