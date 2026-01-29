//package leetcode.study_plan;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//
//public class RandomizedSet {
//
//    private Map<Integer, Integer> map;
//    private List<Integer> array;
//
//    public RandomizedSet() {
//        map = new HashMap<>();
//        array = new ArrayList<>();
//    }
//
//    public boolean insert(int val) {
//        boolean existed =  map.containsKey(val);
//        if(!existed) {
//            map.put(val, val);
//            array.add(val);
//        }
//        return existed;
//    }
//
//    public boolean remove(int val) {
//        boolean existed =  map.remove(val) != null;
//        if(existed) {
//            boolean a = array.remove(val);
//        }
//        array.set()
//        return existed;
//    }
//
//    public int getRandom() {
//        map.values().
//    }
//}
