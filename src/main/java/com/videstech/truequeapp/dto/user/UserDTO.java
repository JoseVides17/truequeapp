package com.videstech.truequeapp.dto.user;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String location;
    private String phone;
    private Double reputation;
}