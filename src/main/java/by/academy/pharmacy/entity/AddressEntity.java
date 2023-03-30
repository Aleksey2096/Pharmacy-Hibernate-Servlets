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
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

import static by.academy.pharmacy.entity.Constant.ADDRESSES;
import static by.academy.pharmacy.entity.Constant.ADDRESS_ENTITY;
import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = ADDRESSES)
public class AddressEntity implements Serializable {
	@Id
	@Column(name = HEALTH_CARE_CARD_NUMBER_DB)
	private Long healthCareCardNumber;
	private Integer postcode;
	private String city;
	private String street;
	private Integer house;
	private Integer apartment;
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToOne(mappedBy = ADDRESS_ENTITY, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private PersonalInfoEntity personalInfoEntity;
}
