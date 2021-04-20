package com.example.projecttest.interceptor;

import com.example.projecttest.bean.Secure;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Secure
@Interceptor
public class AuthorizationInterceptor {

    @AroundInvoke
    public Object authorize(InvocationContext ic) throws Exception {
        System.out.println("Hello interceptor");
        return ic.proceed();
    }
}
