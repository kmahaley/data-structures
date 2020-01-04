package edu.basic.preparation.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Edge {
    int src;
    int dest;
    int weight;
}

/*
List<Edge> edgeList = new ArrayList<>();
[ {1, 2, 2}, {1, 3, 4}, {2, ,3, 1}, {2, 4, 7} ]
*/
