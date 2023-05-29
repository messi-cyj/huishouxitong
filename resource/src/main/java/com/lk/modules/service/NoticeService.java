package com.lk.modules.service;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lk.modules.entity.Notice;

/**
 * notice
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
public interface NoticeService extends IService<Notice>{

    PageInfo<Notice> selectNoticeInfo(Notice notice, Integer pageNum, Integer pageSize);

    void saveNoticeInfo(Notice notice);

    void updateNoticeInfo(Notice notice);

    void delNoticeInfo(Integer id);

    void delBatchNoticeInfo(String idList);


}