package com.octopuscabbage.lunarlander.app.messages;

/**
 * Created by octopuscabbage on 1/9/16.
 */
public class MessageFactory {
        public static Message parseMessage(String rawString){
                Message message = new Message(rawString);
                switch(message.command){
                        case PICTURE_PAYLOAD: return new PicturePayload(rawString);
                        case MOVE_FORWARD: return new MoveMessage(rawString);
                        case TURN_LEFT: return new MoveMessage(rawString);
                        case TURN_RIGHT: return  new MoveMessage(rawString);
                        default: return message;
                }
        }
}
