package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public String process(String query) {
        String[] api_query = query.split(":", 2);
        String api = api_query[0];
        String msg = api_query[1];
        Pattern rAddition = Pattern.compile("what is (\\d+) plus (\\d+)");
        Matcher mAddition = rAddition.matcher(msg);
        Pattern rMultiply = Pattern.compile("what is (\\d+) multiplied by (\\d+)");
        Matcher mMultiply = rMultiply.matcher(msg);
        Pattern rColor = Pattern.compile("what colour is \\w+");
        Matcher mColor = rColor.matcher(msg);
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("what is your name")) {
            return "Waffle";
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
        return "";
    }
}
