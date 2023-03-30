package by.academy.pharmacy.controller.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.academy.pharmacy.entity.Constant.INDEX_JSP;

public final class SecurityFilter implements Filter {
    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse
                = (HttpServletResponse) response;
        request.getServletContext().getRequestDispatcher(INDEX_JSP)
                .forward(httpServletRequest,
                        httpServletResponse);
        chain.doFilter(request, response);
    }
}
