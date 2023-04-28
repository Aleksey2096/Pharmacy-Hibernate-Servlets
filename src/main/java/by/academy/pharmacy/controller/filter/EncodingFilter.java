package by.academy.pharmacy.controller.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

import static by.academy.pharmacy.entity.Constant.ENCODING;

/**
 * @author Alexey
 * @version 1.0 implements Filter.
 */
public final class EncodingFilter implements Filter {
    /**
     * application encoding value.
     */
    private String encoding;

    @Override
    public void init(final FilterConfig filterConfig) {
        encoding = filterConfig.getInitParameter(ENCODING);
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response,
                         final FilterChain chain) throws IOException, ServletException {
        String existingEncoding = request.getCharacterEncoding();
        if (encoding != null && !encoding.equalsIgnoreCase(existingEncoding)) {
            request.setCharacterEncoding(encoding);
            response.setCharacterEncoding(encoding);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        encoding = null;
    }
}
