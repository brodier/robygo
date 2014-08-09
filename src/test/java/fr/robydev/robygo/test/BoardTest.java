package fr.robydev.robygo.test;

/**
 * Created by brodier on 7/30/14.
 */
import static org.junit.Assert.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import fr.robydev.robygo.Board;
import org.junit.Test;

import fr.robydev.robygo.Engine;


public class BoardTest {

    @Test
    public void testPlay() throws Exception {
        Board b = new Board(19);
        b.play(true,Engine.computePos("A1",19));
        b.play(false,Engine.computePos("B1",19));
        b.play(true,Engine.computePos("B2",19));
        b.play(false,Engine.computePos("A2",19));
        b.play(true,Engine.computePos("A1",19));
        b.play(false,Engine.computePos("A1",19));
        assertTrue(true);
    }

    @Test
    public void testPlay2() throws Exception {
        Board b = new Board(19);
        b.play(true,Engine.computePos("B4",19));
        b.play(true,Engine.computePos("B5",19));
        b.play(true,Engine.computePos("C4",19));
        b.play(false,Engine.computePos("A4",19));
        b.play(false,Engine.computePos("A5",19));
        b.play(false,Engine.computePos("B6",19));
        b.play(false,Engine.computePos("B3",19));
        b.play(false,Engine.computePos("C3",19));
        b.play(false,Engine.computePos("C5",19));
        assertTrue(true);
    }

