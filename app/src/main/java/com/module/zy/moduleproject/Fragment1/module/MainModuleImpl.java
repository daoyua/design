package com.module.zy.moduleproject.Fragment1.module;

import com.module.zy.moduleproject.Fragment1.dataResponse.MainResponse;
import com.module.zy.moduleproject.Fragment1.dataResponse.User;

import java.util.ArrayList;

public class MainModuleImpl implements MainModule_inter {

    MainResponse mainResponse;
int i=0;
int j=0;
    @Override
    public MainResponse getData() {
        mainResponse = new MainResponse();
        ArrayList<User> data = new ArrayList<>();
        j=i+30;
        for (;i<j;i++){
            User user=new User();
            user.setAge(i+"岁");
            user.setId(i);
            user.setName(i+"name");
            data.add(user);
        }
        mainResponse.setData(data);
        //TODO
        return mainResponse;
    }
}
