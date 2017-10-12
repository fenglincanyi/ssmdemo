package com.gjr.service.impl;

import com.gjr.mapper.ItemsCustomMapper;
import com.gjr.mapper.ItemsMapper;
import com.gjr.po.Items;
import com.gjr.po.ItemsCustom;
import com.gjr.po.ItemsQueryVo;
import com.gjr.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by geng
 * on 2017/1/28.
 */
@Service
public class ItemsServiceImpl implements ItemsService{

    @Resource
    private ItemsCustomMapper itemsCustomMapper;

    @Resource
    private ItemsMapper itemsMapper;

    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo){
        return itemsCustomMapper.findItemsList(itemsQueryVo);
    }

    public ItemsCustom findItemsById(Integer id){
        Items items = itemsMapper.selectByPrimaryKey(id);

        ItemsCustom itemsCustom = new ItemsCustom();

        // Spring 提供的，拷贝对象属性
        BeanUtils.copyProperties(items, itemsCustom);
        return itemsCustom;
    }

    public void updateItemsById(Integer id, ItemsCustom itemsCustom){
        // 校验id是否为空 等等
        // ...

        itemsCustom.setId(id);
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }
}
