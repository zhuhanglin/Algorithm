package com.example.algorithm.title;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhl
 * @version 1.0
 * @date 2021/11/29 16:50
 * @classDesc: 功能描述:
 * @description
 */
public class Algorithm {
    /**
     * 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * @param s
     * @return
     */
    public static boolean isValidBrackets(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        char[] chars = s.toCharArray();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i=0;i < s.length();i++){
            if(!map.containsKey(chars[i])) {
                //为左括号时直接入栈
                stack.push(chars[i]);
            }else{
                //为右括号时，如果栈为空或者栈顶与该括号类型不匹配返回false
                if(stack.empty() || map.get(chars[i]) != stack.pop()){
                    return false;
                }
            }
        }
        //字符串遍历完毕后，如果栈为空返回true，反之返回false
        return stack.empty();
    }

    /**
     * 压缩字符串
     * 示例1:
     *  输入："aabcccccaaa"
     *  输出："a2b1c5a3"
     * 示例2:
     *  输入："abbccd"
     *  输出："abbccd"
     *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
     * @param S
     * @return
     */
    public String compressString(String S) {
        if (S == null || S.length() <= 2) {//首先判断字符串是否为空，是否长度小于2，是直接返回
            return(S);
        }
        //注意StringBuilder不能写在if判断前面
        StringBuilder a = new StringBuilder().append(S.charAt(0));
        int num = 1;
        for(int i=1;i < S.length();i++){
            char c = S.charAt(i-1);
            char b = S.charAt(i);
            if( c == b){
                num++;
            }else{
                a.append(num).append(S.charAt(i));
                num = 1;
            }
        }
        //最后判断输出结果与原字符串长度是否小于他
        return(a.append(num).length() < S.length() ? a.toString():S);
    }

}
