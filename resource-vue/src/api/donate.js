import request from '../utils/request';


/**
 * 获取所有爱心捐赠,包括条件查询接口
 * @param query
 * @returns {AxiosPromise}
 */
export const getDonateInfo = query =>{
    return request({
        url:'/common/donate/getDonateInfo',
        method:'get',
        params:query
    })
};
/**
 * 保存爱心捐赠接口
 * @param data
 * @returns {AxiosPromise}
 */
export const saveDonateInfo = data =>{
    return request({
        url:'/common/donate/saveDonateInfo',
        method:'post',
        data
    })
};
/**
 * 更新爱心捐赠接口
 * @param data
 * @returns {AxiosPromise}
 */
export const updateDonateInfo = data =>{
    return request({
        url:'/common/donate/updateDonateInfo',
        method:'put',
        data
    })
};
/**
 *根据id删除爱心捐赠接口
 * @param id
 * @returns {AxiosPromise}
 */
export const delDonateInfo = id =>{
    return request({
        url:'/common/donate/delDonateInfo',
        method:'delete',
        params:{id:id}
    })
};
/**
 * 根据id集合批量删除爱心捐赠接口
 * @param id
 * @returns {AxiosPromise}
 */
export const delBatchDonateInfo = id =>{
    return request({
        url:'/common/donate/delBatchDonateInfo',
        method:'delete',
        params:{idList:id}
    })
};


