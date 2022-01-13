package com.gonana.demo.controller.api;

import javax.annotation.Resource;

import com.gonana.demo.model.entity.main.Main;
import com.gonana.demo.service.main.MainService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    
    @Resource
    private MainService mainService;

    @GetMapping("/sysdate")
    public ResponseEntity<Main> getSysdate(){

        return ResponseEntity.ok(mainService.getSysdateOnApi());
    }
}
