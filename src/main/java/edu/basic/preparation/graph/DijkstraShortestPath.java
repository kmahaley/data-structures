package edu.basic.preparation.graph;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraShortestPath {

    public static class WeightedComparator implements Comparator<WeightedNode> {

        // decreasing order of priority queue. least weight on the top
        @Override
        public int compare(WeightedNode o1, WeightedNode o2) {
            return o1.weight - o2.weight;
        }
    }

    public static void main(String[] args) {

        /**
         * Map of source and destination with weight
         */
        Map<Integer, Map<Integer, Integer>> graphWithWeightedDestination = new HashMap() {{
           put(1, new HashMap<Integer, Integer>() {{
               put(2,2);
               put(3,4);
           }});
            put(2, new HashMap<Integer, Integer>() {{
                put(4,7);
                put(3,1);
            }});
            put(3, new HashMap<Integer, Integer>() {{
                put(5,3);
            }});
            put(4, new HashMap<Integer, Integer>() {{
                put(6,1);
            }});
            put(5, new HashMap<Integer, Integer>() {{
                put(4,2);
                put(6,5);
            }});
            put(6, new HashMap<Integer, Integer>() );
        }};


        Map<Integer, Integer> distanceMap = getDistanceFromSource(1, graphWithWeightedDestination);
        System.out.println(distanceMap);
    }

    /**
     * initialize distance map with Integer.MAX_VALUE for vertices except source (source = 0).
     * same goes for priority queue.
     * pull smallest element from priority queue. get its destination nodes from graphWithWeightedDestination
     * calculate new distance and put back to priority queue.
     * do this until priority queue is not empty
     * for each edge and for each node calculate new distance using, u -> v
     * if( d[v] > [d(u) + weight(u,v)] ) {
     *      d[v] = d(u) + weight(u,v)
     * }
     * @param start source node from which distance is calculated
     * @param graphWithWeightedDestination graph with src and dest nodes and their weight
     * @return distance map
     * time complexity = |V| * |no of edges from that vertices|
     * V=no of vertices
     * In complete graph V = n, no of edges from each V = n-1
     * time complexity = n (n-1)
     * reference https://www.youtube.com/watch?v=XB4MIexjvY0
     */
    private static Map<Integer, Integer> getDistanceFromSource(int start,
                                                               Map<Integer, Map<Integer, Integer>> graphWithWeightedDestination) {

        Map<Integer, Integer> distanceMap = new HashMap<>();
        PriorityQueue<WeightedNode> priorityQueue = new PriorityQueue<>(new WeightedComparator());

        //initialize distance map
        //initialize priority queue with node and weight
        graphWithWeightedDestination.forEach((key, value) -> {
            if(start == key) {
                priorityQueue.add(new WeightedNode(key, 0));
                distanceMap.put(key, 0);
            } else {
                priorityQueue.add(new WeightedNode(key, Integer.MAX_VALUE));
                distanceMap.put(key, Integer.MAX_VALUE);
            }
        });

        // remove least weighted node one at a time until its empty
        while (!priorityQueue.isEmpty()) {
            WeightedNode leastWeightedNode = priorityQueue.poll();
            int src = leastWeightedNode.dest;
            int weightAtSource = leastWeightedNode.weight;

            final Map<Integer, Integer> children = graphWithWeightedDestination.get(src);
            for (Integer key: children.keySet()) {
                int dest = key;
                int weightAtEdge = children.get(key);
                int weightAtDestination = distanceMap.get(dest);

                // weight at source is maximum then continue
                if(weightAtSource == Integer.MAX_VALUE) continue;

                int newWeightAtDestination = weightAtSource + weightAtEdge;
                if(weightAtDestination > newWeightAtDestination) {
                    distanceMap.put(dest, newWeightAtDestination);
                    modifyPriorityQueueWeightedNodeIfExists(dest, newWeightAtDestination, priorityQueue);
                }
            }
        }

        return distanceMap;
    }

    /**
     * find element in priority queue with dest and remove old value and add new dest and newWeightAtDestination
     * @param dest to update node in priority queue
     * @param newWeightAtDestination new weight
     * @param priorityQueue queue
     */
    private static void modifyPriorityQueueWeightedNodeIfExists(int dest,
                                                                int newWeightAtDestination,
                                                                PriorityQueue<WeightedNode> priorityQueue) {

        final Iterator<WeightedNode> iterator = priorityQueue.iterator();

        while (iterator.hasNext()) {
            WeightedNode current = iterator.next();
            if(current.dest == dest) {
                iterator.remove();
                priorityQueue.add(new WeightedNode(dest, newWeightAtDestination));
                return;
            }
        }
    }

}
