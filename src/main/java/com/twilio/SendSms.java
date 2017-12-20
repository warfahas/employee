package com.twilio;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
/**
 * Created by mkabd on 12/18/2017.
 */
public class SendSms {
    public static final String ACCOUNT_SID = "ACbe6edbf83b486bfd06fefff5a74d569f";
    public static final String AUTH_TOKEN = "your_auth_token";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber("+15558675309"),
                new PhoneNumber("+15017250604"), "This is the ship that made the Kessel Run in fourteen parsecs?").create();

        System.out.println(message.getSid());
    }

}
