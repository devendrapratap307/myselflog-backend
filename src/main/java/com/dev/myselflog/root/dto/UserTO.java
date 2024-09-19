package com.dev.myselflog.root.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserTO {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String address;
}
