package BOOKINGTOUR.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;





@Entity
@Table(name="TAIKHOAN")
public class TaiKhoan {
	@Id
	@Column(name="MANV")
	private String MANV;
	
	@OneToOne()
	@JoinColumn(name="MANV")
    private NhanVien nhanVien;
	@Column(name="PASSWORD")
	private  String PASSWORD;
	@Column(name="ISADMIN")
	private  boolean isAdmin;
	public String getMANV() {
		return MANV;
	}
	public void setMANV(String mANV) {
		MANV = mANV;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	
	
	

}
