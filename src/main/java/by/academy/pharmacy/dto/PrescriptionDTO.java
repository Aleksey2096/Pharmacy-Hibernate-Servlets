package by.academy.pharmacy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class PrescriptionDTO implements Serializable {
    /**
     * Contains identification number of prescription.
     */
    private Long id;
    /**
     * Contains user who has the prescription.
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private UserDTO userDTO;
    /**
     * Contains information about medicine product.
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private MedicineProductDTO medicineProductDTO;
    /**
     * Contains amount of prescribed medicine.
     */
    private Integer amount;
    /**
     * Contains date of prescription.
     */
    private Date date;
}
