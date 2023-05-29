package com.lk.modules.mapper;

import com.lk.modules.dto.FileDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {

    Boolean saveFile(FileDto dto);
}
