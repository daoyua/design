package com.module.zy.moduleproject.MainPage.module;

import com.module.zy.moduleproject.MainPage.dataResponse.MainResponse;
import com.module.zy.moduleproject.MainPage.dataResponse.User;

import java.util.ArrayList;

public class MainModuleImpl implements MainModule_inter {

    MainResponse mainResponse;

    @Override
    public MainResponse getData() {
        mainResponse = new MainResponse();
        ArrayList<User> data = new ArrayList<>();
        for (int i=0;i<=30;i++){
            User user=new User();
            user.setAge(i+"岁");
            user.setName(i+"name");
            data.add(user);
        }
        mainResponse.setData(data);
        //TODO
        return mainResponse;
    }
}
