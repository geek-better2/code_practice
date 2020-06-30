package com.hai.leecode.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 剑指 Offer 67. 把字符串转换成整数  leetcode 主站第8题
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * <p>
 *  
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StringToInt {

    public int strToInt(String str) {
        if (str == null) {
            return 0;
        }
        int n = str.length();
        int i = 0;
        int res = 0;
        boolean is_negative = false;
        //第一步，跳过前面若干个空格
        while (i < n && str.charAt(i) == ' ') {
            ++i;
        }
        //如果字符串全是空格直接返回
        if (i == n) {
            return 0;
        }
        //第二步，判断正负号
        if (str.charAt(i) == '-') {
            is_negative = true;
        }
        //如果是正负号，还需要将指针i，跳过一位
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            ++i;
        }
        //第三步，循环判断字符是否在 0~9之间
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            //'0'的ASCII码是48，'1'的是49，这么一减就从就可以得到真正的整数值
            int tmp = str.charAt(i) - 48;
            int bigNum = Integer.MAX_VALUE / 10;
            //判断是否大于 最大32位整数
            if (!is_negative && (res > bigNum || (res == bigNum && tmp >= 7))) {
                return Integer.MAX_VALUE ;
            }
            //判断是否小于 最小32位整数,做了除负数运算,最简单的理解为 -res<bigNum || (-res == -bigNum && tmp >= 8)
            if (is_negative && (res > bigNum || (res == bigNum && tmp >= 8))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + tmp;
            ++i;
        }
        //如果有负号标记则返回负数
        if (is_negative) {
            return -res;
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
