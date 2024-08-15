package org.example.costMonitor;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

public class Cost {
    List<Item> phases = new LinkedList<>();

    public void add(String phase, long cost) {
        phases.add(new Item(phase, cost));
    }

    public long getAllCost() {
        return phases.stream().mapToLong(Item::getCost).sum();
    }

    @Getter
    @AllArgsConstructor
    public static class Item {
        String phase;
        long cost;
    }
}
