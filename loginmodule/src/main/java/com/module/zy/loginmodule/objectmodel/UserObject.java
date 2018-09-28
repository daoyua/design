package com.module.zy.loginmodule.objectmodel;

public class UserObject extends BaseObject{
    String name;
    String password;
    String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserObject(String name, String password, String address) {
        this.name = name;
        this.password = password;
        this.address = address;
    }

    @Override
    public String toString() {
        return "BaseObject{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
