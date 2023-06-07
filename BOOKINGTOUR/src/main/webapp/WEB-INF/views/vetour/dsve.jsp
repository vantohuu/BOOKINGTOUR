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
			<c:if test="${sessionScope.TaiKhoan.isAdmin==1}">
			<%@ include file="../includes/Navbarc2.jsp"%></c:if>
			<c:if test="${sessionScope.TaiKhoan.isAdmin==0}">
			<%@ include file="../includes/Navbarnvc2.jsp"%></c:if>
			<div class="col py-3">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
  <button onclick="location.href = '../dsdattour.htm'"  class="btn btn-outline-secondary my-2 my-sm-0" type="submit"> << Trở lại</button>
    <a href="#submenu" style="display: inline;"
										data-bs-toggle="collapse"
										class="nav-link text-white px-0 align-middle "> <i
											class="fa-solid fa-map-location-dot"></i><
											<button class="btn btn-success">Thêm vào danh sách</button>
									</a>
										

    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
       
      </li>
    </ul>
    <form action = "../dsve/${idBK}.htm" class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Tên" name = "timkiem" >
      <button style="
    margin: 20px;
" class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
      
    
    </form>
      <button onclick="location.href = '../dsve/${idBK}.htm'"  class="btn btn-outline-success my-2 my-sm-0" type="submit">Bỏ lọc</button>
  </div>
</nav>
<ul class="collapse nav flex-column ms-1" id="submenu" data-bs-parent="#menu">
                            <li class="w-100">
                                <form action="themvetg.htm" method="post"  style="
    width: 30%;
    /* text-align: center; */
">
							<div class="form-group">
							<div>
								</div>
								<label for="recipient-name" class="col-form-label">Căn cước công dân:</label>
								<input name="CCCD" type="text" class="form-control"  />
									             <input name=idBK type="text" class="form-control" value ="${idBK}"style='display: none'/>
									             
				
								</div>
								
							
							 <button class="btn btn-info">thêm </button>
							 
						</form>
                           
                        </ul>
			<c:if test="${message==3}">
					<div class="alert alert-danger fade show" role="alert"
						style='position: fixed; width: 50%; margin-left: 230px;z-index: 100'>
						<h4 class="alert-heading">ERROR!</h4>
						<p>Chưa tạo vé tour nào để lựa chọn</p>
						<hr>
					</div>
				</c:if>
				<c:if test="${message==1}">
					<div class="alert alert-success fade show" role="alert"
						style='position: fixed; width: 50%; margin-left: 230px;z-index: 100'>
						<h4 class="alert-heading">SUCCESS!</h4>
						<p>xóa vé thành công</p>
						<hr>
					</div>
				</c:if>
				<c:if test="${message==2}">
				
					<div class="alert alert-danger" role="alert"
						style='position: fixed; width: 50%; margin-left: 230px;z-index: 100'>
						<h4 class="alert-heading">ERROR!</h4>
						<p>xóa vé thất bại</p>
						<hr>
					</div>
				</c:if>
				<c:if test="${message==4}">
				
					<div class="alert alert-danger" role="alert"
						style='position: fixed; width: 50%; margin-left: 230px;z-index: 100'>
						<h4 class="alert-heading">Không thể thêm!</h4>
						<p>Vé người lớn đã đủ</p>
						<hr>
					</div>
				</c:if>
				<c:if test="${message==5}">
				
					<div class="alert alert-danger" role="alert"
						style='position: fixed; width: 50%; margin-left: 230px;z-index: 100'>
						<h4 class="alert-heading">Không thể thêm!</h4>
						<p>Vé trẻ nhỏ đã đủ</p>
						<hr>
					</div>
				</c:if>
				<c:if test="${message==6}">
				
					<div class="alert alert-danger" role="alert"
						style='position: fixed; width: 50%; margin-left: 230px;z-index: 100'>
						<h4 class="alert-heading">Không thể thêm!</h4>
						<p>Vé trẻ em đã đủ</p>
						<hr>
					</div>
				</c:if>
				<c:if test="${message==7}">
				
					<div class="alert alert-danger" role="alert"
						style='position: fixed; width: 50%; margin-left: 230px;z-index: 100'>
						<h4 class="alert-heading">CCCD không đúng</h4>
						<p>Nhập lại CCCD chính xác</p>
						<hr>
					</div>
				</c:if>
				<c:if test="${message==8}">
				
					<div class="alert alert-danger" role="alert"
						style='position: fixed; width: 50%; margin-left: 230px;z-index: 100'>
						<h4 class="alert-heading">Tour đã đủ</h4>
						<p>không thể nhập thêm</p>
						<hr>
					</div>
				</c:if>
				
            <c:set var="message" value="0" />
				<div class="container form-dang-nhap">
					<%-- <div style='display: flex; justify-content: space-between;'>

						<a href="#submenu" style="display: inline;"
										data-bs-toggle="collapse"
										class="nav-link text-white px-0 align-middle "> <i
											class="fa-solid fa-map-location-dot"></i><
											<button class="btn btn-success">Thêm vào danh sách</button>
									</a>
										<ul class="collapse nav flex-column ms-1" id="submenu" data-bs-parent="#menu">
                            <li class="w-100">
                                <form action="themvetg.htm" method="post" >
							<div class="form-group">
							<div>
								</div>
								<label for="recipient-name" class="col-form-label">Căn cước công dân:</label>
								<input name="CCCD" type="text" class="form-control"  />
									             <input name=idBK type="text" class="form-control" value ="${idBK}"style='display: none'/>
									             
				
								</div>
								
							
							 <button class="btn btn-success">thêm </button>
							 
						</form>
                           
                        </ul>

						<div style="
    text-align: end;
