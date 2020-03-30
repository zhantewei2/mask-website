import {DirectiveBinding} from "vue/types/options";
import {VNode} from "vue";

export const showImageDirective = (showImage: any) => ({
    bind(el: HTMLElement, binding: DirectiveBinding, vnode: VNode) {
        const wrapper = el;
        const cover = document.createElement("div");
        wrapper.classList.add("show-image-wrapper");
        cover.className = "show-image-cover";
        cover.innerHTML = `
        <i class="fa fa-search"></i>
        `;


        cover.addEventListener("click", () => {
            const img: any = el.querySelector("img");
            img&&showImage.show(img.src);
        });


        el.addEventListener("mouseenter", () => {
            wrapper.appendChild(cover);
        });
        el.addEventListener("mouseleave", () => {
            wrapper.removeChild(cover);
        })
    }
});