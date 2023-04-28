package by.academy.pharmacy.dto;

import by.academy.pharmacy.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class ProducerDTO implements Serializable {
    /**
     * Contains identification number of producer.
     */
    private Long id;
    /**
     * Contains name of the company.
     */
    private String companyName;
    /**
     * Contains information about country where medicine was produced.
     */
    private Country country;
    /**
     * Contains date when company was created.
     */
    private Date creationDate;
}
