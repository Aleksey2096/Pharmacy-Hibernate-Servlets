package by.academy.pharmacy.service.database;

import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.dto.PrescriptionDTO;
import by.academy.pharmacy.dto.UserDTO;
import by.academy.pharmacy.entity.OrderObject;
import by.academy.pharmacy.entity.PaginationObject;
import by.academy.pharmacy.entity.UserEntity;

import java.util.Set;

public interface UserDaoService extends DaoService<UserEntity, UserDTO, Long> {
	UserDTO login(String login, String password);

	PaginationObject<UserDTO> readAllWithParameters(
			PaginationObject<UserEntity> pagination,
			OrderObject orderObject, String searchValue);

	void addToCart(Long healthCareCardNumber,
				   MedicineProductDTO medicineProductDTO);

	void deleteFromCart(Long healthCareCardNumber,
						MedicineProductDTO medicineProductDTO);

	Set<MedicineProductDTO> readCart(Long healthCareCardNumber);

	Set<PrescriptionDTO> readPrescriptions(Long healthCareCardNumber);
}
