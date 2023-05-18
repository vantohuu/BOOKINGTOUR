package BOOKINGTOUR.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
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

import BOOKINGTOUR.entity.NhanVien;
import BOOKINGTOUR.entity.TaiKhoan;
import javassist.expr.NewArray;






@Transactional
@Controller
public class start {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
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
			if (taikhoan.getNhanVien().getTrangThai()==1) {
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
		model.addAttribute("nhanviens",getListNhanVien());
		return"admin/dsnhanvien";
	}
	
	@RequestMapping(value="themnhanvien")
	public String themnhanvien(HttpServletRequest request,ModelMap model) {
		model.addAttribute("nhanviens",getListNhanVien());
		return"admin/themnhanvien";
	}
	
	@RequestMapping(value="suanhanvien/{maNV}")
	public String suanhanvien(ModelMap model ,@PathVariable String maNV) {
		model.addAttribute("nhanVien1", new NhanVien());
		model.addAttribute("nhanVien",this.searchNhanVien(maNV));
		model.addAttribute("nhanviens",getListNhanVien());
		return"admin/suanhanvien";
	}
	
	@RequestMapping(value="suanhanvien/update", method = RequestMethod.POST) 
	public String editNhanVien(@ModelAttribute("nhanVien1") NhanVien nhanVien,ModelMap model) {
		
		Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.update(nhanVien);
				t.commit();
				model.addAttribute("message", "Update thành công");
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Update thất bại");
				
			} finally {
				session.close();
			}
			model.addAttribute("nhanVien1", new NhanVien());
			model.addAttribute("nhanVien",nhanVien);
			model.addAttribute("nhanviens",getListNhanVien());
		return "admin/suanhanvien";
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
	@RequestMapping(value="/themnhanvien",method = RequestMethod.POST) 
	public String themMoi(HttpServletRequest request,ModelMap model) throws ParseException  {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		NhanVien nhanVien = new NhanVien();
		nhanVien.setMaNV(request.getParameter("maNV"));
		nhanVien.setHo(getHo(request.getParameter("hoTen")));
		nhanVien.setTen(getTen(request.getParameter("hoTen")));
		nhanVien.setGioiTinh(request.getParameter("gioiTinh"));
		String tmp = request.getParameter("ngaySinh");
		nhanVien.setNgaySinh(formatter.parse(tmp));
		nhanVien.setcCCD(request.getParameter("cCCD"));
		nhanVien.setsDT(request.getParameter("sDT"));
		nhanVien.setEmail(request.getParameter("email"));
		nhanVien.setTrangThai(1);
		/*
		 * System.out.println(nhanVien.getMaNV()); System.out.println(nhanVien.getHo());
		 * System.out.println(nhanVien.getTen());
		 * System.out.println(nhanVien.getGioiTinh());
		 * System.out.println(nhanVien.getcCCD());
		 * System.out.println(nhanVien.getEmail());
		 */
		if(searchNhanVien(nhanVien.getMaNV()) != null) {
			model.addAttribute("messageMaNV", "** Mã nhân viên bị trùng !");
			model.addAttribute("maNV",taoMaNV());
			model.addAttribute("nhanviens",getListNhanVien());
			return "admin/themnhanvien";
		}else {
			model.addAttribute("messageMaNV", "");
		}
		if(checkTrungCCCD(nhanVien.getcCCD())== 1) {
			model.addAttribute("messageCCCD", "** CCCD bị trùng !");
			model.addAttribute("nhanviens",getListNhanVien());
			System.out.println(3);
			return "admin/themnhanvien";
		}else {
			model.addAttribute("messageCCCD", "");
		}
		try {
			String mkDefault = "123456";
			TaiKhoan tk = new TaiKhoan();
			tk.setMANV(nhanVien.getMaNV());
			tk.setPASSWORD(mkDefault);
			tk.setIsAdmin(Integer.valueOf(request.getParameter("isAdmin")));
			System.out.println(Integer.valueOf(request.getParameter("isAdmin")));
			tk.setNhanVien(nhanVien);
			session.save(nhanVien);
			session.save(tk);
			tr.commit();
			model.addAttribute("message","Đã thêm mới nhân viên thành công!");
		} catch (Exception e) {
			tr.rollback();
			model.addAttribute("message","Nhân viên đã tồn tại!");
		} finally {
			session.close();
		}
		model.addAttribute("nhanviens",getListNhanVien());
		return "admin/themnhanvien";
	}

	
	
	
	
	
	
	public NhanVien searchNhanVien(String maNV) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien WHERE maNV = :maNV";
		Query query = session.createQuery(hql);
		query.setParameter("maNV", maNV);
		if(query.list().size()==0) return null;
		return (NhanVien) query.list().get(0);
	}
	public String taoMaNV() {
		String maNV1 = "manager";
		int ma = getNhanVien1().size() +1;
		maNV1 += String.valueOf(ma);
		return maNV1;
	}
	public List<NhanVien> getNhanVien1() {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien";
		Query query = session.createQuery(hql);
		List<NhanVien> list = query.list();
		return list;
	}
	private int checkTrungCCCD( String cCCD) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien where cCCD = :cCCD";
		Query query = session.createQuery(hql);
		query.setParameter("cCCD", cCCD);
		List<NhanVien> list = query.list();
		if(list.size() == 0) return 0;
		return 1;
	}
	public String getTen(String hoTen) {
	    hoTen.trim();
	    String ten="";
	    int index= hoTen.lastIndexOf(' ');
	    ten = hoTen.substring(index+1);
	  return ten;
	}
public String getHo(String hoTen) {
    hoTen.trim();
    int index= hoTen.lastIndexOf(getTen(hoTen));
    String ho = hoTen.substring(0,index);
    
  return ho.trim();
}
}
