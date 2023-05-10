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
  
   <button type="button" class="btn btn-success" onclick="location.href = 'themnhanvien.htm'">Thêm nhân viên mới</button>
    
<%--      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Thêm nhân viên</button>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Thêm nhân viên</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="themnhanvien.htm" method="post">
          <div class="form-group">
          <div class="row">
    <div class="col">
      <label for="recipient-name" class="col-form-label">Mã nhân viên :</label>
            <input type="text" class="form-control" name="maNV" placeholder="Mã nhân viên" value="${maNv}">
    </div>
    <div class="col">
      <label for="recipient-name" class="col-form-label">Họ và tên :</label>
            <input type="text" class="form-control" name="hoTen" placeholder="Nguyen Van A">
    </div>
     </div>
      <div class="row">
    <div class="col">
      <label for="recipient-name" class="col-form-label">Căn cước công dân :</label>
            <input type="text" class="form-control" name="cCCD"">
    </div>
    <div class="col">
      <label for="recipient-name" class="col-form-label">Giới tính :</label><br>
		<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="gioitinh" id="nam" checked>
  <label class="form-check-label" for="nam">Nam</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="gioitinh" id="nu">
  <label class="form-check-label" for="nu">Nữ</label>
</div>
    </div>
     </div>
    <div class="row">
    <div class="col">
      <label for="recipient-name" class="col-form-label">Ngày sinh :</label>
            <input type="date" class="form-control" name="ngaySinh">
    </div>
    <div class="col">
      <label for="recipient-name" class="col-form-label">Số điện thoại :</label>
		<input type="tel" class="form-control" id="phone" name="sDT" placeholder="0999999999">
    </div>
     </div>
  
            <label for="recipient-name" class="col-form-label">Địa chỉ:</label>
            <input type="text" class="form-control" name="${diaChi}" placeholder="54, đường số 8, Linh Trung ,Tp. Thủ Đức, Tp. Hồ Chí Minh">
            <label for="recipient-name" class="col-form-label">Email :</label>
           <input type="email" class="form-control" name="email" id="inputEmail4" placeholder="nguyenvana@gmail.com">
          </div>
           <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
        <button class="btn btn-primary">Thêm</button>
      </div>
        </form>
      </div>
    </div>
  </div>
</div> --%>
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
									<td>${nhanvien.ho} ${nhanvien.ten}</td>
									<td><%-- ${nhanvien.taikhoan.isAdmin} --%>
								 <c:if test="${nhanvien.taikhoan.isAdmin ==0}" >
									Quản lý</c:if> 
									<c:if test="${nhanvien.taikhoan.isAdmin ==1 }" >
									Admin</c:if>  
									</td>
									<td style='display: flex; justify-content: flex-start;'>
										
											<a href="suanhanvien/${nhanvien.maNV}.htm" ><button 
												class="btn btn-primary">chỉnh sửa</button>
										</a>
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
 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>