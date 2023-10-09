package com.thang.demo.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author thangdt
 */
@Getter
@Setter
public class UserRequest {
    @NotEmpty
    private String fullName;
    @NotEmpty
    private String gmail;
    @NotEmpty
    private String pass;
}
