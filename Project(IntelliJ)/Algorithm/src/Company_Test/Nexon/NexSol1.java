package Company_Test.Nexon;

public class NexSol1 {
    public static void main(String[] args) {
        System.out.println(minNum(3, 5, 5));
    }
    public static int minNum(int samDaily, int kellyDaily, int difference) {
        int firstDiff = (samDaily+difference)-kellyDaily;
        int dayDiff = kellyDaily-samDaily;

        if (samDaily == kellyDaily && difference == 0) {
            return -1;
        }

        int day = 1;

        if (firstDiff >= 0) day += (firstDiff / dayDiff) + 1;

        return day;
    }
}
