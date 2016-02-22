

public class Primo {

    public static boolean primo(int a) {

        return primo(a,2);

    }

    private static boolean primo(int a, int b) {

        if (b <= a / 2) {

            if (a % b == 0) {
                return false;

            } else {

                return primo(a, b + 1);

            }

        } else {

            return true;

        }
    }

}
