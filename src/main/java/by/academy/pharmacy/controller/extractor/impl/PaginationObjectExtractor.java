package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.service.util.RequestDataUtil;

import javax.servlet.http.HttpServletRequest;

public final class PaginationObjectExtractor<E>
        implements Extractor<PaginationObject<E>> {
    @Override
    public PaginationObject<E> extract(final HttpServletRequest request) {
        return PaginationObject.<E>builder()
                .recordsPerPage(RequestDataUtil.getRecordsPerPage(request))
                .currentPage(RequestDataUtil.getCurrentPage(request))
                .build();
    }
}
