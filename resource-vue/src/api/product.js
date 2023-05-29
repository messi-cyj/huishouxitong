import request from '../utils/request';


/**
 * 获取所有回收物,包括条件查询接口
 * @param query
 * @returns {AxiosPromise}
 */
export const getProductInfo = query =>{
    return request({
        url:'/common/product/getProductInfo',
        method:'get',
        params:query
    })
};
/**
 * 保存回收物接口
 * @param data
 * @returns {AxiosPromise}
 */
export const saveProductInfo = data =>{
    return request({
        url:'/common/product/saveProductInfo',
        method:'post',
        data
    })
};
/**
 * 更新回收物接口
 * @param data
 * @returns {AxiosPromise}
 */
export const updateProductInfo = data =>{
    return request({
        url:'/common/product/updateProductInfo',
        method:'put',
        data
    })
};
/**
 *根据id删除回收物接口
 * @param id
 * @returns {AxiosPromise}
 */
export const delProductInfo = id =>{
    return request({
        url:'/common/product/delProductInfo',
        method:'delete',
        params:{id:id}
    })
};
/**
 * 根据id集合批量删除回收物接口
 * @param id
 * @returns {AxiosPromise}
 */
export const delBatchProductInfo = id =>{
    return request({
        url:'/common/product/delBatchProductInfo',
        method:'delete',
        params:{idList:id}
    })
};


