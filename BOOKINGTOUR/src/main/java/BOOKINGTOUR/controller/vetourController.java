package BOOKINGTOUR.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import BOOKINGTOUR.entity.BookingTour;
import BOOKINGTOUR.entity.CTPhongLuuTru;
import BOOKINGTOUR.entity.CTVe;
import BOOKINGTOUR.entity.DiemDuLich;
import BOOKINGTOUR.entity.KhachHang;
import BOOKINGTOUR.entity.KhuyenMai;
import BOOKINGTOUR.entity.LoaiVe;
import BOOKINGTOUR.entity.NhanVien;
import BOOKINGTOUR.entity.NoiLuuTru;
import BOOKINGTOUR.entity.Phong;
import BOOKINGTOUR.entity.TaiKhoan;
import BOOKINGTOUR.entity.Tour;
import BOOKINGTOUR.entity.VeTour;

@Transactional
@Controller
public class vetourController {
	@Autowired
    SessionFactory factory;
	/*
	 * @RequestMapping("dsvetour") public String dsvetour(HttpServletRequest
	 * request,ModelMap model,@ModelAttribute("message") String message) {
	 * 
	 * model.addAttribute("vetours",gettVeTours()); model.addAttribute("message",
	 * message);
	 * 
	 * return "vetour/dsve"; }
	 */
	
	@RequestMapping(value="dsve/{id}")
	public String dsve(ModelMap model ,@PathVariable int id,@ModelAttribute("message") String message) {
		BookingTour bookingTour= this.searchbBookingTour(id);
		model.addAttribute("message", message);
		model.addAttribute("idBK",id);
		model.addAttribute("bookingtour",bookingTour);
		Set<CTVe> vetours =new HashSet<CTVe>();
		for (VeTour s : bookingTour.getVeTours()) {
			vetours.addAll(s.getcTve());
		}

		model.addAttribute("ctvetours",vetours);
		return"vetour/dsve";
	}
	
	@RequestMapping(value="dsve/themvetg", method = RequestMethod.POST)
	public String thembvetg(HttpServletRequest request,HttpSession session,ModelMap model,@ModelAttribute("CCCD") String CCCD,@ModelAttribute("idBK") String idBK )  {
		
		
		KhachHang khachHang = searchKhachHang(CCCD);
		BookingTour bookingTour = searchbBookingTour(Integer.parseInt(idBK));
		if (khachHang == null) {
			khachHang = new KhachHang();
			khachHang.setcCCD(CCCD);
		}
		CTVe ctVe = new CTVe();
		ctVe.setKhachHang(khachHang);
		TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("TaiKhoan");
		ctVe.setNhanVienXN(taiKhoan.getNhanVien());
			model.addAttribute("ctve", ctVe);
			model.addAttribute("vetours", bookingTour.getVeTours());
			model.addAttribute("dotkhuyenmai", getKhuyenMais());
			model.addAttribute("tennvXN",taiKhoan.getNhanVien().getHo() + " "+taiKhoan.getNhanVien().getTen());
		 
			return "vetour/themctve";	
	}
	@RequestMapping(value="dsve/insert", method = RequestMethod.POST) 
	public String insertdattour(@ModelAttribute("ctve") CTVe ctVe,ModelMap model) {
		ctVe.setNhanVienXN(searchNhanVien(ctVe.getNhanVienXN().getcCCD()));
		ctVe.setVeTour(searcVeTour(ctVe.getVeTour().getId()));
		ctVe.setKhuyenMai(searchKhuyenMai(ctVe.getKhuyenMai().getId()));
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		KhachHang khachHang =ctVe.getKhachHang();
			try {
				if(searchKhachHang(ctVe.getKhachHang().getcCCD())==null) {
					session.save(khachHang);
					System.out.println(111111);
				}
				else {session.update(khachHang);	System.out.println(222222);}
				
				session.save(ctVe);
				System.out.println(3333333);
				t.commit();
				
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}
			
			return "redirect:/dsve/" + ctVe.getVeTour().getBookingTour1().getId() + ".htm";
	}
	
