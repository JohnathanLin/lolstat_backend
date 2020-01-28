package com.windypath.lolstat.modules.front.controller;

import com.windypath.lolstat.commons.ResponseData;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class MainController {

    @RequestMapping("/hello")
    public ResponseData hello() {

        return ResponseData.success("hello!");
    }
    @RequestMapping("/")
    public ResponseData root() {

        return ResponseData.success("root!");
    }
}
