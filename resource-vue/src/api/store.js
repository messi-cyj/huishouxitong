import request from '../utils/request';


/**
 * 获取所有仓库信息,包括条件查询接口
 * @param query
 * @returns {AxiosPromise}
 */
export const getStoreInfo = query =>{
    return request({
        url:'/common/store/getStoreInfo',
        method:'get',
        params:query
    })
};
/**
 * 保存仓库信息接口
 * @param data
 * @returns {AxiosPromise}
 */
export const saveStoreInfo = data =>{
    return request({
        url:'/common/store/saveStoreInfo',
        method:'post',
        data
    })
};
/**
 * 更新仓库信息接口
 * @param data
 * @returns {AxiosPromise}
 */
export const updateStoreInfo = data =>{
    return request({
        url:'/common/store/updateStoreInfo',
        method:'put',
        data
    })
};
/**
 *根据id删除仓库信息接口
 * @param id
 * @returns {AxiosPromise}
 */
export const delStoreInfo = id =>{
    return request({
        url:'/common/store/delStoreInfo',
        method:'delete',
        params:{id:id}
    })
};
/**
 * 根据id集合批量删除仓库信息接口
 * @param id
 * @returns {AxiosPromise}
 */
export const delBatchStoreInfo = id =>{
    return request({
        url:'/common/store/delBatchStoreInfo',
        method:'delete',
        params:{idList:id}
    })
};


