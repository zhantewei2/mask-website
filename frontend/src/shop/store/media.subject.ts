import {merge, Subject, of, fromEvent, Observable} from "rxjs";
import {debounce, map, throttleTime,debounceTime} from "rxjs/operators";

export interface MediaRef {
    mobile: boolean;
    mediaWidth: number;
}

const mobileWidth = 1000;

const html: HTMLElement | null = document.querySelector("html");
let currentMediaRef:MediaRef={
    mobile:false,
    mediaWidth:0
};
const isMobile = (w: number): boolean => w < mobileWidth;
const getWidth = (): number | undefined => {
    return html?.offsetWidth;
};
const getMediaRef = (): MediaRef => {
    const w = getWidth();
    currentMediaRef.mediaWidth=getWidth()||0;
    currentMediaRef.mobile=isMobile(currentMediaRef.mediaWidth);
    return currentMediaRef;
};

export const mediaObserver: Observable<MediaRef> = merge(
    of(getMediaRef()),
    fromEvent(window, "resize").pipe(
        map(() => getMediaRef())
    )
);