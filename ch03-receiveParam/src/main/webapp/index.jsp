<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

    <a href="test/some.do">发起一个some.do 的请求 </a><br>

<h3>请求参数名和处理器方法的形参名一样</h3>
    <form action="receiveproperty.do" method="post">

        姓名： <input type="text" name="rname"><br>
        年龄： <input type="text" name="rage"><br>
       <input type="submit" value="提交参数"><br>
    </form>
<h3>请求参数名和处理器方法的形参名不一样</h3>
    <form action="receiveparam.do" method="post">

        姓名： <input type="text" name="rname"><br>
        年龄： <input type="text" name="rage"><br>
        <input type="submit" value="提交参数"><br>
    </form>
<h3>使用java对象接收请求参数</h3>
<form action="receiveObjdct.do" method="post">

    姓名： <input type="text" name="name"><br>
    年龄： <input type="text" name="age"><br>
    <input type="submit" value="提交参数"><br>
</form>
</body>
</html>
