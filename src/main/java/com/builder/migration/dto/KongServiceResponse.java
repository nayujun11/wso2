package com.builder.migration.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KongServiceResponse {
    private String name;
    private Integer retries;
    private String protocol;
    private String host;
    private Integer port;
    private String path;

    @JsonProperty("connect_timeout")
    private Integer connectTimeout; // milli sec 

    @JsonProperty("write_timeout")
    private Integer writeTimeout;   // 백엔드 서버에 데이터 쓰는시간 제한

    @JsonProperty("read_timeout")
    private Integer readTimeout;

    private List<String> tags;       // wso2의 특정값 셋팅 필요
    
    @JsonProperty("client_certificate")
    private ClientCertificate clientCertificate;  //TLS 인증할때 필요

    @JsonProperty("tls_verify")
    private Boolean tlsVerify;

    @JsonProperty("tls_verify_depth")
    private Integer tlsVerifyDepth;

    @JsonProperty("ca_certificates")
    private List<String> caCertificates;
    
    private Boolean enabled;    
}

@Data
@NoArgsConstructor
class ClientCertificate {
    private String id;
}
