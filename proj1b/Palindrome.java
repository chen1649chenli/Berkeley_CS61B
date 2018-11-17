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

    private boolean recursiveHelper(Deque<Character> item) {
        if (item.size() <=1) {
            return true;
        }
        if(item.removeFirst() == item.removeLast()) {
            return recursiveHelper(item);
        } else {
            return false;
        }
    }
}
