<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
  <%@ include file="../includes/backNavAdmin.jsp" %>
 <div class="col py-3">
<div class="container form-dang-nhap">
<div><h1>Sửa thông tin nhân viên</h1></div>
      <div class="modal-body">
        <form:form action="update.htm" modelAttribute="nhanVien">
          <div class="form-group">
          <div class="row">
    <div class="col">
      <label for="recipient-name" class="col-form-label">Mã nhân viên :</label>
            <input type="text" class="form-control" name="maNV" value="${nhanVien.maNV}">
    <span style="color: red;">${messageMaNV}</span>
    </div>
    <div class="col">
      <label for="recipient-name" class="col-form-label">Họ và tên :</label>
            <input type="text" class="form-control" name="hoTen" value="${nhanVien.ho} ${nhanVien.ten}">
    </div>
     </div>
      <div class="row">
    <div class="col">
      <label for="recipient-name" class="col-form-label">Căn cước công dân :</label>
            <input type="text" class="form-control" name="cCCD" value="${nhanVien.cCCD}">
            <span style="color: red;">${messageCCCD}</span>
    </div>
    <div class="col">
    <c:if test="${nhanVien.gioiTinh =='nam'}" >
      <label for="recipient-name" class="col-form-label">Giới tính :</label><br>
		<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="gioiTinh"  checked value="nam">
  <label class="form-check-label" for="nam">Nam</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="gioiTinh"  value="nu">
  <label class="form-check-label" for="nu">Nữ</label>
</div>
</c:if> 
<c:if test="${nhanVien.gioiTinh == 'nữ'}" >
      <label for="recipient-name" class="col-form-label">Giới tính :</label><br>
		<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="gioiTinh"   value="nam">
  <label class="form-check-label" for="nam">Nam</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="gioiTinh" checked value="nu">
  <label class="form-check-label" for="nu">Nữ</label>
</div>
</c:if> 
    </div>
     </div>
    <div class="row">
    <div class="col">
      <label for="recipient-name" class="col-form-label">Ngày sinh :</label>
            <input type="date" class="form-control" value="${nhanVien.ngaySinh}">
    </div>
    <div class="col">
      <label for="recipient-name" class="col-form-label">Số điện thoại :</label>
		<input type="tel" class="form-control" id="phone" name="sDT" value="${nhanVien.sDT}">
    </div>
     </div>
  
            <label for="recipient-name" class="col-form-label">Địa chỉ:</label>
            <input type="text" class="form-control" name="${diaChi}" value="${nhanVien.diaChi}">
            <label for="recipient-name" class="col-form-label">Email :</label>
           <input type="email" class="form-control" name="email" id="inputEmail4" value="${nhanVien.email}">
            
      <label for="recipient-name" class="col-form-label">Chức vụ :</label><br>
      <c:if test="${nhanVien.taikhoan.isAdmin ==0}" >
		<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="isAdmin"  checked value="0">
  <label class="form-check-label" for="0">Nhân viên quản lý</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="isAdmin"  value="1">
  <label class="form-check-label" for="1">Admin</label>
</div>
</c:if>
      <c:if test="${nhanVien.taikhoan.isAdmin ==1}" >
		<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="isAdmin"  value="0">
  <label class="form-check-label" for="0">Nhân viên quản lý</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="isAdmin"  checked value="1">
  <label class="form-check-label" for="1">Admin</label>
</div>
</c:if>
          </div>
          <div><span style="color: red;">${message}</span></div>
        <button class="btn btn-primary">cập nhập nhân viên</button>
        </form:form>
      </div>
    </div>
 <div class="modal-footer">
 	<div style='display: block;'>
    <input type="text" name="timkiem"  placeholder=" Tìm kiếm" style='padding:3px'>
    </div>
   
    <br>
        <table class="table">
  <thead>
    <tr>
    <th scope="col">Mã</th>
      <th scope="col">Họ tên</th>
      <th scope="col">Chức vụ</th>
      <th scope="col">Căn cước công dân</th>
      <th scope="col">Giới tính</th>
      <th scope="col">Ngày sinh</th>
      <th scope="col">Số điện thoại</th>
      <th scope="col"></th>
    </tr>
  </thead>
						<tbody>
							<c:forEach var="nhanvien" items="${nhanviens}">

								<tr>
									<th scope="row">${nhanvien.maNV}</th>
									<td>${nhanvien.ho} ${nhanvien.ten}</td>
									<td><%-- ${nhanvien.taikhoan.isAdmin} --%>
								 <c:if test="${nhanvien.taikhoan.isAdmin ==0}" >
									Quản lý</c:if> 
									<c:if test="${nhanvien.taikhoan.isAdmin ==1 }" >
									Admin</c:if>  
									</td>
									<td>${nhanvien.cCCD}</td>
									<td>${nhanvien.gioiTinh}</td>
									<td>${nhanvien.ngaySinh}</td>
									<td>${nhanvien.sDT}</td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
					</div>
       </div>
        </div>
       </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>