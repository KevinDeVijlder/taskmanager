package com.ipminor.kevindevijlder.taskmanager.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CreateUserDTO {
    @NotEmpty(message = "{user.username.notempty}")
    @Size.List({
            @Size(min = 5, message = "{user.username.min}"),
            @Size(max = 30, message = "{user.username.max}")
    })
    private String username;

    @NotEmpty(message = "{user.firstname.notempty}")
    @Size.List({
            @Size(min = 3, message = "{user.firstname.min}"),
            @Size(max = 20, message = "{user.firstname.max}")
    })
    private String firstname;

    @NotEmpty(message = "{user.lastname.notempty}")
    @Size.List({
            @Size(min = 5, message = "{user.lastname.min}"),
            @Size(max = 30, message = "{user.lastname.max}")
    })
    private String lastname;

    @NotEmpty(message = "{user.password.notempty}")
    @Size.List({
            @Size(min = 8, message = "{user.password.min}"),
            @Size(max = 50, message = "{user.password.max}")
    })
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
