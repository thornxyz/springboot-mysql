package org.jobapplication.springbootapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.jobapplication.springbootapi.entity.SMS;
import org.jobapplication.springbootapi.service.TwilioTest;

@RestController
@Slf4j
public class TwilioController {

    @Autowired
    TwilioTest smsService;

    @PostMapping("/processSMS")
    @CrossOrigin(origins = "http://localhost:5173")
    public String processSMS(@RequestBody SMS sendRequest) {
        log.info("processSMS started sendRequest: "+sendRequest.toString()

        );
        return smsService.sendSMS(sendRequest.getDestinationSMSNumber(),
                sendRequest.getSmsMessage());
    }
}
