package com.octopuscabbage.lunarlander.common;

/**
 * Created by octopuscabbage on 1/9/16.
 */
public enum Command {
    BEGIN_PICTURE,
    END_PICTURE,
    PICTURE_PAYLOAD,
    NMEA,
    MOVE_FORWARD,
    TURN_LEFT,
    TURN_RIGHT,
    TAKE_PICTURE;


    final static char BEGIN_PICTURE_CHAR = 'B';
    final static char END_PICTURE_CHAR = 'E';
    final static char PICTURE_PAYLOAD_CHAR = 'P';
    final static char NMEA_CHAR = 'N';
    final static char MOVE_FORWARD_CHAR = 'F';
    final static char TURN_LEFT_CHAR = 'L';
    final static char TURN_RIGHT_CHAR = 'R';
    final static char TAKE_PICTURE_CHAR = 'T';

    public static Command mnemonicToCommand(char mnemonic){
        switch(mnemonic){
            case BEGIN_PICTURE_CHAR: return BEGIN_PICTURE;
            case END_PICTURE_CHAR: return END_PICTURE;
            case PICTURE_PAYLOAD_CHAR: return PICTURE_PAYLOAD;
            case NMEA_CHAR: return NMEA;
            case MOVE_FORWARD_CHAR: return MOVE_FORWARD;
            case TURN_LEFT_CHAR: return TURN_LEFT;
            case TURN_RIGHT_CHAR: return TURN_RIGHT;
            case TAKE_PICTURE_CHAR: return TAKE_PICTURE;
        }
        throw new IllegalArgumentException();
    }
    public static char commandTomnemonic(Command command){
        switch(command){
            case BEGIN_PICTURE: return BEGIN_PICTURE_CHAR;
            case END_PICTURE: return END_PICTURE_CHAR;
            case PICTURE_PAYLOAD: return PICTURE_PAYLOAD_CHAR;
            case NMEA: return NMEA_CHAR;
            case MOVE_FORWARD: return MOVE_FORWARD_CHAR;
            case TURN_LEFT: return TURN_LEFT_CHAR;
            case TURN_RIGHT: return TURN_RIGHT_CHAR;
            case TAKE_PICTURE: return TAKE_PICTURE_CHAR;
        }
        throw new IllegalArgumentException();
    }
}
