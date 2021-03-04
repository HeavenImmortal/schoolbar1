package com.hl.schoolbar.controller;


import com.hl.schoolbar.entity.Goods;
import com.hl.schoolbar.service.GoodsService;
import com.hl.schoolbar.utils.PageBuilder;
import com.hl.schoolbar.utils.RequestDTo;
import com.hl.schoolbar.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2021-02-25
 */
@Api(tags = "商品管理")
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsServiceImpl;


    /**
     * 分页查询商品
     * @param pageBuilder
     * @return
     */
    @ApiOperation(value="分页查询商品", notes="post请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "pageNum", value = "目标页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "pageSize", value = "每页大小", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "goodsName", value = "学校名称", required = false, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "category_id", value = "类别id", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "user_id", value = "用户id", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "schoolId", value = "学校id", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "phone", value = "电话号码", required = false, dataType = "String"),
    })
    @RequestMapping(value = "/selPageGoods",method = RequestMethod.POST)
    public Result selPageGoods(@RequestBody PageBuilder pageBuilder){
        return goodsServiceImpl.selPageGoods(pageBuilder);
    }

    /**
     * 添加商品
     * @param requestDTo
     * @return
     */
    @ApiOperation(value="添加商品", notes="post请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "goodsName", value = "商品名称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "goodsDescribe", value = "商品描述", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "category_id", value = "类别id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "price", value = "价格", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "qqNumber", value = "qq", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "phone", value = "电话号码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "user_id", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "schoolId", value = "学校id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/insGoods",method = RequestMethod.POST)
    public Result insGoods(@RequestBody RequestDTo requestDTo ){
        return goodsServiceImpl.insGoods(requestDTo);
    }

    /**
     * 修改商品
     * @param goods
     * @return
     */
    @ApiOperation(value="修改商品", notes="post请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "goodsId", value = "商品id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "goodsName", value = "商品名称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "goodsDescribe", value = "商品描述", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "category_id", value = "类别id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "price", value = "价格", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "qqNumber", value = "qq", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "phone", value = "电话号码", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/updGoods",method = RequestMethod.POST)
    public Result updGoods(@RequestBody Goods goods){
        return goodsServiceImpl.updGoods(goods);
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @ApiOperation(value="删除商品", notes="get请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "商品id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/delGoodsById",method = RequestMethod.GET)
    public Result delGoodsById(Integer id){
        return goodsServiceImpl.delGoodsById(id);
    }

    /**
     * 修改商品状态
     * @param id
     * @param isShow
     * @return
     */
    @ApiOperation(value="修改商品展示状态", notes="get请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "商品id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "isShow", value = "商品id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/updGoodsIsShow",method = RequestMethod.GET)
    public Result updGoodsIsShow(Integer id,Integer isShow){
        return goodsServiceImpl.updGoodsIsShow(id,isShow);
    }

    /**
     * 查询所有用户
     * @param
     * @return
     */
    @ApiOperation(value="查询所有用户", notes="get请求方式")
    @ApiImplicitParams({
    })
    @RequestMapping(value = "/selAllUser",method = RequestMethod.GET)
    public Result selAllUser(){
        return goodsServiceImpl.selAllUser();
    }

    /**
     * 查询所有学校
     * @param
     * @return
     */
    @ApiOperation(value="查询所有学校", notes="get请求方式")
    @ApiImplicitParams({
    })
    @RequestMapping(value = "/selAllSchool",method = RequestMethod.GET)
    public Result selAllSchool(){
        return goodsServiceImpl.selAllSchool();
    }

    /**
     * 查询所有子类别
     * @return
     */
    @ApiOperation(value="查询所有子类别", notes="get请求方式")
    @ApiImplicitParams({
    })
    @RequestMapping(value = "/selAllSonCategory",method = RequestMethod.GET)
    public Result selAllSonCategory(){
        return goodsServiceImpl.selAllSonCategory();
    }

}
