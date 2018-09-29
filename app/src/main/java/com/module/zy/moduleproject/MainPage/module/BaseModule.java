package com.module.zy.moduleproject.MainPage.module;

import com.module.zy.moduleproject.MainPage.dataResponse.BaseResponse;

public interface BaseModule <T extends BaseResponse>{
     T getData();
}
