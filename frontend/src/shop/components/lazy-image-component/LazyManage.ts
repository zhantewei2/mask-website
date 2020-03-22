import {fromEvent, merge, Observable, of} from "rxjs";
import {map, throttleTime} from "rxjs/operators";

export class LazyManage {
    body: HTMLElement = document.body;

    getTop(el: any, top: number = 0): any {
        if (el === this.body) return top;
        top += el.offsetTop;
        if (el.offsetParent) return this.getTop(el.offsetParent, top);
    }

    windowScroller: Observable<{
        scrollTop: number,
        scrollBottom: number
    }>;

    constructor() {
        let scrollTop: number;
        let scrollBottom: number;
        const cal = () => {
            scrollTop = document.documentElement.scrollTop;
            if (scrollTop === undefined) scrollTop = this.body.scrollTop;
            scrollBottom = scrollTop + window.innerHeight;
            return {scrollTop, scrollBottom}
        };
        this.windowScroller =
            merge(
                of(cal()),
                fromEvent(window, "scroll")
                    .pipe(
                        map(() => cal())
                    ),
                fromEvent(window, "resize")
                    .pipe(
                        throttleTime(100),
                        map(() => cal())
                    )
            )

    }


}