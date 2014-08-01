package fr.robydev.robygo.test;

/**
 * Created by brodier on 7/30/14.
 */
import static org.junit.Assert.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.Scanner;

import fr.robydev.robygo.Board;
import fr.robydev.robygo.StonesGroup;
import org.junit.Test;

import fr.robydev.robygo.Engine;


public class EngineTest {

    @Test
    public void testComputeCoordinate() throws Exception {
        assertEquals("A1", Engine.computeCoordinate(0, 19));
        assertEquals("T1",Engine.computeCoordinate(18, 19));
        assertEquals("T19",Engine.computeCoordinate(360, 19));
        assertEquals("A19",Engine.computeCoordinate(342, 19));
    }

    @Test
    public void testComputePos() throws Exception {
        assertEquals(0, Engine.computePos("A1", 19));
        assertEquals(18,Engine.computePos("T1",19));
        assertEquals(360,Engine.computePos("T19",19));
        assertEquals(342,Engine.computePos("A19",19));
    }

    @Test
    public void testRandMove() throws Exception {
        Random r = new Random();
        r.nextInt();
    }

    private static ByteBuffer stringBuff(String s){
        return ByteBuffer.wrap(s.getBytes());
    }

    private static void assertPosition(StonesGroup[] b, int pos, boolean isStone, boolean isBlack,int nbStones, int nbLibs){
        if(!isStone){
            assertNull(b[pos]);
        } else {
            assertNotNull(b[pos]);
            assertTrue(b[pos].isSameColor(isBlack));
            assertEquals(b[pos].countLiberties(), nbLibs);
            assertEquals(b[pos].countStones(), nbStones);
        }

    }

    @Test
    public void testReplay1() throws Exception {
        Pipe testEnginePipe = Pipe.open();
        Engine e = new Engine(new Scanner(testEnginePipe.source()));
        e.start();

        WritableByteChannel test = testEnginePipe.sink();
        // Play Black stone A1
        test.write(stringBuff("play b A1\n"));
        assertPosition(e.getPosition(), e.computePos("A1",19), true, true, 1, 2);
        // Atar black stone A1
        test.write(stringBuff("play w B1\n"));
        assertPosition(e.getPosition(), e.computePos("A1",19), true, true, 1, 1);
        assertPosition(e.getPosition(), e.computePos("B1",19), true, false, 1, 2);
        // Atari white stone B1
        test.write(stringBuff("play b B2\n"));
        assertPosition(e.getPosition(), e.computePos("A1",19), true, true, 1, 1);
        assertPosition(e.getPosition(), e.computePos("B1",19), true, false, 1, 1);
        assertPosition(e.getPosition(), e.computePos("B2",19), true, true, 1, 3);
        assertPosition(e.getPosition(), e.computePos("A2",19), false, false, 0, 0);
        // Capture black stone A1
        test.write(stringBuff("play w A2\n"));
        assertPosition(e.getPosition(), e.computePos("A1",19), false, false, 0, 0);
        assertPosition(e.getPosition(), e.computePos("B1",19), true, false, 1, 2);
        assertPosition(e.getPosition(), e.computePos("B2",19), true, true, 1, 2);
        assertPosition(e.getPosition(), e.computePos("A2",19), true, false, 1, 2);
        // Invalid move no change
        test.write(stringBuff("play b A1\n"));
        assertPosition(e.getPosition(), e.computePos("A1",19), false, false, 0, 0);
        assertPosition(e.getPosition(), e.computePos("B1",19), true, false, 1, 2);
        assertPosition(e.getPosition(), e.computePos("B2",19), true, true, 1, 2);
        assertPosition(e.getPosition(), e.computePos("A2",19), true, false, 1, 2);
        e.join();

    }



}
