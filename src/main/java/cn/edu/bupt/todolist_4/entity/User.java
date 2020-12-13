package cn.edu.bupt.todolist_4.entity;

import java.io.Serializable;

public class User implements Serializable {
    private String username, password;

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}