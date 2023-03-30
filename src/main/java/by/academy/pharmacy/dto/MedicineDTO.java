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
public final class MedicineDTO implements Serializable {
    /**
     * Contains identification number of medicine.
     */
    private Long id;
    /**
     * Contains title of the medicine.
     */
    private String title;
    /**
     * Indicates whether medicine needs prescription to be sold or not.
     */
    private Boolean isNonprescription;
    /**
     * Contains information about medicine producer.
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ProducerDTO producerDTO = new ProducerDTO();
    private Date approvalDate;
    private String medicineImagePath;
}
