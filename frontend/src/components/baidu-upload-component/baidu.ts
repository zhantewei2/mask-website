const baidubce: any = (window as any).baidubce;

let client: any;
let bucket: any;

export const upload = (filename: string, blob: any) => {
    if (!client) {
        const config = {
            endpoint: "http://su.bcebos.com",
            credentials: {
                ak: "31f52722a1a945f4861f3ce7896bce00",
                sk: "f0673403fbfa4014944b2ed06bcfe0ba"
            }
        };
        bucket = "h-pc-static-test";
        client = new baidubce.sdk.BosClient(config);
    }


    return client.putObjectFromBlob(bucket, filename, blob, {
        "Content-Type": "image/jpeg"
    }).then(() => `https://su.bcebos.com/v1/${bucket}/${filename}`)
};



