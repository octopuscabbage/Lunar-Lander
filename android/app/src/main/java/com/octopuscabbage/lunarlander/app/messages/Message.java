package com.octopuscabbage.lunarlander.app.messages;

import android.util.Base64;

import com.octopuscabbage.lunarlander.app.Command;
import java.nio.ByteBuffer;

/**
 * Created by octopuscabbage on 1/9/16.
 */
public class Message {
    public static final long MAX_MESSAGE_NUMBER = (long) Math.pow(2,6*3);
    protected long messageNumber;
    protected char checkSum;
    protected Command command;

    public long getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(long messageNumber) {
        this.messageNumber = messageNumber % MAX_MESSAGE_NUMBER;
    }

    public char getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(char checkSum) {
        this.checkSum = checkSum;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Message(){

    }
    public Message(String rawString){
        genericParse(rawString);
    }

    public String encodeToBase64(){
        String outputString = "";
        ByteBuffer longBuffer = ByteBuffer.allocate(Long.SIZE); //this might be bit length
        longBuffer.putLong(messageNumber);
        outputString = Base64.encodeToString(longBuffer.array(),Base64.DEFAULT);
        outputString += computeChecksum();
        outputString += Command.commandTomnemonic(command);
        return outputString;
    }

    public char computeChecksum(){
        return 'A';
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

    public static ByteBuffer decodeToBuffer(String message){
        return ByteBuffer.wrap(Base64.decode(message,Base64.DEFAULT));
    }
}
