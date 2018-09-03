package edu.basic.preparation.service;

import edu.basic.preparation.data.Node;
import edu.basic.preparation.list.MyList;
import edu.basic.preparation.string.StringUtilities;
import org.springframework.stereotype.Service;

/**
 * @author Kartik Mahaley
 */
@Service
public class DependencyService {

    public void list(){
        MyList myList = new MyList();
        myList.add(10);
        myList.add(40);
        myList.add(70);
        myList.add(90);
        myList.addAtFront(5);
        myList.addInMiddle(75,4);
        myList.add(10);
        myList.add(10);
        myList.print();
//        final Node reverseHead = myList.reverse();
//        myList.print(reverseHead);
//        myList.delete(10);
//        myList.print();
        final Node middleElement = myList.middleElement();
        System.out.println("Middle : "+ middleElement.getKey());
    }

    public void stringFunctionality(){

//        StringUtilities.getDuplicateInArrayWindow(DataUtilities.getIntegerArray(), 4);
//        StringUtilities.isStringUnique(DataUtilities.getString());
        StringUtilities.stringURLify("Mr John Smith apple banana",26);
    }
}
