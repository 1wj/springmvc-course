package com.bjpowernode.controller;


import com.bjpowernode.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/*
    @RequestMapping :
        value: 所有请求地址的公共部分，叫做【模块名称】 以什么开头的 一般加上为了规范
        位置；放在类上面
 */

@Controller
//@RequestMapping(value = "/test")
public class MyController {
    /*
        逐个接收请求参数：
            要求：处理器(控制器)方法的形参名和请求名参数必须一致
                同名的请求参数给同名的形参
        框架接收请求参数
            1.使用request对象接收请求参数
              String strName=request.getParameter("name");
              String strAge=request.getParameter("age");
            2.springmvc框架通过DispatcherServlet 调用 MyController的doOther()方法
              调用方法时，按名称对应，把接收的参数赋给形参
              doOther(strName,Integer.valueOf(strAge))
              框架会提供类型转换功能，能把String 转为 int,long,float,double等类型
            400状态码是客户端错误，表示提交请求参数过程中，出现了错误
     */
    @RequestMapping(value = "/receiveproperty.do")
    public ModelAndView doOther(String name,Integer age){
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }

    /*
        请求参数名和处理器方法的形参名不一样
        @RequestParam：逐个接收请求参数中，解决请求中的参数名形参名不一样的问题（参数多就不方便了）
            属性：1.value 请求中的参数名称
                 2.required 是一个Boolean，默认是true
                    true：表示请求中必须包含次参数。否则报错
            位置：在处理器方法的形参定义的前面
     */
    @RequestMapping(value = "/receiveparam.do")
    public ModelAndView receiveparam(@RequestParam(value = "rname",required = false) String name,
                                     @RequestParam(value = "rage",required = false) Integer age){
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }

    /*
        处理器方法形参是java对象，这个对象的属性名和请求中参数名一样的
        框架会创建形参的java对象，给属性赋值，请求中的参数是name，框架就会调用setName()
        类似于set注入  很方便用的多
     */
    @RequestMapping(value = "/receiveObjdct.do")
    public ModelAndView receiveObjdct(Student mystudent){//还可以多个，School school ,String sex
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",mystudent.getName());
        mv.addObject("myage",mystudent.getAge());
        mv.addObject("mystudent",mystudent);

        mv.setViewName("show");
        return mv;
    }


}
