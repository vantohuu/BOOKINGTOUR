/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.71
 * Generated at: 2023-06-01 15:03:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.vetour;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dsvetour_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("jar:file:/E:/bookingtour/product/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BOOKINGTOUR/WEB-INF/lib/jstl-impl.jar!/META-INF/fmt-1_0-rt.tld", Long.valueOf(1343794618000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-impl.jar", Long.valueOf(1682272410279L));
    _jspx_dependants.put("/WEB-INF/views/vetour/../includes/Navbarc2.jsp", Long.valueOf(1685630601462L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>ADMIN</title>\r\n");
      out.write("<link href='assets/css/trangchu.css' rel='stylesheet'>\r\n");
      out.write("<link href='assets/css/all.css' rel='stylesheet'>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Admin quản lý du lịch</title>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\"\r\n");
      out.write("	integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\"\r\n");
      out.write("	crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css\"\r\n");
      out.write("	integrity=\"sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==\"\r\n");
      out.write("	crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n");
      out.write("\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\"\r\n");
      out.write("	integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\"\r\n");
      out.write("	crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"\r\n");
      out.write("	integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\"\r\n");
      out.write("	crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js\"\r\n");
      out.write("	integrity=\"sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+\"\r\n");
      out.write("	crossorigin=\"anonymous\"></script>\r\n");
      out.write("<style>\r\n");
      out.write(".dropdown-menu.show {\r\n");
      out.write("	left: -800px;\r\n");
      out.write("	background-color: aliceblue;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<div class=\"container-fluid\">\r\n");
      out.write("		<div class=\"row flex-nowrap\">\r\n");
      out.write("			");
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
      out.write("                  <li><a href=\"../danhsachnhanvien.htm\" \r\n");
      out.write("							class=\"nav-link text-white px-0 align-middle\">\r\n");
      out.write("							<i class=\"fa-regular fa-calendar-days\"></i> <span\r\n");
      out.write("								class=\"ms-1 d-none d-sm-inline\">Danh sách nhân viên</span>\r\n");
      out.write("						</a></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#submenu2\" data-bs-toggle=\"collapse\" class=\"nav-link text-white px-0 align-middle \">\r\n");
      out.write("                            <i class=\"fa-solid fa-map-location-dot\"></i>\r\n");
      out.write("                            <span class=\"ms-1 d-none d-sm-inline\">Quản lí du lịch</span></a>\r\n");
      out.write("                        <ul class=\"collapse nav flex-column ms-1\" id=\"submenu2\" data-bs-parent=\"#menu\">\r\n");
      out.write("                            <li class=\"w-100\">\r\n");
      out.write("                                <a href=\"../dsdattour.htm\" class=\"nav-link text-white px-0\"> <span class=\"d-none d-sm-inline\">Danh sách đặt tour</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"../diemdulich.htm\" class=\"nav-link text-white px-0\"> <span class=\"d-none d-sm-inline\">Điểm du lịch</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                               <li>\r\n");
      out.write("                                <a href=\"../dsdiemluutru.htm\" class=\"nav-link text-white px-0\"> <span class=\"d-none d-sm-inline\">Điểm lưu trú</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"../dsTour.htm\" class=\"nav-link text-white px-0\"> <span class=\"d-none d-sm-inline\">Tour</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                     <li>\r\n");
      out.write("                        <a href=\"#submenu3\" data-bs-toggle=\"collapse\" class=\"nav-link text-white px-0 align-middle \">\r\n");
      out.write("                           <i class=\"fa-solid fa-sack-dollar\"></i>\r\n");
      out.write("                            <span class=\"ms-1 d-none d-sm-inline\">Quản lý chung</span></a>\r\n");
      out.write("                        <ul class=\"collapse nav flex-column ms-1\" id=\"submenu3\" data-bs-parent=\"#menu\">\r\n");
      out.write("                             <li class=\"w-100\">\r\n");
      out.write("                                <a href=\"../doanhthu.htm\" class=\"nav-link text-white px-0\"> <span class=\"d-none d-sm-inline\">Doanh thu</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"\">\r\n");
      out.write("                                <a href=\"../dskhachhang.htm\" class=\"nav-link text-white px-0\"> <span class=\"d-none d-sm-inline\">Doanh thu</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"../dsvetour.htm\" class=\"nav-link text-white px-0\"> <span class=\"d-none d-sm-inline\">Khách hàng</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                           \r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"../dsdotkhuyenmai.htm\" class=\"nav-link text-white px-0\"> <span class=\"d-none d-sm-inline\">Khuyến mãi</span></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                <hr>\r\n");
      out.write("              \r\n");
      out.write("                <div class=\"dropdown pb-4\">\r\n");
      out.write("                    <a href=\"#\" class=\"d-flex align-items-center text-white text-decoration-none dropdown-toggle\" id=\"dropdownUser1\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("                        <img src=\"https://github.com/mdo.png\" alt=\"hugenerd\" width=\"30\" height=\"30\" class=\"rounded-circle\">\r\n");
      out.write("                        <span class=\"d-none d-sm-inline mx-1\">Tài khoản</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <ul class=\"dropdown-menu dropdown-menu-dark text-small shadow\">\r\n");
      out.write("   \r\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"../nhanvien-thongtin.htm\">Chỉnh sửa thông tin cá nhân</a></li>\r\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"../doimatkhau.htm\">Đổi mật khẩu</a></li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <hr class=\"dropdown-divider\">\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"../logout.htm\">Đăng xuất</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("       \r\n");
      out.write("\r\n");
      out.write("			<div class=\"col py-3\">\r\n");
      out.write("				");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("				");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("				\r\n");
      out.write("            ");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("				<div class=\"container form-dang-nhap\">\r\n");
      out.write("					<div style='display: flex; justify-content: space-between;'>\r\n");
      out.write("\r\n");
      out.write("						<button type=\"button\" class=\"btn btn-success\"\r\n");
      out.write("							onclick=\"location.href = 'themvetour/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${idBK}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(".htm'\">Thêm vé tour mới</button>\r\n");
      out.write("\r\n");
      out.write("						<input type=\"text\" name=\"timkiem\" placeholder=\" Tìm kiếm\"\r\n");
      out.write("							style='padding: 3px'>\r\n");
      out.write("\r\n");
      out.write("					</div>\r\n");
      out.write("					<br>\r\n");
      out.write("					<table class=\"table\">\r\n");
      out.write("						<thead>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<th scope=\"col\">ID</th>\r\n");
      out.write("								<th scope=\"col\">Giá vé</th>\r\n");
      out.write("								<th scope=\"col\">Phí di chuyển</th>\r\n");
      out.write("								<th scope=\"col\">Giá cọc</th>\r\n");
      out.write("								<th scope=\"col\">Loại vé</th>\r\n");
      out.write("								<th scope=\"col\">Xử lý</th>\r\n");
      out.write("							</tr>\r\n");
      out.write("						</thead>\r\n");
      out.write("						<tbody>\r\n");
      out.write("						\r\n");
      out.write("							");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("						</tbody>\r\n");
      out.write("					</table>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script>\r\n");
      out.write("  setTimeout(function() {\r\n");
      out.write("    document.querySelector('.alert').classList.add('d-none');\r\n");
      out.write("  }, 2000);\r\n");
      out.write("</script>\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"\r\n");
      out.write("		integrity=\"sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN\"\r\n");
      out.write("		crossorigin=\"anonymous\"></script>\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/vetour/dsvetour.jsp(52,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message==1}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("				\r\n");
          out.write("					\r\n");
          out.write("					<div class=\"alert alert-success fade show\" role=\"alert\"\r\n");
          out.write("						style='position: fixed; width: 50%; margin-left: 230px;z-index: 100'>\r\n");
          out.write("						<h4 class=\"alert-heading\">SUCCESS!</h4>\r\n");
          out.write("						<p>xóa nhân viên thành công</p>\r\n");
          out.write("						<hr>\r\n");
          out.write("					</div>\r\n");
          out.write("				");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /WEB-INF/views/vetour/dsvetour.jsp(62,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message==2}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("				\r\n");
          out.write("					<div class=\"alert alert-danger\" role=\"alert\"\r\n");
          out.write("						style='position: fixed; width: 50%; margin-left: 230px;z-index: 100'>\r\n");
          out.write("						<h4 class=\"alert-heading\">ERROR!</h4>\r\n");
          out.write("						<p>xóa nhân viên thất bại</p>\r\n");
          out.write("						<hr>\r\n");
          out.write("					</div>\r\n");
          out.write("				");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f0_reused = false;
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /WEB-INF/views/vetour/dsvetour.jsp(72,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("message");
      // /WEB-INF/views/vetour/dsvetour.jsp(72,12) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue("0");
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      _jspx_th_c_005fset_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/views/vetour/dsvetour.jsp(97,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("vetour");
      // /WEB-INF/views/vetour/dsvetour.jsp(97,7) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vetours}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\r\n");
            out.write("								<tr>\r\n");
            out.write("									<th scope=\"row\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vetour.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</th>\r\n");
            out.write("									<td scope=\"row\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vetour.giaVe}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("									<td scope=\"row\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vetour.phiDiChuyen}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("									");
            out.write("\r\n");
            out.write("									<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vetour.giaCoc}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("									<td scope=\"row\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vetour.loaiVe.ten}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("									\r\n");
            out.write("									\r\n");
            out.write("																	<td style='display: flex; justify-content: flex-start;'>\r\n");
            out.write("	\r\n");
            out.write("									\r\n");
            out.write("										<a\r\n");
            out.write("										href=\"suavetour/");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vetour.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write(".htm\"><button\r\n");
            out.write("												class=\"btn btn-primary\">chỉnh sửa</button> </a> \r\n");
            out.write("\r\n");
            out.write("										<button\r\n");
            out.write("											onclick=\"if(confirm('bạn có chắc chắn muốn xóa nhân viên này không ?')){location.href='xoavetour/");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vetour.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write(".htm'}\"\r\n");
            out.write("											class=\"btn btn-danger\" style='margin-left: 7px;'>Xóa</button>\r\n");
            out.write("</td>\r\n");
            out.write("								</tr>\r\n");
            out.write("\r\n");
            out.write("							");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
