package test;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="NOILUUTRU")
public class NoiLuuTru {
	@Id
	@Column(name="MANLT")
	private  int maNLT;
	@Column(name="TENNLT")
	private  String tenNLT;
	@Column(name="DIACHI")
	private  String diaChi;
	@Column(name="SDT")
	private  String sDT;
	@Column(name="EMAIL")
	private  String email;
	@Column(name="CHATLUONG")
	private  String chatLuong;
	@Column(name="MOTA")
	private  String moTa;

	
	@ManyToOne()
	@JoinColumn(name="MALLT")
	private LoaiLuuTru loaiLuuTru;
	
	@OneToMany(mappedBy = "noiLuuTru1", fetch = FetchType.EAGER)
	private List<Phong> phong;
	public int getMaNLT() {
		return maNLT;
	}
	public void setMaNLT(int maNLT) {
		this.maNLT = maNLT;
	}
	public String getTenNLT() {
		return tenNLT;
	}
	public void setTenNLT(String tenNLT) {
		this.tenNLT = tenNLT;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getChatLuong() {
		return chatLuong;
	}
	public void setChatLuong(String chatLuong) {
		this.chatLuong = chatLuong;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public LoaiLuuTru getLoaiLuuTru() {
		return loaiLuuTru;
	}
	public void setLoaiLuuTru(LoaiLuuTru loaiLuuTru) {
		this.loaiLuuTru = loaiLuuTru;
	}
	public List<Phong> getPhong() {
		return phong;
	}
	public void setPhong(List<Phong> phong) {
		this.phong = phong;
	}

	
	
	

}