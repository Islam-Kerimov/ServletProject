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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletOutputStream outputStream = resp.getOutputStream();

        HttpSession session = req.getSession();

        UserInfo userInfo = new UserInfo("Islam", "RUS", 7);

        session.setAttribute(Constants.SESSION_USER_KEY, userInfo);

        outputStream.println("<html>");
        outputStream.println("<head><title>Session example</title></head>");

        outputStream.println("<body>");
        outputStream.println("<h3>You are logined!, info stored in session</h3>");

        outputStream.println("<a href='userInfo'>View User Info</a>");
        outputStream.println("</body>");
        outputStream.println("<html>");
    }
}
