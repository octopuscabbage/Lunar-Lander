package com.octopuscabbage.lunarlander.app.messages;

import android.util.Base64;
import com.octopuscabbage.lunarlander.app.Command;

import java.nio.ByteBuffer;

/**
 * Created by octopuscabbage on 1/9/16.
 */
public abstract class Message {
    protected Long messageNumber;
    protected char checkSum;
    protected Command command;

    public Message(){

    }

    /*
    Parse the common parts of the message. Returns number of charecters consumed
     */
    public int genericParse(String rawMessage){
        messageNumber = decodeToBuffer(rawMessage.substring(0,4)).getLong();
        checkSum = decodeToBuffer(rawMessage.charAt(4)+"").getChar();
        command = Command.mnemonicToCommand(decodeToBuffer(rawMessage.charAt(5)+"").getChar());
        return 5;
    }

    /*
    Parse the specific part of that message
    Return the number of charecters consumed;
     */
    public abstract int parseMessage(String message);

    public static ByteBuffer decodeToBuffer(String message){
        return ByteBuffer.wrap(Base64.decode(message,Base64.DEFAULT));
    }
}
