package com.hl.schoolbar.service;

import com.hl.schoolbar.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hl.schoolbar.utils.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2021-02-04
 */
public interface CategoryService extends IService<Category> {
    /**
     * 添加类别
     * @param category
     * @return
     */
    Result insCategory(Category category);

    /**
     * 删除类别
     * @param id
     * @return
     */
    Result delCategoryById(Integer id);

    /**
     * 查询所有类别
     * @return
     */
    Result selAllCategory();

    /**
     * 通过父id查询子类别
     * @return
     */
    Result selCategoryByPid(Integer id);

    /**
     * 修改类别
     * @param category
     * @return
     */
    Result updCategory(Category category);
}
