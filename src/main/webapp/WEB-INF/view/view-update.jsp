<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post"
           action="/nhan-vien/update/${nhanVienAdd.id}"
           modelAttribute="nhanVienAdd">

    Mã: <form:input path="ma"/>
    <form:errors path="ma"/>
    <br/>

    Họ: <form:input path="ho"/>
    <form:errors path="ho"/>
    <br/>

    Tên đệm: <form:input path="tenDem"/>
    <form:errors path="tenDem"/>
    <br/>

    Tên: <form:input path="ten"/>
    <form:errors path="ten"/>
    <br/>

    Giới tính: <form:radiobutton path="gioiTinh" value="Nam" checked="true"/>Nam
    <form:radiobutton path="gioiTinh" value="Nữ"/>Nữ
    <form:errors path="ma"/>
    <br/>

    Mã Chức vụ: <form:select path="chucVu" items="${chucVus}" itemLabel="ma"/>
    <form:errors path="chucVu"/>
    <br/>

    Mã Cửa hàng: <form:select path="cuaHang" items="${cuaHangs}" itemLabel="ma"/>
    <form:errors path="cuaHang"/>
    <br/>

    Năm sinh: <form:select path="ngaySinh">
    <form:option value="2003-01-01" label="2003"/>
    <form:option value="2004-01-01" label="2004"/>
    <form:option value="2005-01-01" label="2005"/>
</form:select>
    <br/>
    <form:button>Update</form:button>
</form:form>

</body>
</html>