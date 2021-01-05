package com.moses.leet.n0060;


public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] rst = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1; i>=0; i--){
            for(int j=num2.length()-1; j>=0; j--){
                int pos = i+j+1;
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                rst[pos] += a*b;


            }
        }

        int carry = 0;
        for(int k=rst.length-1; k>=0; k--){
            rst[k] += carry;
            carry = rst[k]/10;
            rst[k] = rst[k]%10;
        }

        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for(int i=0; i<rst.length; i++){
            if(found){
                sb.append(rst[i]);
            }else{
                if(rst[i] != 0){
                    found = true;
                    sb.append(rst[i]);
                }
            }
        }
        return found?sb.toString():"0";
    }

    public String multiply1(String num1, String num2){
        int[] rst = new int[num1.length() + num2.length()];

        for(int i=num1.length()-1; i>=0; i--){
            for(int j = num2.length()-1; j>=0; j--){
                int pos = i+j+1;
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                rst[pos] = rst[pos] + n1 * n2;

                //瘦身为十位以下
                int carry = 0;
                for(int k=rst.length-1; k>=0; k--){
                    rst[k] += carry;
                    carry = rst[k]/10;
                    rst[k] = rst[k]%10;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for(int i=0; i<rst.length; i++){
            if(found){
                sb.append(rst[i]);
            }else if(rst[i] != 0){
                sb.append(rst[i]);
                found = true;
            }
        }
        return sb.length()==0?"0":sb.toString();
    }

    public static void main(String[] args) {

        String num1 = "2", num2 = "3";
        System.out.println(new MultiplyStrings().multiply(num1, num2));

        num1 = "9133"; num2 = "0";
        System.out.println(new MultiplyStrings().multiply(num1, num2));

        num1 = "123"; num2 = "456";
        System.out.println(new MultiplyStrings().multiply(num1, num2));

        num1 = "999"; num2 = "99";
        System.out.println(new MultiplyStrings().multiply(num1, num2));
    }


    public String multiplyOld(String num1, String num2){
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        String rst = "0";

        for(int i = char2.length; i>0; i--){
            int posSecond = char2[i-1] - 48;

            StringBuilder sb = new StringBuilder();
            int promote = 0;
            for(int j = char1.length; j>0; j--){
                int posFirst = char1[j-1] - 48;

                int tmp = posSecond * posFirst + promote;
                String tmpStr = tmp+"";
                if(tmpStr.length() == 2) {
                    promote = tmpStr.charAt(0) - 48;
                    sb.insert(0, tmpStr.charAt(1));
                } else {
                    promote = 0;
                    sb.insert(0, tmpStr.charAt(0));
                }
            }
            if(promote != 0){
                sb.insert(0, promote);
            }

            for(int k = 0; k < char2.length -i; k++){
                sb.append('0');
            }
            System.out.println(sb.toString());
            rst = addBigNums(rst, sb.toString());
        }

        return rst;
    }

    private String addBigNums(String num1, String num2){
        char[] char2 = num2.toCharArray();
        char[] char1 = num1.toCharArray();
        int posDif = char2.length - char1.length;
        int promote = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = char2.length; i>0; i--){
            int posSec = char2[i-1] - 48;
            int posFirst = 0;
            if(i-1 >= posDif) {
                posFirst = char1[i - 1 - posDif] - 48;
            }
            int tmp = posSec + posFirst + promote;
            String tmpStr = tmp+"";
            if(tmpStr.length() == 2) {
                promote = tmpStr.charAt(0) - 48;
                sb.insert(0, tmpStr.charAt(1));
            } else {
                promote = 0;
                sb.insert(0, tmpStr.charAt(0));
            }
        }
        if(promote != 0){
            sb.insert(0, promote);
        }
        return sb.toString();
    }


}
