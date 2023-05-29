package com.lk.modules.controller;
import com.lk.modules.service.DictionaryService;
import com.lk.modules.entity.Dictionary;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;

import com.lk.modules.utils.Result;
import com.lk.modules.utils.ResultUtil;

/**
 * dictionary
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@RestController
@RequestMapping("/common/dictionary")
@Api(tags = "字典管理模块")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    /**
     * 获取所有字典管理
     *
     * @param pageNum
     * @param pageSize
     * @param dictionary
     * @return
     */

    @GetMapping("/getDictionaryInfo")
    @ApiOperation("获取所有字典管理")
    public Result getDictionaryInfo(Dictionary dictionary, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageInfo<Dictionary> data = dictionaryService.selectDictionaryInfo(dictionary, pageNum, pageSize);
        return ResultUtil.success(1, "成功", data);
    }

    /**
     * 保存字典管理
     *
     * @param dictionary
     * @return
     */
    @PostMapping("/saveDictionaryInfo")
    @ApiOperation("保存字典管理")
    public Result saveDictionaryInfo(@RequestBody Dictionary dictionary) {
        dictionaryService.saveDictionaryInfo(dictionary);
        return ResultUtil.success(1, "成功", null);
    }


    /**
     * 更新字典管理
     *
     * @param dictionary
     * @return
     */

    @PutMapping("/updateDictionaryInfo")
    @ApiOperation("更新字典管理")
    public Result updateDictionaryInfo(@RequestBody Dictionary dictionary) {
        dictionaryService.updateDictionaryInfo(dictionary);
        return ResultUtil.success(1, "成功", null);
    }

    /**
     * 根据id删除字典管理
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delDictionaryInfo")
    @ApiOperation("根据id删除字典管理")
    public Result delDictionaryInfo(Integer id) {
        dictionaryService.delDictionaryInfo(id);
        return ResultUtil.success(1, "成功", null);
    }

    /**
     * 根据id集合批量删除字典管理
     *
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchDictionaryInfo")
    @ApiOperation("根据id集合批量删除字典管理")
    public Result delBatchDictionaryInfo(String idList) {
        dictionaryService.delBatchDictionaryInfo(idList);
        return ResultUtil.success(1, "成功", null);
    }

}