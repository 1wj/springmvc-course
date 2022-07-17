package com.bjpowernode.controller;
import com.bjpowernode.vo.Student;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    /*
        处理器方法返回String--表示逻辑视图名称，需要配置视图解析器
     */
    @RequestMapping(value = "/returnString-view.do")
    public String doReturnView(HttpServletRequest request, String name, Integer age){
        System.out.println("name:=="+name+"age:=="+age);
        //可以手动添加数据到request作用域
        request.setAttribute("myname",name);
        request.setAttribute("myage",age);
        return "show" ;
    }

    //处理器方法返回void，
    @RequestMapping(value = "/retureVoid-ajax.do")
    public void doReturnVoidAjax(String name, Integer age, HttpServletResponse response) throws IOException {
        System.out.println("name:=="+name+"age:=="+age);
        Student student=new Student(name,age);
        String json="";
        if(student!=null){//将结果转为json格式的数据
            ObjectMapper om=new ObjectMapper();
            json=om.writeValueAsString(student);
            System.out.println(json);
        }
        //输出数据，响应ajax的请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }


    /*
        1.处理器方法返回一个Student，通过框架转为json，响应ajax请求
        2.@ResponseBody：
            作用：把处理器方法返回对象转为json后，通过HttpServletResponse输出给浏览器
            位置：方法的定义上面，和其他注解没有顺序的关系

       3.返回对象框架的处理流程:
        1，框架会把返回student类型，调用框架的中ArrayList<HttpMessageConverter>中每个类的canwrite()方法
            检查那个HttpNessageConverter接口的实现类能处理student类型的数据--MappingJackson2HttpNessageConverter
        2.框架会调用实现类的write( ) ，NappingJackson2HttpNessageConverter的write()方法
            把李四同学的student对象转为json ,调用Jackson 的objectMapper实现转为json
           contentType: application/json;charset=utf-8
        3.框架会调用@ResponseBody把2的结果数据输出到浏览器，ajax请求处理完成

     */
    @RequestMapping(value = "/returnStudentJson.do")
    @ResponseBody
    public Student returnStudentJson(String name, Integer age) {
        System.out.println("name:=="+name+"age:=="+age);
        Student student=new Student("李四同学",20);
       return student;//会被框架转换成json

    }

    /*
        处理器方法返回list集合
     */
    @RequestMapping(value = "/returnStudentJsonList.do")
    @ResponseBody
    public List<Student> returnStudentJsonList(String name, Integer age) {
        List<Student> list=new ArrayList<>();
        System.out.println("name:=="+name+"age:=="+age);
        Student student=new Student("李四同学",20);
        list.add(student);
         student=new Student("小明",28);
        list.add(student);
        return list;//会被框架转换成json

    }

    /*
       处理器方法返回的是String，String表示数据的，不是视图
       区分返回值String是数据还是视图，看有没有@ResponseBdoy注解
       如果有@ResponseBody注解，返回String就是数据，反之就是视图

       默认使用text/plain;charset=ISO-8859-1”作为contentType,导致中文有乱码，
       解决方案;给RequestMapping增加一个屈性produces，使用这个属性指定新的contentType

      返回对象框架的处理流程:
        1，框架会把返回string类型，调用框架的中ArrayList<HttpMessageConverter>中每个类的canMrite()方法
              检查那个HttpMessageConverter接口的实现类能处理string类型的数据--StringHttpMessageconverter
        2.框架会调用实现类的write ( ) , stringHttpMessageConverter的write()方法
              把字符按照指定的编码处理text/plain;charset=ISO-8859-1(这个我们的手动改成utf-8)
        3.框架会调用@ResponseBody把2的结果数据输出到浏览器，ajax请求处理完成


    */
    @RequestMapping(value = "/returnStringData.do" ,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String returnString(String name, Integer age) {

        System.out.println("name:=="+name+" , age:=="+age);

        return "hello SpringMVC 返回对象，表示数据";

    }


}
