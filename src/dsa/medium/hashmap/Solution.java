package dsa.medium.hashmap;

public class Solution {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1009, 20);
        myHashMap.put(1019, 20);
        myHashMap.put(1018, 20);
        System.out.println(myHashMap.get(1009));
        // myHashMap.resize();
        System.out.println(myHashMap.get(1019));
    }
}
