package Company_Test.Nexon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Nexsol2 {
    public static void main(String[] args) {
        List<Integer> order = new LinkedList<>();
        order.add(7);
        order.add(1);
        order.add(2);
        order.add(5);
        order.add(4);
        order.add(3);
        order.add(6);
        System.out.println(getMaximumRemovals(order, "abbabaa", "bb"));
    }

    public static int getMaximumRemovals(List<Integer> order, String source, String target) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < source.length(); i++) {
            map.put(source.charAt(i), 0);
        }

        for (int i = 0; i < source.length(); i++) {
            map.put(source.charAt(i), map.get(source.charAt(i))+1);
        }

        for (int i = 0; i < order.size(); i++) {
            boolean bHave = true;
            char remove = source.charAt(order.get(i)-1);
            map.put(remove, map.get(remove)-1);
            Map<Character, Integer> dummy = new HashMap<>(map);

            for (int j = 0; j < target.length(); j++) {
                char find = target.charAt(j);
                if (map.get(find) > 0) {
                    map.put(find, map.get(find)-1);
                } else {
                    bHave = false;
                    break;
                }
            }

            if (!bHave) {
                break;
            }
            map = dummy;
            result++;
        }

        return result;
    }

    /*
    public static int getMaximumRemovals(List<Integer> order, String source, String target) {
        int answer = 0;
        char[] sourceArr = source.toCharArray();

        for (int i = 0; i < order.size(); i++) {
            sourceArr[order.get(i)-1] = '-';
            //System.out.println(String.valueOf(sourceArr));

            int position = 0;
            boolean bTrue = true;
            for (int j = 0; j < target.length(); j++) {
                //System.out.println("find : " + target.charAt(j));

                for (; position < sourceArr.length; position++) {
                    if (sourceArr[position] == target.charAt(j)) {
                        //System.out.println("find!" + position);
                        break;
                    }
                }

                //System.out.println(position);
                if (position >= sourceArr.length) {
                    bTrue = false;
                    break;
                }
            }

            if (!bTrue) {
                break;
            }
            answer++;
        }

        return answer;
    }*/
}
