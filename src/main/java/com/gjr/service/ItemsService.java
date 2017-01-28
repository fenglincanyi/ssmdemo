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
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
