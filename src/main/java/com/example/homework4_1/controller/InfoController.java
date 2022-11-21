package com.example.homework4_1.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/info")
public class InfoController {
    @Value(value = "${server.port}")
    private int port;

    @GetMapping("/Port")
    public int getPort() {
        return port;
    }


}
