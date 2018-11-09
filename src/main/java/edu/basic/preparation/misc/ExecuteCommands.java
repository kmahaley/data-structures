package edu.basic.preparation.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * DEPEND TELNET TCPIP NETCARD, telnet depend on other two
 * INSTALL TELNET install telnet along with its dependency
 * REMOVE TELNET remove telnet
 * LIST list of all element in the system
 *
 * DEPEND TELNET TCPIP NETCARD
 * DEPEND TCPIP NETCARD
 * DEPEND NETCARD TCPIP
 * TCPIP depends on NETCARD, ignoring command
 * DEPEND DNS TCPIP NETCARD
 * DEPEND BROWSER TCPIP HTML
 * INSTALL NETCARD
 * Installing NETCARD
 * INSTALL TELNET
 * Installing TCPIP
 * Installing TELNET
 * INSTALL foo
 * Installing foo
 * REMOVE NETCARD
 * NETCARD is still needed
 * INSTALL BROWSER
 * Installing HTML
 * Installing BROWSER
 * INSTALL DNS
 * Installing DNS
 * LIST
 * NETCARD
 * TCPIP
 * TELNET
 * foo
 * HTML
 * BROWSER
 * DNS
 * REMOVE TELNET
 * Removing TELNET
 * REMOVE NETCARD
 * NETCARD is still needed
 * REMOVE DNS
 * Removing DNS
 * REMOVE TCPIP
 * TCPIP is still needed
 * REMOVE HTML
 * HTML is still needed
 * REMOVE BROWSER
 * Removing BROWSER
 * REMOVE TCPIP
 * Removing TCPIP
 * LIST
 * foo
 * HTML
 * NETCARD
 * END
 */
public class ExecuteCommands {
    //Dependency map of items
    public static Map<String, List<String>> dependencyMap = new HashMap<>();

    //Map that shows what need to uninstalled when command is issued
    public static Map<String, List<String>> installDependencyMap = new LinkedHashMap<>();

    //Installed items in the system
    public static Set<String> installedItems = new HashSet<>();

    public static void main(String[] args) {

        //read input from stdin
        Scanner scan = new Scanner(System.in);

        while (true) {
            String line = scan.nextLine();

            //no action for empty input
            if (line == null || line.length() == 0) {
                continue;
            }

            //the END command to stop the program
            if ("END".equals(line)) {
                System.out.println("END");
                break;
            }

            //Please provide your implementation here
            processLineCommand(line);
        }

    }

    /**
     * processLineCommand function call helper function based on command in the request
     *
     * @param commandLine command line containing the command to build system
     */
    public static void processLineCommand(String commandLine){

        final String[] commandWithDependencies = commandLine.split("\\s");
        final String command = commandWithDependencies[0];

        switch (command) {

            case "DEPEND": buildDependency(commandWithDependencies);
                break;
            case "INSTALL": installItem(commandWithDependencies);
                break;
            case "REMOVE": removeItem(commandWithDependencies);
                break;
            case "LIST": printItemsInstalled();
                break;
            default: break;
        }
    }

    /**
     * Build dependency installation map
     * index (0) = command (DEPEND), iterate over the other elements on command line
     *
     * @param commandLineArray command line
     */
    private static void buildDependency(String[] commandLineArray) {

        final List<String> commandLine = Arrays.asList(commandLineArray);
        final int sizeOfCommandLine = commandLine.size();
        int currentItem = 1;
        int dependentItemIndex = currentItem + 1;
        if (dependentItemIndex < sizeOfCommandLine) {

            final String item = commandLine.get(currentItem);

            final List<String> dependentItems = new ArrayList<>();
            if(addValidDependency(commandLine, item, dependentItemIndex)){
                dependentItems.addAll(commandLine.subList(dependentItemIndex, sizeOfCommandLine));
                dependencyMap.put(item, dependentItems);
            }

        }
    }

    /**
     * Throw message if dependency dependent on item.
     *
     * for eg. TCPIP depends on NETCARD, ignoring command
     *
     * @param commandLine command line
     * @param item item to be added in the installation map
     * @param fromIndex dependencies of the item
     */
    private static boolean addValidDependency(List<String> commandLine, String item, int fromIndex) {

        final String dependent = commandLine.get(fromIndex);
        if(dependencyMap.containsKey(dependent) && dependencyMap
                .get(dependent).contains(item)){
            System.out.println(dependent+" depends on "+item+", ignoring command");
            return false;
        }
        return true;
    }

    /**
     * Install items
     *
     * @param commandWithDependencies items to be installed
     */
    private static void installItem(String[] commandWithDependencies) {
        final String itemToInstall = commandWithDependencies[1];

        if(itemToInstall !=null && !itemToInstall.isEmpty()){

            if(installedItems.contains(itemToInstall)){
                System.out.println(itemToInstall+" is already installed");
            } else {
                final List<String> dependencies = dependencyMap.get(itemToInstall);
                Set<String> installationList = new HashSet<>();

                depthFirstTraversal(itemToInstall, dependencies, installationList);
                installItems(installationList);

            }

        }
    }

    /**
     * Add item in installationList when it does not have any dependencies
     *
     * @param item item to install
     * @param dependencies list of dependent items of above item
     * @param installationList list of items be to installed
     */
    private static void depthFirstTraversal(String item, List<String> dependencies, Set<String> installationList) {

        if(dependencies == null || dependencies.size() == 0){
            installationList.add(item);
            installDependencyMap.put(item, new ArrayList<>());
        } else {
            for(int i =0; i< dependencies.size() ;i++){
                String newItem = dependencies.get(i);
                final List<String> newDependencies = dependencyMap.get(newItem);
                depthFirstTraversal(newItem, newDependencies, installationList);
            }
            installationList.add(item);
            installDependencyMap.put(item, dependencies);
        }
    }

    /**
     * Install items to the system
     *
     * @param installationList items to install
     */
    private static void installItems(Set<String> installationList) {
        installationList.forEach(item -> {

            if(!installedItems.contains(item)){

                installedItems.add(item);
                System.out.println("Installing "+item);
            }

        });
    }

    /**
     * Remove item from the system
     *
     * @param commandWithDependencies command to remove the item
     */
    private static void removeItem(String[] commandWithDependencies) {
        final String itemToRemove = commandWithDependencies[1];

        Set<String> toBeRemoved = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.add(itemToRemove);

        while (!queue.isEmpty()) {
            final String polled = queue.poll();
            if (!isItemRequired(polled)) {
                toBeRemoved.add(polled);
            } else {
                if(polled.equals(itemToRemove)){
                    System.out.println(polled+" is still needed");
                }
            }
            queue.addAll(installDependencyMap.get(polled));
        }

        for (String item : toBeRemoved) {
            System.out.println("Removing "+item);
            installedItems.remove(item);
            installDependencyMap.remove(item);
        }

    }

    private static boolean isItemRequired(String tobeRemoved) {
        for (String key : installDependencyMap.keySet()) {
            final boolean anyMatch = installDependencyMap
                    .get(key)
                    .stream()
                    .anyMatch(item -> tobeRemoved.equals(item));
            if (anyMatch) {
                return anyMatch;
            }
        }
        return false;
    }


    /**
     * Print items installed in the system
     */
    private static void printItemsInstalled() {
        installedItems.forEach( item -> System.out.println(item));
    }
}
