package com.example.ha8i8eh.wordcounter_hassanabadi.Exception;

import java.net.SocketTimeoutException;

public class ExceptionMessageFactory {
    public static String getMessage(Throwable throwable){
        if(throwable instanceof SocketTimeoutException)
            return "دسترسی به نت ندارید";
        return "اختلال در دریافت اطلاعات" + throwable;
    }
}
