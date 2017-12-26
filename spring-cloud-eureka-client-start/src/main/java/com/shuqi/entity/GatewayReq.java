package com.shuqi.entity;

import lombok.Data;

@Data
public class GatewayReq<T> {

    private String reqId;

    private String timestamp;

    private String partnerChannelCode;

    private String signType;

    private String sign;


    private String reqService;

    private T reqBody;
}