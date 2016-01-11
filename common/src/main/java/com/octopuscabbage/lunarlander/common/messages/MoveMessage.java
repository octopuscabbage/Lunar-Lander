package com.octopuscabbage.lunarlander.common.messages;

/**
 * Created by octopuscabbage on 1/9/16.
 * Covers all movement actions
 */
public class MoveMessage extends GenericMessage implements SerializableMessage {
    int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public MoveMessage(String rawMessage) {
        parse(super.parse(rawMessage));
    }

    @Override
    public String parse(String rawString) {
        duration = GenericMessage.parseTripletToInt(rawString.substring(0,3));
        return rawString.substring(3);
    }

    @Override
    public String encodeToBase64() {
        return super.encodeToBase64() + GenericMessage.encodeIntToTriplet(duration);
    }
}
