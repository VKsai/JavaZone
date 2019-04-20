import com.sun.tools.javac.util.StringUtils;

public class MetaStrings {
    public static void main(String[] args) {
        String str1 = "geeks";
        String str2 = "keegs";

        System.out.println(isMetaStrings(str1, str2));
    }

    private static boolean isMetaStrings(String str1, String str2) {
        boolean result = false;
        if (str1.length() != str2.length()) return false;
        if (str1.matches(str2)) return true;

        int i = 0, pos = 0, count = 0;

        while (i < str1.length()) {
            if (str1.charAt(i) == str2.charAt(i)) {
                i++;
                continue;
            } else {
                if (count == 1) {
                    result = new String(swap(str2.toCharArray(), pos, i)).equals(str1);
                    break;
                } else {
                    pos = i;
                    i++;
                    count++;
                    continue;
                }
            }
        }

        return result;
    }

    private static char[] swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
}
