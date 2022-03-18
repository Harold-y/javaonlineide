package org.chengbing.controller;

import org.chengbing.service.WisdomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/wisdom")
public class WisdomController {

    @Resource
    WisdomService service;

    @GetMapping("/rand")
    public Map<String, String> randWisdom()
    {
        return service.randomWisdom();
    }
}
