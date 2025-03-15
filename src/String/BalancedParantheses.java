//https://leetcode.com/problems/valid-parentheses/

public class BalancedParantheses {
    public boolean isValid(String s) {
        char[] arr = new char[s.length()];

        int index = -1;
        boolean valid = true;
        for (int i = 0 ; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(', '{', '[' -> arr[++index] = ch;
                case ')' -> {
                    if (index <= -1) {
                        return false;
                    }
                    char top = arr[index--];
                    if (top != '(') {
                        return false;
                    }
                }

                case ']' -> {
                    if (index <= -1) {
                        return false;
                    }
                    char top = arr[index--];
                    if (top != '[') {
                        return false;
                    }
                }

                case '}' -> {
                    if (index <= -1) {
                        return false;
                    }
                    char top = arr[index--];
                    if (top != '{') {
                        return false;
                    }
                }
            }
        }

        if (index != -1) {
            valid = false;
        }
        return valid;
    }
}
