package com.octopuscabbage.lunarlander.app.messages;

/**
 * Created by octopuscabbage on 1/9/16.
 * Covers all movement actions
 */
public class MoveMessage extends Message implements ExtendedMessage{
    long duration;

    public MoveMessage(String rawMessage) {
        parseRestOfMessage(rawMessage,genericParse(rawMessage));
    }

    @Override
    public int parseRestOfMessage(String rawString, int consumedChars) {
        duration = Message.decodeToBuffer(rawString.substring(consumedChars+1)).getLong();
        return consumedChars + 4;
    }

}
