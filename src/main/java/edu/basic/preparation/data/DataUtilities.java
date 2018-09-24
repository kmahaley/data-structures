package edu.basic.preparation.data;

import edu.basic.preparation.list.MyList;

/**
 *
 * @author km185223
 */
public final class DataUtilities {

    public static int[] getIntegerArray() {
        return new int[]{1, 2, 1, 3, 4, 2, 3};
    }

    public static String getString() {
        return "tactomac";
    }

    public static MyList getDuplicatedElementList(){
        MyList myList = new MyList();
        myList.add(11);
        myList.add(11);
        myList.add(11);
        myList.add(21);
        myList.add(43);
        myList.add(43);
        myList.add(60);
        return myList;
    }

    public static  MyList getListForBasicOperation(){
        MyList myList = new MyList();
        myList.add(10);
        myList.add(40);
        myList.add(70);
        myList.add(90);
        myList.addAtFront(5);
        myList.addInMiddle(75,4);
        myList.add(10);
        myList.add(10);
        return myList;
    }
}
