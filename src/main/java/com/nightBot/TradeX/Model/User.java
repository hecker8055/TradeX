package com.nightBot.TradeX.Model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.nightBot.TradeX.Domain.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String fullname;
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Embedded
    private TwoFactorAuth  twoFactorAuth = new TwoFactorAuth();

    private UserRole userRole = UserRole.RoleCustomer;


}
