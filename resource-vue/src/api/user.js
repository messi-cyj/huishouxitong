import request from '../utils/request';

/**
 * 登录接口
 * @param query
 * @returns {AxiosPromise}
 */
export const Login = query =>{
    return request({
        url:'/common/user/login',
        method:'post',
        params:query
    })
};

/**
 * 获取所有用户信息,包括条件查询接口
 * @param query
 * @returns {AxiosPromise}
 */
export const getUserInfo = query =>{
    return request({
        url:'/common/user/getUserInfo',
        method:'get',
        params:query
    })
};
/**
 * 保存用户信息接口
 * @param data
 * @returns {AxiosPromise}
 */
export const saveUserInfo = data =>{
    return request({
        url:'/common/user/saveUserInfo',
        method:'post',
        data
    })
};
/**
 * 更新用户信息接口
 * @param data
 * @returns {AxiosPromise}
 */
export const updateUserInfo = data =>{
    return request({
        url:'/common/user/updateUserInfo',
        method:'put',
        data
    })
};
/**
 *根据id删除用户信息接口
 * @param id
 * @returns {AxiosPromise}
 */
export const delUserInfo = id =>{
    return request({
        url:'/common/user/delUserInfo',
        method:'delete',
        params:{id:id}
    })
};
/**
 * 根据id集合批量删除用户信息接口
 * @param id
 * @returns {AxiosPromise}
 */
export const delBatchUserInfo = id =>{
    return request({
        url:'/common/user/delBatchUserInfo',
        method:'delete',
        params:{idList:id}
    })
};


