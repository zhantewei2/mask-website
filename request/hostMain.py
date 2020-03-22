import requests as req

HOST_MAIN="http://localhost:8806"


def Req(method,path,**kwargs):
    method=getattr(req,method)
    result=method(f"{HOST_MAIN}/{path}",**kwargs)
    print("statusCode: ",result.status_code)
    print("content: ",result.content)