    @Test
    public void testRePlay() throws Exception {
        Board b = new Board(19);
        b.play("B".equals("B"),Engine.computePos("O11",19));
        b.play("W".equals("B"),Engine.computePos("A18",19));
        b.play("B".equals("B"),Engine.computePos("D10",19));
        b.play("W".equals("B"),Engine.computePos("S6",19));
        b.play("B".equals("B"),Engine.computePos("K3",19));
        b.play("W".equals("B"),Engine.computePos("N17",19));
        b.play("B".equals("B"),Engine.computePos("H8",19));
        b.play("W".equals("B"),Engine.computePos("H11",19));
        b.play("B".equals("B"),Engine.computePos("K9",19));
        b.play("W".equals("B"),Engine.computePos("H15",19));
        b.play("B".equals("B"),Engine.computePos("P13",19));
        b.play("W".equals("B"),Engine.computePos("G1",19));
        b.play("B".equals("B"),Engine.computePos("M4",19));
        b.play("W".equals("B"),Engine.computePos("M9",19));
        b.play("B".equals("B"),Engine.computePos("B11",19));
        b.play("W".equals("B"),Engine.computePos("H19",19));
        b.play("B".equals("B"),Engine.computePos("F17",19));
        b.play("W".equals("B"),Engine.computePos("K1",19));
        b.play("B".equals("B"),Engine.computePos("M1",19));
        b.play("W".equals("B"),Engine.computePos("H4",19));
        b.play("B".equals("B"),Engine.computePos("A1",19));
        b.play("W".equals("B"),Engine.computePos("D5",19));
        b.play("B".equals("B"),Engine.computePos("L10",19));
        b.play("W".equals("B"),Engine.computePos("R3",19));
        b.play("B".equals("B"),Engine.computePos("G14",19));
        b.play("W".equals("B"),Engine.computePos("D1",19));
        b.play("B".equals("B"),Engine.computePos("F11",19));
        b.play("W".equals("B"),Engine.computePos("A6",19));
        b.play("B".equals("B"),Engine.computePos("B14",19));
        b.play("W".equals("B"),Engine.computePos("P7",19));
        b.play("B".equals("B"),Engine.computePos("C5",19));
        b.play("W".equals("B"),Engine.computePos("D4",19));
        b.play("B".equals("B"),Engine.computePos("Q7",19));
        b.play("W".equals("B"),Engine.computePos("K7",19));
        b.play("B".equals("B"),Engine.computePos("L16",19));
        b.play("W".equals("B"),Engine.computePos("S13",19));
        b.play("B".equals("B"),Engine.computePos("S5",19));
        b.play("W".equals("B"),Engine.computePos("A12",19));
        b.play("B".equals("B"),Engine.computePos("C19",19));
        b.play("W".equals("B"),Engine.computePos("T12",19));
        b.play("B".equals("B"),Engine.computePos("C2",19));
        b.play("W".equals("B"),Engine.computePos("B16",19));
        b.play("B".equals("B"),Engine.computePos("F13",19));
        b.play("W".equals("B"),Engine.computePos("F8",19));
        b.play("B".equals("B"),Engine.computePos("A3",19));
        b.play("W".equals("B"),Engine.computePos("K17",19));
        b.play("B".equals("B"),Engine.computePos("P9",19));
        b.play("W".equals("B"),Engine.computePos("S9",19));
        b.play("B".equals("B"),Engine.computePos("P14",19));
        b.play("W".equals("B"),Engine.computePos("P11",19));
        b.play("B".equals("B"),Engine.computePos("M16",19));
        b.play("W".equals("B"),Engine.computePos("G15",19));
        b.play("B".equals("B"),Engine.computePos("C14",19));
        b.play("W".equals("B"),Engine.computePos("A5",19));
        b.play("B".equals("B"),Engine.computePos("E7",19));
        b.play("W".equals("B"),Engine.computePos("C1",19));
        b.play("B".equals("B"),Engine.computePos("E14",19));
        b.play("W".equals("B"),Engine.computePos("E10",19));
        b.play("B".equals("B"),Engine.computePos("K8",19));
        b.play("W".equals("B"),Engine.computePos("T19",19));
        b.play("B".equals("B"),Engine.computePos("C13",19));
        b.play("W".equals("B"),Engine.computePos("G9",19));
        b.play("B".equals("B"),Engine.computePos("N13",19));
        b.play("W".equals("B"),Engine.computePos("R6",19));
        b.play("B".equals("B"),Engine.computePos("O10",19));
        b.play("W".equals("B"),Engine.computePos("M10",19));
        b.play("B".equals("B"),Engine.computePos("G12",19));
        b.play("W".equals("B"),Engine.computePos("P12",19));
        b.play("B".equals("B"),Engine.computePos("D8",19));
        b.play("W".equals("B"),Engine.computePos("K5",19));
        b.play("B".equals("B"),Engine.computePos("H12",19));
        b.play("W".equals("B"),Engine.computePos("T17",19));
        b.play("B".equals("B"),Engine.computePos("L2",19));
        b.play("W".equals("B"),Engine.computePos("A14",19));
        b.play("B".equals("B"),Engine.computePos("L15",19));
        b.play("W".equals("B"),Engine.computePos("T11",19));
        b.play("B".equals("B"),Engine.computePos("J17",19));
        b.play("W".equals("B"),Engine.computePos("B12",19));
        b.play("B".equals("B"),Engine.computePos("B4",19));
        b.play("W".equals("B"),Engine.computePos("O5",19));
        b.play("B".equals("B"),Engine.computePos("D6",19));
        b.play("W".equals("B"),Engine.computePos("B3",19));
        b.play("B".equals("B"),Engine.computePos("B13",19));
        b.play("W".equals("B"),Engine.computePos("F5",19));
        b.play("B".equals("B"),Engine.computePos("H13",19));
        b.play("W".equals("B"),Engine.computePos("Q8",19));
        b.play("B".equals("B"),Engine.computePos("D2",19));
        b.play("W".equals("B"),Engine.computePos("C16",19));
        b.play("B".equals("B"),Engine.computePos("T9",19));
        b.play("W".equals("B"),Engine.computePos("A17",19));
        b.play("B".equals("B"),Engine.computePos("O4",19));
        b.play("W".equals("B"),Engine.computePos("K11",19));
        b.play("B".equals("B"),Engine.computePos("L13",19));
        b.play("W".equals("B"),Engine.computePos("F1",19));
        b.play("B".equals("B"),Engine.computePos("A10",19));
        b.play("W".equals("B"),Engine.computePos("S4",19));
        b.play("B".equals("B"),Engine.computePos("S12",19));
        b.play("W".equals("B"),Engine.computePos("R18",19));
        b.play("B".equals("B"),Engine.computePos("D14",19));
        b.play("W".equals("B"),Engine.computePos("Q2",19));
        b.play("B".equals("B"),Engine.computePos("G2",19));
        b.play("W".equals("B"),Engine.computePos("P5",19));
        b.play("B".equals("B"),Engine.computePos("Q1",19));
        b.play("W".equals("B"),Engine.computePos("Q11",19));
        b.play("B".equals("B"),Engine.computePos("B9",19));
        b.play("W".equals("B"),Engine.computePos("T1",19));
        b.play("B".equals("B"),Engine.computePos("M2",19));
        b.play("W".equals("B"),Engine.computePos("J9",19));
        b.play("B".equals("B"),Engine.computePos("J13",19));
        b.play("W".equals("B"),Engine.computePos("B7",19));
        b.play("B".equals("B"),Engine.computePos("K16",19));
        b.play("W".equals("B"),Engine.computePos("G19",19));
        b.play("B".equals("B"),Engine.computePos("G18",19));
        b.play("W".equals("B"),Engine.computePos("F7",19));
        b.play("B".equals("B"),Engine.computePos("E9",19));
        b.play("W".equals("B"),Engine.computePos("G3",19));
        b.play("B".equals("B"),Engine.computePos("C17",19));
        b.play("W".equals("B"),Engine.computePos("T7",19));
        b.play("B".equals("B"),Engine.computePos("N10",19));
        b.play("W".equals("B"),Engine.computePos("F19",19));
        b.play("B".equals("B"),Engine.computePos("B2",19));
        b.play("W".equals("B"),Engine.computePos("E5",19));
        b.play("B".equals("B"),Engine.computePos("S8",19));
        b.play("W".equals("B"),Engine.computePos("N9",19));
        b.play("B".equals("B"),Engine.computePos("S17",19));
        b.play("W".equals("B"),Engine.computePos("P19",19));
        b.play("B".equals("B"),Engine.computePos("G13",19));
        b.play("W".equals("B"),Engine.computePos("C6",19));
        b.play("B".equals("B"),Engine.computePos("R4",19));
        b.play("W".equals("B"),Engine.computePos("E11",19));
        b.play("B".equals("B"),Engine.computePos("O6",19));
        b.play("W".equals("B"),Engine.computePos("T10",19));
        b.play("B".equals("B"),Engine.computePos("O2",19));
        b.play("W".equals("B"),Engine.computePos("D16",19));
        b.play("B".equals("B"),Engine.computePos("F12",19));
        b.play("W".equals("B"),Engine.computePos("P2",19));
        b.play("B".equals("B"),Engine.computePos("P1",19));
        b.play("W".equals("B"),Engine.computePos("H16",19));
        b.play("B".equals("B"),Engine.computePos("F9",19));
        b.play("W".equals("B"),Engine.computePos("N3",19));
        b.play("B".equals("B"),Engine.computePos("F4",19));
        b.play("W".equals("B"),Engine.computePos("M11",19));
        b.play("B".equals("B"),Engine.computePos("F10",19));
        b.play("W".equals("B"),Engine.computePos("Q4",19));
        b.play("B".equals("B"),Engine.computePos("L11",19));
        b.play("W".equals("B"),Engine.computePos("B15",19));
        b.play("B".equals("B"),Engine.computePos("G8",19));
        b.play("W".equals("B"),Engine.computePos("O14",19));
        b.play("B".equals("B"),Engine.computePos("S7",19));
        b.play("W".equals("B"),Engine.computePos("O3",19));
        b.play("B".equals("B"),Engine.computePos("N11",19));
        b.play("W".equals("B"),Engine.computePos("H17",19));
        b.play("B".equals("B"),Engine.computePos("A13",19));
        b.play("W".equals("B"),Engine.computePos("E1",19));
        b.play("B".equals("B"),Engine.computePos("T8",19));
        b.play("W".equals("B"),Engine.computePos("E3",19));
        b.play("B".equals("B"),Engine.computePos("B8",19));
        b.play("W".equals("B"),Engine.computePos("F14",19));
        b.play("B".equals("B"),Engine.computePos("K2",19));
        b.play("W".equals("B"),Engine.computePos("N7",19));
        b.play("B".equals("B"),Engine.computePos("A8",19));
        b.play("W".equals("B"),Engine.computePos("O12",19));
        b.play("B".equals("B"),Engine.computePos("L3",19));
        b.play("W".equals("B"),Engine.computePos("S10",19));
        b.play("B".equals("B"),Engine.computePos("E13",19));
        b.play("W".equals("B"),Engine.computePos("Q17",19));
        b.play("B".equals("B"),Engine.computePos("J5",19));
        b.play("W".equals("B"),Engine.computePos("K10",19));
        b.play("B".equals("B"),Engine.computePos("S18",19));
        b.play("W".equals("B"),Engine.computePos("H6",19));
        b.play("B".equals("B"),Engine.computePos("T15",19));
        b.play("W".equals("B"),Engine.computePos("T16",19));
        b.play("B".equals("B"),Engine.computePos("C4",19));
        b.play("W".equals("B"),Engine.computePos("H18",19));
        b.play("B".equals("B"),Engine.computePos("M5",19));
        b.play("W".equals("B"),Engine.computePos("M17",19));
        b.play("B".equals("B"),Engine.computePos("S15",19));
        b.play("W".equals("B"),Engine.computePos("D19",19));
        b.play("B".equals("B"),Engine.computePos("D7",19));
        b.play("W".equals("B"),Engine.computePos("N2",19));
        b.play("B".equals("B"),Engine.computePos("L14",19));
        b.play("W".equals("B"),Engine.computePos("T6",19));
        b.play("B".equals("B"),Engine.computePos("N8",19));
        b.play("W".equals("B"),Engine.computePos("M7",19));
        b.play("B".equals("B"),Engine.computePos("M12",19));
        b.play("W".equals("B"),Engine.computePos("D3",19));
        b.play("B".equals("B"),Engine.computePos("J14",19));
        b.play("W".equals("B"),Engine.computePos("N12",19));
        b.play("B".equals("B"),Engine.computePos("Q19",19));
        b.play("W".equals("B"),Engine.computePos("A4",19));
        b.play("B".equals("B"),Engine.computePos("J12",19));
        b.play("W".equals("B"),Engine.computePos("E4",19));
        b.play("B".equals("B"),Engine.computePos("Q5",19));
        b.play("W".equals("B"),Engine.computePos("T18",19));
        b.play("B".equals("B"),Engine.computePos("M6",19));
        b.play("W".equals("B"),Engine.computePos("C10",19));
        b.play("B".equals("B"),Engine.computePos("A11",19));
        b.play("W".equals("B"),Engine.computePos("F18",19));
        b.play("B".equals("B"),Engine.computePos("H3",19));
        b.play("W".equals("B"),Engine.computePos("B10",19));
        b.play("B".equals("B"),Engine.computePos("K4",19));
        b.play("W".equals("B"),Engine.computePos("T3",19));
        b.play("B".equals("B"),Engine.computePos("G17",19));
        b.play("W".equals("B"),Engine.computePos("R10",19));
        b.play("B".equals("B"),Engine.computePos("E18",19));
        b.play("W".equals("B"),Engine.computePos("Q9",19));
        b.play("B".equals("B"),Engine.computePos("R13",19));
        b.play("W".equals("B"),Engine.computePos("P15",19));
        b.play("B".equals("B"),Engine.computePos("N4",19));
        b.play("W".equals("B"),Engine.computePos("B5",19));
        b.play("B".equals("B"),Engine.computePos("H7",19));
        b.play("W".equals("B"),Engine.computePos("T14",19));
        b.play("B".equals("B"),Engine.computePos("S3",19));
        b.play("W".equals("B"),Engine.computePos("T5",19));
        b.play("B".equals("B"),Engine.computePos("L5",19));
        b.play("W".equals("B"),Engine.computePos("M15",19));
        b.play("B".equals("B"),Engine.computePos("O19",19));
        b.play("W".equals("B"),Engine.computePos("Q12",19));
        b.play("B".equals("B"),Engine.computePos("R19",19));
        b.play("W".equals("B"),Engine.computePos("F6",19));
        b.play("B".equals("B"),Engine.computePos("K14",19));
        b.play("W".equals("B"),Engine.computePos("S19",19));
        b.play("B".equals("B"),Engine.computePos("R7",19));
        b.play("W".equals("B"),Engine.computePos("N14",19));
        b.play("B".equals("B"),Engine.computePos("J3",19));
        b.play("W".equals("B"),Engine.computePos("A2",19));
        b.play("B".equals("B"),Engine.computePos("M19",19));
        assertTrue(true);
    }
}
