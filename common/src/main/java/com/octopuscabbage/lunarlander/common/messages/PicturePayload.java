package com.octopuscabbage.lunarlander.common.messages;

import java.util.Base64;

/**
 * Created by octopuscabbage on 1/9/16.
 */
public class PicturePayload extends GenericMessage implements SerializableMessage {
    public static final int OCTETS_PER_MESSAGE = 100;
    private char topic;
    public byte[] payload;

    public char getTopic() {
        return topic;
    }

    public void setTopic(char topic) {
        this.topic = topic;
    }

    public PicturePayload(String rawString){
        parse(super.parse(rawString));
    }
    public PicturePayload(){}

    @Override
    public String parse(String rawString) {
        topic = rawString.charAt(0);
        payload = decodeToBuffer(rawString.substring(1)).array();
        return "";
    }

    @Override
    public String encodeToBase64() {
        return super.encodeToBase64() + Base64.getEncoder().encodeToString(payload);
    }
}
