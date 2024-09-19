package com.dev.myselflog.root.model;

import com.dev.myselflog.root.dto.UserTO;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
public class UserContext {
    private static final Logger logger = LoggerFactory.getLogger(UserContext.class.getName());

    private static final ThreadLocal<UserTO> currentTenant = new ThreadLocal<>();
    public static void setCurrentTenant(UserTO userTO) {
        logger.debug("Current User Session Setup ==============> " + userTO);
        currentTenant.set(userTO);
    }

    public static UserTO getCurrentTenant() {
        return currentTenant.get();
    }
}