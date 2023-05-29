import request from '../utils/request';


/**
 * 获取所有通知信息,包括条件查询接口
 * @param query
 * @returns {AxiosPromise}
 */
export const getNoticeInfo = query =>{
    return request({
        url:'/common/notice/getNoticeInfo',
        method:'get',
        params:query
    })
};
/**
 * 保存通知信息接口
 * @param data
 * @returns {AxiosPromise}
 */
export const saveNoticeInfo = data =>{
    return request({
        url:'/common/notice/saveNoticeInfo',
        method:'post',
        data
    })
};
/**
 * 更新通知信息接口
 * @param data
 * @returns {AxiosPromise}
 */
export const updateNoticeInfo = data =>{
    return request({
        url:'/common/notice/updateNoticeInfo',
        method:'put',
        data
    })
};
/**
 *根据id删除通知信息接口
 * @param id
 * @returns {AxiosPromise}
 */
export const delNoticeInfo = id =>{
    return request({
        url:'/common/notice/delNoticeInfo',
        method:'delete',
        params:{id:id}
    })
};
/**
 * 根据id集合批量删除通知信息接口
 * @param id
 * @returns {AxiosPromise}
 */
export const delBatchNoticeInfo = id =>{
    return request({
        url:'/common/notice/delBatchNoticeInfo',
        method:'delete',
        params:{idList:id}
    })
};


