package Company_Test.Nexon;

public class Nexon1 {
    /* 제너레이터 문제
    * 1. 5001개 있는 배열에 1~5000까지의 값을 인덱스로 하고, 그 안에 제너레이션한 값 넣기 => n
    * 제너레이션 : 자기 자신 + 각각의 자릿수
    * 2. answer를 1~5000까지 돌리면서 현재 값이 제너레이션 배열 안에 없는 값이면 더하기 => n
    * 3. 결과 반환
    * 시간 복잡도 : n^2 = 2,500,000
    * */
    public static long solution() {
        long result = 0;
        int[] generation = new int[5001];

        for (int i = 1; i <= 5000; i++) {
            int temp = 0;
            int length = String.valueOf(i).length();
            char[] split = new char[length];
            split = String.valueOf(i).toCharArray();
            temp += i;
            for (int j = 0; j < length; j++) {
                temp += Character.getNumericValue(split[j]);
            }

            generation[i] = temp;
        }

        for (int i = 1; i <= 5000; i++) {
            boolean bContain = false;
            for (int j = 1; j <= 5000; j++) {
                if (i == generation[j]) {
                    bContain = true;
                    break;
                }
            }
            if (!bContain) {
                //System.out.println(i);
                result += i;
            }
        }

        return result;
    }
}
