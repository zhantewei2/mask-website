import Vue from "vue";
import {BtnLoadRef} from "./ice";

declare module "vue/types/vue" {
    interface Vue {
        $iceBtnLoad: () => BtnLoadRef;
        $visitImage: (image: string) => void;
    }
}