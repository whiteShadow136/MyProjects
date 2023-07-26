package threadlocal;

import springsecuritymvcinspect.model.User;

/**
 * @Description:threadlocal
 * @Date:2023/7/23
 * @Author:谢锦创
 */
public class UserContext {
    private static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public static void setCurrentUser(User user) {
        userThreadLocal.set(user);
    }

    public static User getCurrentUser() {
        return userThreadLocal.get();
    }

    public static void clearCurrentUser() {
        userThreadLocal.remove();
    }
}
