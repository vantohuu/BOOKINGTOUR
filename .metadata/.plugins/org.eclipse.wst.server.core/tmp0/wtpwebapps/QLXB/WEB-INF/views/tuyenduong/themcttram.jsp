
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
						<p>Xóa chi tiết tour thành công</p>
						<hr>
					</div>
				</c:if>
				<c:if test="${message==2}">
				
					<div class="alert alert-danger" role="alert"
						style='position: fixed; width: 50%; margin-left: 230px;z-index: 100'>
						<h4 class="alert-heading">ERROR!</h4>
						<p>xóa chi tiết tour thất bại</p>
						<hr>
					</div>
				</c:if>
				
            <c:set var="message" value="0" />
				<div class="container form-dang-nhap">
					<div style='display: flex; justify-content: space-between;'>

						
						<input type="text" name="timkiem" placeholder=" Tìm kiếm"
							style='padding: 3px'>

					</div>
					<br>
	<table class="table">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Tên</th>
								<th scope="col">Địa chỉ</th>
								<th scope="col">Xử lý</th>
							</tr>
						</thead>
						<tbody>
						
							<c:forEach var="tramxe" items="${tramxes}">

								<tr>
									<th scope="row">${tramxe.maSo}</th>
									
									<td>${tramxe.ten}</td>
								<td>${tramXe.diaChi}</td>
									
																	<td style='display: flex; justify-content: flex-start;'>
									
											
									           <form action="insertcttour.htm" method="post" >
									           <input name="id" type="text" class="form-control" value ="${tramxe.maSo}" style='display: none'/>
									             <input name="idtour" type="text" class="form-control" value ="${idTD}"style='display: none'/>
									            
										
										<button
												 class="btn btn-success" >Thêm vào danh sách</button>  </form>

										
</td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
	<%-- 				<div style="
    margin: 50px;
">
					<ul class="pagination" style="position: absolute; bottom: 0; right: 0;width:400px;">
			    <li class="page-item ${currentPage == 0 ? 'disabled' : ''}">
			        <a class="page-link" href="../themcttuyenduong/${idTD }.htm?currentPage=${currentPage - 1}">Trước</a>
			    </li>
			    <c:forEach begin="0" end="${totalPages - 1}" var="i">
			        <li class="page-item ${currentPage == i ? 'active' : ''}">
			            <a class="page-link" href="../themcttuyenduong/${idTD}.htm?currentPage=${i}">${i + 1}</a>
			        </li>
			    </c:forEach>
			    <li class="page-item ${currentPage == totalPages - 1 ? 'disabled' : ''}">
			        <a class="page-link" href="../themcttuyenduong/${idTD }.htm?currentPage=${currentPage + 1}">Sau</a>
			    </li>
			</ul>
			</div> --%>
			
			<div style="
    margin: 50px;
">
					<ul class="pagination" style="position: absolute; bottom: 0; right: 0;width:400px;">
			    <li class="page-item ${currentPage == 0 ? 'disabled' : ''}">
			        <a class="page-link" href="../themcttuyenduong/${idTD}.htm?page=${currentPage - 1}">Trước</a>
			    </li>
			    <c:set var="x" value="${currentPage}" /> 
			    <c:set var="y" value="${currentPage +2}" /> 
			    <c:if test="${currentPage < 3}">  <c:set var="x" value="${0}" /> </c:if>
			    <c:if test="${ x+3 > totalPages}">  <c:set var="y" value="${totalPages-1}" /> <c:set var="x" value="${currentPage-1}" /> </c:if>
			    <c:forEach begin="${x}" end="${y}" var="i">
			        <li class="page-item ${currentPage == i ? 'active' : ''}">
			            <a class="page-link" href="../themcttuyenduong/${idTD }.htm?page=${i}">${i + 1}</a>
			        </li>
			    </c:forEach>
			    <li class="page-item ${currentPage == totalPages - 1 ? 'disabled' : ''}">
			        <a class="page-link" href="../themcttuyenduong/${idTD }.htm?page=${currentPage + 1}">Sau</a>
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