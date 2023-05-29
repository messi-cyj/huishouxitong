package com.lk.modules.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lk.modules.dto.FileDto;
import com.lk.modules.service.FileService;
import com.lk.modules.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common/file")
@Api(tags = "文件管理模块")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/saveFile")
    @ApiOperation("上传文件")
    @ApiOperationSupport(order = 1)
    public R saveFile(FileDto dto){
        return R.ok(fileService.saveFile(dto));
    }
}
