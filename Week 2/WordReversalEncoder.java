class WordReversalEncoder {

    static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {

            StringBuilder reverse = new StringBuilder();

            for (int j = words[i].length() - 1; j >= 0; j--) {
                reverse.append(words[i].charAt(j));
            }

            result += reverse.toString();

            if (i != words.length - 1) {
                result += " ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String sentence = "hello club";

        System.out.println(reverseEachWord(sentence));
    }
}