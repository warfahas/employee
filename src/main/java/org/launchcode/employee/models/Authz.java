package org.launchcode.employee.models;

import org.springframework.stereotype.Component;

/**
 * Created by mkabd on 1/23/2018.
 */
@Component
public class Authz {

    public boolean check(Long userId, User user) {
        return userId.equals(user.getId());
    }


}
