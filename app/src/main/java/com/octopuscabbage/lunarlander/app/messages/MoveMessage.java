package com.octopuscabbage.lunarlander.app.messages;

/**
 * Created by octopuscabbage on 1/9/16.
 * Covers all movement actions (and take picture)
 */
public class MoveMessage extends Message {
    long duration;

    public MoveMessage(String rawMessage) {
        parseMessage(rawMessage);
    }

    @Override
    public int parseMessage(String message) {
        int consumedCharecters = genericParse(message);
        Message.decodeToBuffer(message.substring(consumedCharecters+1));
    }
}
