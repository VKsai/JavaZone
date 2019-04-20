import java.util.Random;

public class Test {
    public static void main(String[] args) {
        System.out.println("**"+getRandom(1, 7));
    }

    private static int getRandom(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater");
        }

        Random random = new Random();
        return random.nextInt((max - min) + min);
    }
}
