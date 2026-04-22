package org.fox.servlet;

import org.fox.service.TimeService;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {

    private final TimeService service = new TimeService();

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String timezone = req.getParameter("timezone");

        String result = service.getTime(timezone);

        resp.setContentType("text/html");
        resp.getWriter().write("<h1>" + result + "</h1>");
    }

}