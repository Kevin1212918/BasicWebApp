package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public String process(String query) {
        System.out.println(query);
        String[] api_query = query.split(":", 2);
        String api = api_query[0];
        String msg = api_query[1];
        Pattern rAddition = Pattern.compile("what is (\\d+) plus (\\d+)");
        Matcher mAddition = rAddition.matcher(msg);
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
        return "";
    }
}
