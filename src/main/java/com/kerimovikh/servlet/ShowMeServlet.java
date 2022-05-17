package com.kerimovikh.servlet;

import com.kerimovikh.beans.Constants;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/showMe")
public class ShowMeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String value = (String) req.getAttribute(Constants.ATTRIBUTE_USER_NAME_KEY);

        ServletOutputStream outputStream = resp.getOutputStream();

        outputStream.println("<h1>ShowMeServlet</h1>");
        outputStream.println(value);
    }
}
