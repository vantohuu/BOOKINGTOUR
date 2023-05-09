package test;

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
@Table(name="TOUR")
public class Tour {
	@Id
	@Column(name="MATOUR")
	private  int maTour;
	@Column(name="TENTOUR")
	private  String tenTour;
	@Column(name="MOTA")
	private  String moTa;
	
	@OneToMany(mappedBy = "tour", fetch = FetchType.EAGER)
	private List<BookingTour> bookingTours;
	


	@ManyToMany(mappedBy = "tours")
    private List<DiemDuLich> diemDuLich ;
	
	public int getMaTour() {
		return maTour;
	}

	public void setMaTour(int maTour) {
		this.maTour = maTour;
	}

	public String getTenTour() {
		return tenTour;
	}

	public void setTenTour(String tenTour) {
		this.tenTour = tenTour;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public List<BookingTour> getBookingTours() {
		return bookingTours;
	}

	public void setBookingTours(List<BookingTour> bookingTours) {
		this.bookingTours = bookingTours;
	}



	

	
}