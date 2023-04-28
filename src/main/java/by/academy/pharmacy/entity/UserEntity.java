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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import static by.academy.pharmacy.entity.Constant.AVATAR_IMAGE_PATH_DB;
import static by.academy.pharmacy.entity.Constant.CARTS;
import static by.academy.pharmacy.entity.Constant.DATE_JOINED_DB;
import static by.academy.pharmacy.entity.Constant.HEALTH_CARE_CARD_NUMBER_DB;
import static by.academy.pharmacy.entity.Constant.MEDICINE_PRODUCT_ID_DB;
import static by.academy.pharmacy.entity.Constant.USERS;
import static by.academy.pharmacy.entity.Constant.USER_ENTITY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = USERS)
public class UserEntity implements Serializable {
    /**
     * Contains health care card number of user.
     */
    @Id
    @Column(name = HEALTH_CARE_CARD_NUMBER_DB)
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
    @Enumerated(EnumType.ORDINAL)
    private Role role;
    /**
     * Contains date when user created account.
     */
    @Column(name = DATE_JOINED_DB)
    private Date joinedDate;
    /**
     * Contains users' personal information.
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = HEALTH_CARE_CARD_NUMBER_DB)
    private PersonalInfoEntity personalInfoEntity;
    @Column(name = AVATAR_IMAGE_PATH_DB)
    private String avatarImagePath;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = CARTS, joinColumns = @JoinColumn(name = HEALTH_CARE_CARD_NUMBER_DB),
            inverseJoinColumns = @JoinColumn(name = MEDICINE_PRODUCT_ID_DB))
    private Set<MedicineProductEntity> cart;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = USER_ENTITY)
    private Set<PrescriptionEntity> prescriptionEntities;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = USER_ENTITY)
    private Set<OrderEntity> orderEntities;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = USER_ENTITY)
    private Set<PrescriptionRequestEntity> prescriptionRequestEntities;
}
