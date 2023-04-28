package by.academy.pharmacy.converter;

import by.academy.pharmacy.entity.PaginationObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public interface Converter<E, D> {
    D convertToDto(final E entity);

    E convertToEntity(final D dto);

    default Set<D> convertToDtoCollection(final Collection<E> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(this::convertToDto)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    default Set<E> convertToEntities(final Collection<D> dtoCollection) {
        if (dtoCollection == null) {
            return null;
        }
        return dtoCollection.stream().map(this::convertToEntity)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * @param pagination result of dao pagination method with the list of entities.
     * @return PaginationObject with records list converted to DTO entities.
     */
    default PaginationObject<D> convertToDtoPaginationObject(final PaginationObject<E> pagination) {
        PaginationObject<D> paginationObject = new PaginationObject<>();
        paginationObject.setCurrentPage(pagination.getCurrentPage());
        paginationObject.setPagesNum(pagination.getPagesNum());
        paginationObject.setRecordsPerPage(pagination.getRecordsPerPage());
        paginationObject.setRecords(
                new ArrayList<>(convertToDtoCollection(pagination.getRecords())));
        return paginationObject;
    }
}
