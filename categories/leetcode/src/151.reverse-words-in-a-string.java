class Solution {
    public static String reverseWords(String s) {
        StringBuffer r = new StringBuffer();

        rec_reverse(s, nextNonSpace(s, 0), r);
        r.deleteCharAt(r.length()-1); // must end with an extra space character

        return r.toString();
    }


    /**
     * This method
     * Index points to a non-space character
     * StringBuffer r will be modified once the method ends
     *
     * @param s
     * @param index
     * @param r
     */
    private static void rec_reverse(String s, int index, StringBuffer r) {
        if (index == -1) return;

        char ch = s.charAt(index);
        StringBuffer word = new StringBuffer();
        while (index < s.length() && s.charAt(index) != ' '){
            word.append(s.charAt(index));

            index ++;
        }
        // index points to a space once the loop ends

        rec_reverse(s, nextNonSpace(s, index), r);

        r.append(word);
        r.append(' ');
    }


    /**
     * Given a String s and an index, this method returns the index of the next non-space character
     * If there are no more non-space characters after s[index], return -1
     * Index points to a space currently
     *
     * @param s
     * @param index
     * @return index if there are more non-space chars, -1 otherwise
     */
    public static int nextNonSpace(String s, int index) {
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                return i;
            }
        }

        return -1;
    }
}