package com.mutant.dna.detector.factory.impl;

import com.mutant.dna.detector.factory.interfaces.CheckDna;

public class CheckObliqueSequence implements CheckDna {
    @Override
    public boolean validateDna(String[] dna) {
        int count_sequences_oblique = 0;
        int count_consecutive_letter = 0;
        int consecutive_length = 3;

        //ITERATES THROUGH THE MIDDLE OBLIQUE LINE
        //THIS LOOPS THROUGH
        for(int i = 0; i<dna[0].length()-1; i++){
            int j = i;
            //CHECKS $y IS WITHIN BOUNDARIES AND PERFORMS BELOW ACTIONS IF IT IS
            if(j < dna.length - 1) {
                //COMPARES THE CURRENT VALUE WITH THE VALUE OF THE NEXT OBLIQUE POSITION
                if(dna[j].charAt(i) == dna[j+1].charAt(i+1)) {
                    count_consecutive_letter++;
                } else {
                    //IF THE COMPARISON FAILS, THE COUNTER IS RESET, BECAUSE IN A LARGE MATRIX THERE MAY BE MULTIPLE SEQUENCES OF AT LEAST 4 CONSECUTIVE LETTERS
                    count_consecutive_letter = 0;
                }
                //IF THE COUNT_CONSECUTIVE_LETTER HAS REACHED X, THAT MEANS THAT (X + 1) LETTERS ARE CONSECUTIVE
                //WHY? CCCC IS 4 LETTER SEQUENCE. C1 == C2 is 1 count, C2 == C3 is 2nd count, C3 == C4 is 3rd count. 3 counts of comparison of 4 C's
                if(count_consecutive_letter == consecutive_length - 1) {
                    count_sequences_oblique++;
                }
            }
        }

        //ITERATES THROUGH THE RIGHT HALF SIDE THE MATRIX SQUARE
        //THIS LOOPS THROUGH
        for(int offset_x = 1; offset_x < dna[0].length(); offset_x++) {
            count_consecutive_letter = 0;
            for(int i = offset_x; i<dna[0].length()-1; i++) {
                int j = i - offset_x;
                //CHECKS $y IS WITHIN BOUNDARIES AND PERFORMS BELOW ACTIONS IF IT IS
                if(j < dna.length - 1) {
                    //COMPARES THE CURRENT VALUE WITH THE VALUE OF THE NEXT OBLIQUE POSITION
                    if(dna[j].charAt(i) == dna[j+1].charAt(i+1)) {
                        count_consecutive_letter++;
                    } else {
                        //IF THE COMPARISON FAILS, THE COUNTER IS RESET, BECAUSE IN A LARGE MATRIX THERE MAY BE MULTIPLE SEQUENCES OF AT LEAST 4 CONSECUTIVE LETTERS
                        count_consecutive_letter = 0;
                    }
                    if(count_consecutive_letter == consecutive_length - 1) {
                        count_sequences_oblique++;
                    }
                }
            }
        }
        //ITERATES THROUGH THE LEFT HALF SIDE THE MATRIX SQUARE
        //THIS LOOPS THROUGH [5,A,F], [9,E] AND [D]
        for(int offset_y = 1; offset_y < dna.length; offset_y++) {
            count_consecutive_letter = 0;
            for(int j = offset_y; j < dna.length - 1; j++) {
                int i = j - offset_y;
                //CHECKS $x IS WITHIN BOUNDARIES AND PERFORMS BELOW ACTIONS IF IT IS
                if(i < dna[0].length() - 1) {
                    //COMPARES THE CURRENT VALUE WITH THE VALUE OF THE NEXT OBLIQUE POSITION
                    if(dna[j].charAt(i) == dna[j+1].charAt(i+1)) {
                        count_consecutive_letter++;
                    } else {
                        //IF THE COMPARISON FAILS, THE COUNTER IS RESET, BECAUSE IN A LARGE MATRIX THERE MAY BE MULTIPLE SEQUENCES OF AT LEAST 4 CONSECUTIVE LETTERS
                        count_consecutive_letter = 0;
                    }
                    if(count_consecutive_letter == consecutive_length - 1) {
                        count_sequences_oblique++;
                    }
                }
            }
        }
        return count_sequences_oblique > 0 ? true:false;
    }
}
