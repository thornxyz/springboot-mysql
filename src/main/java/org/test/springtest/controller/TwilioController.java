package org.test.springtest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.test.springtest.entity.SMS;
import org.test.springtest.service.TwilioTest;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class TwilioController {

    @Autowired
    TwilioTest smsService;

    @PostMapping("/processSMS")
    public String processSMS(@RequestBody SMS sendRequest) {
        log.info("processSMS started sendRequest: "+sendRequest.toString()

        );
        return smsService.sendSMS(sendRequest.getDestinationSMSNumber(),
                sendRequest.getSmsMessage());
    }
}
