package com.hl.schoolbar.mapper;

import com.hl.schoolbar.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2021-02-04
 */
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 添加类别
     * @param category
     * @return
     */
    int insCategory(@Param("category")Category category);

    /**
     * 删除类别
     * @param id
     * @return
     */
    int delCategoryById(@Param("id")Integer id);

    /**
     * 查询父类别
     */
    List<Category> selAllCategory();

    /**
     * 通过父id查询类别
     * @param id
     * @return
     */
    List<Category> selCategoryByPid(@Param("id") Integer id);

    /**
     * 修改类别
     * @param category
     * @return
     */
    int updCategory(@Param("category")Category category);
}
