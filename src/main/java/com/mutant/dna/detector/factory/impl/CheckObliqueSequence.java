package com.mutant.dna.detector.factory.impl;

import com.mutant.dna.detector.factory.interfaces.CheckDna;
import org.springframework.stereotype.Component;

@Component
public class CheckObliqueSequence implements CheckDna {
    @Override
    public boolean validateDna(String[] dna) {
        int numberSequencesOb = 0;
        int numberConsecutiveLetter = 0;
        int iterations = 3;

        //ITERATES THROUGH THE MIDDLE OBLIQUE LINE
        //THIS LOOPS THROUGH
        for(int i = 0; i<dna[0].length()-1; i++){
            int j = i;
            //CHECKS $y IS WITHIN BOUNDARIES AND PERFORMS BELOW ACTIONS IF IT IS
            if(j < dna.length - 1) {
                //COMPARES THE CURRENT VALUE WITH THE VALUE OF THE NEXT OBLIQUE POSITION
                if(dna[j].charAt(i) == dna[j+1].charAt(i+1)) {
                    numberConsecutiveLetter++;
                } else {
                    //IF THE COMPARISON FAILS, THE COUNTER IS RESET, BECAUSE IN A LARGE MATRIX THERE MAY BE MULTIPLE SEQUENCES OF AT LEAST 4 CONSECUTIVE LETTERS
                    numberConsecutiveLetter = 0;
                }
                //IF THE COUNT_CONSECUTIVE_LETTER HAS REACHED X, THAT MEANS THAT (X + 1) LETTERS ARE CONSECUTIVE
                //WHY? CCCC IS 4 LETTER SEQUENCE. C1 == C2 is 1 count, C2 == C3 is 2nd count, C3 == C4 is 3rd count. 3 counts of comparison of 4 C's
                if(numberConsecutiveLetter == iterations) {
                    numberSequencesOb++;
                }
            }
        }

        //ITERATES THROUGH THE RIGHT HALF SIDE THE MATRIX SQUARE
        //THIS LOOPS THROUGH
        for(int offset_x = 1; offset_x < dna[0].length(); offset_x++) {
            numberConsecutiveLetter = 0;
            for(int i = offset_x; i<dna[0].length()-1; i++) {
                int j = i - offset_x;
                //CHECKS $y IS WITHIN BOUNDARIES AND PERFORMS BELOW ACTIONS IF IT IS
                if(j < dna.length - 1) {
                    //COMPARES THE CURRENT VALUE WITH THE VALUE OF THE NEXT OBLIQUE POSITION
                    if(dna[j].charAt(i) == dna[j+1].charAt(i+1)) {
                        numberConsecutiveLetter++;
                    } else {
                        //IF THE COMPARISON FAILS, THE COUNTER IS RESET, BECAUSE IN A LARGE MATRIX THERE MAY BE MULTIPLE SEQUENCES OF AT LEAST 4 CONSECUTIVE LETTERS
                        numberConsecutiveLetter = 0;
                    }
                    if(numberConsecutiveLetter == iterations) {
                        numberSequencesOb++;
                    }
                }
            }
        }
        //ITERATES THROUGH THE LEFT HALF SIDE THE MATRIX SQUARE
        //THIS LOOPS THROUGH [5,A,F], [9,E] AND [D]
        for(int offset_y = 1; offset_y < dna.length; offset_y++) {
            numberConsecutiveLetter = 0;
            for(int j = offset_y; j < dna.length - 1; j++) {
                int i = j - offset_y;
                //CHECKS $x IS WITHIN BOUNDARIES AND PERFORMS BELOW ACTIONS IF IT IS
                if(i < dna[0].length() - 1) {
                    //COMPARES THE CURRENT VALUE WITH THE VALUE OF THE NEXT OBLIQUE POSITION
                    if(dna[j].charAt(i) == dna[j+1].charAt(i+1)) {
                        numberConsecutiveLetter++;
                    } else {
                        //IF THE COMPARISON FAILS, THE COUNTER IS RESET, BECAUSE IN A LARGE MATRIX THERE MAY BE MULTIPLE SEQUENCES OF AT LEAST 4 CONSECUTIVE LETTERS
                        numberConsecutiveLetter = 0;
                    }
                    if(numberConsecutiveLetter == iterations) {
                        numberSequencesOb++;
                    }
                }
            }
        }
        return numberSequencesOb > 0 ? true:false;
    }
}
