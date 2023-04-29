package test;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="KHUYENMAI")
public class KhuyenMai {
	@Id
	@Column(name="MAKM")
	private  int maKM;
	@Column(name="TEN")
	private  String ten;
	@Column(name="MOTA")
	private  String moTa;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="TGBD")
	private  Date tGBD;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="TGKT")
	private  Date tGKT;
	@Column(name="SOTIENGIAM")
	private  int soTienGiam;
	
	@OneToMany(mappedBy = "khuyenMai", fetch = FetchType.EAGER)
	private List<CTVe> cTve;

	public int getMaKM() {
		return maKM;
	}

	public void setMaKM(int maKM) {
		this.maKM = maKM;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Date gettGBD() {
		return tGBD;
	}

	public void settGBD(Date tGBD) {
		this.tGBD = tGBD;
	}

	public Date gettGKT() {
		return tGKT;
	}

	public void settGKT(Date tGKT) {
		this.tGKT = tGKT;
	}

	public int getSoTienGiam() {
		return soTienGiam;
	}

	public void setSoTienGiam(int soTienGiam) {
		this.soTienGiam = soTienGiam;
	}

	public List<CTVe> getcTve() {
		return cTve;
	}

	public void setcTve(List<CTVe> cTve) {
		this.cTve = cTve;
	}
	

}
