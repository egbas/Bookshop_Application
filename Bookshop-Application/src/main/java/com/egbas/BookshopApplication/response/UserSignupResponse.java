package com.egbas.BookshopApplication.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSignupResponse {

    private String firstName;
    private String lastName;
    private String email;
}
