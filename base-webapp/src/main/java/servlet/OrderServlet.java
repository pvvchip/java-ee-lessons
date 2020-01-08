package servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet implements Servlet {
    private static Logger logger = LoggerFactory.getLogger(OrderServlet.class);
    private transient ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("New request");

        servletResponse.getWriter().println("<h1>Order Servlet content</h1>");
    }

    @Override
    public String getServletInfo() {
        return "OrderServlet";
    }

    @Override
    public void destroy() {
        logger.info("Servlet {} destroyed", getServletInfo());
    }
}
