package Leetcode.No20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    static Map<Character,Character> map = new HashMap<>();
    static {
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
    }
    public boolean isValid(String s) {

        if(s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for(char i : s.toCharArray()) {
            if(map.containsKey(i)) {
                if(!stack.empty() && map.get(i).equals(stack.lastElement())) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(i);
            }
        }

        if(stack.empty()) return true;

        return false;
    }
}