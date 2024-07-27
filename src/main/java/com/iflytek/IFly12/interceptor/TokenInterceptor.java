package com.iflytek.IFly12.interceptor;

import com.google.gson.Gson;
import com.iflytek.IFly12.util.TokenUtils;
import com.iflytek.IFly12.bean.CodeMsg;
import com.iflytek.IFly12.bean.ResponseVo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //跨域请求会首先发一个option请求，直接返回正常状态并通过拦截器
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        if (token!=null){
            boolean result= TokenUtils.verify(token);
            if (result){
                return true;
            }
        }
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().append(new Gson().toJson(ResponseVo.errorByMsg(CodeMsg.INVALID_SIGNATURE)));
        return false;
    }
}