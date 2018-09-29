package com.module.zy.moduleproject.Fragment1.module;

import com.module.zy.moduleproject.Fragment1.dataResponse.BaseResponse;

public interface BaseModule <T extends BaseResponse>{
     T getData();
}
