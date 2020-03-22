import {merge, Subject, of, fromEvent, Observable} from "rxjs";
import {map, throttleTime} from "rxjs/operators";

export interface MediaRef {
    mobile: boolean;
    mediaWidth: number;
}

const mobileWidth = 1000;

const html: HTMLElement | null = document.querySelector("html");

const isMobile = (w: number): boolean => w < mobileWidth;
const getWidth = (): number | undefined => {
    console.debug("getWidth");
    return html?.offsetWidth;
};
const getMediaRef = (): MediaRef => {
    const w = getWidth();
    return {
        mediaWidth: w || 0,
        mobile: w ? isMobile(w) : false
    }
};

export const mediaObserver: Observable<MediaRef> = merge(
    of(getMediaRef()),
    fromEvent(window, "resize").pipe(
        throttleTime(200),
        map(() => getMediaRef())
    )
);