import { request,request2 } from "./request";

export function userinformation(){//路由拦截
  let token = sessionStorage.getItem("token")
  if(token){
    return true
  }
  return false
}

export function login(obj) {//登录
    return request({
      url: `/loginp`,
      data:obj,
      method:"post"
    });
  }
  export function regist(obj) {//注册
    return request({
      url: `/add`,
      data:obj,
      method:"post"
    });
  }
export function alluser(){//管理员查询所有用户
    return request({
      url:`/secure/findinfomation`,
      method:"post"
    })

}
export function mation(id){//个人信息
  return request({
    url:`/secure/findpermation?id=${id}`,
    method:"post"
  })

}
export function code(obj){//获取验证码
  return request2({
    url:"/lundroid/smsSend",
    params:obj,
    method:"get"
  })
}
