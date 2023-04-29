package test;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TAIKHOAN")
public class LoaiLuuTru {
	@Id
	@Column(name="MALLT")
	private  int maLLT;
	@Column(name="TENLOAILUUTRU")
	private  String tenLoaiLuuTru;
	@OneToMany(mappedBy = "loaiLuuTru", fetch = FetchType.EAGER)
	private List<NoiLuuTru> noiLuuTru;
	
	public int getMaLLT() {
		return maLLT;
	}
	public void setMaLLT(int maLLT) {
		this.maLLT = maLLT;
	}
	public String getTenLoaiLuuTru() {
		return tenLoaiLuuTru;
	}
	public void setTenLoaiLuuTru(String tenLoaiLuuTru) {
		this.tenLoaiLuuTru = tenLoaiLuuTru;
	}
	public List<NoiLuuTru> getNoiLuuTru() {
		return noiLuuTru;
	}
	public void setNoiLuuTru(List<NoiLuuTru> noiLuuTru) {
		this.noiLuuTru = noiLuuTru;
	}
	
}
