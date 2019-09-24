package com.oneworld.springcloud.zuul.zuulserver.api.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

@Component
public class PreZuulFilter extends com.netflix.zuul.ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        System.out.println("prefilter:" + httpServletRequest.getRequestURI());
        return null;
    }
}
