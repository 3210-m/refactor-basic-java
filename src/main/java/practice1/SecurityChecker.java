package practice1;

public class SecurityChecker {
    public boolean checkPermission(User user, Permission permission) {
        boolean isPermission = true;
        //参数检查
        if (user == null || permission == null) {
            isPermission = false;
        }
        //去数据库查询用户是否有相关的权限
        //如果有则返回true
        //没有权限则返回false

        return isPermission;
    }

    public boolean isAdmin() {
        //这里为什么不传入判断用户的参数呢？
        //如果入参为User
        //1.判断User的值是否合理 .if(user == null) return false
        //2.则去数据库中查询该用户是否有Admin权限，如果有则返回true，否则返回false
        return false;
    }
}
