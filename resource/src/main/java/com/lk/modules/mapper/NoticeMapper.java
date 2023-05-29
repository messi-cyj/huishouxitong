package com.lk.modules.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lk.modules.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * notice
 *
 * @author lk
 * @since 1.0.0 2023-03-21
 */
@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {

    List<Notice> selectListInfo(Notice notice);
	
}