package by.academy.pharmacy.service.database;

import by.academy.pharmacy.dto.OrderDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.OrderEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;

public interface OrderDaoService extends DaoService<OrderEntity, OrderDTO, Long> {
    PaginationObject<OrderDTO> readAllWithParameters(
            PaginationObject<OrderEntity> pagination, OrderObject orderObject, String searchValue);

    PaginationObject<OrderDTO> readAllWithParametersByUser(PaginationObject<OrderEntity> pagination,
                                                           OrderObject orderObject,
                                                           String searchValue, UserDTO userDTO);
}
