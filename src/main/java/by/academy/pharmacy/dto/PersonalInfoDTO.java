package by.academy.pharmacy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class PersonalInfoDTO implements Serializable {
    /**
     * Contains health care card number of personal info.
     */
    private Long healthCareCardNumber;
    /**
     * Contains surname of the user.
     */
    private String surname;
    /**
     * Contains name of the user.
     */
    private String name;
    /**
     * Contains users' birthdate.
     */
    private Date birthDate;
    /**
     * Contains users' address.
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private AddressDTO addressDTO;
    /**
     * Contains users' phone number.
     */
    private String phone;
    /**
     * Contains users' email address.
     */
    private String email;
    /**
     * Contains position of the pharmacist.
     */
    private String position;
    /**
     * Contains clients' personal account value.
     */
    private BigDecimal personalAccount;
    /**
     * Contains number of clients' payment card.
     */
    private Long paymentCardNumber;
}
