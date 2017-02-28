package com.mateusz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RENT on 2017-02-28.
 */
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> names = Arrays.asList("Zdzichu", "Zbychu", "Rychu");
        final PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        writer.write("<h1>");
        writer.write("Hello " + req.getParameter("name"));
//        writer.write(req.getRequestURI());
        writer.write("</h1>");
        Integer counter = new Integer(req.getParameter("counter"));
        writer.write("<ul>");
        names.stream()
        .limit(counter)
                .forEach(e -> writer.write("<li>" + e + "</li>"));
        names.forEach(e -> writer.write("<li>" + e + "</li>"));
        writer.write("</ul>");
    }
}
