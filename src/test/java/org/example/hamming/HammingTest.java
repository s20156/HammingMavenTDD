package org.example.hamming;

import org.junit.jupiter.api.*;
class HammingTest {
    Hamming hamming = new Hamming();

    @Test
    void testEmptyStrands() throws Exception {
        Assertions.assertEquals(0, this.hamming.distance("", ""));
    }

    @Test
    void testSingleLetterIdenticalStrands() throws Exception {
        Assertions.assertEquals(0, this.hamming.distance("A", "A"));
    }

    @Test
    void testSingleLettersDifferentStrands() throws Exception {
        Assertions.assertEquals(1, this.hamming.distance("G", "T"));
    }

    @Test
    void testLongIdenticalStrands() throws Exception {
        Assertions.assertEquals(0, this.hamming.distance("GGACTGAAATCTG", "GGACTGAAATCTG"));
    }

    @Test
    void testLongDifferentStrands() throws Exception {
        Assertions.assertEquals(9, this.hamming.distance("GGACGGATTCTG", "AGGACGGATTCT"));
    }

    @Test
    void testDisallowLeftEmptyStrand() throws Exception {
        Assertions.assertThrows(Exception.class, () -> this.hamming.distance("", "G"));
    }

    @Test
    void testDisallowRightEmptyStrand() throws Exception {
        Assertions.assertThrows(Exception.class, () -> this.hamming.distance("G", ""));
    }

    @Test
    void testDisallowNonNucleotideChars() throws Exception {
        Assertions.assertThrows(Exception.class, () -> this.hamming.distance("APGPW", "GAATC"));
    }
}