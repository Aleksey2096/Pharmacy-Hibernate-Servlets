package by.academy.pharmacy.dto;

import by.academy.pharmacy.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class UserDTO implements Serializable {
    /**
     * Contains health care card number of user.
     */
    private Long healthCareCardNumber;
    /**
     * Contains users' login.
     */
    private String login;
    /**
     * Contains users' password.
     */
    private String password;
    /**
     * Contains client, pharmacist, administrator roles of users.
     */
    private Role role;
    /**
     * Contains date when user created account.
     */
    private Date joinedDate;
    /**
     * Contains users' personal information.
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private PersonalInfoDTO personalInfoDTO;
    private String avatarImagePath;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<MedicineProductDTO> cart;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<PrescriptionDTO> prescriptionDTOs;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<OrderDTO> orderDTOs;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<PrescriptionRequestDTO> prescriptionRequestDTOs;
}
