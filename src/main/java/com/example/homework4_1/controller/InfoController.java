package com.example.homework4_1.controller;


import com.example.homework4_1.service.Infoservice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/info")
public class InfoController {
    private final Infoservice infoservice;

    public InfoController(Infoservice infoservice) {
        this.infoservice = infoservice;
    }

    @Value(value = "${server.port}")
    private int port;

    @GetMapping("/Port")
    public int getPort() {
        return port;
    }

    @GetMapping("/returnNumber")
    public long returnNumber() {
        return infoservice.returnNumber();
    }


}
