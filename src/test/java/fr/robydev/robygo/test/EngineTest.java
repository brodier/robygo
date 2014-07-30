package fr.robydev.robygo.test;

/**
 * Created by brodier on 7/30/14.
 */
import static org.junit.Assert.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

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

}
