package BOOKINGTOUR.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BOOKINGTOUR")
public class BookingTour {
	@Id
	@Column(name="MABK")
	private int maBK;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="TGBD")
	private  Date tGBD;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="TGKT")
	private Date tGKT;
	
	@Column(name="MAXNL")
	private  int maxNL;
	@Column(name="MAXTE")
	private int maxTE;
	@Column(name="MAXTN")
	private  int maxtn;
	@Column(name="MINNL")
	private int minNL;
	@Column(name="MINTE")
	private  int minTE;
	@Column(name="MINTN")
	private int minTN;
	@Column(name="TRANGTHAI")
	private  int trangThai;
	@Column(name="GHICHU")
	private String ghiChu;

	
	
	@ManyToOne()
	@JoinColumn(name="MAVE")
	private VeTour veTour1;
	
	@ManyToOne()
	@JoinColumn(name="MATOUR")
	private Tour tour;
	@ManyToOne()
	@JoinColumn(name="IDCTPLT")
	private CTPhongLuuTru cTPhongLuuTru;
	
	@ManyToOne()
	@JoinColumn(name="MALT")
	private LoaiTour loaiTour;

	public int getMaBK() {
		return maBK;
	}

	public void setMaBK(int maBK) {
		this.maBK = maBK;
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

	public int getMaxNL() {
		return maxNL;
	}

	public void setMaxNL(int maxNL) {
		this.maxNL = maxNL;
	}

	public int getMaxTE() {
		return maxTE;
	}

	public void setMaxTE(int maxTE) {
		this.maxTE = maxTE;
	}

	public int getMaxtn() {
		return maxtn;
	}

	public void setMaxtn(int maxtn) {
		this.maxtn = maxtn;
	}

	public int getMinNL() {
		return minNL;
	}

	public void setMinNL(int minNL) {
		this.minNL = minNL;
	}

	public int getMinTE() {
		return minTE;
	}

	public void setMinTE(int minTE) {
		this.minTE = minTE;
	}

	public int getMinTN() {
		return minTN;
	}

	public void setMinTN(int minTN) {
		this.minTN = minTN;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public VeTour getVeTour1() {
		return veTour1;
	}

	public void setVeTour1(VeTour veTour1) {
		this.veTour1 = veTour1;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public CTPhongLuuTru getcTPhongLuuTru() {
		return cTPhongLuuTru;
	}

	public void setcTPhongLuuTru(CTPhongLuuTru cTPhongLuuTru) {
		this.cTPhongLuuTru = cTPhongLuuTru;
	}

	public LoaiTour getLoaiTour() {
		return loaiTour;
	}

	public void setLoaiTour(LoaiTour loaiTour) {
		this.loaiTour = loaiTour;
	}
	
	

}
