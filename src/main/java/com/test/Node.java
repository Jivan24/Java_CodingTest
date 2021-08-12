package com.test;

import java.util.ArrayList;
import java.util.List;

class Node {
    public String value;
    public List<Node> next;

    public Node(String value) {
        this.value = value;
        this.next = new ArrayList<>();
    }

    public String getValue() {
        return value;
    }

    public List<Node> getNext() {
        return next;
    }

}
