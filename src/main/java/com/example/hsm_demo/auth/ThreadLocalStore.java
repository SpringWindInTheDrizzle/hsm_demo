package com.example.hsm_demo.auth;

public class ThreadLocalStore {

    private static final ThreadLocal<UserDetail> USER_DETAIL_THREAD_LOCAL = new ThreadLocal<>();

    public static UserDetail getCurrentUser() {
        return USER_DETAIL_THREAD_LOCAL.get();
    }

    public static void clearUser() {
        USER_DETAIL_THREAD_LOCAL.remove();
    }

    public static void setCurrentUser(UserDetail user) {
        USER_DETAIL_THREAD_LOCAL.set(user);
    }
}
