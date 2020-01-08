package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class PageFilter implements Filter {
    private transient FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        resp.setCharacterEncoding("utf-8");

//        resp.getWriter().println("<!DOCTYPE html>\n" +
//                "<html lang=\"en\">\n" +
//                "<head>\n" +
//                "    <meta charset=\"UTF-8\">\n" +
//                "</head>");

//        filterConfig.getServletContext().getRequestDispatcher("/header.html").include(req, resp);
        chain.doFilter(req, resp);
        filterConfig.getServletContext().getRequestDispatcher("/menu.html").include(req, resp);

    }

    @Override
    public void destroy() {

    }



}
