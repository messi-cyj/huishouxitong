package com.lk.modules.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lk.modules.mapper.SortMapper;
import com.lk.modules.entity.Sort;
import com.lk.modules.service.SortService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Arrays;

/**
 * sort
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@Service
public class SortServiceImpl extends ServiceImpl<SortMapper, Sort> implements SortService {

    @Autowired
    private SortMapper sortMapper;


    @Override
    public PageInfo<Sort> selectSortInfo(Sort sort, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<Sort> wrapper = new QueryWrapper<>();
        if (sort.getSortName() !=null){
            wrapper.like("sort_name",sort.getSortName());
        }
        List<Sort> data = sortMapper.selectList(wrapper);
        return new PageInfo<>(data);
    }

    @Override
    public void saveSortInfo(Sort sort) {
        sortMapper.insert(sort);
    }

    @Override
    public void updateSortInfo(Sort sort) {
        sortMapper.updateById(sort);
    }

    @Override
    public void delSortInfo(Integer id) {
        sortMapper.deleteById(id);
    }

    @Override
    public void delBatchSortInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        sortMapper.deleteBatchIds(list);
    }


}