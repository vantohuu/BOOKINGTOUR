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
@Table(name="VETOUR")
public class VeTour {
	@Id
	@Column(name="MAVE")
	private  int maVe;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="BATDAUTU")
	private  Date batDauTu;
	@Column(name="GIAVE")
	private  int giaVe;
	@Column(name="PHIDICHUYEN")
	private  int phiDiChuyen;
	@Column(name="GIACOC")
	private  int giaCoc;
	
	@OneToMany(mappedBy = "veTour1", fetch = FetchType.EAGER)
	private List<BookingTour> bookingTours;
	
	@OneToMany(mappedBy = "veTour", fetch = FetchType.EAGER)
	private List<CTVe> cTve;
	
	@ManyToOne()
	@JoinColumn(name="MALOAIVE")
	private LoaiVe loaiVe;

	public int getMaVe() {
		return maVe;
	}

	public void setMaVe(int maVe) {
		this.maVe = maVe;
	}

	public Date getBatDauTu() {
		return batDauTu;
	}

	public void setBatDauTu(Date batDauTu) {
		this.batDauTu = batDauTu;
	}

	public int getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(int giaVe) {
		this.giaVe = giaVe;
	}

	public int getPhiDiChuyen() {
		return phiDiChuyen;
	}

	public void setPhiDiChuyen(int phiDiChuyen) {
		this.phiDiChuyen = phiDiChuyen;
	}

	public int getGiaCoc() {
		return giaCoc;
	}

	public void setGiaCoc(int giaCoc) {
		this.giaCoc = giaCoc;
	}

	public List<BookingTour> getBookingTours() {
		return bookingTours;
	}

	public void setBookingTours(List<BookingTour> bookingTours) {
		this.bookingTours = bookingTours;
	}

	public List<CTVe> getcTve() {
		return cTve;
	}

	public void setcTve(List<CTVe> cTve) {
		this.cTve = cTve;
	}

	public LoaiVe getLoaiVe() {
		return loaiVe;
	}

	public void setLoaiVe(LoaiVe loaiVe) {
		this.loaiVe = loaiVe;
	}
	
	
	

}