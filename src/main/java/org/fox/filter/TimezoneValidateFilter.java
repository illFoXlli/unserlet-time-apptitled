package org.fox.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneId;

@WebFilter("/time")
public class TimezoneValidateFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String timezone = req.getParameter("timezone");

        if (timezone != null && !timezone.isEmpty()) {
            timezone = normalize(timezone);
            try {
                ZoneId.of(timezone);
            } catch (Exception e) {
                resp.setStatus(400);
                resp.getWriter().write("Invalid timezone");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    private String normalize(String timezone) {
        if (timezone == null) return null;
        return timezone.replace(" ", "+");
    }
}