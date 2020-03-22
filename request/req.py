import requests as req
from hostMain import Req


# result=req.post(f"{HOST_MAIN}/addition/sendMail")
#
def getShopClassList():
    Req("get","manage/queryShopClass")

def insertShopClass():
    Req("post","manage/m/insertShopClass",json={
        "name":"1234"
    })

def updateShopClass():
    Req("post","manage/m/updateShopClass",json={
        "id":1,
        "name":"testOne",
        "enabled":1
    })

def insertShop():
    Req("post","shop/m/insertShop",json={
        "name":"shopName",
        "img":"img1",
        "vestIn":0,
        "imgs":"img2,img3"
    })

def updateShop():
    Req("post","shop/m/updateShop",json={
        "id":"15845481263198500",
        "body":{
            "name":"image1"
        }
    })
def queryShop():
    Req("post","shop/queryShop",json={
        "currentPage":1,
        "pageSize":10
    })
# getShopClassList()
# insertShopClass()
# updateShopClass()

# insertShop()
# updateShop()

queryShop()
