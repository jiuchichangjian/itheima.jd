<%--
  Created by IntelliJ IDEA.
  User: my
  Date: 2018/7/21
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<form action="fileUpload" method="post" enctype="multipart/form-data">
用户名<input type="text" name="username"><br>
文件<<input type="File" name="imgFile"><br>
<input type="submit" value="上传">
</form>
</body>
</html>
