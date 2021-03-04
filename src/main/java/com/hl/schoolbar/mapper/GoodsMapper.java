package com.hl.schoolbar.mapper;

import com.hl.schoolbar.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hl.schoolbar.entity.Img;
import com.hl.schoolbar.utils.GoodsQueryConditions;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2021-02-25
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * 分页查询商品
     * @param goodsQueryConditions
     * @return
     */
    List<HashMap<String,Object>> selPageGoods(@Param("goodsQueryConditions")GoodsQueryConditions goodsQueryConditions);

    /**
     * 添加商品
     * @param goods
     * @return
     */
    int insGoods(@Param("goods")Goods goods);

    /**
     * 删除商品
     * @param id
     * @return
     */
    int delGoodsById(@Param("id")Integer id);

    /**
     * 修改商品
     * @param goods
     * @return
     */
    int updGoods(@Param("goods")Goods goods);

    /**
     * 查询所有用户
     * @return
     */
    List<HashMap<String ,Object>> selAllUser();

    /**
     * 修改商品展示状态
     * @param id
     * @param isShow
     * @return
     */
    int updGoodsIsShow(@Param("id")Integer id,@Param("isShow")Integer isShow);

    /**
     * 查询所有子类别
     * @return
     */
    List<HashMap<String ,Object>> selAllSonCategory();

    /**
     * 添加商品图片
     * @param goodsId
     * @return
     */
    int insGoodsAndImg(@Param("goodsId")Integer goodsId, @Param("imgList")List<Img> imgList);

    /**
     * 查询商品图片
     * @param goodsId
     * @return
     */
    List<Img> selImgListByGoodsId(@Param("goodsId")Integer goodsId);

    /**
     * 删除商品所有图片
     * @param goodsId
     * @return
     */
    int delGoodsImgByGoodsId(@Param("goodsId")Integer goodsId);
}
