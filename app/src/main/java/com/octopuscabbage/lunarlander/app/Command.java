package com.octopuscabbage.lunarlander.app;

import android.renderscript.Sampler;
import android.view.WindowManager;

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

    public static Command mnemonicToCommand(char mnemonic){
        switch(mnemonic){
            case 'B': return BEGIN_PICTURE;
            case 'E': return END_PICTURE;
            case 'P': return PICTURE_PAYLOAD;
            case 'N': return NMEA;
            case 'F': return MOVE_FORWARD;
            case 'L': return TURN_LEFT;
            case 'R': return TURN_RIGHT;
            case 'T': return TAKE_PICTURE;
        }
        throw new IllegalArgumentException();
    }
}
