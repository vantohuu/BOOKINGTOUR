package BOOKINGTOUR.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import BOOKINGTOUR.entity.NhanVien;
import BOOKINGTOUR.entity.TaiKhoan;




@Transactional
@Controller
public class start {
	@Autowired
    SessionFactory factory;
	@RequestMapping("index")
	public String welcome() {
		return "login/login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ModelMap model, HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		TaiKhoan taikhoan = queryLogin(username, password);
		if (taikhoan != null) {
			if (taikhoan.getNhanVien().isTrangThai()==true) {
				session.setAttribute("TaiKhoan", taikhoan);
				if (taikhoan.getIsAdmin()==1) {
					return "admin/admin";
				} else  {
					return "manager/manager";
				}
			} 
			else {
				model.addAttribute("error", "Tài khoản đã ngừng hoạt động !!!");
				return "login/login";
			}
		}
		else
			model.addAttribute("error", "Mã tài khoản hoặc mật khẩu chưa đúng !!!");
			return "login/login"; 
		
	}
	@RequestMapping(value="danhsachnhanvien")
	public String danhsachtaikhoan(HttpServletRequest request,ModelMap model) {
		System.out.println(123);
		model.addAttribute("nhanviens",getListNhanVien());
		return"admin/dsnhanvien";
	}
	
	public List<NhanVien> getListNhanVien() {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien";
		List<NhanVien> nhanviens = session.createQuery(hql).list();
		return  nhanviens;
	}
	
	
	public TaiKhoan queryLogin(String username, String password) {

		Session session = factory.getCurrentSession();
		
		String hql = "FROM TaiKhoan WHERE MANV= :USERNAME AND PASSWORD = :PASSWORD";
		Query query = session.createQuery(hql);
		query.setParameter("USERNAME", username);
		query.setParameter("PASSWORD", password);
		if(query.list().size()==0) {
			return null;
		}
		return  (TaiKhoan)query.list().get(0);
	}

}
