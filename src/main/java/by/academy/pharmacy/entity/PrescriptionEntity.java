package by.academy.pharmacy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.ID;
import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCT_ID_DB;
import static by.academy.pharmacy.entity.Constant.PRESCRIPTIONS;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = PRESCRIPTIONS)
public class PrescriptionEntity implements Serializable {
	/**
	 * Contains identification number of prescription.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Contains user who has the prescription.
	 */
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = HEALTH_CARE_CARD_NUMBER_DB,
			referencedColumnName = HEALTH_CARE_CARD_NUMBER_DB)
	private UserEntity userEntity;
	/**
	 * Contains information about medicine product.
	 */
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = MEDICINE_PRODUCT_ID_DB, referencedColumnName = ID)
	private MedicineProductEntity medicineProductEntity;
	/**
	 * Contains amount of prescribed medicine.
	 */
	private Integer amount;
	/**
	 * Contains date of prescription.
	 */
	private Date date;
}
