package com.shuqi;

import com.shuqi.filter.route.MyRouteFilter;
import org.springframework.cloud.netflix.zuul.ZuulProxyConfiguration;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomZuulProxyConfig  {

    @Bean
    public MyRouteFilter myRouteFilter(ProxyRequestHelper helper,
                                                 ZuulProperties zuulProperties) {
        return new MyRouteFilter(helper, zuulProperties);
    }


}
