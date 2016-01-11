package com.octopuscabbage.lunarlander.common;

import com.octopuscabbage.lunarlander.common.messages.GenericMessage;

import java.util.LinkedList;
import java.util.stream.Stream;

/**
 * Created by octopuscabbage on 1/10/16.
 */
public class MessageQueue {
    private LinkedList<GenericMessage> messageHolder;
    public MessageQueue(){
        messageHolder = new LinkedList<>();
    }
    public void insertMessage(GenericMessage message){
        int messageNum = message.getMessageNumber();
        if(messageHolder.size() == 0){
            messageHolder.add(message);
        }
        else if(messageNum < messageHolder.getFirst().getMessageNumber()){
            messageHolder.addFirst(message);
        }
        else if (messageNum > messageHolder.getLast().getMessageNumber()) {
            messageHolder.addLast(message);
        }else{
            int i = 0;
            for (GenericMessage curMessage: messageHolder) {
                if(messageNum > curMessage.getMessageNumber()){
                    messageHolder.add(i+1,message);
                }
                i++;
            }

        }
    }
    public int length(){return messageHolder.size();}
    public GenericMessage getNextMessage(){
        return messageHolder.removeFirst();
    }
    public Stream<GenericMessage> stream(){return messageHolder.stream();}

}
