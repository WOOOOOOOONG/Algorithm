package Test.Nexon;

import java.util.*;

public class Nexsol3 {
    public static void main(String[] args) {
        List<Integer> initial = new ArrayList<>();
        initial.add(1);
        initial.add(1);
        initial.add(3);

        List<Integer> newL = new ArrayList<>();
        newL.add(2);
        newL.add(4);

        System.out.println(getMinimumHealth(initial, newL, 2));
    }

    public static long getMinimumHealth(List<Integer> initial_players, List<Integer> new_players, int rank) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < initial_players.size(); i++) {
            pq.add(initial_players.get(i));
        }

        Object[] objects = pq.toArray();
        result = (int)objects[rank-1];
        System.out.println(result);

        for (int i = 0; i < new_players.size(); i++) {
            pq.add(new_players.get((i)));
            pq.stream().sorted();
            objects = pq.toArray();
            for (int j =0; j < pq.size(); j++) {
                System.out.print(objects[j] + " ");
            }
            result += (int)objects[rank-1];
            System.out.println((int)objects[rank-1]);
        }

        return result;
    }
}
