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

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
	integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
	integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
	crossorigin="anonymous"></script>
<style>
.dropdown-menu.show {
	left: -800px;
	background-color: aliceblue;
}
</style>
</head>
<body>

	<div class="container-fluid">
		<div class="row flex-nowrap">
			<%@ include file="../includes/Navbarc1.jsp"%>
			<div class="col py-3">
				<c:if test="${message==1}">
				
					
					<div class="alert alert-success fade show" role="alert"
						style='position: fixed; width: 50%; margin-left: 230px;z-index: 100'>
						<h4 class="alert-heading">SUCCESS!</h4>
						<p>xóa nhân viên thành công</p>
						<hr>
					</div>
				</c:if>
				<c:if test="${message==2}">
				
					<div class="alert alert-danger" role="alert"
						style='position: fixed; width: 50%; margin-left: 230px;z-index: 100'>
						<h4 class="alert-heading">ERROR!</h4>
						<p>xóa nhân viên thất bại</p>
						<hr>
					</div>
				</c:if>
				
            <c:set var="message" value="0" />
				<div class="container form-dang-nhap">
					<div style='display: flex; justify-content: space-between;'>

						<button type="button" class="btn btn-success"
							onclick="location.href = 'themdiemluutru.htm'">Thêm điểm lưu trú mới</button>

						<input type="text" name="timkiem" placeholder=" Tìm kiếm"
							style='padding: 3px'>

					</div>
					<br>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Tên</th>
								<th scope="col">Quản lý</th>
								<th scope="col">Xử lý</th>
							</tr>
						</thead>
						<tbody>
						
							<c:forEach var="diemluutru" items="${diemluutrus}">

								<tr>
									<th scope="row">${diemluutru.id}</th>
									
									<td>${diemluutru.tenNLT}</td>
									<td><a
										href="dsphong/${diemluutru.id}.htm"><button
												class="btn btn-primary">Phòng</button> </a></td>
																	<td style='display: flex; justify-content: flex-start;'>
									<div class="dropdown" style="margin-right: 10px;">
											<button class="btn btn-primary dropdown-toggle"
												data-toggle="dropdown">Chi tiết</button>
											<div class="dropdown-menu"
												aria-labelledby="dropdownMenuButton">
												<div class="container">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLabel">Thông
															tin địa điểm</h5>
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close"></button>
													</div>
													<div class="modal-body" style="width: 500px;">

														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Tên :</label>
																 <label for="recipient-name"
																	class="col-form-label"> 
																	${diemluutru.tenNLT}</label>
															</div>
														</div>
														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Loại hình :</label>
																 <label for="recipient-name"
																	class="col-form-label"> 
																	${diemluutru.loaiLuuTru.ten}</label>
															</div>
														</div>
														<c:if test="${diemluutru.chatLuong !=0}">
														<div class="row">
															<div class="col">
															
																<label for="recipient-name" class="col-form-label">Hạng
																	:</label>
																	
																	
										<c:choose>
   <c:when test="${diemluutru.chatLuong ==1}">
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
   </c:when>
   <c:when test="${diemluutru.chatLuong ==2}">
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i><i class="fa-solid fa-star" style="color: #e9ed02;"></i>
   </c:when>
   <c:when test="${diemluutru.chatLuong ==3}">
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
   </c:when>
   <c:when test="${diemluutru.chatLuong ==4}">
     
<i class="fa-solid fa-star" style="color: #e9ed02;"></i>
<i class="fa-solid fa-star" style="color: #e9ed02;"></i>
<i class="fa-solid fa-star" style="color: #e9ed02;"></i>
<i class="fa-solid fa-star" style="color: #e9ed02;"></i>
   </c:when>
   <c:when test="${diemluutru.chatLuong ==5}">
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
      <i class="fa-solid fa-star" style="color: #e9ed02;"></i>
   </c:when>
   <c:otherwise>

   </c:otherwise>
</c:choose>
															</div>
														</div>
														</c:if>
														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Địa chỉ :</label> 
																<label for="recipient-name"
																	class="col-form-label">${diemluutru.diaChi}</label>
															</div>
														</div>
														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Số điện thoại :</label> 
																<label for="recipient-name"
																	class="col-form-label">${diemluutru.sDT}</label>
															</div>
														</div>
														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Email :</label> 
																<label for="recipient-name"
																	class="col-form-label">${diemluutru.email}</label>
															</div>
														</div>
														
														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Mô tả
																	:</label> <label for="recipient-name" class="col-form-label">
																	${diemluutru.moTa}</label>
															</div>
														</div>
														<%-- <div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Hình ảnh
																	:</label> <label for="recipient-name" class="col-form-label">
																	${diemdulich.hinhAnh}</label>
															</div>
														</div>
								 --%>
													

														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Đóng</button>
														</div>


													</div>
												</div>
											</div>
										</div>
									
									
											
									
										<a
										href="suadiemluutru/${diemluutru.id}.htm"><button
												class="btn btn-primary">chỉnh sửa</button> </a> 

										<button
											onclick="if(confirm('bạn có chắc chắn muốn xóa nhân viên này không ?')){location.href='xoadiemluutru/${diemluutru.id}.htm'}"
											class="btn btn-danger" style='margin-left: 7px;'>Xóa</button>
</td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script>
  setTimeout(function() {
    document.querySelector('.alert').classList.add('d-none');
  }, 2000);
</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>