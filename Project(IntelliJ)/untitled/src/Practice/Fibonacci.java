package Practice;

public class Fibonacci {
    public static void main(String[] args) {
        int[] cache = new int[11];

        //System.out.println(topdown(10, cache));
        System.out.println(bottomup(10));
    }

    public static int topdown(int number, int[] cache) {
        if (number <= 1) return number;

        if (cache[number] != 0) return cache[number];

        int cal = topdown(number - 1, cache) + topdown(number - 2, cache);

        cache[number] = cal;

        return cache[number];
    }

    public static int bottomup(int number) {
        int[] cache = new int[number + 1];

        cache[0] = 0;
        cache[1] = 1;

        for(int i = 2; i <= number; ++i) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[number];
    }
}
