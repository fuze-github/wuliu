import axios from "axios";
export function request(obj) {
  const instance = axios.create({
    baseURL: "http://39.103.163.45:8080",
    timeout: 5000,
    headers: { authorization: `Bearer ${sessionStorage.getItem("token")}` },
  });
  return instance(obj);
}

export function request2(obj) {
  const instance = axios.create({
    baseURL: "https://jnlzsms.market.alicloudapi.com",
    timeout: 5000,
    headers: { Authorization: "APPCODE 5524712919504fb8a6980f4eb45471b9" },
  });
  return instance(obj);
}
