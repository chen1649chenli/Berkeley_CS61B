public class Palindrome {
    public Deque<Character> wordToDeque (String word) {
        Deque<Character> characterDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            characterDeque.addLast(word.charAt(i));
        }
        return characterDeque;
    }

    public boolean isPalindrome (String word) {
        return true;
    }
}
