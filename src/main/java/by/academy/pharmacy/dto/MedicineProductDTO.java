package by.academy.pharmacy.dto;

import by.academy.pharmacy.entity.Form;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class MedicineProductDTO implements Serializable {
    /**
     * Contains identification number of medicine storage.
     */
    private Long id;
    /**
     * Reference to the object containing information about medicine.
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private MedicineDTO medicineDTO;
    /**
     * Contains the size or frequency of a dose of a medicine or drug.
     */
    private Short dosage;
    /**
     * Contains physical representation of medicine.
     */
    private Form form;
    /**
     * Contains price of the medicine.
     */
    private BigDecimal price;
    /**
     * Contains amount of concrete medicine available in the storage.
     */
    private Integer amount;
}
