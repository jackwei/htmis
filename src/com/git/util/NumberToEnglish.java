/*
 * Created on 2006-2-9
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.git.util;


/**
 * @author Administrator
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class NumberToEnglish {
    private static String nStr = "";

    public static String n2e(String nValue) {
        String input = nValue + "";
        String numName = "";
        if (input.length() == 0) {
            //alert ('������һ������'+input);
            return "Zero";
        } else {
            //�жϸ���
            boolean neg = false;
            if (input.charAt(0) == '-') {
                neg = true;
                input = input.substring(1);
            }

            //�ҵ�С����λ�ò�����λ�úŸ���pos
            int pos = input.indexOf(".");
            
            String pdec = input.substring(pos + 1);//ȡС���
            if (Integer.parseInt(pdec)==0){
                pdec="";
                input = input.substring(0, pos);
                pos = -1;
            }
            
            if (pos > 0) {
                numName = i2e(input.substring(0, pos));//ȡ�����
                
                if (pdec.length() == 1)
                    numName = numName + "," + i2e(pdec.charAt(0) + "0")
                            + " Cents";
                else {
                    numName = numName + "," + i2e(pdec.substring(0, 2))
                            + " Cents";
                }
            } else {
                numName = i2e(input) + " Only";
            }

            //��ͷ��׷�Ӹ���˵��
            if (neg) {
                return "Negative " + numName;
            } else {
                return numName;
            }
        }
    }

    private static String d0(int x) { // single digit terms
        switch (x) {
        case 0:
            nStr = " Zero";
            break;
        case 1:
            nStr = " One";
            break;
        case 2:
            nStr = " Two";
            break;
        case 3:
            nStr = " Three";
            break;
        case 4:
            nStr = " Four";
            break;
        case 5:
            nStr = " Five";
            break;
        case 6:
            nStr = " Six";
            break;
        case 7:
            nStr = " Seven";
            break;
        case 8:
            nStr = " Eight";
            break;
        case 9:
            nStr = " Nine";
            break;
        default:
            nStr = "Not a Number";
        }
        return nStr;
    }

    private static String d1(int x) { // single digit terms
        switch (x) {
        case 0:
            nStr = "";
            break;
        case 1:
            nStr = " One";
            break;
        case 2:
            nStr = " Two";
            break;
        case 3:
            nStr = " Three";
            break;
        case 4:
            nStr = " Four";
            break;
        case 5:
            nStr = " Five";
            break;
        case 6:
            nStr = " Six";
            break;
        case 7:
            nStr = " Seven";
            break;
        case 8:
            nStr = " Eight";
            break;
        case 9:
            nStr = " Nine";
            break;
        default:
            nStr = "Not a Number";
        }
        return nStr;
    }

    private static String d2(int x) { // 10x digit terms
        switch (x) {
        case 0:
            nStr = "";
            break;
        case 1:
            nStr = "";
            break;
        case 2:
            nStr = " Twenty";
            break;
        case 3:
            nStr = " Thirty";
            break;
        case 4:
            nStr = " Forty";
            break;
        case 5:
            nStr = " Fifty";
            break;
        case 6:
            nStr = " Sixty";
            break;
        case 7:
            nStr = " Seventy";
            break;
        case 8:
            nStr = " Eighty";
            break;
        case 9:
            nStr = " Ninety";
            break;
        default:
            nStr = "Not a Number";
        }
        return nStr;
    }

    private static String d3(int x) { // teen digit terms
        switch (x) {
        case 0:
            nStr = " Ten";
            break;
        case 1:
            nStr = " Eleven";
            break;
        case 2:
            nStr = " Twelve";
            break;
        case 3:
            nStr = " Thirteen";
            break;
        case 4:
            nStr = " Fourteen";
            break;
        case 5:
            nStr = " Fifteen";
            break;
        case 6:
            nStr = " Sixteen";
            break;
        case 7:
            nStr = " Seventeen";
            break;
        case 8:
            nStr = " Eighteen";
            break;
        case 9:
            nStr = " Nineteen";
            break;
        default:
            nStr = "Not a Number";
        }
        return nStr;
    }

    private static String i2e(String input) {
        int inputlength = input.length();
        int x = 0;
        String teen1 = "";
        String teen2 = "";
        String teen3 = "";
        String numName = "";
        String invalidNum = "";
        String a1 = ""; // for insertion of million, thousand, hundred
        String a2 = "";
        String a3 = "";
        String a4 = "";
        String a5 = "";
        String[] digit = new String[inputlength + 1]; // stores output
        for (int i = 0; i < inputlength; i++) {
            // puts digits into array
            digit[inputlength - i] = String.valueOf(input.charAt(i));
        }
        String[] store = new String[10]; // store output
        for (int i = 0; i < inputlength; i++) {
            x = inputlength - i;
            switch (x) { // assign text to each digit
            case 9:
                store[x] = d1(Integer.parseInt(digit[x]));
                break;
            case 8:
                if (digit[x].equals("1")) {
                    teen3 = "yes";
                } else {
                    teen3 = "";
                }
                store[x] = d2(Integer.parseInt(digit[x]));
                break;
            case 7:
                if (teen3.equals("yes")) {
                    teen3 = "";
                    d3(Integer.parseInt(digit[x]));
                } else {
                    d1(Integer.parseInt(digit[x]));
                }
                store[x] = nStr;
                break;
            case 6:
                d1(Integer.parseInt(digit[x]));
                store[x] = nStr;
                break;
            case 5:
                if (digit[x].equals("1")) {
                    teen2 = "yes";
                } else {
                    teen2 = "";
                }
                d2(Integer.parseInt(digit[x]));
                store[x] = nStr;
                break;
            case 4:
                if (teen2.equals("yes")) {
                    teen2 = "";
                    d3(Integer.parseInt(digit[x]));
                } else {
                    d1(Integer.parseInt(digit[x]));
                }
                store[x] = nStr;
                break;
            case 3:
                d1(Integer.parseInt(digit[x]));
                store[x] = nStr;
                break;
            case 2:
                if (digit[x].equals("1")) {
                    teen1 = "yes";
                } else {
                    teen1 = "";
                }
                d2(Integer.parseInt(digit[x]));
                store[x] = nStr;
                break;
            case 1:
                if (teen1.equals("yes")) {
                    teen1 = "";
                    d3(Integer.parseInt(digit[x]));
                } else {
                    d1(Integer.parseInt(digit[x]));
                }
                store[x] = nStr;
                break;
            }
            if (store[x].equals("Not a Number")) {
                invalidNum = "yes";
            }
            ;
            switch (inputlength) {
            case 1:
                store[2] = "";
            case 2:
                store[3] = "";
            case 3:
                store[4] = "";
            case 4:
                store[5] = "";
            case 5:
                store[6] = "";
            case 6:
                store[7] = "";
            case 7:
                store[8] = "";
            case 8:
                store[9] = "";
            }
            if (!isEmpty(store[9])) {
                a1 = " Hundred";
                if (!isEmpty(store[8]) || !isEmpty(store[7])) {
                    a1 += " and";
                }
            } else {
                a1 = "";
            }
            if ((!isEmpty(store[9])) || (!isEmpty(store[8]))
                    || (!isEmpty(store[7]))) {
                a2 = "Million ";
            } else {
                a2 = "";
            }
            if (!isEmpty(store[6])) {
                a3 = " Hundred";
                if (!isEmpty(store[5]) || !isEmpty(store[4])) {
                    a3 += " and";
                }
            } else {
                a3 = "";
            }
            if ((!isEmpty(store[6])) || (!isEmpty(store[5]))
                    || (!isEmpty(store[4]))) {
                a4 = " Thousand";
            } else {
                a4 = "";
            }
            if (!isEmpty(store[3])) {
                a5 = " Hundred";
                if (!isEmpty(store[2]) || !isEmpty(store[1])) {
                    a5 += " and";
                }
            } else {
                a5 = "";
                if (!isEmpty(store[2]) || !isEmpty(store[1])) {
                }
            }
        }
        // add up text, cancel if invalid input found
        if (invalidNum.equals("yes")) {
            numName = "�Բ���������Ĳ�������!";
        } else {
            numName = store[9] + a1 + store[8] + store[7] + a2 + store[6] + a3
                    + store[5] + store[4] + a4 + store[3] + a5 + store[2]
                    + store[1];
        }
        store[1] = "";
        store[2] = "";
        store[3] = "";
        store[4] = "";
        store[5] = "";
        store[6] = "";
        store[7] = "";
        store[8] = "";
        store[9] = "";
        if (numName.equals("")) {
            numName = " Zero ";
        }
        ;
        return numName;
    }
    private static boolean isEmpty(String str) {
        return str == null || str.equals("")?true :false;
    }
}