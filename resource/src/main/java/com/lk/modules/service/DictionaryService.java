package com.lk.modules.service;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lk.modules.entity.Dictionary;

/**
 * dictionary
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
public interface DictionaryService extends IService<Dictionary>{

    PageInfo<Dictionary> selectDictionaryInfo(Dictionary dictionary, Integer pageNum, Integer pageSize);

    void saveDictionaryInfo(Dictionary dictionary);

    void updateDictionaryInfo(Dictionary dictionary);

    void delDictionaryInfo(Integer id);

    void delBatchDictionaryInfo(String idList);


}