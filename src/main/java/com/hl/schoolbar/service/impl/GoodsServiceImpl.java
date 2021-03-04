package com.hl.schoolbar.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hl.schoolbar.entity.Goods;
import com.hl.schoolbar.mapper.GoodsMapper;
import com.hl.schoolbar.mapper.UserMapper;
import com.hl.schoolbar.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hl.schoolbar.utils.PageBuilder;
import com.hl.schoolbar.utils.RequestDTo;
import com.hl.schoolbar.utils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2021-02-25
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private UserMapper userMapper;

    /**
     * 分页查询所有商品
     * @param pageBuilder
     * @return
     */
    @Override
    public Result selPageGoods(PageBuilder pageBuilder) {
        PageHelper.startPage(pageBuilder.getPageNum(),pageBuilder.getPageSize());
        List<HashMap<String ,Object>> goodsList = goodsMapper.selPageGoods(pageBuilder.getGoodsQueryConditions());
        PageInfo<HashMap<String ,Object>> pageInfo = new PageInfo<>(goodsList);
        return Result.ok().put("pageInfo",pageInfo);
    }

    /**
     * 添加商品
     * @param requestDTo
     * @return
     */
    @Override
    public Result insGoods(RequestDTo requestDTo) {
        try{
            Goods goods = requestDTo.getGoods();
            //设置数据
            goods.setIsDelete(0);
            goods.setIsShow(0);
            goods.setCreateDate(System.currentTimeMillis());
            int i = goodsMapper.insGoods(goods);
            System.out.println(goods.getGoodsId());
            if(i==1){

                int n = goodsMapper.insGoodsAndImg(goods.getGoodsId(),requestDTo.getImgList());
                if(n!=requestDTo.getImgList().size()){
                    return Result.error("添加商品图片失败");
                }else {
                    return Result.ok();
                }
            }else {
                return Result.error("添加失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            return Result.error("添加失败");
        }
    }

    /**
     * 修改商品
     * @param goods
     * @return
     */
    @Override
    public Result updGoods(Goods goods) {
        try{
            int i = goodsMapper.updGoods(goods);
            if(i==1){
                return Result.ok();
            }else {
                return Result.error("修改失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            return Result.error("修改失败");
        }
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @Override
    public Result delGoodsById(Integer id) {
        try{
            int i = goodsMapper.delGoodsById(id);
            if(i==1){
                return Result.ok();
            }else {
                return Result.error("删除失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            return Result.error("删除失败");
        }
    }

    /**
     * 修改商品展示状态
     * @param id
     * @param isShow
     * @return
     */
    @Override
    public Result updGoodsIsShow(Integer id, Integer isShow) {
        try{
            int i = goodsMapper.updGoodsIsShow(id, isShow);
            if(i==1){
                return Result.ok();
            }else {
                return Result.error("修改失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            return Result.error("修改失败");
        }
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public Result selAllUser() {
        List<HashMap<String ,Object>> userList = goodsMapper.selAllUser();
        return Result.ok().put("userList",userList);
    }

    @Override
    public Result selAllSchool() {
        List<HashMap<String ,Object>> schoolList = userMapper.selAllSchool();
        return Result.ok().put("schoolList",schoolList);
    }

    /**
     * 查询所有子类别
     * @return
     */
    @Override
    public Result selAllSonCategory() {
        List<HashMap<String ,Object>> categoryList = goodsMapper.selAllSonCategory();
        return Result.ok().put("categoryList",categoryList);
    }
}
