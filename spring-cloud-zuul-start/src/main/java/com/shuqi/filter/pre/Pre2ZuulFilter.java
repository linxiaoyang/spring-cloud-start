package com.shuqi.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.shuqi.entity.GatewayReq;
import org.springframework.stereotype.Component;

@Component
public class Pre2ZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 11;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        //获取上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        Object gatewayReq = ctx.get("gatewayReq");
        GatewayReq gatewayReq1;
        if (gatewayReq != null) {
            gatewayReq1 = (GatewayReq) gatewayReq;
            System.out.println(gatewayReq1);
        }
        return null;
    }
}
