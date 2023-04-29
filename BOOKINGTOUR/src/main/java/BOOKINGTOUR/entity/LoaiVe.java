package BOOKINGTOUR.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LOAIVE")
public class LoaiVe {
	@Id
	@Column(name="MALOAIVE")
	private  int maLoaiVe;
	@Column(name="TENLOAIVE")
	private  String tenLoaiVe;
	
	@OneToMany(mappedBy = "loaiVe", fetch = FetchType.EAGER)
	private List<VeTour> veTours;

	public int getMaLoaiVe() {
		return maLoaiVe;
	}

	public void setMaLoaiVe(int maLoaiVe) {
		this.maLoaiVe = maLoaiVe;
	}

	public String getTenLoaiVe() {
		return tenLoaiVe;
	}

	public void setTenLoaiVe(String tenLoaiVe) {
		this.tenLoaiVe = tenLoaiVe;
	}

	public List<VeTour> getVeTours() {
		return veTours;
	}

	public void setVeTours(List<VeTour> veTours) {
		this.veTours = veTours;
	}
	

}
