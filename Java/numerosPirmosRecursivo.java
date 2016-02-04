
public class Misterio1 {

    public static boolean misterio(int a) {
        return misterio (a,2);
    }

    private static boolean misterio(int a, int b) {
        if (b <= a / 2) {
            if (a % b == 0) {
                return false;
            } else {
                return misterio(a, b + 1);
            }
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            boolean r = misterio(i);
            if (r) {
                System.out.println("Para i = " + i + " -> " + r);
            }
        }
    }
}
