import request from '../utils/request';

/**
 * 获取所有员工列表信息,包括条件查询接口
 * @param data
 * @returns {AxiosPromise}
 */
export const getStaffList = (data) => {
    return request({
        url: '/common/staff/getStaffList',
        method: 'post',
        data
    });
};
/**
 * 保存员工信息接口
 * @param data
 * @returns {AxiosPromise}
 */
export const saveStaff = (data) => {
    return request({
        url: '/common/staff/saveStaff',
        method: 'post',
        data
    });
};
/**
 * 更新员工信息接口
 * @param data
 * @returns {AxiosPromise}
 */
export const updateStaff = (data) => {
    return request({
        url: '/common/staff/updateStaff',
        method: 'put',
        data
    });
};
/**
 *根据id删除员工信息接口
 * @param id
 * @returns {AxiosPromise}
 */
export const deleteStaff = (id) => {
    return request({
        url: '/common/staff/deleteStaff',
        method: 'delete',
        params: { id: id }
    });
};
/**
 * 根据id获取员工信息详情
 * @param {*} id 
 * @returns 
 */
export const getStaffDetails = (id) => {
    return request({
        url: '/common/staff/getStaffDetails',
        method: 'get',
        params: { id: id }
    });
};
