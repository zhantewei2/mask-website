import {http} from "@ztwx/http";
import {ticketKey, requestHost} from "@config";

http.setHost(requestHost);
http.setTicketKey(ticketKey);


http.setAfterHandler(({status, content}, retry: any) => new Promise<any>((resolve, reject) => {
    try {
        let result: any;
        try {
            result = JSON.parse(content);
        } catch (e) {
            result = content;
        }
        if (status != 200) {
            //登录过期
            if (status == 400 && result.type == 2) {
                const win: any = window;
                win.vueStore && win.vueStore.dispatch("user/logExpired");
            }
            reject(content);
        } else {
            resolve(result)
        }
    } catch (e) {
        reject(e && e.toString());
    }
}));
export {
    http
}
