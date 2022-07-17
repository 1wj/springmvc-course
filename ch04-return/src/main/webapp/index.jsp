<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
               $.ajax({
                  // url:"retureVoid-ajax.do",
                   //url:"returnStudentJsonList.do",
                   url:"returnStringData.do",
                   data:{
                       name:"zhangsan",
                       age:20,
                   },
                   dataType:"text",//这个的就是将返回的字符串转成json对象  不写的话后天有setContentType也是一样的效果 ,但都不写的话就不行
                   type:"post",
                   success:function (resp) {
                       //resp从服务器中返回的是json格式的字符串{"name":"zhansan","age":20}
                       //jquery会把字符串转换成json对象，赋值给resp形参
                       //alert(resp.name +"  "+resp.age);

                      alert(resp);
                   }

               });

            })
        })
    </script>
</head>
<body>
<h2>Hello World!</h2>


<h3>处理器方法返回String表示视图名称</h3>
    <form action="returnString-view.do" method="post">
        姓名： <input type="text" name="name"><br>
        年龄： <input type="text" name="age"><br>
       <input type="submit" value="提交参数"><br>
    </form>

<button id="btn">发起一个ajax请求</button>
</body>
</html>
