package BOOKINGTOUR.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import BOOKINGTOUR.entity.TaiKhoan;

@Transactional
@Controller
public class doanhthuController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("doanhthu")
	public String xemDoanhThu(ModelMap model, HttpSession ss, @RequestParam(defaultValue = "") String tungay,
			@RequestParam(defaultValue = "") String denngay) {
		if (tungay.length() != 0 && denngay.length() != 0) {
			model.addAttribute("thoigian", "Từ ngày " + tungay + " đến ngày " + denngay + " :");
		} else if (tungay.length() != 0) {
			model.addAttribute("thoigian", "Sau ngày " + tungay + " :");
		} else if (denngay.length() != 0) {
			model.addAttribute("thoigian", "Trước ngày " + denngay + " :");
		}

		/*
		 * TaiKhoan taiKhoan = (TaiKhoan) ss.getAttribute("TaiKhoan"); if (taiKhoan !=
		 * null) {
		 */
		long c_yeucau_nl = countDoanhThu_YC_NL(2, tungay, denngay);
		long c_yeucau_tn = countDoanhThu_YC_TN(2, tungay, denngay);
		long c_yeucau_te = countDoanhThu_YC_TE(2, tungay, denngay);
		long c_binhthuong_nl = countDoanhThu_BT(1, 1, tungay, denngay);
		long c_binhthuong_tn = countDoanhThu_BT(1, 2, tungay, denngay);
		long c_binhthuong_te = countDoanhThu_BT(1, 3, tungay, denngay);
		
		 long s_binhthuong_nl = sumDoanhThu_BT(1, 1, tungay, denngay);
		 long s_binhthuong_tn = sumDoanhThu_BT(1, 2, tungay, denngay);
		 long s_binhthuong_te = sumDoanhThu_BT(1, 3, tungay, denngay);
		 long s_yeucau_nl = sumDoanhThu_YC_NL(2, tungay, denngay);
		 long s_yeucau_tn = sumDoanhThu_YC_TN(2, tungay, denngay);
		 long s_yeucau_te = sumDoanhThu_YC_TE(2, tungay, denngay);
		
		model.addAttribute("c_yeucau_nl", c_yeucau_nl);
		model.addAttribute("c_yeucau_tn", c_yeucau_tn);
		model.addAttribute("c_yeucau_te", c_yeucau_te);
		model.addAttribute("c_yeucau_tong", c_yeucau_te + c_yeucau_nl + c_yeucau_tn);
		model.addAttribute("c_binhthuong_nl", c_binhthuong_nl);
		model.addAttribute("c_binhthuong_tn", c_binhthuong_tn);
		model.addAttribute("c_binhthuong_te", c_binhthuong_te);
		model.addAttribute("c_binhthuong_tong", c_binhthuong_nl + c_binhthuong_tn + c_binhthuong_te);
		model.addAttribute("s_binhthuong_nl", s_binhthuong_nl);
		model.addAttribute("s_binhthuong_tn", s_binhthuong_tn);
		model.addAttribute("s_binhthuong_te", s_binhthuong_te);
		model.addAttribute("s_binhthuong_tong", s_binhthuong_te +s_binhthuong_tn+s_binhthuong_nl);
		model.addAttribute("s_yeucau_nl", s_yeucau_nl);
		model.addAttribute("s_yeucau_tn", s_yeucau_tn);
		model.addAttribute("s_yeucau_te", s_yeucau_te);
		model.addAttribute("s_yeucau_tong", s_yeucau_te +s_yeucau_nl+s_yeucau_tn);
		

		/* } */
		return "doanhthu/doanhthu";

	}

	public long countDoanhThu_YC_NL(int loaitour, String tungay, String denngay) {
		Session session = factory.getCurrentSession();
		Query query = null;
		String hql1 = "";

		if (tungay.length() != 0 && denngay.length() != 0) {
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum(maxNL) FROM BookingTour  where ((loaiTour.id = :loaitour ) and tGBD >= :date1) and tGKT <= :date2";
			query = (Query) session.createQuery(hql1);
			query.setParameter("loaitour", loaitour);
			query.setParameter("date1", date1);
			query.setParameter("date2", date2);
		}

		else if (tungay.length() != 0) {
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum(maxNL) FROM BookingTour  where ((loaiTour.id = :loaitour ) and tGBD >= :date1) ";
			query = session.createQuery(hql1);
			query.setParameter("date1", date1);
			query.setParameter("loaitour", loaitour);
		}

		else if (denngay.length() != 0) {
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum(maxNL) FROM BookingTour  where ((loaiTour.id = :loaitour )and tGKT <= :date2) ";
			query = session.createQuery(hql1);
			query.setParameter("date2", date2);

			query.setParameter("loaitour", loaitour);
		} else {
			hql1 = "Select sum(maxNL) FROM BookingTour  where (loaiTour.id = :loaitour ) ) ";
			query = session.createQuery(hql1);

			query.setParameter("loaitour", loaitour);
		}
		if (query.uniqueResult() == null)
			return 0;
		long total = (Long) query.uniqueResult();
		return total;
	}

	public long countDoanhThu_YC_TN(int loaitour, String tungay, String denngay) {
		Session session = factory.getCurrentSession();
		Query query = null;
		String hql1 = "";

		if (tungay.length() != 0 && denngay.length() != 0) {
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum(maxTN) FROM BookingTour  where ((loaiTour.id = :loaitour ) and tGBD >= :date1) and tGKT <= :date2";
			query = (Query) session.createQuery(hql1);
			query.setParameter("loaitour", loaitour);
			query.setParameter("date1", date1);
			query.setParameter("date2", date2);
		}

		else if (tungay.length() != 0) {
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum(maxTN) FROM BookingTour  where ((loaiTour.id = :loaitour ) and tGBD >= :date1) ";
			query = session.createQuery(hql1);
			query.setParameter("date1", date1);
			query.setParameter("loaitour", loaitour);
		}

		else if (denngay.length() != 0) {
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum(maxTN) FROM BookingTour  where ((loaiTour.id = :loaitour ) and tGKT <= :date2) ";
			query = session.createQuery(hql1);
			query.setParameter("date2", date2);

			query.setParameter("loaitour", loaitour);
		} else {
			hql1 = "Select sum(maxTN) FROM BookingTour  where (loaiTour.id = :loaitour ) ) ";
			query = session.createQuery(hql1);

			query.setParameter("loaitour", loaitour);
		}
		if (query.uniqueResult() == null)
			return 0;
		long total = (Long) query.uniqueResult();
		return total;
	}

	public long countDoanhThu_YC_TE(int loaitour, String tungay, String denngay) {
		Session session = factory.getCurrentSession();
		Query query = null;
		String hql1 = "";

		if (tungay.length() != 0 && denngay.length() != 0) {
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum(maxTE) FROM BookingTour  where ((loaiTour.id = :loaitour ) and tGBD >= :date1) and tGKT <= :date2";
			query = (Query) session.createQuery(hql1);
			query.setParameter("loaitour", loaitour);
			query.setParameter("date1", date1);
			query.setParameter("date2", date2);
		}

		else if (tungay.length() != 0) {
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum(maxTE) FROM BookingTour  where ((loaiTour.id = :loaitour ) and tGBD >= :date1) ";
			query = session.createQuery(hql1);
			query.setParameter("date1", date1);
			query.setParameter("loaitour", loaitour);
		}

		else if (denngay.length() != 0) {
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum(maxTE) FROM BookingTour  where ((loaiTour.id = :loaitour )and tGKT <= :date2) ";
			query = session.createQuery(hql1);
			query.setParameter("date2", date2);

			query.setParameter("loaitour", loaitour);
		} else {
			hql1 = "Select sum(maxTE) FROM BookingTour  where (loaiTour.id = :loaitour ) ) ";
			query = session.createQuery(hql1);

			query.setParameter("loaitour", loaitour);
		}
		if (query.uniqueResult() == null)
			return 0;
		long total = (Long) query.uniqueResult();
		return total;
	}

	public long countDoanhThu_BT(int loaitour, Integer loaive, String tungay, String denngay) {
		Session session = factory.getCurrentSession();
		Query query = null;
		String hql1 = "";

		if (tungay.length() != 0 && denngay.length() != 0) {
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select count(*) FROM CTVe  where ((veTour.bookingTour1.loaiTour.id = :loaitour and veTour.loaiVe.id =:loaive) and veTour.bookingTour1.tGBD >= :date1) and veTour.bookingTour1.tGKT <= :date2";
			query = (Query) session.createQuery(hql1);
			query.setParameter("loaitour", loaitour);
			query.setParameter("loaive", loaive);
			query.setParameter("date1", date1);
			query.setParameter("date2", date2);
		}

		else if (tungay.length() != 0) {
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select count(*) FROM CTVe  where ((veTour.bookingTour1.loaiTour.id = :loaitour and veTour.loaiVe.id =:loaive) and veTour.bookingTour1.tGBD >= :date1) ";
			query = session.createQuery(hql1);
			query.setParameter("date1", date1);
			query.setParameter("loaitour", loaitour);
			query.setParameter("loaive", loaive);
		}

		else if (denngay.length() != 0) {
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select count(*) FROM CTVe  where ((veTour.bookingTour1.loaiTour.id = :loaitour and veTour.loaiVe.id =:loaive) and veTour.bookingTour1.tGKT <= :date2) ";
			query = session.createQuery(hql1);
			query.setParameter("date2", date2);
			query.setParameter("loaive", loaive);
			query.setParameter("loaitour", loaitour);
		} else {
			hql1 = "Select count(*) FROM CTVe  where (veTour.bookingTour1.loaiTour.id = :loaitour and veTour.loaiVe.id =:loaive)  ";
			query = session.createQuery(hql1);
			query.setParameter("loaive", loaive);
			query.setParameter("loaitour", loaitour);
		}

		long total = (Long) query.uniqueResult();
		return total;
	}
	
	
	public long sumDoanhThu_BT(int loaitour, Integer loaive, String tungay, String denngay) {
		Session session = factory.getCurrentSession();
		Query query = null;
		String hql1 = "";

		if (tungay.length() != 0 && denngay.length() != 0) {
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum(veTour.giaVe+ veTour.phiDiChuyen) FROM CTVe  where ((veTour.bookingTour1.loaiTour.id = :loaitour and veTour.loaiVe.id =:loaive) and veTour.bookingTour1.tGBD >= :date1) and veTour.bookingTour1.tGKT <= :date2";
			query = (Query) session.createQuery(hql1);
			query.setParameter("loaitour", loaitour);
			query.setParameter("loaive", loaive);
			query.setParameter("date1", date1);
			query.setParameter("date2", date2);
		}

		else if (tungay.length() != 0) {
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum(veTour.giaVe+ veTour.phiDiChuyen) FROM CTVe  where ((veTour.bookingTour1.loaiTour.id = :loaitour and veTour.loaiVe.id =:loaive) and veTour.bookingTour1.tGBD >= :date1) ";
			query = session.createQuery(hql1);
			query.setParameter("date1", date1);
			query.setParameter("loaitour", loaitour);
			query.setParameter("loaive", loaive);
		}

		else if (denngay.length() != 0) {
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum(veTour.giaVe+ veTour.phiDiChuyen) FROM CTVe  where ((veTour.bookingTour1.loaiTour.id = :loaitour and veTour.loaiVe.id =:loaive) and veTour.bookingTour1.tGKT <= :date2) ";
			query = session.createQuery(hql1);
			query.setParameter("date2", date2);
			query.setParameter("loaive", loaive);
			query.setParameter("loaitour", loaitour);
		} else {
			hql1 = "Select sum(veTour.giaVe+ veTour.phiDiChuyen) FROM CTVe  where (veTour.bookingTour1.loaiTour.id = :loaitour and veTour.loaiVe.id =:loaive)  ";
			query = session.createQuery(hql1);
			query.setParameter("loaive", loaive);
			query.setParameter("loaitour", loaitour);
		}

		if (query.uniqueResult() == null)
			return 0;
		long total = (Long) query.uniqueResult();
		return total;
	}
	
	public long sumDoanhThu_YC_NL(int loaitour, String tungay, String denngay) {
		Session session = factory.getCurrentSession();
		Query query = null;
		String hql1 = "";

		if (tungay.length() != 0 && denngay.length() != 0) {
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum( veTour.bookingTour1.maxNL*(veTour.giaVe+veTour.phiDiChuyen)) FROM CTVe  where( (veTour.bookingTour1.loaiTour.id = :loaitour )and veTour.bookingTour1.tGBD >= :date1) and veTour.bookingTour1.tGKT <= :date2  ";	
			query = (Query) session.createQuery(hql1);
			query.setParameter("loaitour", loaitour);
			query.setParameter("date1", date1);
			query.setParameter("date2", date2);
		}

		else if (tungay.length() != 0) {
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum( veTour.bookingTour1.maxNL*(veTour.giaVe+veTour.phiDiChuyen)) FROM CTVe  where (veTour.bookingTour1.loaiTour.id = :loaitour )  and veTour.bookingTour1.tGBD >= :date1) ";			query = session.createQuery(hql1);
			query.setParameter("date1", date1);
			query.setParameter("loaitour", loaitour);
		}

		else if (denngay.length() != 0) {
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum( veTour.bookingTour1.maxNL*(veTour.giaVe+veTour.phiDiChuyen)) FROM CTVe  where (veTour.bookingTour1.loaiTour.id = :loaitour ) and veTour.bookingTour1.tGKT <= :date2)  ";
			query = session.createQuery(hql1);
			query.setParameter("date2", date2);

			query.setParameter("loaitour", loaitour);
		} else {
			hql1 = "Select sum( veTour.bookingTour1.maxNL*(veTour.giaVe+veTour.phiDiChuyen)) FROM CTVe  where (veTour.bookingTour1.loaiTour.id = :loaitour )  ";
			query = session.createQuery(hql1);

			query.setParameter("loaitour", loaitour);
		}
		if (query.uniqueResult() == null)
			return 0;
		long total = (Long) query.uniqueResult();
		return total;
	}
	public long sumDoanhThu_YC_TN(int loaitour, String tungay, String denngay) {
		Session session = factory.getCurrentSession();
		Query query = null;
		String hql1 = "";

		if (tungay.length() != 0 && denngay.length() != 0) {
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum( veTour.bookingTour1.maxTN*(veTour.giaVe+veTour.phiDiChuyen)) FROM CTVe  where( (veTour.bookingTour1.loaiTour.id = :loaitour )and veTour.bookingTour1.tGBD >= :date1) and veTour.bookingTour1.tGKT <= :date2  ";	
			query = (Query) session.createQuery(hql1);
			query.setParameter("loaitour", loaitour);
			query.setParameter("date1", date1);
			query.setParameter("date2", date2);
		}

		else if (tungay.length() != 0) {
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum( veTour.bookingTour1.maxTN*(veTour.giaVe+veTour.phiDiChuyen)) FROM CTVe  where (veTour.bookingTour1.loaiTour.id = :loaitour )  and veTour.bookingTour1.tGBD >= :date1) ";			query = session.createQuery(hql1);
			query.setParameter("date1", date1);
			query.setParameter("loaitour", loaitour);
		}

		else if (denngay.length() != 0) {
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum( veTour.bookingTour1.maxTN*(veTour.giaVe+veTour.phiDiChuyen)) FROM CTVe  where (veTour.bookingTour1.loaiTour.id = :loaitour ) and veTour.bookingTour1.tGKT <= :date2)  ";
			query = session.createQuery(hql1);
			query.setParameter("date2", date2);

			query.setParameter("loaitour", loaitour);
		} else {
			hql1 = "Select sum( veTour.bookingTour1.maxTN*(veTour.giaVe+veTour.phiDiChuyen)) FROM CTVe  where (veTour.bookingTour1.loaiTour.id = :loaitour )  ";
			query = session.createQuery(hql1);

			query.setParameter("loaitour", loaitour);
		}
		if (query.uniqueResult() == null)
			return 0;
		long total = (Long) query.uniqueResult();
		return total;
	}
	public long sumDoanhThu_YC_TE(int loaitour, String tungay, String denngay) {
		Session session = factory.getCurrentSession();
		Query query = null;
		String hql1 = "";

		if (tungay.length() != 0 && denngay.length() != 0) {
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum( veTour.bookingTour1.maxTE*(veTour.giaVe+veTour.phiDiChuyen)) FROM CTVe  where( (veTour.bookingTour1.loaiTour.id = :loaitour )and veTour.bookingTour1.tGBD >= :date1) and veTour.bookingTour1.tGKT <= :date2  ";	
			query = (Query) session.createQuery(hql1);
			query.setParameter("loaitour", loaitour);
			query.setParameter("date1", date1);
			query.setParameter("date2", date2);
		}

		else if (tungay.length() != 0) {
			LocalDate localDate1 = LocalDate.parse(tungay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum( veTour.bookingTour1.maxTE*(veTour.giaVe+veTour.phiDiChuyen)) FROM CTVe  where (veTour.bookingTour1.loaiTour.id = :loaitour )  and veTour.bookingTour1.tGBD >= :date1) ";			query = session.createQuery(hql1);
			query.setParameter("date1", date1);
			query.setParameter("loaitour", loaitour);
		}

		else if (denngay.length() != 0) {
			LocalDate localDate2 = LocalDate.parse(denngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			hql1 = "Select sum( veTour.bookingTour1.maxTE*(veTour.giaVe+veTour.phiDiChuyen)) FROM CTVe  where (veTour.bookingTour1.loaiTour.id = :loaitour ) and veTour.bookingTour1.tGKT <= :date2)  ";
			query = session.createQuery(hql1);
			query.setParameter("date2", date2);

			query.setParameter("loaitour", loaitour);
		} else {
			hql1 = "Select sum( veTour.bookingTour1.maxTE*(veTour.giaVe+veTour.phiDiChuyen)) FROM CTVe  where (veTour.bookingTour1.loaiTour.id = :loaitour )  ";
			query = session.createQuery(hql1);

			query.setParameter("loaitour", loaitour);
		}
		if (query.uniqueResult() == null)
			return 0;
		long total = (Long) query.uniqueResult();
		return total;
	}

}
