package ru.job4j.dream.servlet;


import ru.job4j.dream.mockito.Validate;
import ru.job4j.dream.mockito.ValidateService;
import ru.job4j.dream.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserService extends HttpServlet {
    private final Validate logic = ValidateService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logic.add(new User(0, req.getParameter("name")));
    }
}
