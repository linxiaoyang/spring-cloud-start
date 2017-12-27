package com.shuqi.filter.error;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by qiuwencheng on 17/4/18.
 * 统一异常处理
 */
@Component
public class ErrorHandlerFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(ErrorHandlerFilter.class);

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 100;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        logger.error("this is a ErrorFilter : {}", throwable.getCause().getMessage());
        ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        ctx.set("error.exception", throwable.getCause());
        if(ctx.getResponse().getStatus()==0){
            //"pre"阶段的异常发生时,SendErrorFilter处理阶段中,response.status=0,
            //执行dispatcher.forward(request, ctx.getResponse());抛异常; @See HttpStatus.valueOf()
            ctx.getResponse().setStatus(500);
        }
        return null;
    }
}