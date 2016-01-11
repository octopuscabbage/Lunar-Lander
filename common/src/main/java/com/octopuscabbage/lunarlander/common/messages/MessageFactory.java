package com.octopuscabbage.lunarlander.common.messages;

/**
 * Created by octopuscabbage on 1/9/16.
 */
public class MessageFactory {
        public static GenericMessage parseMessage(String rawString){
                GenericMessage message = new GenericMessage(rawString);
                switch(message.command){
                        case PICTURE_PAYLOAD: return new PicturePayload(rawString);
                        case MOVE_FORWARD: return new MoveMessage(rawString);
                        case TURN_LEFT: return new MoveMessage(rawString);
                        case TURN_RIGHT: return  new MoveMessage(rawString);
                        case BEGIN_PICTURE: return new BeginPicture(rawString);
                        default: return message;
                }
        }
}
