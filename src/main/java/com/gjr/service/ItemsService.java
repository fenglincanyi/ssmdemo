package com.gjr.service;

import com.gjr.po.ItemsCustom;
import com.gjr.po.ItemsQueryVo;

import java.util.List;

/**
 * Created by geng
 * on 2017/1/28.
 */
public interface ItemsService {

    // 商品的查询列表
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo);

    // 根据id查询商品信息
    ItemsCustom findItemsById(Integer id);

    // 修改商品信息 by id
    void updateItemsById(Integer id, ItemsCustom itemsCustom);
}
