package by.academy.pharmacy.controller.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.academy.pharmacy.entity.Constant.INDEX_JSP;

public final class SecurityFilter implements Filter {
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response,
                         final FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        request.getServletContext().getRequestDispatcher(INDEX_JSP)
                .forward(httpServletRequest, httpServletResponse);
        chain.doFilter(request, response);
    }
}
