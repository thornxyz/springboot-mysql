package org.test.springtest.service;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TwilioTest{
    @Value("${TWILIO_ACCOUNT_SID}")
    String ACCOUNT_SID;

    @Value("${TWILIO_AUTH_TOKEN}")
    String AUTH_TOKEN;

    @Value("${twiliophoneNumber}")
    String OUTGOING_SMS_NUMBER ;


    @PostConstruct
    private void setup(){
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);


    }
    public String sendSMS(String smsNumber, String smsMessage){
        Message  message= Message.creator(
                new PhoneNumber(smsNumber),
                new PhoneNumber(OUTGOING_SMS_NUMBER),
                smsMessage).create();

        return message.getStatus().toString();
    }
}


