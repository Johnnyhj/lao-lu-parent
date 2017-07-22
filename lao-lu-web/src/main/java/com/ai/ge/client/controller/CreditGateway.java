package com.ai.ge.client.controller;

import com.ai.ge.bus.core.AbilityRegister;
import com.ai.ge.bus.core.IAbility;
import com.ai.ge.bus.core.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Sam on 17/6/6.
 */
@Service
@AbilityRegister(name = "credit")
public class CreditGateway implements IAbility {

    private Logger logger = LoggerFactory.getLogger(CreditGateway.class);

    @Override
    public Message execute(Message message) {

//        message.setView();
        return message;
    }
}
