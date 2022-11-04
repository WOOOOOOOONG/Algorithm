package Programmers.Practice.Stack;

public class L2_RightingBracket {
    /*
    1. '('와 ')'의 수를 저장할 count 변수를 생성한다.
    2. 문자열 가장 첫번째부터 카운팅을 할 건데, '('면 더하고, ')'면 뺀다
       조건) 만약 count가 -가 되면 false다
    3. 문자열 가장 마지막이 0이 아니면 false다
    */
    boolean solution(String s) {
        int count = 0;
        char[] str = s.toCharArray(); // 속도를 위해 char 배열화 한다

        for (int i = 0; i < s.length(); i++) {
            if (count < 0) return false;

            if (str[i] == '(') count++;
            else count--;
        }

        if (count == 0) return true;
        else return false;
    }
}
