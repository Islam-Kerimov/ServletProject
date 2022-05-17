package com.kerimovikh.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/initParam", "/initPar"}, initParams = {
        @WebInitParam(name = "emailSupport1", value = "first@mail.ru"),
        @WebInitParam(name = "emailSupport2", value = "second@mail.ru")
})
public class InitParamServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private String emailSupport1;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        this.emailSupport1 = config.getInitParameter("emailSupport1");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String emailSupport2 = this.getServletConfig().getInitParameter("emailSupport2");

        ServletOutputStream outputStream = resp.getOutputStream();

        outputStream.println("<html>");
        outputStream.println("<head><title>Init Param</title></head>");

        outputStream.println("<body>");
        outputStream.println("<h3>Servlet with Annotation configuration</h3>");
        outputStream.println("<p>emailSupport1 = " + this.emailSupport1 + "</p>");
        outputStream.println("<p>emailSupport2 = " + emailSupport2 + "</p>");
        outputStream.println("</body>");
        outputStream.println("<html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
