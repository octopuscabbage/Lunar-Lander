package com.octopuscabbage.lunarlander.app.messages;

/**
 * Created by octopuscabbage on 1/9/16.
 */
public class PicturePayload extends Message implements ExtendedMessage {
    byte[] payload;

    public PicturePayload(String rawString){
        parseRestOfMessage(rawString,genericParse(rawString));
    }

    @Override
    public int parseRestOfMessage(String rawString, int consumedChars) {
        payload = Message.decodeToBuffer(rawString.substring(consumedChars + 1)).array();
        return 140;
    }
}
