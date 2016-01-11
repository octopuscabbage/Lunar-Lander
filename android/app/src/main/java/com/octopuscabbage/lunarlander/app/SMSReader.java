package com.octopuscabbage.lunarlander.app;

import android.app.Service;
import android.content.ContentResolver;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.content.Context;
import android.os.IBinder;
import android.provider.Telephony;
import com.octopuscabbage.lunarlander.common.MessageQueue;
import com.octopuscabbage.lunarlander.common.PictureQueue;
import com.octopuscabbage.lunarlander.common.messages.MessageFactory;

/**
 * Created by octopuscabbage on 1/10/16.
 */
public class SMSReader {
    private MessageQueue queue;
    private Cursor inboxCursor;
    private int threadDelay;
    public SMSReader(Cursor inboxCursor){
        queue = new MessageQueue();
        this.inboxCursor = inboxCursor;
        threadDelay = 100;

    }

    public MessageQueue getQueue() {
        return queue;
    }

    public void setQueue(MessageQueue queue) {
        this.queue = queue;
    }

    public int getThreadDelay() {
        return threadDelay;
    }

    public void setThreadDelay(int threadDelay) {
        this.threadDelay = threadDelay;
    }

    public void startDaemon(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    readAllSMS();
                    try {
                        Thread.sleep(threadDelay);
                    } catch (InterruptedException e){

                    }
                }
            }
        });
    }

    public void readAllSMS(){
        if(inboxCursor.moveToFirst()) {
            for(int i=0; i < inboxCursor.getCount(); i++) {
                queue.insertMessage(MessageFactory.parseMessage(inboxCursor.getString(inboxCursor.getColumnIndexOrThrow("body"))));
                inboxCursor.moveToNext();
            }
        }
    }
}
