package com.bjpowernode.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
    @Controller ：创建处理对象，对象放在springMVC容器中
    能处理请求的都是控制器(处理器): MyController能处理请求，叫做【后端控制器】
 */
@Controller
public class MyController {
    /*
        处理用户提交的请求，springMVC中是使用方法来处理的
        方法是自定义的，可以有多种返回值，多种参数，方法名称自定义
        @RequestMapping ：请求映射，作用是把一个请求地址和一个方法绑定在一起
                             一个请求指定一个方法处理
                       属性：1.value 是一个spring ，表示请求的uri地址的
                       value的值必须是唯一的，不能重复。在使用时，推荐地址以 "/" 开头
         说明：使用RequestMapping修饰的方法就做处理器方法或者控制器方法
         使用@RequestMapping修饰的方法可以处理请求的，类似servlet中的doget depost
     */
    /*
        返回值：ModeAndVieew 表示本次请求的处理结果
         Mode ：数据，请求处理完成后，要显示个用户的数据
         View ：视图，比如jsp等
     */
    @RequestMapping(value = {"/some.do","/first.do"})//可以有多个请求
    public ModelAndView doSome(){
        //创建一个返回值
        ModelAndView mv=new ModelAndView();

        //添加数据，框架在请求的【最后】把数据放入到request作用域。
        mv.addObject("msg","欢迎使用springMVC做web开发");
        mv.addObject("fun","执行的是dosome方法");

        //指定视图,可以指定视图的完整路径
        //框架对视图执行的forward操作【最后】， request.getRequestDispatecher("/show.jsp").forward(..);
        //为配置视图解析器：mv.setViewName("/WEB-INF/view/show.jsp");

        //当配置了视图解析器后，可以使用逻辑名称（文件名），指定视图
        mv.setViewName("show");
        //返回mv
        return mv;
    }

}
