package com.hl.schoolbar.service;

import com.hl.schoolbar.entity.School;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hl.schoolbar.utils.PageBuilder;
import com.hl.schoolbar.utils.Result;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2021-02-04
 */
public interface SchoolService extends IService<School> {

    /**
     * 添加学校
     * @param school
     * @return
     */
    Result insSchool(School school);

    /**
     * 修改学校
     * @param school
     * @return
     */
    Result updSchool(School school);

    /**
     * 删除学校
     * @param id
     * @return
     */
    Result delSchoolById(Integer id);

    /**
     * 分页查询学校
     * @param pageBuilder
     * @return
     */
    Result selPageSchool(PageBuilder pageBuilder);

}
