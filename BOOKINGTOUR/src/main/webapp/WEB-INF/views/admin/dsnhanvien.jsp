<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN</title>
<link href='assets/css/trangchu.css' rel='stylesheet'>
<link href='assets/css/all.css' rel='stylesheet'>


<head>
    <title>Admin quản lý du lịch</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
        integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
        integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
        crossorigin="anonymous"></script>
</head>
<body>
   <div class="container-fluid">
    <div class="row flex-nowrap">
  <%@ include file="../includes/NavAdmin.jsp" %>
 <div class="col py-3">
<div class="container form-dang-nhap">
    <div style='display: flex;
  justify-content: space-between;'>
    
     <button type="button" class="btn btn-success" onclick="location.href = './themtaikhoan.htm'">Thêm nhân viên mới</button>
    <input type="text" name="timkiem"  placeholder=" Tìm kiếm" style='padding:3px'>
   
    </div>
    <br>
    <table class="table">
  <thead>
    <tr>
    <th scope="col">Mã</th>
      <th scope="col">Họ tên</th>
      <th scope="col">Chức vụ</th>
      <th scope="col">Xử lý</th>
    </tr>
  </thead>
						<tbody>
							<c:forEach var="nhanvien" items="${nhanviens}">

								<tr>
									<th scope="row">${nhanvien.maNV}</th>
									<td>${nhanvien.ho}${nhanvien.ten}</td>
									<td><%-- ${nhanvien.taikhoan.isAdmin} --%>
								<%-- <c:if test="${nhanvien.taikhoan.isAdmin() = false}" >
									Quản lý</c:if> --%>
									<c:if test="${nhanvien.taikhoan.isAdmin}" >
									Admin</c:if>  
									</td>
									<td style='display: flex; justify-content: flex-start;'>
										<form action="suattnhanvien.htm" method="post">
											<button name="manv" value="${nhanvien.maNV}"
												class="btn btn-primary">chỉnh sửa</button>
										</form>
										<form action="suattnhanvien.htm" method="post">
											<button type="button" class="btn btn-danger"
												style='margin-left: 7px;'>xóa</button>
										</form>
									</td>

								</tr>

							</c:forEach>
						</tbody>
					</table>
       </div>

    </div>
 
    </div></div>
</body>
</html>