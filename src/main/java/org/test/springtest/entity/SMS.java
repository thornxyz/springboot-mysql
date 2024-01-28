package org.test.springtest.entity;

import lombok.Data;

@Data
public class SMS {
    private String destinationSMSNumber;
    private String smsMessage;
}
