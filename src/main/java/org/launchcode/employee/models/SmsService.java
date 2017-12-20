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

    @Value("${account-sid}")
    public static String ACCOUNT_SID;
    @Value("${account-token}")
    public static String AUTH_TOKEN;
    @Value("${account-num}")
    public static String account;
    @Value("${account-num}")
    public static String number;


    public SmsService() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public void sendSms(String message, String number) {
        Message msg = Message.creator(new PhoneNumber("account-num"),
                new PhoneNumber("receiver"),
                "This is the ship that made the Kessel Run in fourteen parsecs?").create();

        System.out.println(msg.getSid());
    }

}
