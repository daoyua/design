package com.module.zy.moduleproject.converter;

import com.module.zy.moduleproject.retrofit2.response.UserResponse;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class TestConverter implements Converter<ResponseBody,UserResponse> {
    @Override
    public UserResponse convert(ResponseBody value) throws IOException {

        try { /** * fastjson解析数据 * 此处特别注意： Info应为外部类，并将其类中的成员设置为public， * 否则会无法创建Info对象，从而导致解析异常 */
//        UserResponse info = Gson.parseObject(value.string(), type); System.out.println(info); return info; } finally { value.close();
        }catch (Exception e){

        }

        return null;
    }
}
