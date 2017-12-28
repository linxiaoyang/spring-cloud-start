package com.shuqi.filter.pre;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.http.HttpServletRequestWrapper;
import com.shuqi.entity.GatewayReq;
import org.springframework.stereotype.Component;

@Component
public class PreZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 这里还不能简单的调整filter的优先级，因为有系统默认的
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        //获取上下文
        RequestContext ctx = RequestContext.getCurrentContext();

        //去simpleRoute
        if (ctx.getRouteHost() != null) {
            System.out.println(ctx.getRouteHost());
            ctx.setSendZuulResponse(false);
        }

        ctx.set("newRoute","true");

        HttpServletRequestWrapper request = new HttpServletRequestWrapper(ctx.getRequest());
        HttpServletRequestWrapper need = (HttpServletRequestWrapper) request.getRequest();
        if (need.getContentData() != null && need.getContentData().length > 0) {
            String string = new String(need.getContentData());
            GatewayReq gatewayReq = JSONObject.parseObject(string, GatewayReq.class);
            ctx.set("gatewayReq", gatewayReq);
            System.out.println(gatewayReq);

        }
        return null;
    }
}
