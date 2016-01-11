package com.octopuscabbage.lunarlander.common.messages;

/**
 * Created by octopuscabbage on 1/9/16.
 */
public interface SerializableMessage {
    /*
    Parses out the part of the message it cares about
    Returns the rest of the message;
     */
    String parse(String rawString);

    /*
    Encodes itself  to base 64;
     */
    String encodeToBase64();
}
