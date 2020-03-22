import {Vue} from "vue-property-decorator";
import IceButtonComponent from "./ice-button-component/ice-button-component.vue";
import IceInputComponent from "./ice-input-component/ice-input-component.vue";
import IceDropdownComponent from "./ice-dropdown-component/ice-dropdown-component.vue";
export const IceComponentModule:any={
  install:function(vue:Vue){
      (vue as any).prototype.$pageLoading=true;
      const v: any = (window as any).Vue || Vue;
      v.component("cmIce-btn",IceButtonComponent);
      v.component("cmIce-input",IceInputComponent);
      v.component("cmIce-dropdown",IceDropdownComponent);
  }
};

export {
    IceButtonComponent,
    IceInputComponent
}