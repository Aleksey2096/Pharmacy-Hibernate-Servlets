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
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static by.academy.pharmacy.entity.Constant.CONTACT_PHONE_DB;
import static by.academy.pharmacy.entity.Constant.DATE_TIME_DB;
import static by.academy.pharmacy.entity.Constant.DELIVERY_ADDRESS_DB;
import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.ID;
import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCT_ID_DB;
import static by.academy.pharmacy.entity.Constant.ORDERS;
import static by.academy.pharmacy.entity.Constant.PAYMENT_CARD_NUMBER_DB;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = ORDERS)
public class OrderEntity implements Serializable {
	/**
	 * Contains identification number of order.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Contains precise time and date of the order.
	 */
	@Column(name = DATE_TIME_DB)
	private LocalDateTime localDateTime;
	/**
	 * Contains user who ordered the medicine.
	 */
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = HEALTH_CARE_CARD_NUMBER_DB,
			referencedColumnName = HEALTH_CARE_CARD_NUMBER_DB)
	private UserEntity userEntity;
	/**
	 * Contains medicine product with medicine which was ordered by user.
	 */
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = MEDICINE_PRODUCT_ID_DB, referencedColumnName = ID)
	private MedicineProductEntity medicineProductEntity;
	/**
	 * Contains ordered amount of the medicine.
	 */
	private Integer amount;
	/**
	 * Contains price of the medicine product, while purchasing.
	 */
	private BigDecimal price;
	/**
	 * Contains number of clients' payment card.
	 */
	@Column(name = PAYMENT_CARD_NUMBER_DB)
	private Long paymentCardNumber;
	/**
	 * Contains users' contact phone number.
	 */
	@Column(name = CONTACT_PHONE_DB)
	private String contactPhone;
	/**
	 * Contains users' delivery address.
	 */
	@Column(name = DELIVERY_ADDRESS_DB)
	private String deliveryAddress;
}
