package org.jobapplication.springbootapi.entity;

import lombok.Data;

@Data
public class SMS {
    private String destinationSMSNumber;
    private String smsMessage;
}
