package Practice;

/*
-ID 조건
        문자 3~6자리
        숫자 0~6자리(단, 숫자는 0으로 시작할 수 없음)
        무조건 S + N 형식만 됨

        -변수명
        new_id : 신규 ID
        registered_list : 이미 가입된 ID들

        -ID 추천 방법
        1. registered_list에 등록여부 확인
        2. 등록되어 있을시 N을 10진수로 변환(이를 n이라 함)
        (단, N이 null이면 0)
        3. n+1을 문자열로 변환
        4. N+N1 하고 1로 돌아간다.

        -전체 순서
        1. new_id가 ID 조건에 부합한지 확인한다
        2-1. 부합하다면 중복 여부 체크 후 중복이라면 ID 추천, 아니라면 결과 반환
        2-2. 부합하지 않다면 ID 추천
        3. 이를 반복 후 결과 값 찾아 반환

        -복잡도
        최대 N log N
*/
public class Test1 {
    static class Solution {
        public String solution(String[] registered_list, String new_id) {
            // 1. new_id가 ID 조건에 부합한지 Check
            int position = -1;
            boolean bCheck = false;
            for (int i = 0; i < new_id.length(); i++) { // S + N 형식인지
                if (new_id.charAt(i) >= '0' && new_id.charAt(i) <= '9') {
                    if (!bCheck) {
                        bCheck = true;
                        position = i;
                    }
                } else {
                    // S + N 형식이 아닌것
                    if (bCheck) {
                        position = -1;
                        bCheck = false;
                        break;
                    }
                }
            }

            String front = position != -1 ? new_id.substring(0, position) : new_id;
            String back = position != -1 ? new_id.substring(position) : "";

            // 잘려진 문자열 확인
            //System.out.println(front + ", " + back);

            // 자릿수 Confirm
            if ((front.length() >= 3 && front.length() <= 6)
                && (back.length() >= 0 && back.length() <= 6)) {
                bCheck = true;
            }

            // N 첫 시작이 0인지
            if (back.length() > 0 && back.charAt(0) == '0') {
                bCheck = false;
            }

            // 2. registered_list에 등록되어 있으면 ID 추천, 아니면 반환
            while (true) {
                for (int i = 0; i < registered_list.length; i++) {
                    if (registered_list[i].length() == new_id.length()) {
                        //System.out.println(registered_list[i] + ", " + new_id);
                        if (registered_list[i].equals(new_id)) {
                            bCheck = false;
                            break;
                        }
                    } else {
                        continue;
                    }
                }

                if (bCheck) break;

                int n = back.length() > 0 ? Integer.parseInt(back) : 0;
                int N1 = n + 1;

                back = String.valueOf(N1);
                new_id = front + back;

                bCheck = true;
            }

            return new_id;
        }
    }
}
