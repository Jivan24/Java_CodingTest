package com.test;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class PlaceOrder {

    public static void main(String[] args) {

        Map<String, Double> map = new HashMap<String, Double>();
        map.put("Item1", 2.0);
        map.put("Item2", 2.5);
        map.put("Item3", 4.5);
        PlaceOrder ob = new PlaceOrder();

        System.out.println(ob.fetchItem(map, 4.5));

    }

    List<String> fetchItem(Map<String, Double> menu, double totalAmount) {
        if (totalAmount < 0) {
            try {
                throw new Exception("Not a valid Amount");
            } catch (Exception e) {
                System.out.println("Error occurred");
            }
        }
        List<String> output = new ArrayList<String>();
        menu = menu.entrySet().stream().sorted(Collections
                .reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        for (Map.Entry<String, Double> entry : menu.entrySet()) {
            if (entry.getValue() <= totalAmount) {
                totalAmount -= entry.getValue();
                output.add(entry.getKey());

            }
        }
        return output;
    }


}
