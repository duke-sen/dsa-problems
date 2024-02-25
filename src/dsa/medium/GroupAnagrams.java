package dsa.medium;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringAndAnagrams = new HashMap<>();

        for (String str : strs) {
            String sortedString = sortString(str);
            if (!stringAndAnagrams.containsKey(sortedString)) {
                stringAndAnagrams.put(sortedString, new ArrayList<>());
            }
            stringAndAnagrams.get(sortedString).add(str);
            /*List<String> groupingForThisString = stringAndAnagrams.getOrDefault(sortedString, new ArrayList<>());
            groupingForThisString.add(str);
            stringAndAnagrams.put(sortedString, groupingForThisString);*/
        }

        return new ArrayList<>(stringAndAnagrams.values());
    }

    private String sortString(String str) {
        char[] characters = str.toCharArray();
        Arrays.sort(characters);
        return Arrays.toString(characters);
    }

    public static void main(String[] args) {
        String[] elements = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(elements));
    }
}