	@RequestMapping(value="dsve/suactve/{id}")
	public String suactve(ModelMap model ,@PathVariable int id) {
		CTVe ctVe=new CTVe();
		ctVe =this.searchctCtVe(id);
		NhanVien nhanVienXN =ctVe.getNhanVienXN();
		BookingTour bookingTour = ctVe.getVeTour().getBookingTour1();
		model.addAttribute("ctve",this.searchctCtVe(id));
		model.addAttribute("vetours", bookingTour.getVeTours());
		model.addAttribute("dotkhuyenmai", getKhuyenMais());
		model.addAttribute("tennvXN",nhanVienXN.getHo() + " "+nhanVienXN.getTen());
		return"vetour/suactve";
	}
	@RequestMapping(value="dsve/suactve/update", method = RequestMethod.POST) 
	public String updatectve(@ModelAttribute("ctve") CTVe ctVe,ModelMap model) {
		
		
	
		
		ctVe.setNhanVienXN(searchNhanVien(ctVe.getNhanVienXN().getcCCD()));
		ctVe.setVeTour(searcVeTour(ctVe.getVeTour().getId()));
		ctVe.setKhuyenMai(searchKhuyenMai(ctVe.getKhuyenMai().getId()));
		
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
			try {
				session.update(ctVe.getKhachHang());
				session.update(ctVe);
				t.commit();
				
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}
		
		return"redirect:/dsve/"+ctVe.getVeTour().getBookingTour1().getId()+".htm";
	}
	
	@RequestMapping(value="dsve/xoactve/{id}")
	public String xoactve(ModelMap model ,@PathVariable int id) {
		CTVe ctVe = searchctCtVe(id);
		int idBK = ctVe.getVeTour().getBookingTour1().getId();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			String hql = "delete from CTVe where id= :id";
			Query query = session.createQuery(hql);
			
			query.setParameter("id", id);
			System.out.println(query.executeUpdate());
			t.commit();
			model.addAttribute("message", 1);
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", 2);
			
		} finally {
			session.close();
		}
		
