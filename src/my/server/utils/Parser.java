package my.server.utils;

import java.util.ArrayList;

public class Parser {

    public static String helloOut(String str) {
        return str.split(":")[1];
    }


    public static ArrayList<String> parse(String s)
    {
        String str = helloOut(s);
        String[] split = str.split("\\?");
        ArrayList<String> list = new ArrayList<>();
        for (String spletted :
                split) {
                list.add(spletted.trim());
        }
        return list;
    }
}
