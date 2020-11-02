package com.wc.algorithm.beauty;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

/**
 * 数学运算符
 *
 * @author shovel
 * @date 2018/11/26 14:55
 * @since 1.0.0
 */
public class MathCalculate {
    public static void main(String[] args) {


        // 34+13*9+44-12/3
        MathCalculate cal = new MathCalculate();
        System.out.println(cal.calculate("34+13*9+44-12/3"));

    }

    int calculate(String expression) {
        if (StringUtils.isEmpty(expression)) {
            return 0;
        }
        Stack<Integer> intStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        char[] charArray = expression.toCharArray();
        /**
         * 两个栈，a存数字，b存符号
         * 数字直接压栈
         * 符号跟栈顶符号比较：如果比栈顶优先级高，直接入栈；如果比栈顶优先级低或者同级，弹出栈顶符号计算，并将结果入栈，继续比较
         */
        for (char c : charArray) {
            if ('+' == c || '-' == c || '*' == c || '/' == c) {
                if (stringStack.isEmpty()) {
                    stringStack.push(String.valueOf(c));
                    continue;
                }

                if ('+' == c || '-' == c) {
                    do {
                        String symbol = stringStack.pop();
                        int a = intStack.pop();
                        int b = intStack.pop();
                        int result = this.cal(b, a, symbol);
                        intStack.push(result);
                    } while (!stringStack.isEmpty());
                }

                stringStack.push(String.valueOf(c));
            } else {
                intStack.push(Integer.valueOf(String.valueOf(c)));
            }
        }

        String symbol = stringStack.pop();
        int a = intStack.pop();
        int b = intStack.pop();
        int result = this.cal(b, a, symbol);

        return result;
    }

    int cal(int a, int b, String symbol) {
        int result;
        switch (symbol) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
                default:
                    throw new UnsupportedOperationException("不支持的运算");
        }

        return result;
    }
}
