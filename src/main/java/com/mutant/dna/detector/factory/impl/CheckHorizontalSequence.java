package com.mutant.dna.detector.factory.impl;

import com.mutant.dna.detector.factory.interfaces.CheckDna;
import org.springframework.stereotype.Component;

@Component
public class CheckHorizontalSequence implements CheckDna {
    @Override
    public boolean validateDna(String[] dna) {
        int numberSequencesHz = 0;
        int iterations = 3;
        //ITERATES THROUGH EACH ROW
        for(int row=0; row<dna.length; row++){
            int numberConsecutiveLetter = 0;
            //ITERATES THROUGH EACH COLUMN
            for(int col = 0; col<dna[0].length()-1; col++){
                //COMPARES THE CURRENT VALUE WITH THE VALUE OF THE NEXT HORIZONTAL POSITION
                if(dna[row].charAt(col) == dna[row].charAt(col+1)) {
                    numberConsecutiveLetter++;
                } else {
                    //IF THE COMPARISON FAILS, THE COUNTER IS RESET, BECAUSE IN A LARGE MATRIX THERE MAY BE MULTIPLE SEQUENCES OF AT LEAST 4 CONSECUTIVE LETTERS
                    numberConsecutiveLetter = 0;
                }
                //IF THE COUNT_CONSECUTIVE_LETTER HAS REACHED X, THAT MEANS THAT (X + 1) LETTERS ARE CONSECUTIVE
                //WHY? CCCC IS 4 LETTER SEQUENCE. C1 == C2 is 1 count, C2 == C3 is 2nd count, C3 == C4 is 3rd count. 3 counts of comparison of 4 C's
                if(numberConsecutiveLetter == iterations) {
                    numberSequencesHz++;
                }
            }
        }

        return numberSequencesHz > 0 ? true:false;
    }
}
