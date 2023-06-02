package BOOKINGTOUR.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import BOOKINGTOUR.entity.DiemDuLich;
import BOOKINGTOUR.entity.LoaiLuuTru;
import BOOKINGTOUR.entity.NoiLuuTru;
import BOOKINGTOUR.entity.Phong;


@Transactional
@Controller
public class diemluutruController {
	@Autowired
    SessionFactory factory;
	@RequestMapping("dsdiemluutru")
	public String dsdiemluutru(HttpServletRequest request,ModelMap model,@ModelAttribute("message") String message) {
		model.addAttribute("diemluutrus",this.gettNoiLuuTrus());
		model.addAttribute("message", message);
		return "diemluutru/dsdiemluutru";
	}
	
	@RequestMapping(value="themdiemluutru")
	public String themdiemluutru(HttpServletRequest request,ModelMap model) {
		model.addAttribute("diemluutru1", new NoiLuuTru());
		model.addAttribute("diemluutrus",this.gettNoiLuuTrus());
		model.addAttribute("loailuutrus",this.geLoaiLuuTrus());
		return"diemluutru/themdiemluutru";
	}
	@RequestMapping(value="insertdiemluutru", method = RequestMethod.POST) 
	public String insertdiemluutru(@ModelAttribute("diemluutru1") NoiLuuTru diemluutru,ModelMap model, BindingResult errors) {
		boolean kt=true;
		if (diemluutru.getTenNLT().trim().length() == 0) {
			errors.rejectValue("tenNLT", "diemluutru", "Vui lòng nhập tên !");
			kt=false;
		}
		else if(checkTenDiemLuuTruTrung(diemluutru.getTenNLT())==1) {
			errors.rejectValue("tenNLT", "diemluutru", "Tên đã bị trùng !");
			kt=false;
		}
		 if (diemluutru.getDiaChi().trim().length() == 0) {
			errors.rejectValue("diaChi", "diemluutru", "Vui lòng nhập địa chỉ !");kt=false;
		}
		 if (diemluutru.getsDT().trim().length() < 5  ) {
				errors.rejectValue("sDT", "diemluutru", "Vui lòng nhập sdt !");kt=false;
			}
		if(kt==true) {
	

		
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(diemluutru);
				t.commit();
				System.out.println(diemluutru.getId());
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}}
			
