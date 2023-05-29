package com.lk.modules.service;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lk.modules.entity.Sort;

/**
 * sort
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
public interface SortService extends IService<Sort>{

    PageInfo<Sort> selectSortInfo(Sort sort, Integer pageNum, Integer pageSize);

    void saveSortInfo(Sort sort);

    void updateSortInfo(Sort sort);

    void delSortInfo(Integer id);

    void delBatchSortInfo(String idList);


}