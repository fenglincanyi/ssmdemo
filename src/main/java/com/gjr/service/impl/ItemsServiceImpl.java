package com.gjr.service.impl;

import com.gjr.mapper.ItemsCustomMapper;
import com.gjr.po.ItemsCustom;
import com.gjr.po.ItemsQueryVo;
import com.gjr.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by geng
 * on 2017/1/28.
 */
public class ItemsServiceImpl implements ItemsService{

    @Autowired
    private ItemsCustomMapper itemsCustomMapper;

    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsCustomMapper.findItemsList(itemsQueryVo);
    }
}
