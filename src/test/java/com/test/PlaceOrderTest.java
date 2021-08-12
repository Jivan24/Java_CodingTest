package com.test;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaceOrderTest {


    @Test
    public void testFetchItem() {

        Map<String, Double> orderMap = new HashMap<String, Double>();
        orderMap.put("Item1", 2.0);
        orderMap.put("Item2", 2.5);
        orderMap.put("Item3", 4.5);
        PlaceOrder ob = new PlaceOrder();
        List<String> outputItems = ob.fetchItem(orderMap,5);

        assertTrue(outputItems.contains("Item3"));
    }


}
