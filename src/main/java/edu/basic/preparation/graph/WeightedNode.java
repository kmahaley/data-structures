package edu.basic.preparation.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class WeightedNode {
    int dest;
    int weight;
}

/*
key is source and value is list of destination node and weight
Map<Integer, List<WeightedNode>> graphWithWeightedNode = new HashMap<>();
{
        {1, [{2,2},{3,4}] },
        {2, [{4,7},{3,1}] },
        {5, [{4,2},{6,5}] }
}*/