			model.addAttribute("loailuutrus",this.geLoaiLuuTrus());
			model.addAttribute("diemluutrus",gettNoiLuuTrus());
		return "diemluutru/themdiemluutru";
	}
	
	@RequestMapping(value="suadiemluutru/{id}")
	public String suadiemdulich(ModelMap model ,@PathVariable int id) {
		NoiLuuTru diemluutru1 =new NoiLuuTru();
		diemluutru1.setId(id);
		model.addAttribute("diemluutru1", diemluutru1);
		model.addAttribute("diemluutru",this.searchDiemLuuTru(id));
		model.addAttribute("loailuutrus",this.geLoaiLuuTrus());
		model.addAttribute("diemluutrus",gettNoiLuuTrus());
		return"diemluutru/suadiemluutru";
	}
	@RequestMapping(value="suadiemluutru/update", method = RequestMethod.POST) 
	public String editdiemluutru(@ModelAttribute("diemluutru") NoiLuuTru diemluutru,ModelMap model,BindingResult errors) {
		boolean kt=true;
		if (diemluutru.getTenNLT().trim().length() == 0) {
			errors.rejectValue("tenNLT", "diemluutru", "Vui lòng nhập tên !");
			kt=false;
		}
		 if (diemluutru.getDiaChi().trim().length() == 0) {
			errors.rejectValue("diaChi", "diemluutru", "Vui lòng nhập địa chỉ !");kt=false;
		}
		 if (diemluutru.getsDT().trim().length() < 5  ) {
				errors.rejectValue("sDT", "diemluutru", "Vui lòng nhập sdt !");kt=false;
			}
		if(kt==true) {
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.update(diemluutru);
				t.commit();
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}}
			model.addAttribute("loailuutrus",this.geLoaiLuuTrus());
			model.addAttribute("diemluutru",diemluutru);
			model.addAttribute("diemluutrus",gettNoiLuuTrus());
		return "diemluutru/suadiemluutru";
	}
	
	@RequestMapping(value="xoadiemluutru/{id}")
	public String xoadiemluutru(ModelMap model ,@PathVariable int id) {
	
	
	
	
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			 
			
			String hql = "delete from NoiLuuTru where id= :id";
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
		
		return"redirect:/dsdiemluutru.htm";
	}
	
	public List<NoiLuuTru> gettNoiLuuTrus() {
		Session session = factory.getCurrentSession();
		String hql = "FROM NoiLuuTru";
		List<NoiLuuTru> noiLuuTrus = session.createQuery(hql).list();
		return  noiLuuTrus;
	}
	public List<LoaiLuuTru> geLoaiLuuTrus() {
		Session session = factory.getCurrentSession();
		String hql = "FROM LoaiLuuTru";
		List<LoaiLuuTru> loaiLuuTrus = session.createQuery(hql).list();
		return  loaiLuuTrus;
	}
	
	private int checkTenDiemLuuTruTrung( String tenTLT) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NoiLuuTru where tenNLT = :tenTLT";
		Query query = session.createQuery(hql);
		query.setParameter("tenTLT", tenTLT);
		List<NoiLuuTru> list = query.list();
		if(list.size() == 0) return 0;
		return 1;
	}
	public NoiLuuTru searchDiemLuuTru(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NoiLuuTru WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (NoiLuuTru) query.list().get(0);
	}
	public Phong searchPhong(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Phong WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (Phong)query.list().get(0);
	}
	
	@RequestMapping(value="dsphong/{id}")
	public String dsphong(ModelMap model ,@PathVariable int id,@ModelAttribute("message") String message) {
		NoiLuuTru diemdulich= this.searchDiemLuuTru(id);
		model.addAttribute("message", message);
		model.addAttribute("idNLT",id);
		model.addAttribute("diemluutru",this.searchDiemLuuTru(id));
		model.addAttribute("phongs",diemdulich.getPhong());
		return"diemluutru/dsphong";
	}
	
	@RequestMapping(value="dsphong/themphong/{idNLT}")
	public String themphong(HttpServletRequest request,ModelMap model,@PathVariable int idNLT) {
		Phong phong= new Phong();
		phong.setNoiLuuTru1(searchDiemLuuTru(idNLT));
		model.addAttribute("phong",phong);
		return"diemluutru/themphong";
	}
	@RequestMapping(value="dsphong/themphong/insertphong", method = RequestMethod.POST) 
	public String insertphong(@ModelAttribute("phong") Phong phong,ModelMap model,BindingResult errors) {
		boolean kt=true;
		if (phong.getTen().trim().length() == 0) {
			errors.rejectValue("ten", "phong", "Vui lòng nhập tên !");
			kt=false;
		}
		 if (phong.getSoGiuong() < 1) {
			errors.rejectValue("soGiuong", "phong", "Số giường phải lớn hơn 0 !");kt=false;
		}
		 if (phong.getsLNMax() < 1  ) {
				errors.rejectValue("sLNMax", "phong", "Số lượng người tối đa phải lớn hơn 0 !");kt=false;
			}
		if(kt==true) {
		
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(phong);
				t.commit();
				System.out.println(phong.getId());
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}}
		
		return "diemluutru/themphong";
	}
	@RequestMapping(value="dsphong/suaphong/{id}")
	public String suaphong(ModelMap model ,@PathVariable int id) {
		Phong phong =this.searchPhong(id);
		model.addAttribute("phong",phong);
		return"diemluutru/suaphong";
	}
	@RequestMapping(value="dsphong/suaphong/update", method = RequestMethod.POST) 
	public String editphong(@ModelAttribute("phong") Phong phong,ModelMap model,BindingResult errors) {
	
		boolean kt=true;
		if (phong.getTen().trim().length() == 0) {
			errors.rejectValue("ten", "phong", "Vui lòng nhập tên !");
			kt=false;
		}
		 if (phong.getSoGiuong() < 1) {
			errors.rejectValue("soGiuong", "phong", "Số giường phải lớn hơn 0 !");kt=false;
		}
		 if (phong.getsLNMax() < 1  ) {
				errors.rejectValue("sLNMax", "phong", "Số lượng người tối đa phải lớn hơn 0 !");kt=false;
			}
		if(kt==true) {
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.update(phong);
				t.commit();
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}}

			model.addAttribute("phong",phong);
		
		return "diemluutru/suaphong";
	}
	@RequestMapping(value="xoaphong/{id}")
	public String xoaphong(ModelMap model ,@PathVariable int id) {
		Phong phong= searchPhong(id);
		int idNLT=phong.getNoiLuuTru1().getId();

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			String hql = "delete from Phong where id =:id ";
			Query query1 = session.createQuery(hql);
			query1.setParameter("id", id);
			int result1 = query1.executeUpdate();
			t.commit();
			model.addAttribute("message", 1);
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", 2);
			
		} finally {
			session.close();
		}
		model.addAttribute("idNLT",idNLT);
		return"redirect:/dsphong/{idNLT}.htm";
	}
//	public LoaiLuuTru searchLLT(int id) {
//		Session session = factory.getCurrentSession();
//		String hql = "FROM LoaiLuuTru where id = :id";
//		Query query = session.createQuery(hql);
//		query.setParameter("id", id);
//		if(query.list().size()==0) {
//			return null;
//		}
//		LoaiLuuTru llt = (LoaiLuuTru) query.list().get(0);
//
//		return llt;
//	}

}
