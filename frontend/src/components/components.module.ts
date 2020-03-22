import Vue from "vue";
import Cell from "./cell-component/cell-component.vue";
import Row from "./row-component/row-component.vue";
import Content from "./content-component/content-component.vue";
import Label from "./label-component/label-component.vue";
import Aside from "./card-aside-component/card-aside-component.vue";
import PaginationTablePackage from "./table-package-for-el-component/pagination-table-package";
import MiniLoader from "./mini-loader-component/mini-loader-component.vue";
import From from "./form-component/form-component.vue";
import {formControlDirective} from "./form-component/form-control.directive";
import BaiduUpload from "./baidu-upload-component/baidu-upload-component.vue";
import {ShowImagePlugin} from "./showImage-plugin/showImage.plugin";

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


Vue.component("baidu-upload", BaiduUpload);
