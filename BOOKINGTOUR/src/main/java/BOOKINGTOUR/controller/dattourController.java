package BOOKINGTOUR.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
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
import BOOKINGTOUR.entity.CTTour;
import BOOKINGTOUR.entity.DiemDuLich;
import BOOKINGTOUR.entity.LoaiTour;
import BOOKINGTOUR.entity.NoiLuuTru;
import BOOKINGTOUR.entity.Phong;
import BOOKINGTOUR.entity.Tour;

@Transactional
@Controller
public class dattourController {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
    SessionFactory factory;
	@RequestMapping("dsdattour")
	public String dsdattour(HttpServletRequest request,ModelMap model,@ModelAttribute("message") String message) {
		model.addAttribute("bookingtours",this.geBookingTours());
		model.addAttribute("message", message);
		return "dattour/dsdattour";
	}
	@RequestMapping(value="themdattour")
	public String themdattour(HttpServletRequest request,ModelMap model) {
		model.addAttribute("bookingtour", new BookingTour());
		model.addAttribute("loaitours",gettLoaiTours());
		model.addAttribute("tours", getTours());
		return"dattour/themdattour";
	}
	
	@RequestMapping(value="insertdattour", method = RequestMethod.POST) 
	public String insertdattour(@ModelAttribute("bookingtour") BookingTour bookingtour,ModelMap model) {
		
		System.out.println(bookingtour.gettGBD());
		System.out.println(bookingtour.gettGKT());
		System.out.println(bookingtour.getTour1().getId());
		/*
		 * bookingtour.setTour1(searchTour(bookingtour.getTour1().getId()));
		 */

		
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(bookingtour);
				t.commit();
				System.out.println(bookingtour.getId());
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}
			
			model.addAttribute("bookingtours",this.geBookingTours());
		
			return "dattour/themdattour";
	}
	
	@RequestMapping(value="suadattour/{id}")
	public String suadiemdulich(ModelMap model ,@PathVariable int id) {
		model.addAttribute("bookingtour", searchbBookingTour(id));
		model.addAttribute("loaitours",gettLoaiTours());
		model.addAttribute("tours", getTours());
		return"dattour/suadattour";
	}
	@RequestMapping(value="updatetour", method = RequestMethod.POST) 
	public String editdiemluutru(@ModelAttribute("bookingtour") BookingTour bookingtour,ModelMap model) {
		
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.update(bookingtour);
				t.commit();
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}
			model.addAttribute("bookingtour", bookingtour);
			model.addAttribute("loaitours",gettLoaiTours());
			model.addAttribute("tours", getTours());
		return "dattour/suadattour";
	}
	
	@RequestMapping(value="xoadattour/{id}")
	public String xoadiemluutru(ModelMap model ,@PathVariable int id) {
	
	
	
	
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			 
			
			String hql = "delete from BookingTour where id= :id";
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
		
		return"redirect:/dsdattour.htm";
	}
	
	@RequestMapping(value="themdatphong/{id}")
	public String themdatphong(HttpServletRequest request,ModelMap model,@PathVariable int id,@ModelAttribute("message") String message) {
		BookingTour bookingTour= new BookingTour();
		bookingTour=searchbBookingTour(id);
		
		List<Phong> listPhong= new ArrayList<Phong>();
		
		for(CTPhongLuuTru c: bookingTour.getCtPhongLuuTrus()) {
			listPhong.add(c.getPhong());
		}
		model.addAttribute("idBK",id);
		model.addAttribute("phongs",phongConLai(listPhong,getPhongs()));
		return"dattour/themdatphong";
	}
	@RequestMapping(value="themdatphong/insertdatphong", method = RequestMethod.POST)
	public String insertdatphong(HttpServletRequest request,ModelMap model ,@ModelAttribute("id") String id,@ModelAttribute("idBK") String idBK) throws ParseException {
		System.out.println(id);
		System.out.println(idBK);
		System.out.println(request.getParameter("tgden"));
		System.out.println(request.getParameter("tgdi"));
		
		
		
		
		Phong phong= this.searchPhong(Integer.parseInt(id));
		BookingTour bookingTour =this.searchbBookingTour( Integer.parseInt(idBK));
		
		
		CTPhongLuuTru ctPhongLuuTru =new CTPhongLuuTru();
		ctPhongLuuTru.setPhong(phong);
		ctPhongLuuTru.setBookingTour(bookingTour);

		String tmp = request.getParameter("tgden");
		String tmp1 = request.getParameter("tgdi");
		ctPhongLuuTru.setNgayDen(formatter.parse(tmp));
		ctPhongLuuTru.setNgayDi(formatter.parse(tmp1));
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(ctPhongLuuTru);
				t.commit();
				
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}
			int id1=Integer.parseInt(idBK);
			
			
			return "redirect:/themdatphong/" + id1 + ".htm";
			
			
	}
	
	
	@RequestMapping(value="dsdatphong/{id}")
	public String dsdatphong(ModelMap model ,@PathVariable int id,@ModelAttribute("message") String message) {
		BookingTour bookingTour= this.searchbBookingTour(id);
		model.addAttribute("message", message);
		model.addAttribute("idBK",id);
		model.addAttribute("bookingtour",bookingTour);
		

		model.addAttribute("ctphongluutrus",bookingTour.getCtPhongLuuTrus());
		return"dattour/dsdatphong";
	}
	
	@RequestMapping(value="xoadatphong/{id}")
	public String xoadatphong(ModelMap model ,@PathVariable int id) {
	CTPhongLuuTru ctPhongLuuTru= searchCtPhongLuuTru(id);
	
	
	
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			 
			
			String hql = "delete from CTPhongLuuTru where id= :id";
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
		
		return "redirect:/dsdatphong/" + ctPhongLuuTru.getBookingTour().getId()+ ".htm";
	
	}
	
	
	public List<BookingTour> geBookingTours() {
		Session session = factory.getCurrentSession();
		String hql = "FROM BookingTour";
		List<BookingTour> bookingTours = session.createQuery(hql).list();
		return  bookingTours;
	}
	public List<Tour> getTours() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Tour";
		List<Tour> tous = session.createQuery(hql).list();
		return  tous;
	}
	public List<LoaiTour> gettLoaiTours() {
		Session session = factory.getCurrentSession();
		String hql = "FROM LoaiTour";
		List<LoaiTour> loaiTours = session.createQuery(hql).list();
		return  loaiTours;
	}
	
	public Tour searchTour(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Tour WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (Tour) query.list().get(0);
	}
	
	public CTPhongLuuTru searchCtPhongLuuTru(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CTPhongLuuTru WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (CTPhongLuuTru) query.list().get(0);
	}
	
	public BookingTour searchbBookingTour(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM BookingTour WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (BookingTour) query.list().get(0);
	}
	
	public Phong searchPhong(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Phong WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (Phong) query.list().get(0);
	}
	public List<Phong> getPhongs() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Phong";
		List<Phong> phong = session.createQuery(hql).list();
		return  phong;
	}
	public static List<Phong> phongConLai(List<Phong> list1, List<Phong> list2) {
	    List<Phong> combined = new ArrayList<>();
	    
	    combined.addAll(list2);
	    combined.removeAll(list1);

	   

	    return combined;
	}
	
}