package com.training.two.util;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<String> nodes = new ArrayList<>();

    public void add(String node) {
        nodes.add(node);
    }

    public List<String> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}
