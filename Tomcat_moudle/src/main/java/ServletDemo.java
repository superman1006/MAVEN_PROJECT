import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


//创建访问路径,一定要用/,后面可以随便写
@WebServlet(urlPatterns = {"/Demo1","/Demo2"},loadOnStartup = 1)//精确匹配
//@WebServlet(urlPatterns = "/Demo1/*",loadOnStartup = 1)//目录匹配，可以访问Demo1下的所有网页
//@WebServlet(urlPatterns = "*.do",loadOnStartup = 1)//扩展名匹配，可以访问.do结尾的所有网页
//@WebServlet(urlPatterns = "/",loadOnStartup = 1)//任意匹配1
//@WebServlet(urlPatterns = "/*",loadOnStartup = 1)//任意匹配2
public class ServletDemo implements Servlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = config;
        System.out.println("init...");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet is running...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
