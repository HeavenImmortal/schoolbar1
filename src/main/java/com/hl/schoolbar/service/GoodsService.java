package com.hl.schoolbar.service;

import com.hl.schoolbar.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hl.schoolbar.utils.PageBuilder;
import com.hl.schoolbar.utils.RequestDTo;
import com.hl.schoolbar.utils.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2021-02-25
 */
public interface GoodsService extends IService<Goods> {

    /**
     * 分页后查询商品
     * @param pageBuilder
     * @return
     */
    Result selPageGoods(PageBuilder pageBuilder);

    /**
     * 添加商品
     * @param requestDTo
     * @return
     */
    Result insGoods(RequestDTo requestDTo);

    /**
     * 修改商品
     * @param goods
     * @return
     */
    Result updGoods(Goods goods);

    /**
     * 删除商品
     * @param id
     * @return
     */
    Result delGoodsById(Integer id);

    /**
     * 修改商品状态
     * @param id
     * @param isShow
     * @return
     */
    Result updGoodsIsShow(Integer id,Integer isShow);

    /**
     * 查询所有用户
     * @return
     */
    Result selAllUser();

    /**
     * 查询所有学校
     * @return
     */
    Result selAllSchool();

    /**
     * 查询所有子类别
     * @return
     */
    Result selAllSonCategory();
}
