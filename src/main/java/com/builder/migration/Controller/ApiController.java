package com.builder.migration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.builder.migration.dto.ApiApplicationResponse;
import com.builder.migration.dto.ApiDetailResponse;
import com.builder.migration.dto.ApiPolicyResponse;
import com.builder.migration.dto.ApiResponse;
import com.builder.migration.dto.ApiSwaggerResponse;
import com.builder.migration.dto.ApiTierResponse;
import com.builder.migration.embeded.CorsConfiguration;
import com.builder.migration.entity.Api;
import com.builder.migration.entity.ApiTier;
import com.builder.migration.entity.Application;
import com.builder.migration.entity.Policy;
import com.builder.migration.service.ApiApplicationService;
import com.builder.migration.service.ApiDetailService;
import com.builder.migration.service.ApiPolicyService;
import com.builder.migration.service.ApiService;
import com.builder.migration.service.ApiSwaggerService;
import com.builder.migration.service.ApiTierService;
import com.builder.migration.service.Wso2GetApisService;
import com.builder.migration.service.Wso2GetTokenService;

@RestController
@RequestMapping("/wso2api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private ApiDetailService apiDetailService;

    @Autowired
    private ApiSwaggerService apiSwaggerService;

    @Autowired
    private ApiTierService apiTierService;

    @Autowired
    private ApiPolicyService apiPolicyService;

    @Autowired
    private ApiApplicationService apiApplicationService;

    @Autowired
    private Wso2GetTokenService wso2ApiExtractorService;

    @Autowired
    private Wso2GetApisService wso2GetApisService;

    @PostMapping("/apis/adds")
    public void addApi(@RequestBody ApiResponse apiResponse) {
        List<Api> apis = apiResponse.getList();
        apiService.saveAll(apis);
    }

    @PostMapping("/apiDetail/add")
    public void addApiDetail(@RequestBody ApiDetailResponse apiDetailResponse) {
        CorsConfiguration corsConfiguration = apiDetailResponse.getCorsConfiguration();
        List<String> headers = corsConfiguration.getAccessControlAllowHeaders();

        for (String header : headers) {
            System.out.println(header);
        }

        apiDetailService.saveApiDetail(apiDetailResponse);
    }

    @PostMapping("/apiSwagger/add")
    public void addSwagger(@RequestBody ApiSwaggerResponse apiSwaggerResponse) {
        apiSwaggerService.saveApiSwagger(apiSwaggerResponse);
    }

    @PostMapping("/apiTiers/add")
    public void addTiers(@RequestBody ApiTierResponse apiTierResponse) {
        List<ApiTier> apiTiers = apiTierResponse.getList();
        apiTierService.saveAll(apiTiers);
    }

    @PostMapping("/apiPolicies/adds")
    public void addTiers(@RequestBody ApiPolicyResponse apiPolicyResponse) {
        List<Policy> policies = apiPolicyResponse.getList();
        apiPolicyService.saveAll(policies);
    }

    @PostMapping("/apiApplication/adds")
    public void addApplications(@RequestBody ApiApplicationResponse apiApplicationResponse) {
        List<Application> applications = apiApplicationResponse.getList();
        apiApplicationService.saveAll(applications);
    }

    //GetMapping
    @GetMapping("/performTask")
    public void performTask() throws Exception {
        System.err.println("token:"+wso2ApiExtractorService.getAccessToken());
        String accessToken = wso2ApiExtractorService.getAccessToken().getAccess_token();
        ApiResponse apiResponse = wso2GetApisService.getWso2Apis(accessToken);
        List<Api> apis = apiResponse.getList();

        for (Api api : apis) {
            System.out.println(api.getName());
        }
    }

    //GetMapping
    // @GetMapping("/performTask")
    // public String performTask() throws Exception {
    //     System.err.println("token:"+wso2ApiExtractorService.getAccessToken());
    //     return wso2ApiExtractorService.getAccessToken();
    // }
}
