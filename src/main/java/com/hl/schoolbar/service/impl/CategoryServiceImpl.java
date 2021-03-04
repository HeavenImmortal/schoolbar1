package com.hl.schoolbar.service.impl;

import com.hl.schoolbar.entity.Category;
import com.hl.schoolbar.mapper.CategoryMapper;
import com.hl.schoolbar.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hl.schoolbar.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2021-02-04
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 添加类别
     * @param category
     * @return
     */
    @Override
    public Result insCategory(Category category){
        int i = categoryMapper.insCategory(category);
        if (i==1){
            return Result.ok("添加成功");
        }else{
            return Result.error("添加失败");
        }
    }


    /**
     * 删除类别
     * @param id
     * @return
     */
    @Override
    public Result delCategoryById(Integer id) {
        int i = categoryMapper.delCategoryById(id);
        if (i==1){
            return Result.ok("删除成功");
        }else{
            return Result.error("删除失败");
        }
    }

    /**
     * 查询父类别
     * @return
     */
    @Override
    public Result selAllCategory() {
        List<Category> categoryList = categoryMapper.selAllCategory();
        return Result.ok().put("categoryList",categoryList);
    }

    /**
     * 通过父类别查询子类别
     * @param id
     * @return
     */
    @Override
    public Result selCategoryByPid(Integer id) {
        List<Category> categoryList = categoryMapper.selCategoryByPid(id);

        return Result.ok().put("categoryList",categoryList);
    }

    /**
     * 修改类别
     * @param category
     * @return
     */
    @Override
    public Result updCategory(Category category) {
        try{
            int i = categoryMapper.updCategory(category);
            if(i==1){
                return Result.ok();
            }else {
                return Result.error("修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("修改失败");
        }
    }
}
