package cn.cool.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        String uri = request.getRequestURI();
        if(uri.contains("/login.jsp")||uri.contains("/checkServlet")||uri.contains("/loginServlet")
                ||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/fonts/")){
            chain.doFilter(req, resp);
        }else {
            //不包括,需要验证用户是否登录
            Object user = request.getSession().getAttribute("user");
            if(user!=null){
                chain.doFilter(req,resp);
            }else{
                //没有登录,跳转登录页面
                request.setAttribute("login_msg","您尚未登录,请登录");
                request.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
