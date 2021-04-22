package com.ipminor.kevindevijlder.taskmanager.dto;

import com.ipminor.kevindevijlder.taskmanager.config.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@FieldMatch(first = "password", second = "passwordconfirmed", message = "{user.notequalpasswords}")
public class CreateUserDTO {
    @NotEmpty(message = "{user.username.notempty}")
    @Size.List({
            @Size(min = 5, message = "{user.username.min}"),
            @Size(max = 30, message = "{user.username.max}")
    })
    private String username;

    @NotEmpty(message = "{user.fullname.notempty}")
    @Size.List({
            @Size(min = 5, message = "{user.fullname.min}"),
            @Size(max = 30, message = "{user.fullname.max}")
    })
    private String fullname;

    @Email(message = "{user.email.valid}")
    @NotEmpty(message = "{user.email.notempty}")
    private String email;

    @NotEmpty(message = "{user.password.notempty}")
    @Size.List({
            @Size(min = 8, message = "{user.password.min}"),
            @Size(max = 50, message = "{user.password.max}")
    })
    private String password;

    @NotEmpty(message = "{user.passwordconfirmed.notempty}")
    @Size.List({
            @Size(min = 8, message = "{user.passwordconfirmed.min}"),
            @Size(max = 50, message = "{user.passwordconfirmed.max}")
    })
    private String passwordconfirmed;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordconfirmed() {
        return passwordconfirmed;
    }

    public void setPasswordconfirmed(String passwordconfirmed) {
        this.passwordconfirmed = passwordconfirmed;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
