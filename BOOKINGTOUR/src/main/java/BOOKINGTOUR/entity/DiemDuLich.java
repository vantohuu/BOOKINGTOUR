package BOOKINGTOUR.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DIEMDULICH")
public class DiemDuLich {
	@Id
	@Column(name="MADIEM")
	private  int maDiem;
	@Column(name="TEN")
	private  String ten;
	@Column(name="DIACHI")
	private  String diaChi;
	@Column(name="MOTA")
	private  String moTa;
	@Column(name="HINHANH")
	private  String hinhAnh;
	
	@ManyToMany
    private List<Tour> tours ;
	
	
	public int getMaDiem() {
		return maDiem;
	}
	public void setMaDiem(int maDiem) {
		this.maDiem = maDiem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	

	
	

}
