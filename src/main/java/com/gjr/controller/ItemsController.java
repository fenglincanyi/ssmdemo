package com.gjr.controller;

import com.gjr.po.Items;
import com.gjr.po.ItemsCustom;
import com.gjr.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by geng
 * on 2017/1/28.
 */

@Controller
@RequestMapping("/items")
public class ItemsController {

//    private final ItemsService itemsService;

//    @Autowired
//    public ItemsController(ItemsService itemsService) {
//        this.itemsService = itemsService;
//    }

    @Autowired
    private ItemsService itemsService;


    /**
     * test url:  http://localhost:8080/ssmdemo/items/queryItems
     */
    @RequestMapping("/queryItems")
    public ModelAndView queryItems() throws Exception {
        // 查询条件为空
        List<ItemsCustom> itemsCustomList = itemsService.findItemsList(null);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsCustomList);
        modelAndView.setViewName("items/itemsList");
        return modelAndView;
    }

//    /**
//     * 修改商品，数据显示
//     */
//    @RequestMapping(value = "/editItems", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView editItems(@RequestParam(value = "id") Integer _id) throws Exception {
//        ItemsCustom itemsCustom = itemsService.findItemsById(_id);
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("itemsCustom", itemsCustom);
//        modelAndView.setViewName("items/editItems");
//
//        return modelAndView;
//    }

    /**
     * 使用 jackson 自动输出pojo对应的 json
     *
     * 注意： @ResponseBody ItemsCustom
     *
     * test url:  http://localhost:8080/ssmdemo/items/editItems?id=1
     */
    @RequestMapping(value = "/editItems", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Items editItems(@RequestParam(value = "id") Integer _id) throws Exception {
        Items items = itemsService.findItemsById(_id);

        System.out.println(items);
        return items;
    }


    /**
     * 修改商品 提交
     *
     * 需要校验的 pojo前必须添加 @Validated, 则必须出现BindingResult；若有多个pojo要校验，则必须是配对出现，且顺序保持一前一后
     */
    @RequestMapping(value = "/editItemsSubmit", method = RequestMethod.POST)
    public ModelAndView editItemsSubmit(Integer id, @Validated ItemsCustom itemsCustom,
                                        BindingResult bindingResult) throws Exception {

        // 若参数不合法
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
        }


        // id 取到值，在itemsCustom对象中，也能取到 id值，赋给自己到id属性
        itemsService.updateItemsById(id, itemsCustom);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");

        return modelAndView;
    }
}
