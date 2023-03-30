package by.academy.pharmacy.entity;

import by.academy.pharmacy.service.util.FormConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import static by.academy.pharmacy.entity.Constant.CART;
import static by.academy.pharmacy.entity.Constant.ID;
import static by.academy.pharmacy.entity.Constant.MEDICINE_ID_DB;
import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCTS_DB;
import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCT_ENTITY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = MEDICINE_PRODUCTS_DB)
public class MedicineProductEntity implements Serializable {
	/**
	 * Contains identification number of medicine storage.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Reference to the object containing information about medicine.
	 */
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = MEDICINE_ID_DB, referencedColumnName = ID)
	private MedicineEntity medicineEntity;
	/**
	 * Contains the size or frequency of a dose of a medicine or drug.
	 */
	private Short dosage;
	/**
	 * Contains physical representation of medicine.
	 */
	@Convert(converter = FormConverter.class)
	private Form form;
	/**
	 * Contains price of the medicine.
	 */
	private BigDecimal price;
	/**
	 * Contains amount of concrete medicine available in the storage.
	 */
	private Integer amount;
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = CART, cascade = CascadeType.ALL)
	private Set<UserEntity> customers = new LinkedHashSet<>();
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = MEDICINE_PRODUCT_ENTITY, cascade = CascadeType.ALL)
	private Set<PrescriptionEntity> prescriptionEntities;
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = MEDICINE_PRODUCT_ENTITY, cascade = CascadeType.ALL)
	private Set<OrderEntity> orderEntities;
}
