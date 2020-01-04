package edu.basic.preparation.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFordShortestPath {


    public static void main(String[] args) {
        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(1,2,4));
        edgeList.add(new Edge(3,2,-10));
        edgeList.add(new Edge(4,3,3));
        edgeList.add(new Edge(1,4,5));

        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 4));
        graph.put(2, Arrays.asList());
        graph.put(3, Arrays.asList(2));
        graph.put(4, Arrays.asList(3));

        Map<Integer, Integer> distanceMap = getDistanceFromSource(1, graph, edgeList);

        System.out.println(distanceMap);
    }

    /**
     * initialize distance map with  Integer.MAX_VALUE for vertices except source
     * for each edge and for each node calculate new distance using, u -> v
     * if( d[v] > [d(u) + weight(u,v)] ) {
     *      d[v] = d(u) + weight(u,v)
     * }
     *
     *
     * @param src calculate distance from source
     * @param graph graph representation
     * @param edgeList edge list with edge as [src, dest, weight]
     * @return distance map with respect to source
     *
     * time complexity = |V-1| * |E|
     * V=no of vertices, E= no of edges
     * reference : https://www.youtube.com/watch?v=FtN3BYH2Zes
     */
    private static Map<Integer, Integer> getDistanceFromSource(int src, Map<Integer, List<Integer>> graph,
                                                               List<Edge> edgeList) {

        Map<Integer, Integer> distanceMap = new HashMap<>();
        distanceMap.put(src, 0);
        List<Integer> vertices = new ArrayList<>();

        graph.keySet().forEach( key -> {
            if(!distanceMap.containsKey(key)) {

                distanceMap.put(key, Integer.MAX_VALUE);
                vertices.add(key);
            }
        });
        // initial distance map
        System.out.println(distanceMap);

        for (Integer vertex : vertices) {
            for (Edge edge: edgeList) {

                int source = edge.src;
                int destination = edge.dest;
                int edgeWeight = edge.weight;

                int weightAtSource = distanceMap.get(source);
                int weightAtDestination = distanceMap.get(destination);

                if(weightAtSource == Integer.MAX_VALUE) continue;
                int newWeightAtDestination = weightAtSource + edgeWeight;
                if(weightAtDestination > newWeightAtDestination) {
                    distanceMap.put(destination, newWeightAtDestination);
                }
            }
        }
        return distanceMap;
    }
}
