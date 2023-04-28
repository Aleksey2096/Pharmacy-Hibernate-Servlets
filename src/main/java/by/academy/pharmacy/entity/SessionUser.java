package by.academy.pharmacy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class SessionUser implements Serializable {
    private Long healthCareCardNumber;
    private String login;
    private Role role;
}
