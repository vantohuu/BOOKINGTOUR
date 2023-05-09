package test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PHONG")
public class Phong {
	@Id
	@Column(name="MAPHONG")
	private  int maPhong;
	@Column(name="TENPHONG")
	private  String tenPhong;
	@Column(name="GIA")
	private  int gia;
	@Column(name="SOGIUONG")
	private  int soGiuong;
	@Column(name="SLNGUOI")
	private  int sLNguoi;
	
	@Column(name="HANGPHONG")
	private  String hangPhong;
	
	@ManyToOne()
	@JoinColumn(name="IDCTPLT")
	private CTPhongLuuTru cTPhongLuuTru1;
	
	@ManyToOne()
	@JoinColumn(name="MANLT")
	private NoiLuuTru noiLuuTru1;

	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public int getSoGiuong() {
		return soGiuong;
	}

	public void setSoGiuong(int soGiuong) {
		this.soGiuong = soGiuong;
	}

	public int getsLNguoi() {
		return sLNguoi;
	}

	public void setsLNguoi(int sLNguoi) {
		this.sLNguoi = sLNguoi;
	}

	public String getHangPhong() {
		return hangPhong;
	}

	public void setHangPhong(String hangPhong) {
		this.hangPhong = hangPhong;
	}

	public CTPhongLuuTru getcTPhongLuuTru1() {
		return cTPhongLuuTru1;
	}

	public void setcTPhongLuuTru1(CTPhongLuuTru cTPhongLuuTru1) {
		this.cTPhongLuuTru1 = cTPhongLuuTru1;
	}

	public NoiLuuTru getNoiLuuTru1() {
		return noiLuuTru1;
	}

	public void setNoiLuuTru1(NoiLuuTru noiLuuTru1) {
		this.noiLuuTru1 = noiLuuTru1;
	}
	
	

}