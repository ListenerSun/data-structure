package com.sqt;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description:
 * @author: ListenerSun(男, 未婚) 微信:810548252
 * @Date: Created in 2020-04-20 20:20
 */
public class Test {

    private static HashMap<Character, Character> mappings;

    public static void main(String[] args) {
        mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        String s = "{}{}{}}";
        System.out.println(valid(s));
    }

    public static boolean valid(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mappings.containsKey(c)) {
                char topElement = stack.empty() ? 'a' : stack.pop();
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
