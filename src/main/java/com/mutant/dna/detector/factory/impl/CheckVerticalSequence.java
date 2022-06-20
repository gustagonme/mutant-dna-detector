package com.mutant.dna.detector.factory.impl;

import com.mutant.dna.detector.factory.interfaces.CheckDna;

public class CheckVerticalSequence implements CheckDna {
    @Override
    public boolean validateDna(String[] dna) {
        int count_sequences_vertical = 0;
        int consecutive_length = 3;
        //ITERATES THROUGH EACH COLUMN
        for(int i = 0; i<dna[0].length(); i++){
            int count_consecutive_letter = 0;
            //ITERATES THROUGH EACH ROW
            for(int j=0; j<dna.length - 1; j++){
                //COMPARES THE CURRENT VALUE WITH THE VALUE OF THE NEXT HORIZONTAL POSITION
                if(dna[j].charAt(i) == dna[j+1].charAt(i)) {
                    count_consecutive_letter++;
                } else {
                    //IF THE COMPARISON FAILS, THE COUNTER IS RESET, BECAUSE IN A LARGE MATRIX THERE MAY BE MULTIPLE SEQUENCES OF AT LEAST 4 CONSECUTIVE LETTERS
                    count_consecutive_letter = 0;
                }
                //IF THE COUNT_CONSECUTIVE_LETTER HAS REACHED X, THAT MEANS THAT (X + 1) LETTERS ARE CONSECUTIVE
                //WHY? CCCC IS 4 LETTER SEQUENCE. C1 == C2 is 1 count, C2 == C3 is 2nd count, C3 == C4 is 3rd count. 3 counts of comparison of 4 C's
                if(count_consecutive_letter == consecutive_length) {
                    count_sequences_vertical++;
                }
            }
        }
        return count_sequences_vertical > 0 ? true: false;
    }
}