		return"redirect:/dsve/"+idBK+".htm";
	}
	
	@RequestMapping(value="dsvetour/{id}")
	public String dsvetour(ModelMap model ,@PathVariable int id,@ModelAttribute("message") String message) {
		BookingTour bookingTour= this.searchbBookingTour(id);
		model.addAttribute("message", message);
		model.addAttribute("idBK",id);
		model.addAttribute("bookingtour",bookingTour);
		model.addAttribute("vetours",bookingTour.getVeTours());
		return"vetour/dsvetour";
	}
	
	@RequestMapping(value="dsvetour/themvetour/{id}")
	public String themvetour(HttpServletRequest request,ModelMap model,@PathVariable int id,@ModelAttribute("message") String message) {
		VeTour VeTour= new VeTour();
		VeTour.setBookingTour1(searchbBookingTour(id));
		model.addAttribute("vetour",VeTour);
		model.addAttribute("tentour",VeTour.getBookingTour1().getTour1().getTen());
		model.addAttribute("loaives",getLoaiVes());
		
		return"vetour/themvetour";
	}
	
	@RequestMapping(value="dsvetour/themvetour/insert", method = RequestMethod.POST) 
	public String insertdiemluutru(@ModelAttribute("vetour") VeTour vetour,ModelMap model) {
		
	System.out.println(vetour.getGiaVe());
	System.out.println(vetour.getGiaCoc());
	System.out.println(vetour.getPhiDiChuyen());
	System.out.println(vetour.getBookingTour1().getId());
	System.out.println(vetour.getLoaiVe().getId());
	

		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(vetour);
				t.commit();
				System.out.println(vetour.getId());
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}
			
		return 
				"redirect:/dsvetour/themvetour/" + vetour.getBookingTour1().getId() + ".htm";
	}
	
	
		
		
	@RequestMapping(value="dsvetour/suavetour/{id}")
	public String suavetour(ModelMap model ,@PathVariable int id) {
		VeTour veTour =this.searcVeTour(id);
		model.addAttribute("vetour",veTour);
		model.addAttribute("loaives",getLoaiVes());
		model.addAttribute("tentour",veTour.getBookingTour1().getTour1().getTen());
		return"vetour/suavetour";
	}
	
	@RequestMapping(value="dsvetour/suavetour/update", method = RequestMethod.POST) 
	public String editvetour(@ModelAttribute("vetour") VeTour vetour,ModelMap model) {
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.update(vetour);
				t.commit();
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}

			model.addAttribute("vetour",vetour);
			model.addAttribute("loaives",getLoaiVes());
			
		
		return "vetour/suavetour";
	}
		
	@RequestMapping(value="dsvetour/xoavetour/{id}")
	public String xoavetour(ModelMap model ,@PathVariable int id) {
	VeTour veTour= searcVeTour(id);

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			String hql = "delete from VeTour where id= :id";
			Query query = session.createQuery(hql);
			
			query.setParameter("id", id);
			System.out.println(query.executeUpdate());
			t.commit();
			model.addAttribute("message", 1);
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", 2);
			
		} finally {
			session.close();
		}
		model.addAttribute("idBK",veTour.getBookingTour1().getId());
		model.addAttribute("bookingtour",veTour.getBookingTour1());
		model.addAttribute("vetours",veTour.getBookingTour1().getVeTours());
		return"redirect:/dsvetour/"+veTour.getBookingTour1().getId()+".htm";
	}
		
	
	
	
	@RequestMapping(value="dskhachhang")
	public String dskhachhang(ModelMap model ,@ModelAttribute("message") String message) {
		model.addAttribute("khachhangs",getKhachHangs());
		return"khachhang/dskhachhang";
	}
	
	public List<VeTour> gettVeTours() {
		Session session = factory.getCurrentSession();
		String hql = "FROM VeTour";
		List<VeTour> veTours = session.createQuery(hql).list();
		return  veTours;
	}
	public List<LoaiVe> getLoaiVes() {
		Session session = factory.getCurrentSession();
		String hql = "FROM LoaiVe";
		List<LoaiVe> loaiVes = session.createQuery(hql).list();
		return  loaiVes;
	}
	public List<KhachHang> getKhachHangs() {
		Session session = factory.getCurrentSession();
		String hql = "FROM KhachHang";
		List<KhachHang> khachHangs = session.createQuery(hql).list();
		return  khachHangs;
	}
	
	public BookingTour searchbBookingTour(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM BookingTour WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (BookingTour) query.list().get(0);
	}
	public KhuyenMai searchKhuyenMai(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM KhuyenMai WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (KhuyenMai) query.list().get(0);
	}

	public KhachHang searchKhachHang(String cCCD) {
		Session session = factory.getCurrentSession();
		String hql = "FROM KhachHang WHERE cCCD = :cCCD";
		Query query = session.createQuery(hql);
		query.setParameter("cCCD", cCCD);
		if(query.list().size()==0) return null;
		return (KhachHang) query.list().get(0);
	}
	
	public CTVe searchctCtVe(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CTVe WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (CTVe) query.list().get(0);
	}
	public NhanVien searchNhanVien(String cCCD) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien WHERE cCCD = :cCCD";
		Query query = session.createQuery(hql);
		query.setParameter("cCCD", cCCD);
		if(query.list().size()==0) return null;
		return (NhanVien) query.list().get(0);
	}
	public VeTour searcVeTour(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM VeTour WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (VeTour) query.list().get(0);
	}
	public List<KhuyenMai> getKhuyenMais() {
		Session session = factory.getCurrentSession();
		String hql = "FROM KhuyenMai";
		List<KhuyenMai> khuyenmai = session.createQuery(hql).list();
		return  khuyenmai;
	}
}
