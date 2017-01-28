package com.gjr.mapper;

import com.gjr.po.ItemsCustom;
import com.gjr.po.ItemsQueryVo;

import java.util.List;

public interface ItemsCustomMapper {

    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}