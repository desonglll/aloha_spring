package com.sd.aloha_spring.model.dto.user_group;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatchRequest {
    private String groupName;
}
