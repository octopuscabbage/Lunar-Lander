package com.octopuscabbage.lunarlander.common;

import com.octopuscabbage.lunarlander.common.messages.PicturePayload;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by octopuscabbage on 1/10/16.
 */
public class PictureEncoder {
    public static List<PicturePayload> encodeByteArrayOutputStream(int startingMessageCount,ByteArrayOutputStream jpegStream) throws IOException{
        jpegStream.close();
        byte[] array = jpegStream.toByteArray();
        List<PicturePayload> messages = new ArrayList<>();
        int currentMessageCount = startingMessageCount;
        int i;
        for(i = 0; i < array.length; i+= PicturePayload.OCTETS_PER_MESSAGE){
            PicturePayload currentPayload = new PicturePayload();
            currentPayload.setCommand(Command.PICTURE_PAYLOAD);
            currentPayload.setMessageNumber(currentMessageCount);
            currentMessageCount++;
            System.arraycopy(array,i * PicturePayload.OCTETS_PER_MESSAGE,currentPayload.payload,0,PicturePayload.OCTETS_PER_MESSAGE);
            currentPayload.computeChecksum();
            messages.add(currentPayload);
        }
        return messages;
    }
}
