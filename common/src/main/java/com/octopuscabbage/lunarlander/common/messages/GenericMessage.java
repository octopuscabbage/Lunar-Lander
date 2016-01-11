package com.octopuscabbage.lunarlander.common.messages;


import com.octopuscabbage.lunarlander.common.Command;

import java.nio.ByteBuffer;
import java.util.Base64;

/**
 * Created by octopuscabbage on 1/9/16.
 */
public class GenericMessage implements SerializableMessage {
    public static final char MAX_MESSAGE_NUMBER = (char) Math.pow(2,6*3);
    protected int messageNumber;

    @Override
    public String parse(String rawString) {
        messageNumber = parseTripletToInt(rawString.substring(0,3));
        checkSum = rawString.charAt(3);
        command = Command.mnemonicToCommand(rawString.charAt(4));
        return rawString.substring(5);
    }

    protected char checkSum;
    protected Command command;

    public int getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(int messageNumber) {
        //this.messageNumber = (char) messageNumber % MAX_MESSAGE_NUMBER;
        this.messageNumber = messageNumber;
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

    public GenericMessage(){

    }
    public GenericMessage(String rawString){
        parse(rawString);
    }

    public String encodeToBase64(){
        String outputString = "";
        outputString = encodeIntToTriplet(messageNumber);
        outputString += computeChecksum();
        outputString += Command.commandTomnemonic(command);
        return outputString;
    }

    public char computeChecksum(){
        return 'A';
    }


    public static ByteBuffer decodeToBuffer(String message){
        return ByteBuffer.wrap(Base64.getDecoder().decode(message));

    }
    public static int parseTripletToInt(String triplet){
        // TODO: 1/10/16 This is a little shakey and unportable
        if(triplet.length() != 3){
            throw new IllegalArgumentException("Triplet not proper length");
        }
        String inputInt = "AAA" + triplet + "==";
        return decodeToBuffer(inputInt).getInt();
    }
    public static String encodeIntToTriplet(int input){
        String outputString = "";
        ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
        intBuffer.putInt(input);
        outputString = Base64.getEncoder().encodeToString(intBuffer.array());
        if(!outputString.substring(0,2).equals("AA") || !outputString.substring(outputString.length()-2).equals("==")){
            throw new IllegalArgumentException("Integer is too big");
        }
        // TODO: 1/10/16 This is also a little shakey and unportable
        outputString = outputString.substring(0,outputString.length()-2);
        outputString = outputString.substring(outputString.length()-3);
        return outputString;
    }
}
