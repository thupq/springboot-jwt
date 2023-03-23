package com.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.model.AppUserRole;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class UserDataDTO {

    //  @ApiModelProperty(position = 0)
    @NotBlank(message = "error.user.username.notBlank")
    @Length(min = 4, message = "error.user.username.length")
    @Length(max = 20, message = "error.user.username.length")
    private String username;

    //  @ApiModelProperty(position = 1)
    @NotBlank(message = "error.user.email.notBlank")
    @Length(max = 200, message = "error.user.email.length.max")
    private String email;

    //  @ApiModelProperty(position = 2)
    @NotBlank(message = "error.user.password.notBlank")
    @Length(min = 4, message = "error.user.password.length")
    @Length(max = 20, message = "error.user.password.length")
    private String password;

    //  @ApiModelProperty(position = 3)
    List<AppUserRole> appUserRoles;

}
