import request from '../utils/request';


/**
 * 获取所有生活服务,包括条件查询接口
 * @param query
 * @returns {AxiosPromise}
 */
export const getLifeInfo = query =>{
    return request({
        url:'/common/life/getLifeInfo',
        method:'get',
        params:query
    })
};
/**
 * 保存生活服务接口
 * @param data
 * @returns {AxiosPromise}
 */
export const saveLifeInfo = data =>{
    return request({
        url:'/common/life/saveLifeInfo',
        method:'post',
        data
    })
};
/**
 * 更新生活服务接口
 * @param data
 * @returns {AxiosPromise}
 */
export const updateLifeInfo = data =>{
    return request({
        url:'/common/life/updateLifeInfo',
        method:'put',
        data
    })
};
/**
 *根据id删除生活服务接口
 * @param id
 * @returns {AxiosPromise}
 */
export const delLifeInfo = id =>{
    return request({
        url:'/common/life/delLifeInfo',
        method:'delete',
        params:{id:id}
    })
};
/**
 * 根据id集合批量删除生活服务接口
 * @param id
 * @returns {AxiosPromise}
 */
export const delBatchLifeInfo = id =>{
    return request({
        url:'/common/life/delBatchLifeInfo',
        method:'delete',
        params:{idList:id}
    })
};


