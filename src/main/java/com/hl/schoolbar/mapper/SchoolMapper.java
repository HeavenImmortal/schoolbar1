package com.hl.schoolbar.mapper;

import com.hl.schoolbar.entity.School;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hl.schoolbar.utils.SchoolQueryConditions;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2021-02-04
 */
public interface SchoolMapper extends BaseMapper<School> {



    /**
     * 添加学校
     * @param school
     * @return
     */
    int insSchool(@Param("school")School school);

    /**
     * 修改学校
     * @param school
     * @return
     */
    int updSchool(@Param("school")School school);

    /**
     * 删除学校
     * @param id
     * @return
     */
    int delSchoolById(@Param("id")Integer id);

    /**
     * 分页查询学校
     * @param schoolQueryConditions
     * @return
     */
    List<HashMap<String,Object>> selPageSchool(@Param("schoolQueryConditions")SchoolQueryConditions schoolQueryConditions);
}
