package com.gjr.controller;

import com.gjr.constant.ErrorCode;
import com.gjr.entity.Result;
import com.gjr.service.ItemsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by geng
 * on 2017/3/19.
 */
@RestController
@RequestMapping("/items")
public class RestDemoController{

    @Resource
    private ItemsService itemsService;

    @RequestMapping(value = "/{id:\\d}",method = RequestMethod.GET)
    Result query(@PathVariable("id") Integer id,HttpServletRequest request){
        try{
            return Result.builder().data(itemsService.findItemsById(id)).success().build();
        }catch(Exception e){
            return Result.builder().failed(ErrorCode.BAD_REQUEST,e.getMessage()).build();
        }
    }
}
