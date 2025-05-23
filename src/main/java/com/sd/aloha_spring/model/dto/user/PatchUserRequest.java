package com.sd.aloha_spring.model.dto.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PatchUserRequest {
    private String username;
    private String password;
    private String email;
    private String phone;
    private boolean enabled;
}
