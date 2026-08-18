class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        String vowels = "aeiouAEIOU";
        int vowelCount = 0;
        for (int i = 0; i < n / 2; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                vowelCount++;
            }
            if (vowels.indexOf(s.charAt(i + n / 2)) != -1) {
                vowelCount--;
            }
        }
        return vowelCount == 0;
    }
}
