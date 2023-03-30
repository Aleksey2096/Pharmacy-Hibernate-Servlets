package by.academy.pharmacy.dao;

import by.academy.pharmacy.entity.MedicineProductEntity;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.PrescriptionEntity;
import by.academy.pharmacy.entity.UserEntity;

import java.util.Set;

public interface UserDAO extends DAO<UserEntity, Long> {
	UserEntity selectByLogin(String login);

	Set<MedicineProductEntity> selectCart(Long healthCareCardNumber);

	Set<PrescriptionEntity> selectPrescriptions(Long healthCareCardNumber);

	PaginationObject<UserEntity> selectAllWithParameters(
			final PaginationObject<UserEntity> pagination,
			final OrderObject orderObject,
			final String searchValue);
}
