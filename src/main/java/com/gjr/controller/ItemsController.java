package com.gjr.controller;

import com.gjr.po.ItemsCustom;
import com.gjr.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by geng
 * on 2017/1/28.
 */

@Controller
@RequestMapping("/items")
public class ItemsController {

    private final ItemsService itemsService;

    @Autowired
    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @RequestMapping("/queryItems")
    public ModelAndView queryItems() throws Exception {
        // 查询条件为空
        List<ItemsCustom> itemsCustomList = itemsService.findItemsList(null);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsCustomList);
        modelAndView.setViewName("items/itemsList");
        return modelAndView;
    }

    /**
     * 修改商品，数据显示
     */
    @RequestMapping(value = "/editItems", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView editItems(@RequestParam(value = "id") Integer _id) throws Exception {
        ItemsCustom itemsCustom = itemsService.findItemsById(_id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsCustom", itemsCustom);
        modelAndView.setViewName("items/editItems");

        return modelAndView;
    }


    /**
     * 修改商品 提交
     */
    @RequestMapping(value = "/editItemsSubmit", method = RequestMethod.POST)
    public ModelAndView editItemsSubmit(Integer id, ItemsCustom itemsCustom) throws Exception {
        // id 取到值，在itemsCustom对象中，也能取到 id值，赋给自己到id属性

        itemsService.updateItemsById(id, itemsCustom);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");

        return modelAndView;
    }
}
