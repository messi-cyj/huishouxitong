import request from '../utils/request';


/**
 * 获取所有字典管理,包括条件查询接口
 * @param query
 * @returns {AxiosPromise}
 */
export const getDictionaryInfo = query =>{
    return request({
        url:'/common/dictionary/getDictionaryInfo',
        method:'get',
        params:query
    })
};
/**
 * 保存字典管理接口
 * @param data
 * @returns {AxiosPromise}
 */
export const saveDictionaryInfo = data =>{
    return request({
        url:'/common/dictionary/saveDictionaryInfo',
        method:'post',
        data
    })
};
/**
 * 更新字典管理接口
 * @param data
 * @returns {AxiosPromise}
 */
export const updateDictionaryInfo = data =>{
    return request({
        url:'/common/dictionary/updateDictionaryInfo',
        method:'put',
        data
    })
};
/**
 *根据id删除字典管理接口
 * @param id
 * @returns {AxiosPromise}
 */
export const delDictionaryInfo = id =>{
    return request({
        url:'/common/dictionary/delDictionaryInfo',
        method:'delete',
        params:{id:id}
    })
};
/**
 * 根据id集合批量删除字典管理接口
 * @param id
 * @returns {AxiosPromise}
 */
export const delBatchDictionaryInfo = id =>{
    return request({
        url:'/common/dictionary/delBatchDictionaryInfo',
        method:'delete',
        params:{idList:id}
    })
};


