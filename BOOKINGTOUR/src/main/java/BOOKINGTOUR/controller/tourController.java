package BOOKINGTOUR.controller;

import java.util.ArrayList;
import java.util.HashSet;
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

import BOOKINGTOUR.entity.CTTour;
import BOOKINGTOUR.entity.DiemDuLich;
import BOOKINGTOUR.entity.NoiLuuTru;
import BOOKINGTOUR.entity.Tour;

@Transactional
@Controller
public class tourController {
	@Autowired
    SessionFactory factory;
	@RequestMapping("dsTour")
	public String dstour(HttpServletRequest request,ModelMap model,@ModelAttribute("message") String message) {
		
		  model.addAttribute("tours",this.getTours());
		  model.addAttribute("message",
		  message);
		 
		return "tour/dstour";
	}
	@RequestMapping(value="themtour")
	public String themtour(HttpServletRequest request,ModelMap model) {
		model.addAttribute("tour", new Tour());
		return"tour/themtour";
	}
	
	@RequestMapping(value="insertTour", method = RequestMethod.POST) 
	public String inserttour(@ModelAttribute("tour") Tour tour,ModelMap model) {
		
		System.out.println(tour.getTen());
		System.out.println(tour.getMoTa());

		if(checkTenTourTrung(tour.getTen())==1) {
			model.addAttribute("message", 3);

			return "diemluutru/themdiemluutru";
		}
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(tour);
				t.commit();
				System.out.println(tour.getId());
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}
		
		return "tour/themtour";
	}
	
	@RequestMapping(value="suatour/{id}")
	public String suatour(ModelMap model ,@PathVariable int id) {
		Tour tour =new Tour();
		tour.setId(id);
		
		model.addAttribute("tour",this.searchTour(id));
		
		return"tour/suatour";
	}
	@RequestMapping(value="updateTour", method = RequestMethod.POST) 
	public String editdiemdulich(@ModelAttribute("tour") Tour tour,ModelMap model) {
		
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.update(tour);
				t.commit();
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}
			
			
		return "tour/suatour";
	}
	
	@RequestMapping(value="xoatour/{id}")
	public String xoatour(ModelMap model ,@PathVariable int id) {
		Tour tour = searchTour(id);
		System.out.println(tour.getTen());
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			String hql = "delete from Tour where id= :id";
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
		
		return"redirect:/dsTour.htm";
	}
	
	@RequestMapping(value="cttour/{id}")
	public String cttour(ModelMap model ,@PathVariable int id,@ModelAttribute("message") String message) {
		Tour tour= this.searchTour(id);
		model.addAttribute("message", message);
		model.addAttribute("id",id);
		model.addAttribute("tour",id);
		model.addAttribute("cttours",tour.getCtTours());
		return"tour/cttour";
	}
	@RequestMapping(value="cttour/themcttour/insertcttour", method = RequestMethod.POST)
	public String insertcctour(ModelMap model ,@ModelAttribute("id") String id,@ModelAttribute("idtour") String idtour) {
		DiemDuLich diemdulich= this.searchDiemDuLich(Integer.parseInt(id));
		Tour tour =this.searchTour( Integer.parseInt(idtour));
		
		System.out.println(tour.getTen());
		System.out.println(diemdulich.getTen());
		
		CTTour ctTour =new CTTour();
		ctTour.setDiemDuLich(diemdulich);
		ctTour.setTour(tour);
		ctTour.setThuTu(tour.getCtTours().size()+1);
		
		
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(ctTour);
				t.commit();
				System.out.println(ctTour.getId());
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}
			int id1=Integer.parseInt(idtour);
			
			
			return "redirect:/cttour/themcttour/" + id1 + ".htm";
			
			
	}
	
	@RequestMapping(value="cttour/themcttour/{id}")
	public String themcttour(HttpServletRequest request,ModelMap model,@PathVariable int id,@ModelAttribute("message") String message) {
		Tour tour= new Tour();
		tour=searchTour(id);
		
		List<DiemDuLich> listDDL= new ArrayList<DiemDuLich>();
		
		for(CTTour c:tour.getCtTours()) {
			listDDL.add(c.getDiemDuLich());
		}
		model.addAttribute("idtour",id);
		model.addAttribute("diemDuLichs",diemDuLichConLai(listDDL,getListDiemDuLich()));
		return"tour/themcttour";
	}
	
	public DiemDuLich searchDiemDuLich(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM DiemDuLich WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (DiemDuLich) query.list().get(0);
	}
	
	@RequestMapping(value="xoacttour/{id}")
	public String xoadiemluutru(ModelMap model ,@PathVariable int id) {
	CTTour ctTour= searchCTTour(id);
	
	
	
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			 
			
			String hql = "delete from CTTour where id= :id";
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
		
		return "redirect:/cttour/" + ctTour.getTour().getId() + ".htm";
	
	}
	
	
	
	public Tour searchTour(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Tour WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (Tour) query.list().get(0);
	}
	public CTTour searchCTTour(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CTTour WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (CTTour) query.list().get(0);
	}
	
	
	private int checkTenTourTrung( String ten) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Tour where ten = :ten";
		Query query = session.createQuery(hql);
		query.setParameter("ten", ten);
		List<Tour> list = query.list();
		if(list.size() == 0) return 0;
		return 1;
	}
	public List<Tour> getTours() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Tour";
		List<Tour> tous = session.createQuery(hql).list();
		return  tous;
	}
	
	public int idThuTuTuDongTang(Tour tour) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CTTour where id =:tour.id";
		List<CTTour> ctTours = session.createQuery(hql).list();
		
		return  ctTours.size();
	}
	public List<DiemDuLich> getListDiemDuLich() {
		Session session = factory.getCurrentSession();
		String hql = "FROM DiemDuLich";
		List<DiemDuLich> diemDuLich = session.createQuery(hql).list();
		return  diemDuLich;
	}
	
	public static List<DiemDuLich> diemDuLichConLai(List<DiemDuLich> list1, List<DiemDuLich> list2) {
	    List<DiemDuLich> combined = new ArrayList<>();
	    
	    combined.addAll(list2);
	    combined.removeAll(list1);

	   

	    return combined;
	}
	
}
