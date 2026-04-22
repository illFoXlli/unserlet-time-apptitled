package org.fox.servlet;

import org.fox.service.TimeService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {

    private final TimeService service = new TimeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        String timezone = req.getParameter("timezone");
        String result = service.getTime(timezone);

        req.setAttribute("time", result);

        req.getRequestDispatcher("/time.jsp").forward(req, resp);
    }

}
