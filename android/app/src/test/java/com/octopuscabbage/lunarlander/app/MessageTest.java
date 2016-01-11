package com.octopuscabbage.lunarlander.app;

import android.test.AndroidTestCase;

import org.junit.Test;
import org.junit.Assert;

/**
 * Created by octopuscabbage on 1/10/16.
 */
public class MessageTest extends AndroidTestCase{
    @Test
    public void testMessageSerialization(){
    com.octopuscabbage.lunarlander.app.messages.Message message = new com.octopuscabbage.lunarlander.app.messages.Message();
        message.setMessageNumber(1L);
        message.setCommand(com.octopuscabbage.lunarlander.app.Command.MOVE_FORWARD);
        message.setCheckSum('A');
        com.octopuscabbage.lunarlander.app.messages.Message outMessage = new com.octopuscabbage.lunarlander.app.messages.Message(message.encodeToBase64());
        Assert.assertEquals(message.getMessageNumber(),1L);
    }
}
