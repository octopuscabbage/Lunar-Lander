package com.octopuscabbage.lunarlander.common;

import com.octopuscabbage.lunarlander.common.messages.BeginPicture;
import com.octopuscabbage.lunarlander.common.messages.GenericMessage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by octopuscabbage on 1/10/16.
 */
public class MessageTest{
       @Test
       public void testMessageSerialization(){
              GenericMessage message = new GenericMessage();
              message.setCheckSum('A');
              message.setCommand(Command.MOVE_FORWARD);
              message.setMessageNumber(1);

              GenericMessage outMessage = new GenericMessage(message.encodeToBase64());
              Assert.assertEquals(message.getMessageNumber(),outMessage.getMessageNumber());
              Assert.assertEquals(message.getCommand(),message.getCommand());
       }
       @Test
       public void testBeginPictureSerialization(){
              BeginPicture message = new BeginPicture();
              message.setMessageNumber(1);
              message.setCheckSum('A');
              message.setCommand(Command.BEGIN_PICTURE);
              message.setLength(50);
              message.setTopic('A');

              BeginPicture outMessage = new BeginPicture(message.encodeToBase64());

              Assert.assertEquals(message.getMessageNumber(),outMessage.getMessageNumber());
              Assert.assertEquals(outMessage.getCommand(),Command.BEGIN_PICTURE);
              Assert.assertEquals(message.getCommand(),outMessage.getCommand());
              Assert.assertEquals(message.getCheckSum(),outMessage.getCheckSum());
              Assert.assertEquals(message.getTopic(),outMessage.getTopic());
              Assert.assertEquals(message.getLength(),outMessage.getLength());
       }


}
