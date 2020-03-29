import {http} from "ztwx-fire-ui/http";
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
            if (status == 400) {
                const vueStore:any=(window as any).vueStore;
                if(result.type==2){
                    vueStore&&vueStore.dispatch("user/logExpired");
                }
                if(result.type==201){
                    vueStore&&vueStore.dispatch("err","已存在");
                }
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