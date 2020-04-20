package com.sqt;

import java.util.*;

/**
 * @Description:
 * @author: ListenerSun(男, 未婚) 微信:810548252
 * @Date: Created in 2020-04-13 21:02
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        int result = getNumber(n);
        int result = getCount(s);

        System.out.println(result);
    }


    private static int getCount(String s){
        List<String> result = new ArrayList<String>();
        char[] chars = s.toCharArray();
        char[] tempChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++){
            tempChars[i] = chars[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
           for (int j = 0; j < chars.length; j++) {
             char temp = chars[i];
             chars[i] = chars[j];
             chars[j] = temp;
             sb.append(chars);
             if (!result.contains(sb.toString())){
                 result.add(sb.toString());
             }
               chars[j] = chars[i];
               chars[i] = temp;
             sb.delete(0,chars.length);
           }
        }
        return result.size();
    }








    private static int getNumber(int num) {
        int result = 0;
        if (num < 10) {
            result = num;
        } else {
            String s = String.valueOf(num);
            char[] chars = s.toCharArray();
            for (char c : chars) {
                result += Integer.parseInt(String.valueOf(c));
            }
        }
        if (result >= 10) {
            result = getNumber(result);
        }
        return result;
    }
}
