package com.octopuscabbage.lunarlander.common;

import com.octopuscabbage.lunarlander.common.messages.BeginPicture;
import com.octopuscabbage.lunarlander.common.messages.PicturePayload;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by octopuscabbage on 1/10/16.
 */
public class PictureQueue {
    private MessageQueue queue;
    private char topic;
    private int duration;

    public PictureQueue(BeginPicture beginPictureMessage){
        topic = beginPictureMessage.getTopic();
        duration = beginPictureMessage.getLength();
        queue = new MessageQueue();
    }
    public void insertMessage(PicturePayload picturePayload){
        queue.insertMessage(picturePayload);
    }
    public boolean isComplete(){
        return duration == queue.length();
    }
    public byte[] getBytes() throws Exception{
        if(!isComplete()){
            throw new Exception("Picture has not finished transferring!");
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        queue.stream().forEachOrdered(genericMessage -> {
            try {
                outputStream.write(((PicturePayload) genericMessage).payload);
            } catch (IOException e){
                throw new RuntimeException(e);
            }
        });
        return outputStream.toByteArray();
    }
}
