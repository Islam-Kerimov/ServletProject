package com.kerimovikh.servlet.session;

import com.kerimovikh.beans.Constants;
import com.kerimovikh.beans.UserInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletOutputStream outputStream = resp.getOutputStream();

        HttpSession session = req.getSession();

        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);

        if (userInfo != null) {
            outputStream.println("<html>");
            outputStream.println("<head><title>Session example</title></head>");

            outputStream.println("<body>");

            outputStream.println("<h3>User Info:</h3>");

            outputStream.println("<p>User Name:" + userInfo.getUserName() + "</p>");
            outputStream.println("<p>Country:" + userInfo.getCountry() + "</p>");
            outputStream.println("<p>Post:" + userInfo.getPost() + "</p>");

            outputStream.println("</body>");
            outputStream.println("<html>");
        } else {
            resp.sendRedirect(this.getServletContext().getContextPath() + "/login");
        }
    }
}
