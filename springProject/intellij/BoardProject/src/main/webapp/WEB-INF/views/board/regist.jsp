<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2023-05-25
  Time: 오후 7:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Regist</title>
</head>
<body>

<h1>글 작성</h1>
<hr>

<form method="post" enctype="multipart/form-data">

    <table border="1">
        <tr>
            <td>제목</td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <td>내용</td>
            <td><textarea name="content" cols="30" rows="10"></textarea></td>
        </tr>
        <tr>
            <td>첨부파일</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="작성"></td>
        </tr>
    </table>

</form>

</body>
</html>