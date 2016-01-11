package com.octopuscabbage.lunarlander.app.messages;

/**
 * Created by octopuscabbage on 1/9/16.
 */
public interface ExtendedMessage {
    int parseRestOfMessage(String rawString, int consumedChars);
}
