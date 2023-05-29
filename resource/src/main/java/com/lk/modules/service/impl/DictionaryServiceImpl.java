package com.lk.modules.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lk.modules.mapper.DictionaryMapper;
import com.lk.modules.entity.Dictionary;
import com.lk.modules.service.DictionaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Arrays;

/**
 * dictionary
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;


    @Override
    public PageInfo<Dictionary> selectDictionaryInfo(Dictionary dictionary, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<Dictionary> wrapper = new QueryWrapper<>();
        if (dictionary.getName() !=null){
            wrapper.like("name",dictionary.getName());
        }
        if (dictionary.getStatus() !=null){
            wrapper.eq("status",dictionary.getStatus());
        }
        List<Dictionary> data = dictionaryMapper.selectList(wrapper);
        return new PageInfo<>(data);
    }

    @Override
    public void saveDictionaryInfo(Dictionary dictionary) {
        dictionaryMapper.insert(dictionary);
    }

    @Override
    public void updateDictionaryInfo(Dictionary dictionary) {
        dictionaryMapper.updateById(dictionary);
    }

    @Override
    public void delDictionaryInfo(Integer id) {
        dictionaryMapper.deleteById(id);
    }

    @Override
    public void delBatchDictionaryInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        dictionaryMapper.deleteBatchIds(list);
    }


}