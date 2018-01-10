package org.launchcode.employee.models;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by mkabd on 12/19/2017.
 */
@Service
public class SmsService {


    @Value("${account-num}")
    public String account;
    @Value("${account-num}")
    public String number;


    public SmsService( @Value("${account-sid}") String ACCOUNT_SID, @Value("${account-token}") String AUTH_TOKEN) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public void sendSms(String message, String number) {
        Message msg = Message.creator(new PhoneNumber(number),
                new PhoneNumber(account),
                message).create();

        System.out.println(msg.getSid());
    }

}
