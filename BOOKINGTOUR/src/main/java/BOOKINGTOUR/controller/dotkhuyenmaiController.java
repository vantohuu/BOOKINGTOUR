package BOOKINGTOUR.controller;

import java.text.SimpleDateFormat;
import java.util.List;

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

import BOOKINGTOUR.entity.DiemDuLich;
import BOOKINGTOUR.entity.KhuyenMai;

@Transactional
@Controller
public class dotkhuyenmaiController {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
    SessionFactory factory;
	@RequestMapping("dsdotkhuyenmai")
	public String dsdotkhuyenmai(HttpServletRequest request,ModelMap model,@ModelAttribute("message") String message) {
		model.addAttribute("dotkhuyenmais",getKhuyenMais());
		model.addAttribute("message", message);
		return "dotkhuyenmai/dsdotkhuyenmai";
	}
	
	
	@RequestMapping(value="themdotkhuyenmai")
	public String themdotkhuyenmai(HttpServletRequest request,ModelMap model) {
		model.addAttribute("dotKhuyenMai1", new KhuyenMai());
		model.addAttribute("dotkhuyenmais",getKhuyenMais());
		return"dotkhuyenmai/themdotkhuyenmai";
	}
	@RequestMapping(value="insertDotKhuyenMai", method = RequestMethod.POST) 
	public String insertDotKhuyenMai(@ModelAttribute("dotKhuyenMai1") KhuyenMai dotkhuyenmai,ModelMap model) {
		System.out.println(dotkhuyenmai.getId());
		System.out.println(dotkhuyenmai.getTen());
		System.out.println(dotkhuyenmai.getMoTa());
		System.out.println(dotkhuyenmai.getPhanTramGiam());
		System.out.println(dotkhuyenmai.gettGBD());
		System.out.println(dotkhuyenmai.gettGKT());
		
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(dotkhuyenmai);
				t.commit();
				System.out.println(dotkhuyenmai.getId());
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}
		
			model.addAttribute("dotkhuyenmais",getKhuyenMais());
		return "dotkhuyenmai/themdotkhuyenmai";
	}
	@RequestMapping(value="suadotkhuyenmai/{id}")
	public String suadotkhuyenmai(ModelMap model ,@PathVariable int id) {
		KhuyenMai dotkhuyenmai =new KhuyenMai();
		dotkhuyenmai.setId(id);
		model.addAttribute("dotKhuyenMai1",this.searchKhuyenMai(id));
		model.addAttribute("dotkhuyenmais",getKhuyenMais());
		return"dotkhuyenmai/suadotkhuyenmai";
	}
	
	@RequestMapping(value="suadotkhuyenmai/update", method = RequestMethod.POST) 
	public String editdotkhuyenmai(@ModelAttribute("dotKhuyenMai1") KhuyenMai dotKhuyenMai,ModelMap model) {
		System.out.println(dotKhuyenMai.getId());
		System.out.println(dotKhuyenMai.getTen());
		
		System.out.println(dotKhuyenMai.getMoTa());
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.update(dotKhuyenMai);
				t.commit();
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}
			
			model.addAttribute("dotKhuyenMai1",dotKhuyenMai);
			model.addAttribute("dotkhuyenmais",getKhuyenMais());
		return "dotkhuyenmai/suadotkhuyenmai";
	}
	
	@RequestMapping(value="xoadotkhuyenmai/{id}")
	public String xoadotkhuyenmai(ModelMap model ,@PathVariable int id) {
		KhuyenMai dotkhuyenmai = searchKhuyenMai(id);

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(dotkhuyenmai);
			t.commit();
			model.addAttribute("message", 1);
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", 2);
			
		} finally {
			session.close();
		}
		
		return"redirect:/dsdotkhuyenmai.htm";
	}
	public KhuyenMai searchKhuyenMai(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM KhuyenMai WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (KhuyenMai) query.list().get(0);
	}
	public List<KhuyenMai> getKhuyenMais() {
		Session session = factory.getCurrentSession();
		String hql = "FROM KhuyenMai";
		List<KhuyenMai> khuyenmai = session.createQuery(hql).list();
		return  khuyenmai;
	}
}