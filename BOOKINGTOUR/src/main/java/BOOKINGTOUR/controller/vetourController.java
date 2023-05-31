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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import BOOKINGTOUR.entity.BookingTour;
import BOOKINGTOUR.entity.CTVe;
import BOOKINGTOUR.entity.DiemDuLich;
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
	public String dsdatphong(ModelMap model ,@PathVariable int id,@ModelAttribute("message") String message) {
		BookingTour bookingTour= this.searchbBookingTour(id);
		model.addAttribute("message", message);
		model.addAttribute("idBK",id);
		model.addAttribute("bookingtour",bookingTour);
		Set<CTVe> vetours =new HashSet<CTVe>();
		for (VeTour s : bookingTour.getVeTours()) {
			vetours.addAll(s.getcTve());
		}

		model.addAttribute("ctvetour",vetours);
		return"vetour/dsve";
	}
	
	public List<VeTour> gettVeTours() {
		Session session = factory.getCurrentSession();
		String hql = "FROM VeTour";
		List<VeTour> veTours = session.createQuery(hql).list();
		return  veTours;
	}
	
	public BookingTour searchbBookingTour(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM BookingTour WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (BookingTour) query.list().get(0);
	}
}