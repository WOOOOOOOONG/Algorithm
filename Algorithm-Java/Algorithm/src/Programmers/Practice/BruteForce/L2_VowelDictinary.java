package Programmers.Practice.BruteForce;

/* 모음 사전
*
* */

import java.util.ArrayList;
import java.util.Collections;

public class L2_VowelDictinary {
    private char[] vowel = {'A', 'E', 'I', 'O', 'U'};
    ArrayList<String> dictinory = new ArrayList<>();

    public int solution(String word) {
        recursive(0, "");
        Collections.sort(dictinory);

        return dictinory.indexOf(word) + 1;
    }

    public void recursive(int index, String str) {
        if (index >= 5) return;
        for (int i = 0; i < vowel.length; i++) {
            dictinory.add(str + vowel[i]);
            recursive(index + 1, str + vowel[i]);
        }
    }
}
