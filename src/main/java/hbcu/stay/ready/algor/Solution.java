package hbcu.stay.ready.algor;
import java.util.*;

public class Solution {

    public Boolean harmlessRansomNote(String message , String magazineText){

        HashMap<String, Integer> messageDictionary = createDictionary(message);
        HashMap<String, Integer> magazineTextDictionary = createDictionary(magazineText);
        for (Map.Entry<String, Integer> entry: messageDictionary.entrySet()){
            String word = entry.getKey();
            if(magazineTextDictionary.containsKey(word)){
                String wordTwo = word;
                if (messageDictionary.get(word) > magazineTextDictionary.get(wordTwo)){
                    return false;
                }
            }
        }



        return true;
    }

    private HashMap<String, Integer> createDictionary(String input){

        HashMap<String, Integer> dictionary = new HashMap<>();

        String[] list = input.split("\\W+");

        for (String word: list){
            if (!dictionary.containsKey(word)){
                dictionary.put(word, 1);
            }
            else{
                dictionary.put(word, dictionary.get(word) + 1);
            }
        }
        return dictionary;
    }




}
