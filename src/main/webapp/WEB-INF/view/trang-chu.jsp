<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post"
action="/nhan-vien/search">
    <h3>Search:</h3>
    <br/>
    Tuổi Min:<input name="tuoiMin">
    <br/>
    Tuổi Max:<input name="tuoiMax">
    <br/>
    <button>Search</button>
</form>

<form:form method="post"
           action="/nhan-vien/add"
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
    <form:button>Add</form:button>
</form:form>

<table>
    <thead>
    <tr>
        <th><b>#</b></th>
        <th><b>Mã</b></th>
        <th><b>Họ và tên</b></th>
        <th><b>Giới tính</b></th>
        <th><b>Tuổi</b></th>
        <th><b>Chức vụ</b></th>
        <th><b>Cửa hàng</b></th>
        <th><b>Action</b></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${nhanViens}" var="nhanVien" varStatus="stt">
        <tr>
            <td>${stt.index}</td>
            <td>${nhanVien.ma}</td>
            <td>${nhanVien.ho} ${nhanVien.tenDem} ${nhanVien.ten}</td>
            <td>${nhanVien.gioiTinh}</td>
            <td>${2023 - nhanVien.ngaySinh.toLocalDate().getYear()}</td>
            <td>${nhanVien.chucVu.ten}</td>
            <td>${nhanVien.cuaHang.ten}</td>
            <td>
                <a href="/nhan-vien/view-update/${nhanVien.id}" type="buton">Update</a>
                <a href="/nhan-vien/remove/${nhanVien.id}" type="buton">Remove</a>
                <a href="/nhan-vien/detail/${nhanVien.id}" type="buton">Detail</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:forEach begin="0" end="${ nhanViens1.totalPages -1}" varStatus="loop">
    <li class="page-item">
        <a class="page-link" href="/nhan-vien/hien-thi?page=${loop.begin + loop.count - 1}">
                ${loop.begin + loop.count }
        </a>
    </li>
</c:forEach>
</body>
</html>