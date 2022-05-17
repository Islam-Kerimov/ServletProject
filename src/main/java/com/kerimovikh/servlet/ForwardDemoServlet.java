package com.kerimovikh.servlet;

import com.kerimovikh.beans.Constants;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/forwardDemo")
public class ForwardDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward = req.getParameter("forward");

        if ("true".equals(forward)) {
            System.out.println("Forward to ShowMeServlet");

            req.setAttribute(Constants.ATTRIBUTE_USER_NAME_KEY, "Hi, I'm Tom come from Walt Disney !");

            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/showMe");

            dispatcher.forward(req, resp);

            return;
        }

        ServletOutputStream outputStream = resp.getOutputStream();

        outputStream.println("<html>");

        outputStream.println("<body>");
        outputStream.println("<h3>Text of ForwardDemoServlet</h3>");
        outputStream.println("- servletPath=" + req.getServletPath());
        outputStream.println("</body>");
        outputStream.println("<html>");

    }
}
