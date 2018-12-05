package edu.basic.preparation;

import edu.basic.preparation.service.DependencyService;

/**
 * @author kartik mahaley
 */
public class Application {

    public static void main(String[] args) {

        final DependencyService dependencyService = new DependencyService();

        dependencyService.binaryTreeFunctionality();

//        dependencyService.listFunctionality();

//        dependencyService.queueFunctionality();

//        dependencyService.stackFunctionality();

//        dependencyService.stringFunctionality();

//        dependencyService.graphFunctionality();

//        List<String> wizards = new ArrayList<>();
//        wizards.add("1 2");
//        wizards.add("1 3");
//        wizards.add("1 2 3");
//        wizards.add("6");
//        wizards.add("1 2 3");
//        wizards.add("1 2 3");
//        wizards.add("9");
//        wizards.add("1 2 3");
//        wizards.add("1 2 3");
//        wizards.add("1 4");
//        meet(wizards);

    }

//    static List<Integer> meet(List<String> wizards) {
//        List<Integer> path = new ArrayList<>();
//        path.add(0);
//        final Map<Integer, List<Integer>> map = createMap(wizards);
////        System.out.println(map);
//        final ArrayList<Integer> objects = new ArrayList<>();
//        allPaths(0, 0,  wizards.size()-1,objects, 0, map);
//
//        return path;
//    }
//
//    public static void allPaths(Integer curr, int sum, int top, List<Integer> list, int index, Map<Integer, List<Integer>> map) {
//        Math.abs()
//        sum = sum +;
//        list.add(index, root.key);
//        index++;
//
//        //condition for maxSum
//        if (curr == top) {
//            printList(list, index);
//        }
//
//        allPathsFromRootWithGivenSum(root.left, sum, maxSum,list, index);
//        allPathsFromRootWithGivenSum(root.right, sum, maxSum,list, index);
//    }
//
//    private static void printList(List<Integer> list, int index) {
//    }
//
//    public static Map<Integer, List<Integer>> createMap(List<String> wizards) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < wizards.size(); i++) {
//            final List<String> strings = Arrays.asList(wizards
//                    .get(i)
//                    .split(" "));
//            List<Integer> connects = new ArrayList<>();
//            for (int j = 0; j < strings.size(); j++) {
//                connects.add(Integer.valueOf(strings.get(j)));
//
//            }
//            map.put(i, connects);
//        }
//        return map;
//    }
}
