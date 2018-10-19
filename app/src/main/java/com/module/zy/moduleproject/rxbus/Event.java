package com.module.zy.moduleproject.rxbus;

/**
 * If you have any questions, you can contact by email {wangzhumoo@gmail.com} * @author 王诛魔 2017/10/19 下午5:38 * * 发送事件包装类
 */
public class Event<T> {
    public static final int EVENT_CLOSE_ALL_ACTIVITY = 10001;
    /**
     * reserved data
     */
    private T data;
    /**
     * this code distinguish between different events
     */
    private int eventCode = -1;

    public Event(int eventCode) {
        this(eventCode, null);
    }

    public Event(int eventCode, T data) {
        this.eventCode = eventCode;
        this.data = data;
    }

    /**
     * get event code * * @return
     */
    public int getCode() {
        return this.eventCode;
    }

    /**
     * get event reserved data * * @return
     */
    public T getData() {
        return this.data;
    }
}


