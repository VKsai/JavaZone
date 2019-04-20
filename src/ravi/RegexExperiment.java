package ravi;

public class RegexExperiment {
    public static void main(String[] args) {
        String str = "abc@xyz.com";
        System.out.println(matchEmail(str));
    }

    private static boolean matchEmail(String str) {
        return str.trim().toLowerCase().replaceAll(" ", "").matches("^[a-zA-Z0-9._%+-].+@[a-zA-Z0-9.-].+\\.[a-zA-Z]{2,6}");
    }
}
