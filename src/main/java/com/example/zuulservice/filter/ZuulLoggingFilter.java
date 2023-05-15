package com.example.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Component
public class ZuulLoggingFilter extends ZuulFilter {

    @Override
    public Object run() throws ZuulException {
        log.info("************ printing logs: ");

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("************ " + request.getRequestURI());
        return null;
    }

    // 사전/사후필터 결정
    @Override
    public String filterType() {
        return "pre";
    }
    // 여러 필터 사용시 적용 순서

    @Override
    public int filterOrder() {
        return 1;
    }
    // filter 사용여부
    @Override
    public boolean shouldFilter() {
        return true;
    }


}
