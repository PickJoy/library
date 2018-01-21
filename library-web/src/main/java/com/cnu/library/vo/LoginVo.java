package com.cnu.library.vo;

/**
 * Created by dell on 2016/1/24.
 */
public class LoginVo {
    private int id;
    //账号
    private String account;
    //密码
    private String password;

    //登陆用户类型
    private int userType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }


}
