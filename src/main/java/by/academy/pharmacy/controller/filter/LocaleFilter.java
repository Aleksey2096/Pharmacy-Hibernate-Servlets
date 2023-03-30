package by.academy.pharmacy.controller.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.academy.pharmacy.entity.Constant.DEFAULT_LOCALE;
import static by.academy.pharmacy.entity.Constant.LOCALE;

public final class LocaleFilter implements Filter {
    private String defaultLocale;

    @Override
    public void init(final FilterConfig filterConfig) {
        defaultLocale = filterConfig.getInitParameter(DEFAULT_LOCALE);
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession httpSession = httpServletRequest.getSession();
        String locale = (String) httpSession.getAttribute(LOCALE);
        if (locale == null) {
            httpSession.setAttribute(LOCALE, defaultLocale);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        defaultLocale = null;
    }
}