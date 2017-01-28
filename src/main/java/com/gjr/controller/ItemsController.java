package com.gjr.controller;

import com.gjr.po.ItemsCustom;
import com.gjr.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by geng
 * on 2017/1/28.
 */

@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/queryItems")
    public ModelAndView queryItems() throws Exception {
        List<ItemsCustom> itemsCustomList = itemsService.findItemsList(null);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsCustomList);
        modelAndView.setViewName("items/itemsList");
        return modelAndView;
    }
}
