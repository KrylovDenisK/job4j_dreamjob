package ru.job4j.dream.servlet;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;


public class GreetingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String result = req.getReader().lines().collect(Collectors.joining());
        JSONObject jsonObject = new JSONObject(result);
        String value = jsonObject.getString("name");
        jsonObject.put("name", "Nice to meet you " + value);
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(jsonObject.toString());
    }
}