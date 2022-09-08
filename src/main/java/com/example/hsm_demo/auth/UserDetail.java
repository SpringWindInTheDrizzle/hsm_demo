package com.example.hsm_demo.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {

    private Long userId;

    private String userName;

    private String phoneNum;

    public static UserDetail currentUser() {
        UserDetail userDetail = ThreadLocalStore.getCurrentUser();
        if (userDetail == null) {
            throw new RuntimeException("用户未登录");
        }
        return userDetail;
    }

}
