package org.fox;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));

        resp.setContentType("text/html");
        resp.getWriter().write("<h1>" + now.format(formatter) + "</h1>");
    }

}