package com.builder.migration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.builder.migration.dto.KongRouteResponse;
import com.builder.migration.dto.KongServiceResponse;
import com.builder.migration.service.KongRouteService;
import com.builder.migration.service.KongServiceService;
import com.builder.migration.service.KongWorkSpaceService;

@RestController
@RequestMapping("/kongApi")
public class KongApiController {
    @Autowired
    private KongWorkSpaceService kongWorkSpaceService;

    @Autowired
    private KongServiceService kongServiceService;

    @Autowired
    private KongRouteService kongRouteService;

    @PostMapping("/workspace/add")
    public void addApplications(String name) throws Exception {
        kongWorkSpaceService.putKongWorkSpace("worksapce_3");
    }

    @PostMapping("service/add")
    public void addService(@RequestBody KongServiceResponse kongServiceResponse) throws Exception {
        ResponseEntity<String> response = kongServiceService.createKongService(kongServiceResponse);
        System.out.println("response:" + response.getStatusCode());
    }

    @DeleteMapping("service/del/{name}")
    public void delService(@PathVariable String name) throws Exception {
        ResponseEntity<String> response = kongServiceService.deleteKongService(name);
        System.out.println("response:" + response.getStatusCode());
    }

    @PostMapping("route/add")
    public void addService(@RequestBody KongRouteResponse KongRouteResponse) throws Exception {
        ResponseEntity<String> response = kongRouteService.createKongRoute(KongRouteResponse);
        System.out.println("response:" + response.getStatusCode());
    }
}

