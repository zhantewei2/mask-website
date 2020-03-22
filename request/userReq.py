from hostMain import Req

headers={
    "ztwx-ticket": "c8aaac9a29779e790fad959fe0f66dc917ff62e440a74f881cf4789115b52b3a1ec6f0d046f94489144a64b50ebba287"
}


def registerUser():
    Req("post","/manage/registerUser",json={
        "name":"admin",
        "account":"admin",
        "password":"admin123"
    })

def loginUser():
    Req("post","/manage/login",json={
        "username":"admin",
        "password":"admin123"
    })


def loginFromTicket():
    Req("post","/manage/m/loginFromTicket",headers=headers)
# registerUser()
# loginUser()

loginFromTicket()