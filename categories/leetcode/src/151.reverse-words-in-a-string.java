class Solution {
    public static String reverseWords(String s) {
        String reversed = reverse(s);
        return reversed;
    }


    public static String reverse(String s) {
        StringBuffer r = new StringBuffer();

        rec_reverse(s, nextNonSpace(s, 0), r);
        r.deleteCharAt(s.length()-1); // must end with an extra space character

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
        while (index < s.length()-1 && s.charAt(index) != ' '){
            System.out.println("The current char is " + s.charAt(index));
            word.append(s.charAt(index));

            index ++;
        }
        // index points to a space once the loop ends
        System.out.println("the loop is broke, now points to " + s.charAt(index));

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
        for (int i = index; i < s.length()-1; i++) {
            if (s.charAt(i) != ' ') {
                System.out.println("The non-space char is at " + i + ", which is " + s.charAt(i));
                return i;
            }
        }

        return -1;
    }
}