package com.biteup.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequestDTO {

    private String firstName;
    private String lastName;
    private Integer mobile;
    private String address;
    private String email;
}
