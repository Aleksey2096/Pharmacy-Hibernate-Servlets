package by.academy.pharmacy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import static by.academy.pharmacy.entity.Constant.APPROVAL_DATE_DB;
import static by.academy.pharmacy.entity.Constant.ID;
import static by.academy.pharmacy.entity.Constant.IS_NONPRESCRIPTION_DB;
import static by.academy.pharmacy.entity.Constant.MEDICINES;
import static by.academy.pharmacy.entity.Constant.MEDICINE_ENTITY;
import static by.academy.pharmacy.entity.Constant.MEDICINE_IMAGE_PATH_DB;
import static by.academy.pharmacy.entity.Constant.PRODUCER_ID_DB;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = MEDICINES)
public class MedicineEntity implements Serializable {
	/**
	 * Contains identification number of medicine.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Contains title of the medicine.
	 */
	private String title;
	/**
	 * Indicates whether medicine needs prescription to be sold or not.
	 */
	@Column(name = IS_NONPRESCRIPTION_DB)
	private boolean isNonprescription;
	/**
	 * Contains information about medicine producer.
	 */
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = PRODUCER_ID_DB, referencedColumnName = ID)
	private ProducerEntity producerEntity;
	@Column(name = APPROVAL_DATE_DB)
	private Date approvalDate;
	@Column(name = MEDICINE_IMAGE_PATH_DB)
	private String medicineImagePath;
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = MEDICINE_ENTITY, cascade = CascadeType.ALL)
	private Set<MedicineProductEntity> medicineProductEntities;
}
