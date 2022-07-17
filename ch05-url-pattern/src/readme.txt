ch04-return:处理器方法的返回值表示请求的处理结果
1.ModelAndView：有数据和视图，对视图执行forward
2.String:表示视图，可以逻辑名称，也可以是完整的视图路径
3.void：不能表示数据，也不能表示视图，
            在处理ajax时，可以使用void返回值，同HttpServletResponse输出数据，
            响应ajax请求。ajax请求服务器端返回的就是数据，和视图无关
4.Object：例如String，Integer，Map,list,Student 等等都是对象
    对象有属性，属性就是数据，所有返回Object表示数据，和视图无关
    可以使用对象表示数据，响应ajax请求

    现在做ajax，主要使用json的数据格式。实现步骤：
    1.加入处理json的工具库的依赖，springmvc默认使用的Jackson。
    2.在springmvc配置文件之间加入<mvc:annotation-driven> 注解驱动 将java对象变成json对象
        json = om.writeValueAsString(Student);
        <mvc:annotation-driven>在加人到springmvc配置文件后，会自动创建HttpMessageConverter接口的7个实现类对象，
        包括 NappingJackson2HttpNessageConverter(使用jackson工具库中的objectNapper实现java对象转为json)

    3.在处理器方法的上面加入@ResponseBody注解 ，通过HttpservletResponse输出数据,发送json对象给前端,，响应ajax请求的。
       response.setContentType("application/json;charset=utf-8");
       PrintWriter out=response.getWriter();
       out.println(json);

    springmvc处理器方法返回Object，可以转为json输出到浏览器，响应ajax的内部原理
1.<mvc:annotation-driven> 注解驱动
        注解驱动的主要功能是完成java对象到json。xml.text。二进制等数据格式的转换。
        HttpMessageConveter接口：消息转换器。
        功能：定义了java转为json，xml等数据格式的方法，这个接口有很多实现类。
        这些实现类完成java对象到json，java对象到xml，java对象到二进制数据格式的转换

    下面的两个方法是控制器类把结果输出给浏览器时使用的:
    boolean canwrite(class<?> var1，@Nullable MediaType var2);
    void write(T var1，@Nullable MediaType var2，HttpoutputMessage var3)
    例如处理器方法
    @RequestMapping("/doReturnView2")
    public student doReturnView2(HttpServletRequest request,string name，Integer age){
            student student = new student();
            student.setName("lisi");
            student.setAge(20);
            return student;
    }
    1 ) canwrite作用检查处理器方法的返回值，能不能转为var2表示的数据格式。
        检查student(lisi , 20)能不能转为var2表示的数据格式。如果检查能转为json , canwrite返回true
        MediaType:表示数格式的，例如json , xml等等
    2 ) write:把处理器方法的返回值对象，调用jackson中的objectMapper转为json字符串。
        json = om.writevalueAsstring(student);

2.@ResponseBody注解
    放在处理器方法的上面，通过HttpservletResponse输出数据，响应ajax请求的。
    Printwriter pw= response.getwriter();
    pw.println(json);
    pw.flush();
    pw.close();





