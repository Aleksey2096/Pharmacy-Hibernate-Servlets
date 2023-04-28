package by.academy.pharmacy.service.database.impl;

import by.academy.pharmacy.converter.Converter;
import by.academy.pharmacy.converter.impl.MedicineProductConverter;
import by.academy.pharmacy.converter.impl.PrescriptionConverter;
import by.academy.pharmacy.converter.impl.UserConverter;
import by.academy.pharmacy.dao.DAO;
import by.academy.pharmacy.dao.UserDAO;
import by.academy.pharmacy.dao.impl.UserDaoImpl;
import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.dto.PrescriptionDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.MedicineProductEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.PrescriptionEntity;
import by.academy.pharmacy.entity.UserEntity;
import by.academy.pharmacy.service.database.UserDaoService;
import by.academy.pharmacy.service.util.PasswordUtil;

import java.util.Set;

public final class UserDaoServiceImpl implements UserDaoService {
    private final UserDAO dao = new UserDaoImpl();
    private final Converter<UserEntity, UserDTO> converter = new UserConverter();
    private final Converter<MedicineProductEntity, MedicineProductDTO> medicineProductConverter
            = new MedicineProductConverter();
    private final Converter<PrescriptionEntity, PrescriptionDTO> prescriptionConverter
            = new PrescriptionConverter();

    @Override
    public DAO<UserEntity, Long> getDAO() {
        return dao;
    }

    @Override
    public Converter<UserEntity, UserDTO> getConverter() {
        return converter;
    }

    @Override
    public void update(final UserDTO dto) {
        dto.setCart(medicineProductConverter.convertToDtoCollection(
                dao.selectCart(dto.getHealthCareCardNumber())));
        UserDaoService.super.update(dto);
    }

    @Override
    public UserDTO login(final String login, final String password) {
        UserEntity userEntity = dao.selectByLogin(login);
        if (userEntity == null || !PasswordUtil.validatePassword(password,
                userEntity.getPassword())) {
            return null;
        }
        return converter.convertToDto(userEntity);
    }

    @Override
    public PaginationObject<UserDTO> readAllWithParameters(
            final PaginationObject<UserEntity> pagination, final OrderObject orderObject,
            final String searchValue) {
        return converter.convertToDtoPaginationObject(
                dao.selectAllWithParameters(pagination, orderObject, searchValue));
    }

    @Override
    public void addToCart(final Long healthCareCardNumber,
                          final MedicineProductDTO medicineProductDTO) {
        dao.addToCart(healthCareCardNumber,
                medicineProductConverter.convertToEntity(medicineProductDTO));
    }

    @Override
    public Set<MedicineProductDTO> readCart(final Long healthCareCardNumber) {
        return medicineProductConverter.convertToDtoCollection(
                dao.selectCart(healthCareCardNumber));
    }

    @Override
    public void deleteFromCart(final Long healthCareCardNumber,
                               final MedicineProductDTO medicineProductDTO) {
        dao.deleteFromCart(healthCareCardNumber,
                medicineProductConverter.convertToEntity(medicineProductDTO));
    }

    @Override
    public Set<PrescriptionDTO> readPrescriptions(final Long healthCareCardNumber) {
        return prescriptionConverter.convertToDtoCollection(
                dao.selectPrescriptions(healthCareCardNumber));
    }
}