">
						<form class = "d-flex my-2" action = "../dsve/${idBK}.htm">
						<label class = "mx-1 mt-2">Tìm kiếm:</label>
						 <input 
							type="text" class="form-control w-25 mx-2 " name = "timkiem" placeholder="Tên">
					<button type="submit" class="btn btn-primary">Tra</button>
				</form>
<button type="button" class="btn btn-success"
							onclick="location.href = '../dsve/${idBK}.htm'">Bỏ lọc</button></div>

					</div> --%>
						<br>
					 <h2>Danh sách vé tham gia tour</h2>
					<br>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">STT</th>
								<th scope="col">CCCD</th>
								<th scope="col">Họ Tên khách hàng</th>
								<th scope="col">Phí di chuyển</th>
								<th scope="col">Giá vé</th>
								<th scope="col">Giá cọc</th>
								<th scope="col">Xử lý</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="counter" value="${offset+1 }" />
							<c:forEach var="ctvetour" items="${ctvetours}">

								<tr>
									<th scope="row">${counter}</th>
									<td scope="row">${ctvetour.khachHang.cCCD}</td>
									<td scope="row">${ctvetour.khachHang.ho} ${ctvetour.khachHang.ten}</td>
									<%-- <td>${ctvetour.veTour.phiDiChuyen}</td> --%>
									<td>${ctvetour.veTour.phiDiChuyen}</td>
									<td>${ctvetour.veTour.phiDiChuyen}</td>
									<td>${ctvetour.veTour.phiDiChuyen}</td>
									
																	<td style='display: flex; justify-content: flex-start;'>
									<div class="dropdown" style="margin-right: 10px;">
											<button class="btn btn-primary dropdown-toggle"
												data-toggle="dropdown">Chi tiết</button>
											<div class="dropdown-menu"
												aria-labelledby="dropdownMenuButton">
												<div class="container">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLabel">Thông tin Chi tiết</h5>
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close"></button>
													</div>
													<div class="modal-body" style="width: 500px;">

														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Căn cước công dân:</label>
																 <label for="recipient-name"
																	class="col-form-label"> 
																	${ctvetour.khachHang.cCCD}</label>
															</div>
														</div>
														 <div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Họ và tên :</label>
																 <label for="recipient-name"
																	class="col-form-label"> 
																	${ctvetour.khachHang.ho} ${ctvetour.khachHang.ten}</label>
															</div>
														</div> 
														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Số điện thoại:</label>
																 <label for="recipient-name"
																	class="col-form-label"> 
																	${ctvetour.khachHang.sDT}</label>
															</div>
														</div> 
														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Email :</label>
																 <label for="recipient-name"
																	class="col-form-label"> 
																	${ctvetour.khachHang.email}</label>
															</div>
														</div> 
														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Ghi chú khách hàng:</label>
																 <label for="recipient-name"
																	class="col-form-label"> 
																	${ctvetour.khachHang.ghiChu}</label>
															</div>
														</div> 
														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Nhân viên lập :</label>
																 <label for="recipient-name"
																	class="col-form-label"> 
																	${ctvetour.nhanVienXN.ho} ${ctvetour.nhanVienXN.ten}</label>
															</div>
														</div> 
														<div class="row">
															<div class="col">
																<label for="recipient-name" class="col-form-label">Nhân viên hủy :</label>
																 <label for="recipient-name"
																	class="col-form-label"> 
																	${ctvetour.nhanVienHuy.ho} ${ctvetour.nhanVienHuy.ten}</label>
															</div>
														</div> 
								
														<%-- <div class="row">
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
														</div> --%>
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
										href="suactve/${ctvetour.id}.htm"><button
												class="btn btn-primary">chỉnh sửa</button> </a> 

										<button
											onclick="if(confirm('bạn có chắc chắn muốn xóa nhân viên này không ?')){location.href='xoactve/${ctvetour.id}.htm'}"
											class="btn btn-danger" style='margin-left: 7px;'>Xóa</button>
</td>
								</tr>
<c:set var="counter" value="${counter+1}" />
							</c:forEach>
						</tbody>
					</table>
					<div style="
    margin: 50px;
">
					<ul class="pagination" style="position: absolute; bottom: 0; right: 0;width:400px;">
			    <li class="page-item ${currentPage == 0 ? 'disabled' : ''}">
			        <a class="page-link" href="../dsve/${idBK }.htm?currentPage=${currentPage - 1}">Trước</a>
			    </li>
			    <c:forEach begin="0" end="${totalPages - 1}" var="i">
			        <li class="page-item ${currentPage == i ? 'active' : ''}">
			            <a class="page-link" href="../dsve/${idBK }.htm?currentPage=${i}">${i + 1}</a>
			        </li>
			    </c:forEach>
			    <li class="page-item ${currentPage == totalPages - 1 ? 'disabled' : ''}">
			        <a class="page-link" href="../dsve/${idBK }.htm?currentPage=${currentPage + 1}">Sau</a>
			    </li>
			</ul>
			</div>
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