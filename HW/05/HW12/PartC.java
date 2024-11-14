public class PartC {
    
    // Method to count vowels in the given string
    public static int countVowels(String phrase) {
        int count = 0;
        for (int i = 0; i < phrase.length(); i++) {
            char c = phrase.charAt(i);
            if (isVowel(c)) {
                count++;
            }
        }
        return count;
    }

    // Helper method to check if a character is a vowel
    public static boolean isVowel(char c) {
        // Convert character to lowercase to handle both uppercase and lowercase vowels
        c = Character.toLowerCase(c);
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    // Main method to test the countVowels method
    public static void main(String[] args) {
        String testPhrase1 = "Hello World";
        System.out.println("Vowel count in \"" + testPhrase1 + "\": " + countVowels(testPhrase1));

        String testPhrase2 = "Java Programming";
        System.out.println("Vowel count in \"" + testPhrase2 + "\": " + countVowels(testPhrase2));

        String testPhrase3 = "This is a Test Phrase";
        System.out.println("Vowel count in \"" + testPhrase3 + "\": " + countVowels(testPhrase3));
    }
}
