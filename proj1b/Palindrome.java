public class Palindrome {
    public Deque<Character> wordToDeque (String word) {
        Deque<Character> characterDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            characterDeque.addLast(word.charAt(i));
        }
        return characterDeque;
    }

    public boolean isPalindrome (String word) {
        Deque<Character> placeholder = wordToDeque(word);
        return recursiveHelper(placeholder);
    }

    public boolean isPalindrome (String word, CharacterComparator cc) {
        Deque<Character> placeholder = wordToDeque(word);
        return recursiveHelper2(placeholder, cc);
    }

    /** Helper method for isPalindrome (String word) */
    private boolean recursiveHelper (Deque<Character> item) {
        if (item.size() <=1) {
            return true;
        }
        if(item.removeFirst() == item.removeLast()) {
            return recursiveHelper(item);
        } else {
            return false;
        }
    }

    /**
     * Helper method for isPalindrome (String word, CharacterComparator cc)
     */
    private boolean recursiveHelper2 (Deque<Character> item, CharacterComparator cc) {
        if (item.size() <=1) {
            return true;
        }
        Character i = item.removeFirst();
        Character j = item.removeLast();
        if (cc.equalChars(i, j)) {
            return recursiveHelper2(item, cc);
        } else {
            return false;
        }
    }
}
