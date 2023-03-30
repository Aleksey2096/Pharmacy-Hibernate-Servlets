package by.academy.pharmacy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class AddressDTO implements Serializable {
    private Long healthCareCardNumber;
    private Integer postcode;
    private String city;
    private String street;
    private Integer house;
    private Integer apartment;
}
