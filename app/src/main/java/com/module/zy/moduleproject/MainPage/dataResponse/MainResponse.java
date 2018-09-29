package com.module.zy.moduleproject.MainPage.dataResponse;

import java.util.ArrayList;

public class MainResponse extends BaseResponse {
  ArrayList<User> data;

    public ArrayList<User> getData() {
        return data;
    }

    public void setData(ArrayList<User> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MainResponse{" +
                "data=" + data +
                '}';
    }
}
