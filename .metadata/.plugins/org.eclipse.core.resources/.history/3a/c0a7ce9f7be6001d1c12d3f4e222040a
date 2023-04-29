package test;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LOAITOUR")
public class LoaiTour {
	@Id
	@Column(name="MALT")
	private  int maLT;
	@Column(name="TENLOAITOUR")
	private  String tenLoaiTour;
	
	@OneToMany(mappedBy = "loaiTour", fetch = FetchType.EAGER)
	private List<BookingTour> bookingTours;

	public int getMaLT() {
		return maLT;
	}

	public void setMaLT(int maLT) {
		this.maLT = maLT;
	}

	public String getTenLoaiTour() {
		return tenLoaiTour;
	}

	public void setTenLoaiTour(String tenLoaiTour) {
		this.tenLoaiTour = tenLoaiTour;
	}

	public List<BookingTour> getBookingTours() {
		return bookingTours;
	}

	public void setBookingTours(List<BookingTour> bookingTours) {
		this.bookingTours = bookingTours;
	}
	
}
