package com.lk.modules.service;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lk.modules.entity.Life;

/**
 * life
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
public interface LifeService extends IService<Life>{

    PageInfo<Life> selectLifeInfo(Life life, Integer pageNum, Integer pageSize);

    void saveLifeInfo(Life life);

    void updateLifeInfo(Life life);

    void delLifeInfo(Integer id);

    void delBatchLifeInfo(String idList);


}