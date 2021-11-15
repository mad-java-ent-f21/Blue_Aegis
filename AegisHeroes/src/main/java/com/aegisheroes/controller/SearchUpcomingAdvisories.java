package com.aegisheroes.controller;

import com.aegisheroes.persistence.VulnerabilityDao;
import com.aegisheroes.persistence.VulnerabilityData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUsers"}
)

public class SearchUpcomingAdvisories extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //UserData userData = new UserData();
        VulnerabilityDao vulnerabilityDaoDao = new VulnerabilityDao();
        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("users", vulnerabilityDaoDao.getUsersByLastName(req.getParameter("searchTerm")));
        } else {
            req.setAttribute("users", vulnerabilityDaoDao.getAllUsers());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}