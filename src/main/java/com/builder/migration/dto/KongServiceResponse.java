package com.builder.migration.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KongServiceResponse {
    private String name;
    private Integer retries;
    private String protocol;
    private String host;
    private Integer port;
    private String path;
    private Integer connect_timeout; // 밀리sec 
    private Integer write_timeout;   // 백엔드 서버에 데이터 쓰는시간 제한
    private Integer read_timeout;
    private List<String> tags;       // wso2의 특정값 셋팅 필요
    // private ClientCertificate client_certificate;  //TLS 인증할때 필요
    // private Boolean tls_verify;
    // private Integer tls_verify_depth;
    // private List<String> ca_certificates;
    private Boolean enabled;    
}

@Data
@NoArgsConstructor
class ClientCertificate {
    private String id;
}
