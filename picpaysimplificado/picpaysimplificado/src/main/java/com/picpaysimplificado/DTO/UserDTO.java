package com.picpaysimplificado.DTO;

import com.picpaysimplificado.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO (String firstName, String lastName, String document, BigDecimal balance, String decimal, String password, UserType userType, String email) {
}
