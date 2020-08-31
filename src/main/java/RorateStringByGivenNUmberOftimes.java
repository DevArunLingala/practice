public class RorateStringByGivenNUmberOftimes {
    public static void main(String[] args) {
        System.out.println(new RorateStringByGivenNUmberOftimes().rotate("geeksgeeksfor", 2));
    }
    public String rotate(String str, int n) {
        char[] chars = str.toCharArray();
        int l = chars.length;
        while(n-- > 0) {
            char last = chars[l - 1];
            for (int i = l- 1; i > 0; i--) {
                chars[i] = chars[i-1];
            }
            chars[0] = last;
        }
        return new String(chars);
    }
}
