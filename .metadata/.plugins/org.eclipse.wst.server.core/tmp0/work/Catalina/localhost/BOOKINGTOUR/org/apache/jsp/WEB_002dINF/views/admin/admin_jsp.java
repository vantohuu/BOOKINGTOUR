/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.71
 * Generated at: 2023-06-01 14:37:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/views/admin/../includes/Navbarc1.jsp", Long.valueOf(1685630137886L));
    _jspx_dependants.put("jar:file:/E:/bookingtour/product/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BOOKINGTOUR/WEB-INF/lib/jstl-impl.jar!/META-INF/fmt-1_0-rt.tld", Long.valueOf(1343794618000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-impl.jar", Long.valueOf(1682272410279L));
    _jspx_dependants.put("jar:file:/E:/bookingtour/product/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BOOKINGTOUR/WEB-INF/lib/jstl-impl.jar!/META-INF/c-1_0-rt.tld", Long.valueOf(1343794618000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write(" <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" \r\n");
      out.write("     integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\" crossorigin=\"anonymous\"> \r\n");
      out.write("     <script src=\"https://kit.fontawesome.com/ee36f81461.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<title>Admin quản lý du lịch</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("   ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("        <div class=\"col-auto col-md-3 col-xl-2 px-sm-2 px-0t bg-primary\">\r\n");
      out.write("            <div class=\"d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100 \">\r\n");
      out.write("                <a href=\"#\" class=\"d-flex align-items-center pb-5 pt-5 mb-md-0 me-md-auto text-white text-decoration-none\">\r\n");
      out.write("                    <span class=\"fs-5 d-none d-sm-inline\">ADMIN QUẢN LÝ DU LỊCH</span>\r\n");
      out.write("                </a>\r\n");
      out.write("                <ul class=\"nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start \" id=\"menu\">\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a href=\"home.htm\" class=\"nav-link text-white align-middle px-0\">\r\n");
      out.write("                           <i class=\"fa-solid fa-house\"></i>\r\n");
      out.write("                            <span class=\"ms-1 d-none d-sm-inline\">Home</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                  <li><a href=\"danhsachnhanvien.htm\" \r\n");
      out.write("							class=\"nav-link text-white px-0 align-middle\">\r\n");
      out.write("							<i class=\"fa-regular fa-calendar-days\"></i> <span\r\n");
      out.write("								class=\"ms-1 d-none d-sm-inline\">Danh sách nhân viên</span>\r\n");
      out.write("						</a></li>\r\n");
      out.write("						     </li>\r\n");
      out.write("                 <!--  <li><button onclick=\"goHome()\">Go to Intro Page</button></li> -->\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#submenu2\" data-bs-toggle=\"collapse\" class=\"nav-link text-white px-0 align-middle \">\r\n");
      out.write("                            <i class=\"fa-solid fa-map-location-dot\"></i>\r\n");
      out.write("                            <span class=\"ms-1 d-none d-sm-inline\">Quản lí du lịch</span></a>\r\n");
      out.write("                        <ul class=\"collapse nav flex-column ms-1\" id=\"submenu2\" data-bs-parent=\"#menu\">\r\n");
      out.write("                            <li class=\"w-100\">\r\n");
      out.write("                                <a href=\"dsdattour.htm\" class=\"nav-link text-white px-0\"> <span class=\"d-none d-sm-inline\">Danh sách đặt tour</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"diemdulich.htm\" class=\"nav-link text-white px-0\"> <span class=\"d-none d-sm-inline\">Điểm du lịch</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                               <li>\r\n");
      out.write("                                <a href=\"dsdiemluutru.htm\" class=\"nav-link text-white px-0\"> <span class=\"d-none d-sm-inline\">Điểm lưu trú</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"dsTour.htm\" class=\"nav-link text-white px-0\"> <span class=\"d-none d-sm-inline\">Tour</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                     <li>\r\n");
      out.write("                        <a href=\"#submenu3\" data-bs-toggle=\"collapse\" class=\"nav-link text-white px-0 align-middle \">\r\n");
      out.write("                           <i class=\"fa-solid fa-sack-dollar\"></i>\r\n");
      out.write("                            <span class=\"ms-1 d-none d-sm-inline\">Quản lý chung</span></a>\r\n");
      out.write("                        <ul class=\"collapse nav flex-column ms-1\" id=\"submenu3\" data-bs-parent=\"#menu\">\r\n");
      out.write("                            <li class=\"w-100\">\r\n");
      out.write("                                <a location.href=\"doanhthu.htm\" class=\"nav-link text-white px-0\"> <span class=\"d-none d-sm-inline\">Doanh thu</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            \r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"dskhachhang.htm\" class=\"nav-link text-white px-0\"> <span class=\"d-none d-sm-inline\">Khách hàng</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"dsvetour.htm\" class=\"nav-link text-white px-0\"> <span class=\"d-none d-sm-inline\">Vé tour</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"dsdotkhuyenmai.htm\" class=\"nav-link text-white px-0\"> <span class=\"d-none d-sm-inline\">Khuyến mãi</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                <hr>\r\n");
      out.write("                </ul>\r\n");
      out.write("                \r\n");
      out.write("              \r\n");
      out.write("                <div class=\"dropdown pb-4\">\r\n");
      out.write("                    <a href=\"#\" class=\"d-flex align-items-center text-white text-decoration-none dropdown-toggle\" id=\"dropdownUser1\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("                        <img src=\"https://github.com/mdo.png\" alt=\"hugenerd\" width=\"30\" height=\"30\" class=\"rounded-circle\">\r\n");
      out.write("                        <span class=\"d-none d-sm-inline mx-1\">Tài khoản</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <ul class=\"dropdown-menu dropdown-menu-dark text-small shadow\">\r\n");
      out.write("   \r\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"nhanvien-thongtin.htm\">Chỉnh sửa thông tin cá nhân</a></li>\r\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"doimatkhau.htm\">Đổi mật khẩu</a></li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <hr class=\"dropdown-divider\">\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"logout.htm\">Đăng xuất</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("     <script>\r\n");
      out.write("    /* function goHome() {\r\n");
      out.write("        window.location.href = \"danhsachnhanvien.htm\";\r\n");
      out.write("    } */\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
