package kr.ac.mjc.kiosk.validation.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

public class LoginForm {

    @Data
    public class LoginForm {
        @NotBlank
        private String username;
        @NotBlank
        private String password;
}
