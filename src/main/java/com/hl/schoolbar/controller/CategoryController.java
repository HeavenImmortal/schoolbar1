package com.hl.schoolbar.controller;


import com.hl.schoolbar.entity.Category;
import com.hl.schoolbar.service.CategoryService;
import com.hl.schoolbar.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/category")
@Api(tags = "类别管理")
public class CategoryController {

    @Autowired
    private CategoryService categoryServiceImpl;

    /**
     * 添加类别
     */
    @ApiOperation(value="添加类别", notes="以json格式传递数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "categoryName", value = "类别名称", required = true, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "categoryPid", value = "父类别id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/insCategory",method = RequestMethod.POST)
    public Result insCategory(@RequestBody Category category){
        return categoryServiceImpl.insCategory(category);
    }

    /**
     * 删除类别
     *
     */
    @ApiOperation(value="删除类别", notes="get请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "类别id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/delCategoryById",method = RequestMethod.GET)
    public Result delCategoryById(@RequestParam("id") Integer id){
        return categoryServiceImpl.delCategoryById(id);
    }

    /**
     * 查询父类别
     */
    @ApiOperation(value="查询一级类别", notes="get请求方式")
    @ApiImplicitParams({

    })
    @RequestMapping(value = "/selAllCategory",method = RequestMethod.GET)
    public Result selAllCategory(){
        return categoryServiceImpl.selAllCategory();
    }

    /**
     * 查询子类别
     * @param id
     * @return
     */
    @ApiOperation(value="通过父id查询子类别", notes="get请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "父类别id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/selCategoryByPid",method = RequestMethod.GET)
    public Result selCategoryByPid(Integer id){
        System.out.println(id);
        return categoryServiceImpl.selCategoryByPid(id);
    }

    /**
     * 修改类别
     * @param category
     * @return
     */
    @ApiOperation(value="修改类别", notes="以json格式传递数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "categoryId", value = "类别id", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "categoryName", value = "类别名称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "categoryPid", value = "父类别id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/updCategory",method = RequestMethod.POST)
    public Result updCategory(@RequestBody Category category){
        return categoryServiceImpl.updCategory(category);
    }
}
