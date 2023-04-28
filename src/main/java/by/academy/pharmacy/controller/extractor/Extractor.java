package by.academy.pharmacy.controller.extractor;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @param <T> concrete dto object type to extract from request.
 */
public interface Extractor<T> {
    /**
     * @param request client's browser request.
     * @return extracted dto object.
     */
    T extract(HttpServletRequest request);
}
