package com.lk.modules.service.impl;

import com.lk.modules.dto.FileDto;
import com.lk.modules.mapper.FileMapper;
import com.lk.modules.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public Boolean saveFile(FileDto dto) {
        return fileMapper.saveFile(dto);
    }
}
