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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.PRESCRIPTION_REQUESTS_DB;
import static by.academy.pharmacy.entity.Constant.PRESCRIPTION_REQUEST_STATUS_DB;
import static by.academy.pharmacy.entity.Constant.PRESCRIPTION_SCAN_PATH_DB;
import static by.academy.pharmacy.entity.Constant.UPLOAD_DATE_TIME_DB;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = PRESCRIPTION_REQUESTS_DB)
public class PrescriptionRequestEntity {
	/**
	 * Contains identification number of prescription request.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Contains path to prescription scan.
	 */
	@Column(name = PRESCRIPTION_SCAN_PATH_DB)
	private String prescriptionScanPath;
	/**
	 * Contains time and date of prescription scan uploading.
	 */
	@Column(name = UPLOAD_DATE_TIME_DB)
	private LocalDateTime uploadDateTime;
	/**
	 * Contains status of prescription request.
	 */
	@Column(name = PRESCRIPTION_REQUEST_STATUS_DB)
	@Enumerated(EnumType.STRING)
	private PrescriptionRequestStatus prescriptionRequestStatus;
	/**
	 * Contains user who made prescription request.
	 */
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = HEALTH_CARE_CARD_NUMBER_DB,
			referencedColumnName = HEALTH_CARE_CARD_NUMBER_DB)
	private UserEntity userEntity;
}
