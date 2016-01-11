package com.octopuscabbage.lunarlander.common.messages;

/**
 * Created by octopuscabbage on 1/10/16.
 */
public class BeginPicture extends GenericMessage implements SerializableMessage {
    char topic;
    int length;

    public char getTopic() {
        return topic;
    }

    public void setTopic(char topic) {
        this.topic = topic;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public BeginPicture(){

    }
    public BeginPicture(String rawMessage){
        parse(super.parse(rawMessage));
    }

    @Override
    public String parse(String rawString) {
        topic = rawString.charAt(0);
        length = parseTripletToInt(rawString.substring(1,4));
        return rawString.substring(4);
    }

    @Override
    public String encodeToBase64() {
        return super.encodeToBase64() + topic + encodeIntToTriplet(length);
    }
}
