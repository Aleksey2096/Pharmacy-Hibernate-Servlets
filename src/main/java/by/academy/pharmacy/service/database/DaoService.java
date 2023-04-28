package by.academy.pharmacy.service.database;

import by.academy.pharmacy.converter.Converter;
import by.academy.pharmacy.dao.DAO;

import java.util.Set;

public interface DaoService<E, D, K> {
    DAO<E, K> getDAO();

    Converter<E, D> getConverter();

    default D create(final D dto) {
        return getConverter().convertToDto(getDAO().insert(getConverter().convertToEntity(dto)));
    }

    default D readById(final K key) {
        return getConverter().convertToDto(getDAO().selectById(key));
    }

    default void update(final D dto) {
        getDAO().update(getConverter().convertToEntity(dto));
    }

    default void deleteById(final K key) {
        getDAO().deleteById(key);
    }

    default Set<D> readAll() {
        return getConverter().convertToDtoCollection(getDAO().selectAll());
    }
}
