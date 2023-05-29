package com.lk.modules.controller;

import com.lk.modules.entity.Dictionary;
import com.lk.modules.mapper.DictionaryMapper;
import com.lk.modules.service.NoticeService;
import com.lk.modules.entity.Notice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;

import com.lk.modules.utils.Result;
import com.lk.modules.utils.ResultUtil;


/**
 * notice
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@RestController
@RequestMapping("/common/notice")
@Api(tags = "通知管理模块")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    /**
     * 获取所有通知信息
     *
     * @param pageNum
     * @param pageSize
     * @param notice
     * @return
     */

    @GetMapping("/getNoticeInfo")
    @ApiOperation("获取所有通知信息")
    public Result getNoticeInfo(Notice notice, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageInfo<Notice> data = noticeService.selectNoticeInfo(notice, pageNum, pageSize);
        return ResultUtil.success(1, "成功", data);
    }


    @Autowired
    private DictionaryMapper dictionaryMapper;

    /**
     * 保存通知信息
     *
     * @param notice
     * @return
     */
    @PostMapping("/saveNoticeInfo")
    @ApiOperation("保存通知信息")
    public Result saveNoticeInfo(@RequestBody Notice notice) {
//        QueryWrapper<Dictionary> wrapper = new QueryWrapper<>();
        if (notice.getType() == 1) {
            //系统推送
            Dictionary dictionary = dictionaryMapper.selectById(6);
            if (dictionary.getStatus() == 2) {
                return ResultUtil.error(-1, "系统推送已关闭");
            }
        }
        if (notice.getType() == 2) {
            //系统推送
            Dictionary dictionary = dictionaryMapper.selectById(7);
            if (dictionary.getStatus() == 2) {
                return ResultUtil.error(-1, "紧急通知已关闭");
            }
        }
        if (notice.getType() == 3) {
            //系统推送
            Dictionary dictionary = dictionaryMapper.selectById(8);
            if (dictionary.getStatus() == 2) {
                return ResultUtil.error(-1, "普通推送已关闭");
            }
        }
        noticeService.saveNoticeInfo(notice);
        return ResultUtil.success(1, "成功", null);
    }


    /**
     * 更新通知信息
     *
     * @param notice
     * @return
     */

    @PutMapping("/updateNoticeInfo")
    @ApiOperation("更新通知信息")
    public Result updateNoticeInfo(@RequestBody Notice notice) {
        noticeService.updateNoticeInfo(notice);
        return ResultUtil.success(1, "成功", null);
    }

    /**
     * 根据id删除通知信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delNoticeInfo")
    @ApiOperation("根据id删除通知信息")
    public Result delNoticeInfo(Integer id) {
        noticeService.delNoticeInfo(id);
        return ResultUtil.success(1, "成功", null);
    }

    /**
     * 根据id集合批量删除通知信息
     *
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchNoticeInfo")
    @ApiOperation("根据id集合批量删除通知信息")
    public Result delBatchNoticeInfo(String idList) {
        noticeService.delBatchNoticeInfo(idList);
        return ResultUtil.success(1, "成功", null);
    }

}