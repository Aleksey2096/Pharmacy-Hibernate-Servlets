package by.academy.pharmacy.service.util;

import by.academy.pharmacy.dto.MedicineProductDTO;
import by.academy.pharmacy.dto.OrderDTO;
import by.academy.pharmacy.dto.PrescriptionDTO;
import by.academy.pharmacy.dto.UserDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class ValidatorUtil {
    private ValidatorUtil() {
    }

    public static boolean isEnoughAccountFunds(final UserDTO userDTO,
                                               final BigDecimal totalPrice) {
        return userDTO.getPersonalInfoDTO().getPersonalAccount()
                .compareTo(totalPrice) >= 0;
    }

    public static boolean isValidOrders(
            final Set<PrescriptionDTO> prescriptions,
            final List<OrderDTO> orders) {
        Map<MedicineProductDTO, Integer> prescriptionsMap
                = prescriptions.stream()
                .collect(Collectors.toMap(
                        PrescriptionDTO::getMedicineProductDTO,
                        PrescriptionDTO::getAmount));
        Map<MedicineProductDTO, Integer> ordersMap = orders.stream()
                .filter(x -> !x.getMedicineProductDTO().getMedicineDTO()
                        .getIsNonprescription())
                .collect(Collectors.toMap(
                        OrderDTO::getMedicineProductDTO,
                        OrderDTO::getAmount));
        for (MedicineProductDTO medicineProductDTO : ordersMap.keySet()) {
            if (!prescriptionsMap.containsKey(medicineProductDTO)
                    || prescriptionsMap
                    .get(medicineProductDTO) < ordersMap.get(
                    medicineProductDTO)) {
                return false;
            }
        }
        return true;
    }
}
