<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container-fluid">
		<div class="row flex-nowrap">
			<div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-primary">
				<div
					class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
					<a href="/"
						class="d-flex align-items-center pb-5 pt-5 mb-md-0 me-md-auto text-white text-decoration-none">
						<span class="fs-5 d-none d-sm-inline">ADMIN</span>
					</a>
					<ul
						class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start"
						id="menu">
						<li class="nav-item"><a href="home.htm"
							class="nav-link text-white align-middle px-0"><i
								class="fa-solid fa-house"></i> <span
								class="ms-1 d-none d-sm-inline">Home</span>
						</a></li>
						<li><a href="#submenu1" data-bs-toggle="collapse"
							class="nav-link text-white px-0 align-middle">
							<i class="fa-regular fa-calendar-days"></i> <span
								class="ms-1 d-none d-sm-inline">Danh sách nhân viên</span>
						</a>
							
								<li class="w-100"><a href="thevao.htm"
									class="nav-link text-white px-0"><i class="fa-solid fa-map-location-dot"></i> <span
										class="d-none d-sm-inline">Địa điểm du lịch</span></a></li>
								<li><a href="thera.htm" class="nav-link text-white px-0">
								<i class="fa-solid fa-hotel"></i>
										<span class="d-none d-sm-inline">Điểm lưu trú</span>
								</a></li>
								<li><a href="lichsugui.htm"
									class="nav-link text-white px-0">
									<i class="fa-solid fa-rectangle-list"></i> <span
										class="d-none d-sm-inline">Danh sách đặt tour</span></a></li>
							
						<li><a href="lich.htm"
							class="nav-link text-white px-0 align-middle"><i class="fa-solid fa-people-group"></i> <span
								class="ms-1 d-none d-sm-inline">Danh sách khách hàng</span>
						</a></li>
						<li><a href="lich.htm"
							class="nav-link text-white px-0 align-middle"> <i class="fa-solid fa-ticket"></i><span
								class="ms-1 d-none d-sm-inline">Giá vé</span>
						</a></li>
						<li><a href="#submenu2" data-bs-toggle="collapse"
							class="nav-link text-white px-0 align-middle "> <i class="fa-solid fa-sack-dollar"></i><span
								class="ms-1 d-none d-sm-inline">Khuyến mãi</span></a>
</ul>

							<ul class="collapse nav flex-column ms-1" id="submenu2"
								data-bs-parent="#menu">
								<li class="w-100"><a href="doanhthu.htm"
									class="nav-link px-0"> <span class="d-none d-sm-inline">Doanh
											thu</span></a></li>
								<li><a href="nhanvien.htm" class="nav-link px-0"> <span
										class="d-none d-sm-inline">Nhân viên</span></a></li>
								<li><a href="quanlithethang.htm" class="nav-link px-0">
										<span class="d-none d-sm-inline">Nhân viên</span>
								</a></li>
								<li><a href="quanlilich.htm" class="nav-link px-0"> <span
										class="d-none d-sm-inline">Lịch</span></a></li>

								<li><a href="chucvu.htm" class="nav-link px-0"> <span
										class="d-none d-sm-inline">Chức vụ</span></a></li>
								<li><a href="quanlitaikhoan.htm" class="nav-link px-0">
										<span class="d-none d-sm-inline">Tài khoản</span>
								</a></li>
								<li><a href="bangluong.htm" class="nav-link px-0"> <span
										class="d-none d-sm-inline">Bảng lương</span></a></li>

								<li><a href="chinhsuaphi.htm" class="nav-link px-0"> <span
										class="d-none d-sm-inline">Phí gửi xe</span></a></li>

							</ul>

						<hr>

						<div class="dropdown pb-4">
							<a href="#"
								class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
								id="dropdownUser1" data-bs-toggle="dropdown"
								aria-expanded="false"> <img src="https://github.com/mdo.png"
								alt="hugenerd" width="30" height="30" class="rounded-circle">
								<span class="d-none d-sm-inline mx-1">Tài khoản</span>
							</a>
							<ul class="dropdown-menu dropdown-menu-dark text-small shadow">

								<li><a class="dropdown-item" href="nhanvien-thongtin.htm">Chỉnh
										sửa thông tin cá nhân</a></li>
								<li><a class="dropdown-item" href="doimatkhau.htm">Đổi
										mật khẩu</a></li>
								<li>
									<hr class="dropdown-divider">
								</li>
								<li><a class="dropdown-item" href="logout.htm">Đăng
										xuất</a></li>
							</ul>
						</div>
				</div>
			</div>
			<div class="" col py-3 d-flex justify-content-centeralign-items-center"">

			</div>
		</div>
	</div>