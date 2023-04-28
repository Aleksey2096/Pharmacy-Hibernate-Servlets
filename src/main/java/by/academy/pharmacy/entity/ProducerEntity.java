package by.academy.pharmacy.entity;

import by.academy.pharmacy.service.util.CountryConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import static by.academy.pharmacy.entity.Constant.COMPANY_NAME_DB;
import static by.academy.pharmacy.entity.Constant.COUNTRY_CODE_DB;
import static by.academy.pharmacy.entity.Constant.CREATION_DATE_DB;
import static by.academy.pharmacy.entity.Constant.PRODUCERS;
import static by.academy.pharmacy.entity.Constant.PRODUCER_ENTITY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = PRODUCERS)
public class ProducerEntity implements Serializable {
    /**
     * Contains identification number of producer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Contains name of the company.
     */
    @Column(name = COMPANY_NAME_DB)
    private String companyName;
    /**
     * Contains information about country where medicine was produced.
     */
    @Column(name = COUNTRY_CODE_DB)
    @Convert(converter = CountryConverter.class)
    private Country country;
    /**
     * Contains date when company was created.
     */
    @Column(name = CREATION_DATE_DB)
    private Date creationDate;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = PRODUCER_ENTITY)
    private Set<MedicineEntity> medicineEntities;
}
