package org.example.hamming;

import java.util.Arrays;
import java.util.List;

public class Hamming {
    private List<Character> nucleotides = Arrays.asList('A', 'T', 'G', 'C');

    public List<Character> getNucleotides() {
        return nucleotides;
    }

    public void setNucleotides(List<Character> nucleotides) {
        this.nucleotides = nucleotides;
    }

    public int distance (String strand1, String strand2) throws Exception {
        int hammmingValue = 0;
        if (strand1.length() != strand2.length()) {
            throw new Exception("Strands of different length");
        }
        for (int i = 0; i < strand1.length(); i++) {
            if (!this.nucleotides.contains(strand1.charAt(i)) || !this.nucleotides.contains(strand2.charAt(i))) {
                throw new Exception("Invalid nucleotide(s)");
            }
            if (strand1.charAt(i) != strand2.charAt(i)) {
                hammmingValue += 1;
            }
        }
        return hammmingValue;
    }
}
