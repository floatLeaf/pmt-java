package com.pmt.config;

import com.zhimo.erp.framework.utils.JacksonUtil;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.tomcat.util.json.JSONParser;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CustomerShiroFilter extends FormAuthenticationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        System.out.println("customerFilter=>>>>>>>>>>>>>>>>>>>>allowed");

        if (request instanceof HttpServletRequest) {
            if (((HttpServletRequest) request).getMethod().toUpperCase().equals("OPTIONS")) {
                return true;
            }
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("customerFilter=>>>>>>>>>>>>>>>>>>>>deny");

        HttpServletResponse res = (HttpServletResponse)response;
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Content-Type", "text/html; charset=utf-8");
        res.setStatus(HttpServletResponse.SC_OK);
        res.setCharacterEncoding("utf-8");
        PrintWriter writer = res.getWriter();
        Map<String, Object> map= new HashMap<>();
        map.put("code", 401);
        map.put("msg", "用户登录已过期");
        writer.write(JacksonUtil.obj2Str(map));
        writer.close();
        return false;
    }
}
