package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public String process(String query) {
        String[] api_query = query.split(":", 2);
        String api = api_query[0];
        String msg = api_query[1];
        System.out.println(msg);
        Pattern rAM = Pattern.compile("what is (\\d+) plus (\\d+) multiplied by (\\d+)");
        Matcher mAM = rAM.matcher(msg);
        Pattern rAddition = Pattern.compile("what is (\\d+) plus (\\d+)");
        Matcher mAddition = rAddition.matcher(msg);
        Pattern rMultiply = Pattern.compile("what is (\\d+) multiplied by (\\d+)");
        Matcher mMultiply = rMultiply.matcher(msg);
        Pattern rColor = Pattern.compile("what colour is (\\w+)");
        Matcher mColor = rColor.matcher(msg);
        Pattern rFibo = Pattern.compile("what is the (\\d+)th number in the Fibonacci sequence");
        Matcher mFibo = rFibo.matcher(msg);
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("what is your name")) {
            return "Waffle";
        }
        if (mAM.matches()){
            return String.valueOf(Integer.valueOf(mAM.group(1)) + Integer.valueOf(mAM.group(2)) * Integer.valueOf(mAM.group(3)));
        }
        if (mAddition.matches()){
            return String.valueOf(Integer.valueOf(mAddition.group(1)) + Integer.valueOf(mAddition.group(2)));
        }
        if (mMultiply.matches()){
            return String.valueOf(Integer.valueOf(mMultiply.group(1)) * Integer.valueOf(mMultiply.group(2)));
        }
        if (mColor.matches()){
            if(mColor.group(1).equals("banana")){
                return "yellow";
            }
        }
        if (mFibo.matches()){
            int rank = Integer.valueOf(mFibo.group(1))-1;
            int num1 = 0, num2 = 1;
  
            int counter = 0;
    
            // Iterate till counter is N
            while (counter < rank) {
    
                int num3 = num2 + num1;
                num1 = num2;
                num2 = num3;
                counter = counter + 1;
            }
            return String.valueOf(num1);
        }

        return "";
    }
}
