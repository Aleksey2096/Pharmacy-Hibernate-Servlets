package by.academy.pharmacy.service.database;

import by.academy.pharmacy.dto.ProducerDTO;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.ProducerEntity;

public interface ProducerDaoService extends DaoService<ProducerEntity, ProducerDTO, Long> {
    PaginationObject<ProducerDTO> readAllWithParameters(PaginationObject<ProducerEntity> pagination,
                                                        OrderObject orderObject,
                                                        String searchValue);
}
