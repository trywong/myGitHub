package com.wc.domain;

import com.wc.service.MessageService;

public class Student implements Person {

    MessageService hahaService;

    @Override
    public void sendMessage() {
        hahaService.printMessage();
    }

    public void setHahaService(MessageService hahaService) {
        this.hahaService = hahaService;
    }

}
