package BOOKINGTOUR.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="CTPHONGLUUTRU")
public class CTPhongLuuTru {
	@Id
	@Column(name="IDCTPLT")
	private  int iDCTPLT;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="THOIGIAN")
	private  Date thoiGian;
	@Column(name="MAPHONG")
	private  int maPhong;
	
	@OneToMany(mappedBy = "cTPhongLuuTru", fetch = FetchType.EAGER)
	private List<BookingTour> bookingTours;

	@OneToMany(mappedBy = "cTPhongLuuTru1", fetch = FetchType.EAGER)
	private List<Phong> phong;

	public int getiDCTPLT() {
		return iDCTPLT;
	}

	public void setiDCTPLT(int iDCTPLT) {
		this.iDCTPLT = iDCTPLT;
	}

	public Date getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	public List<BookingTour> getBookingTours() {
		return bookingTours;
	}

	public void setBookingTours(List<BookingTour> bookingTours) {
		this.bookingTours = bookingTours;
	}

	public List<Phong> getPhong() {
		return phong;
	}

	public void setPhong(List<Phong> phong) {
		this.phong = phong;
	}
	

}
