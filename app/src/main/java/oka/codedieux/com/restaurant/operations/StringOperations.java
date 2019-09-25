package oka.codedieux.com.restaurant.operations;

/**
 * Created by meliodas on 25/06/2019.
 */

public class StringOperations {

    public static String parseServerTags(String input){
       input= input.replaceAll("newLine","\n");
        input= input.replaceAll("boldStart","");
        input=input.replaceAll("boldEnd","");
        input=input.replaceAll("placeQuote","'");
        return input;
    }


}
