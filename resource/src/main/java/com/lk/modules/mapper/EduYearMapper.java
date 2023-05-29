package com.lk.modules.mapper;

import com.lk.modules.args.EduYearSearchArgs;
import com.lk.modules.dto.EduYearDto;
import com.lk.modules.po.EduYearPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EduYearMapper {

    Boolean saveYearEdu(EduYearDto dto);

    Boolean saveYearEduFileLink(@Param("trainId") Integer trainId,@Param("fileIdList") List<Integer> fileIdList);

    void updateYearEdu(EduYearDto dto);

    void deleteYearFileLink(@Param("id") Integer id);

    Boolean deleteYearEdu(Integer id);

    List<EduYearPo> getYearEduList(EduYearSearchArgs args);

    EduYearPo getYearEduDetails(@Param("id") Integer id);
}
