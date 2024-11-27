package lc;

public class ModPai {

    public static void main(String[] args) {
        for (int i = 11; i <= 19; i++)
            System.out.print(get(i) + " ");
        System.out.println();
        for (int i = 21; i <= 29; i++)
            System.out.print(get(i) + " ");
        System.out.println();
        for (int i = 31; i <= 39; i++)
            System.out.print(get(i) + " ");
        System.out.println();
        for (int i = 45; i <= 47; i++)
            System.out.print(get(i) + " ");
        System.out.println();
    }

    private static int get(int x) {
        x++;
        if (x >= 11 && x <= 20) {
            x = 11 + (x - 11) % 9;
        } else if (x >= 21 && x <= 30) {
            x = 21 + (x - 21) % 9;
        } else if (x >= 31 && x <= 40) {
            x = 31 + (x - 31) % 9;
        } else  {
            x = 45 + (x - 45) % 2;
        }

        return x;
    }
}
