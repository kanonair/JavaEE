package io.kanonair.service;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl {

    public String test01(String s) {
        System.out.println(s);
        return s;
    }

}
