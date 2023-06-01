import request from '../utils/request';

/**
 * 获取所有车辆列表信息,包括条件查询接口
 * @param data
 * @returns {AxiosPromise}
 */
export const getCarList = (data) => {
    return request({
        url: '/common/car/getCarList',
        method: 'post',
        data
    });
};
/**
 * 保存车辆信息接口
 * @param data
 * @returns {AxiosPromise}
 */
export const saveCar = (data) => {
    return request({
        url: '/common/car/saveCar',
        method: 'post',
        data
    });
};
/**
 * 更新车辆信息接口
 * @param data
 * @returns {AxiosPromise}
 */
export const updateCar = (data) => {
    return request({
        url: '/common/car/updateCar',
        method: 'put',
        data
    });
};
/**
 *根据id删除车辆信息接口
 * @param id
 * @returns {AxiosPromise}
 */
export const deleteCar = (id) => {
    return request({
        url: '/common/car/deleteCar',
        method: 'delete',
        params: { id: id }
    });
};
/**
 * 根据id获取车辆信息详情
 * @param {*} id 
 * @returns 
 */
export const getCarDetails = (id) => {
    return request({
        url: '/common/car/getCarDetails',
        method: 'get',
        params: { id: id }
    });
};
