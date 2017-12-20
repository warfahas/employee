package org.launchcode.employee.models;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by mkabd on 12/19/2017.
 */

public class SendingSms {
    @Autowired
    @Value("${account-sid}")
    public static String ACCOUNT_SID;
    @Value("${account-token}")
    public static String AUTH_TOKEN;


    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber("account-num"),
                new PhoneNumber("receiver"),
                "This is the ship that made the Kessel Run in fourteen parsecs?").create();

        System.out.println(message.getSid());
    }
}


