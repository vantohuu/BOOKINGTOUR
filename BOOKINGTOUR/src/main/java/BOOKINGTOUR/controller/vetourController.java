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
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import BOOKINGTOUR.entity.BookingTour;
import BOOKINGTOUR.entity.CTPhongLuuTru;
import BOOKINGTOUR.entity.CTTour;
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
	public String dsve(ModelMap model ,@PathVariable int id,@ModelAttribute("message") String message,@RequestParam(defaultValue = "0") int currentPage,@RequestParam(defaultValue = "") String timkiem) {
		BookingTour bookingTour= this.searchbBookingTour(id);
        int pageSize = 6; // Số lượng phần tử trên mỗi trang
        
        
		/*
		 * List<CTVe> vetours1 =new ArrayList<CTVe>(); for (VeTour s :
		 * bookingTour.getVeTours()) { vetours1.addAll(s.getcTve()); }
		 * 
		 * 
		 * 
		 * int totalCount = vetours1.size(); // Tổng số lượng phần tử trên toàn bộ danh
		 * sách int totalPages = (int) Math.ceil((double) totalCount / pageSize); int
		 * startIndex = (currentPage) * pageSize; int endIndex = Math.min(startIndex +
		 * pageSize, totalCount); // Lấy phần tử của danh sách theo giới hạn kết quả trả
		 * về List<CTVe> result = vetours1.subList(startIndex, endIndex);
		 */
        List<CTVe> vetours1 =new ArrayList<CTVe>(); for (VeTour s :
   		 bookingTour.getVeTours()) { vetours1.addAll(s.getcTve()); }
        
        
        int totalUsers = vetours1.size();
		List<CTVe> ctTours = this.getCTVe(currentPage,pageSize,id,timkiem);
	    int totalPages = (int) Math.ceil((double) totalUsers / pageSize);
	    if(totalPages==0) {
			totalPages=1;
		}
		
		
		 model.addAttribute("totalPages", totalPages);
		    model.addAttribute("currentPage", currentPage);
		    model.addAttribute("offset", currentPage * pageSize);
		model.addAttribute("message", message);
		
		model.addAttribute("idBK",id);
		model.addAttribute("bookingtour",bookingTour);
		model.addAttribute("ctvetours",ctTours);
		return"vetour/dsve";
	}
	
	@RequestMapping(value="dsve/themvetg", method = RequestMethod.POST)
	public String thembvetg(HttpServletRequest request,HttpSession session,ModelMap model,@ModelAttribute("CCCD") String CCCD,@ModelAttribute("idBK") String idBK )  {
		BookingTour bookingTour =searchbBookingTour(Integer.parseInt(idBK));
		if(bookingTour.getTrangThai() !=0 && listctCtVes(bookingTour.getId()).size() >=1  ) {
			model.addAttribute("message",8);
			return "redirect:/dsve/" + idBK + ".htm";}
		
		if(bookingTour.getVeTours().size()==0) { 
			model.addAttribute("message",3);
			return "redirect:/dsve/" + idBK + ".htm";}
		else {
		if(CCCD.trim().length()<4) {
			model.addAttribute("message",7);
			return "redirect:/dsve/" + idBK + ".htm";
		}
		KhachHang khachHang = searchKhachHang(CCCD);
		/* BookingTour bookingTour = searchbBookingTour(Integer.parseInt(idBK)); */
		if (khachHang == null) {
			khachHang = new KhachHang();
			khachHang.setcCCD(CCCD);
		}
		CTVe ctVe = new CTVe();
		ctVe.setKhachHang(khachHang);
		TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("TaiKhoan");
		ctVe.setNhanVienXN(taiKhoan.getNhanVien());
		ctVe.setKhuyenMai(getKhuyenMais().get(0));
		ctVe.setVeTour(searchbBookingTour(Integer.parseInt(idBK)).getVeTours().get(0));
			model.addAttribute("ctve", ctVe);
			model.addAttribute("vetours", searchbBookingTour(Integer.parseInt(idBK)).getVeTours());
			model.addAttribute("dotkhuyenmai", getKhuyenMais());
			model.addAttribute("tennvXN",taiKhoan.getNhanVien().getHo() + " "+taiKhoan.getNhanVien().getTen());
		 
			return "vetour/themctve";	}
	}
	@RequestMapping(value="dsve/insert", method = RequestMethod.POST) 
	public String insertdattour(@ModelAttribute("ctve") CTVe ctVe,ModelMap model, BindingResult errors) {
		BookingTour bookingTour = searchVeTour(ctVe.getVeTour().getId()).getBookingTour1();
		boolean kt=true;
		if (ctVe.getKhachHang().getHo().trim().length() == 0) {
			errors.rejectValue("khachHang.ho", "ctVe", "Vui lòng nhập họ !");
			kt=false;
		}
		if (ctVe.getKhachHang().getTen().trim().length() == 0) {
			errors.rejectValue("khachHang.ten", "ctVe", "Vui lòng nhập tên !");
			kt=false;
		}
		if (ctVe.getKhachHang().getsDT().trim().length() <= 5) {
			errors.rejectValue("khachHang.sDT", "ctVe", "Vui lòng nhập sdt đúng !");
			kt=false;
		}
		if(kt==true) {
		ctVe.setNhanVienXN(searchNhanVien(ctVe.getNhanVienXN().getcCCD()));
		ctVe.setVeTour(searcVeTour(ctVe.getVeTour().getId()));
		
		
		if(ctVe.getVeTour().getLoaiVe().getId()==1 && bookingTour.getMaxNL() <= ListLoaiVe(bookingTour.getId(), 1).size() ) {
			model.addAttribute("message", 4);
			return "redirect:/dsve/" + bookingTour.getId() + ".htm";
		}
		else if(ctVe.getVeTour().getLoaiVe().getId()==2 && bookingTour.getMaxTN() <= ListLoaiVe(bookingTour.getId(), 2).size() ) { 
			model.addAttribute("message", 5);
			return "redirect:/dsve/" + bookingTour.getId() + ".htm";
			
		}
		else if(ctVe.getVeTour().getLoaiVe().getId()==3 && bookingTour.getMaxTE() <= ListLoaiVe(bookingTour.getId(), 3).size() ) { 
			model.addAttribute("message", 6);
			return "redirect:/dsve/" + bookingTour.getId() + ".htm";
		}
		else {
		ctVe.setKhuyenMai(searchKhuyenMai(ctVe.getKhuyenMai().getId()));
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		KhachHang khachHang =ctVe.getKhachHang();
			try {
				if(searchKhachHang(ctVe.getKhachHang().getcCCD())==null) {
					session.save(khachHang);
					System.out.println(111111);
				}
				else {session.update(khachHang);}
				
				session.save(ctVe);
				
				t.commit();
				
				model.addAttribute("message", 1);
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", 2);
				
			} finally {
				session.close();
			}}}
		else {
			List<VeTour> veTours=bookingTour.getVeTours();
			ctVe.setVeTour(veTours.get(0));
			ctVe.setNhanVienXN(searchNhanVien(ctVe.getNhanVienXN().getcCCD()));
				model.addAttribute("ctve", ctVe);
				model.addAttribute("vetours", veTours);
				model.addAttribute("dotkhuyenmai", getKhuyenMais());
				model.addAttribute("tennvXN",ctVe.getNhanVienXN().getHo() + " "+ctVe.getNhanVienXN().getTen());
			 
				return "vetour/themctve";	
		}
			
			return "redirect:/dsve/" + ctVe.getVeTour().getBookingTour1().getId() + ".htm";
	}
	
	@RequestMapping(value="dsve/suactve/{id}")
	public String suactve(ModelMap model ,@PathVariable int id) {
		CTVe ctVe=new CTVe();
		ctVe =this.searchctCtVe(id);
		NhanVien nhanVienXN =ctVe.getNhanVienXN();
		BookingTour bookingTour = ctVe.getVeTour().getBookingTour1();
		ctVe.setKhuyenMai(getKhuyenMais().get(0));
		ctVe.setVeTour(bookingTour.getVeTours().get(0));
		model.addAttribute("ctve",ctVe);
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
	public String dsvetour(ModelMap model ,@PathVariable int id,@ModelAttribute("message") String message,@RequestParam(defaultValue = "0") int currentPage) {
		BookingTour bookingTour= this.searchbBookingTour(id);
int pageSize = 7; // Số lượng phần tử trên mỗi trang
		

		int totalCount = bookingTour.getVeTours().size(); // Tổng số lượng phần tử trên toàn bộ danh sách
		 int totalPages = (int) Math.ceil((double) totalCount / pageSize);
		if(totalPages==0) {
			totalPages=1;
		}
	
		
		int startIndex = (currentPage)  * pageSize;
		int endIndex = Math.min(startIndex + pageSize, totalCount);
		System.out.println(startIndex);
		System.out.println(endIndex);
		// Lấy phần tử của danh sách theo giới hạn kết quả trả về
		List<VeTour> result = bookingTour.getVeTours().subList(startIndex, endIndex);
		model.addAttribute("offset", currentPage * pageSize);
		 model.addAttribute("totalPages", totalPages);
		    model.addAttribute("currentPage", currentPage);
		model.addAttribute("message", message);
		model.addAttribute("idBK",id);
		model.addAttribute("bookingtour",bookingTour);
		model.addAttribute("vetours",result);
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
	public String insertdiemluutru(@ModelAttribute("vetour") VeTour vetour,ModelMap model, BindingResult errors) {
		
		
		

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
		
		return"redirect:/dsvetour/"+veTour.getBookingTour1().getId()+".htm";
	}
		
	@RequestMapping(value="xoakhachang/{cCCD}")
	public String xoanhanvien(ModelMap model ,@PathVariable String cCCD) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			String hql = "delete from KhachHang where cCCD =:cCCD ";
			Query query1 = session.createQuery(hql);
			query1.setParameter("cCCD", cCCD);
			int result1 = query1.executeUpdate();

			t.commit();
			
			model.addAttribute("message", 1);
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", 2);
			
		} finally {
			session.close();
		}
		return"redirect:/dskhachhang.htm";
	}
	
	
	@RequestMapping(value="dskhachhang")
	public String dskhachhang(ModelMap model ,@ModelAttribute("message") String message,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String timkiem) {
		int pageSize = 7;
		int totalUsers = getSize();
		List<KhachHang> khachHang = this.getKhachHang(page,pageSize,timkiem);
	    int totalPages = (int) Math.ceil((double) totalUsers / pageSize);
	    if(totalPages==0) {
			totalPages=1;
		}
	    model.addAttribute("offset", page * pageSize);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("currentPage", page);
		
		
		
		
		model.addAttribute("khachhangs",khachHang);
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
	public VeTour searchVeTour(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM VeTour WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		if(query.list().size()==0) return null;
		return (VeTour) query.list().get(0);
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
	
	public int  getSize() {
		Session session = factory.getCurrentSession();
		String hql = "FROM KhachHang";
		Query query = session.createQuery(hql);
		List<KhachHang> list = query.list();

		return list.size();
	}
	public List<KhachHang> getKhachHang(int page, int pageSize) {
		Session session = factory.getCurrentSession();
		String hql = "FROM KhachHang";
		Query query = session.createQuery(hql);
		int offset = page * pageSize;
		List<KhachHang> list = query.setFirstResult(offset).setMaxResults(pageSize).list();

		return list;
	}
	public List<KhachHang> getKhachHang(int page, int pageSize, String ten) {
		Session session = factory.getCurrentSession();
		String hql;
		Query query;
		List<KhachHang> list;
		if (ten.length() == 0 )
		{
			hql ="FROM KhachHang t ORDER BY t.cCCD DESC";
			query = session.createQuery(hql);
			int offset = page * pageSize;
			list = query.setFirstResult(offset).setMaxResults(pageSize).list();
		} else
		{
			hql ="FROM KhachHang t where t.ten LIKE CONCAT( :ten, '%') ORDER BY t.cCCD DESC";
			query = session.createQuery(hql);
			int offset = page * pageSize;
			query.setParameter("ten", ten);
			list = query.setFirstResult(offset).setMaxResults(pageSize).list();
		}
		return list;
	}
	
	public List<CTVe> getCTVe(int page, int pageSize, int idTour,String ten) {
		Session session = factory.getCurrentSession();
		String hql;
		Query query;
		List<CTVe> list;
		if (ten.length() == 0 )
		{
			hql ="FROM CTVe t where t.veTour.bookingTour1.id =:idTour ORDER BY t.khachHang.ten";
			query = session.createQuery(hql);
			query.setParameter("idTour", idTour);
			int offset = page * pageSize;
			list = query.setFirstResult(offset).setMaxResults(pageSize).list();
		} else
		{
			hql ="FROM CTVe t where t.khachHang.ten LIKE CONCAT( :ten, '%') and  t.veTour.bookingTour1.id =:idTour ORDER BY t.khachHang.ten";
			query = session.createQuery(hql);
			int offset = page * pageSize;
			query.setParameter("idTour", idTour);
			query.setParameter("ten", ten);
			list = query.setFirstResult(offset).setMaxResults(pageSize).list();
		}
		return list;
	}
	
	private List<CTVe> ListLoaiVe(int idBK,int idLoaiVe) {
		Session session = factory.getCurrentSession();
		String hql;
		Query query;
		List<CTVe> list;
		hql ="FROM CTVe t where t.veTour.loaiVe.id =:idLoaiVe and t.veTour.bookingTour1.id =:idTour";
		query = session.createQuery(hql);
		query.setParameter("idTour", idBK);
		query.setParameter("idLoaiVe", idLoaiVe);
		list = query.list();
		return list;
	}
	private List<CTVe> listctCtVes(int idBK) {
		Session session = factory.getCurrentSession();
		String hql;
		Query query;
		List<CTVe> list;
		hql ="FROM CTVe t where  t.veTour.bookingTour1.id =:idTour";
		query = session.createQuery(hql);
		query.setParameter("idTour", idBK);
		list = query.list();
		return list;
	}
	
	
	
}
