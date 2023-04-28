package by.academy.pharmacy.controller.extractor.impl;

import by.academy.pharmacy.controller.extractor.Extractor;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.service.util.RequestDataUtil;
import jakarta.servlet.http.HttpServletRequest;

public final class OrderObjectExtractor implements Extractor<OrderObject> {
    @Override
    public OrderObject extract(final HttpServletRequest request) {
        return OrderObject.builder()
                .orderField(RequestDataUtil.getOrderField(request))
                .orderType(RequestDataUtil.getOrderType(request))
                .build();
    }
}
