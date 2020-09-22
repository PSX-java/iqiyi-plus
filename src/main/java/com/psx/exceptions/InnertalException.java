package com.psx.exceptions;

/**
 * @author ：psx
 * @date ：Created in 2020/9/21 18:49
 * @description：登陆辅助功能
 * @modified By：
 * @version: $
 */
public class InnertalException extends Exception {

    private String message;

    public InnertalException(){
        super();
    }

    public InnertalException(String message){
        super();
        this.message=message;
    }
}
