import {NzxAnimation} from "ztwx-fire-ui/utils";
import Vue, {PluginObject} from "vue";
import {showImageDirective} from "./show-image.directive";

export class ShowImage {
    imgWrapper: HTMLElement;
    isShow: boolean = false;
    isClosing: boolean = false;
    nzxAnimation: NzxAnimation;

    show(imageData: string) {
        if (!this.imgWrapper) {
            this.imgWrapper = document.createElement("div");
            this.nzxAnimation = new NzxAnimation(this.imgWrapper, "show-image-transition");
            this.imgWrapper.addEventListener("click", (e: any) => {
                if (e.showImgStopPropagination) return;
                this.close();
            })
        }
        if (!this.isShow) document.documentElement.appendChild(this.imgWrapper);

        this.imgWrapper.className = "show-image-bg";
        this.imgWrapper.innerHTML = `
        <div class="container">
            <div class="close">
                <i class="fa fa-close"></i>        
            </div>
            <img src="${imageData}"/>
        </div>
        `;
        const closeEl: HTMLElement | null = this.imgWrapper.querySelector(".close");
        const containerEl: HTMLElement | null = this.imgWrapper.querySelector(".container");
        containerEl && containerEl.addEventListener("click", (e: any) => e.showImgStopPropagination = true);
        closeEl && closeEl.addEventListener("click", (e: any) => {
            e.showImgStopPropagination = true;
            this.close();
        });
        this.isShow = true;
    }

    close() {

        if (!this.imgWrapper || !this.isShow || this.isClosing) return;
        this.isClosing = true;
     
        this.nzxAnimation.leave("image-bg-leave", null, () => {
            this.isClosing = this.isShow = false;
        })
    }
}

export const ShowImagePlugin: PluginObject<any> = {
    install: function (vue: typeof Vue, v: any): void {
        const showImage = new ShowImage();
        vue.prototype.$visitImage = (img: string) => showImage.show(img);
        vue.directive("show-image", showImageDirective(showImage));
    }
};