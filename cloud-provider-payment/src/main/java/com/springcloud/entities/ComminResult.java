package com.springcloud.entities;

/**
 * @author liuyang
 * @version 1.0
 * @date 2020/8/2 4:12 下午
 */
public class ComminResult<T> {
    private Integer code;
    private String message;
    private T data;
    public ComminResult(Integer code,String message){
        this(code,message,null);
    }

    public ComminResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ComminResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
