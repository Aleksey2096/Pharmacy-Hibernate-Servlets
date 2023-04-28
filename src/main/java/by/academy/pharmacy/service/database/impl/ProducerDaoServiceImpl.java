package by.academy.pharmacy.service.database.impl;

import by.academy.pharmacy.converter.Converter;
import by.academy.pharmacy.converter.impl.ProducerConverter;
import by.academy.pharmacy.dao.DAO;
import by.academy.pharmacy.dao.ProducerDAO;
import by.academy.pharmacy.dao.impl.ProducerDaoImpl;
import by.academy.pharmacy.dto.ProducerDTO;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.ProducerEntity;
import by.academy.pharmacy.service.database.ProducerDaoService;

public final class ProducerDaoServiceImpl implements ProducerDaoService {
    private final ProducerDAO dao = new ProducerDaoImpl();
    private final Converter<ProducerEntity, ProducerDTO> converter = new ProducerConverter();

    @Override
    public DAO<ProducerEntity, Long> getDAO() {
        return dao;
    }

    @Override
    public Converter<ProducerEntity, ProducerDTO> getConverter() {
        return converter;
    }

    @Override
    public PaginationObject<ProducerDTO> readAllWithParameters(
            final PaginationObject<ProducerEntity> pagination, final OrderObject orderObject,
            final String searchValue) {
        return converter.convertToDtoPaginationObject(
                dao.selectAllWithParameters(pagination, orderObject, searchValue));
    }
}
