package com.builder.migration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.builder.migration.dto.KongConsumerResponse;
import com.builder.migration.dto.KongPluginResponse;
import com.builder.migration.dto.KongRouteResponse;
import com.builder.migration.dto.KongServiceResponse;
import com.builder.migration.service.KongConsumerService;
import com.builder.migration.service.KongPluginService;
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

    @Autowired
    private KongConsumerService kongConsumerService;

    @Autowired
    private KongPluginService kongPluginService;

    @PostMapping("/workspace/add")
    public void addApplications(String name) throws Exception {
        kongWorkSpaceService.putKongWorkSpace("worksapce_3");
    }

    @PostMapping("service/add")
    public void addService(@RequestBody KongServiceResponse kongServiceResponse) throws Exception {
        ResponseEntity<String> response = kongServiceService.createService(kongServiceResponse);
        System.out.println("response:" + response.getStatusCode());
    }

    @DeleteMapping("service/del/{name}")
    public void delService(@PathVariable String name) throws Exception {
        ResponseEntity<String> response = kongServiceService.deleteService(name);
        System.out.println("response:" + response.getStatusCode());
    }

    @PostMapping("route/add")
    public void addService(@RequestBody KongRouteResponse KongRouteResponse) throws Exception {
        ResponseEntity<String> response = kongRouteService.createRoute(KongRouteResponse);
        System.out.println("response:" + response.getStatusCode());
    }

    @PostMapping("consumer/add")
    public void addConsumer(@RequestBody KongConsumerResponse KongConsumerResponse) throws Exception {
        ResponseEntity<String> response = kongConsumerService.createConsumer(KongConsumerResponse);
        System.out.println("response:" + response.getStatusCode());
    }

    @PostMapping("/service/plugin/add/{id}")
    public void addPlugin(@PathVariable String id, @RequestBody KongPluginResponse KongPluginResponse) throws Exception {
        ResponseEntity<String> response = kongPluginService.createPluginInService(id, KongPluginResponse);
        System.out.println("response:" + response.getStatusCode());
    }

    @PostMapping("plugin/add")
    public void addPlugin(@RequestBody KongPluginResponse KongPluginResponse) throws Exception {
        ResponseEntity<String> response = kongPluginService.createPlugin(KongPluginResponse);
        System.out.println("response:" + response.getStatusCode());
    }

    @DeleteMapping("plugin/del/{id}")
    public void delPlugin(@PathVariable String id) throws Exception {
        ResponseEntity<String> response = kongPluginService.deletePlugin(id);
        System.out.println("response:" + response.getStatusCode());
    }

    @PatchMapping("plugin/update/{id}")
    public void delPlugin(@PathVariable String id, @RequestBody KongPluginResponse kongPluginResponse) throws Exception {
        ResponseEntity<String> response = kongPluginService.updatePlugin(id, kongPluginResponse);
        System.out.println("response:" + response.getStatusCode());
    }
}

