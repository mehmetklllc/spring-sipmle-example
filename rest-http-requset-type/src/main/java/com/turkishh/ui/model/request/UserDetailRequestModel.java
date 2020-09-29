package com.turkishh.ui.model.request;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDetailRequestModel {

    @NotNull(message = "First name address cannot be null")
    private String firstName;

    private String lastName;

    @Email
    @NotNull(message = "Email address cannot be null")
    private String email;

    @Size(min = 8, max = 16, message = "Password must be equls or grater than 8 characters and less then 16 characters")
    private String password;

}
