package com.bjpowernode.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/*
    @RequestMapping :
        value: 所有请求地址的公共部分，叫做【模块名称】 以什么开头的 一般加上为了规范
        位置；放在类上面
 */

@Controller
@RequestMapping(value = "/test")
public class MyController {
    /*
        @RequestMapping ：请求映射
                属性：method，表示请求的方式。它的值RequestMethod类枚举值。
                例如表示get请求方式，RequestMethod.GET
                       post请求方式，RequestMethod.POST
     */
    //指定other.do是get请求方式
    @RequestMapping(value = {"/some.do","/first.do"},method = RequestMethod.GET)//原本是/test/some.do  /test/first.do
    public ModelAndView doSome(HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","欢迎使用springMVC做web开发"+"===="+request.getParameter("name"));
        mv.addObject("fun","执行的是dosome方法");
        mv.setViewName("show");
        return mv;
    }
    //指定other.do是post请求方式
    @RequestMapping(value = "/other.do",method = RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","===欢迎使用springMVC做web开发===");
        mv.addObject("fun","执行的是doOther方法");
        mv.setViewName("other");
        return mv;
    }

}
