package com.sd.aloha_spring.model.dto.user;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private boolean enabled;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
