package com.example.homework4_1.service;

import org.springframework.stereotype.Service;

import java.util.stream.LongStream;


@Service
public class Infoservice {

    public long returnNumber() {
        long tyme = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(1, 1_000_000)
                .parallel()
                .reduce(0, Long::sum);
        return System.currentTimeMillis() - tyme;

    }


}
