package com.octopuscabbage.lunarlander.common;

import com.octopuscabbage.lunarlander.common.messages.BeginPicture;
import com.octopuscabbage.lunarlander.common.messages.PicturePayload;
import org.junit.Assert;
import org.junit.Test;
import java.util.Base64;
import java.util.concurrent.Exchanger;

/**
 * Created by octopuscabbage on 1/10/16.
 */
public class PictureQueueTest {
    @Test
    public void testSerialization() throws Exception{
        BeginPicture beginPicture = new BeginPicture();
        beginPicture.setTopic('A');
        beginPicture.setLength(3);
        PictureQueue queue = new PictureQueue(beginPicture);
        for(int i = 0; i < 3; i++){
            PicturePayload payload1 = new PicturePayload();
            payload1.setTopic('A');
            payload1.payload = Base64.getDecoder().decode("AAAB"); //1
            payload1.setMessageNumber(i);
            queue.insertMessage(payload1);
        }
        Assert.assertTrue(queue.isComplete());
        byte[] bytes = queue.getBytes();
        byte[] expectedBytes = {0,0,1,0,0,1,0,0,1};
        Assert.assertArrayEquals(expectedBytes,bytes);
    }
}
