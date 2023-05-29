import axios from 'axios';

const service = axios.create({
    //本地
   // baseURL: 'http://39.99.158.36:15465/api',
    baseURL: 'http://127.0.0.1:9000',
    //47服务器
    // baseURL: 'http://47.103.39.109:15465/api',
    // baseURL:'http://47.111.21.35:8082/api',
    timeout: 5000
});
service.interceptors.request.use(
    config => {
        if (sessionStorage.getItem('Authorization')) {
            config.headers.Authorization = sessionStorage.getItem('Authorization');
        }
        return config;
    },
    error => {
        console.log(error);
        return Promise.reject();
    }
);

service.interceptors.response.use(
    response => {
        if (response.status === 200) {
            return response.data;
        } else {
            Promise.reject();
        }
    },
    error => {
        console.log(error);
        return Promise.reject();
    }
);

export default service;
