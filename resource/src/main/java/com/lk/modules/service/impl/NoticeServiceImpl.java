package com.lk.modules.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lk.modules.mapper.NoticeMapper;
import com.lk.modules.entity.Notice;
import com.lk.modules.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Arrays;
import com.lk.modules.utils.TimeUtil;

/**
 * notice
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;


    @Override
    public PageInfo<Notice> selectNoticeInfo(Notice notice, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
        List<Notice> data = noticeMapper.selectListInfo(notice);
        return new PageInfo<>(data);
    }

    @Override
    public void saveNoticeInfo(Notice notice) {
        notice.setCreateTime(TimeUtil.getCurrentTime());
        noticeMapper.insert(notice);
    }

    @Override
    public void updateNoticeInfo(Notice notice) {
        noticeMapper.updateById(notice);
    }

    @Override
    public void delNoticeInfo(Integer id) {
        noticeMapper.deleteById(id);
    }

    @Override
    public void delBatchNoticeInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        noticeMapper.deleteBatchIds(list);
    }


}