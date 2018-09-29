package edu.basic.preparation.service;

import static edu.basic.preparation.data.DataUtilities.getDuplicatedElementList;
import static edu.basic.preparation.data.DataUtilities.getListForBasicOperation;
import static edu.basic.preparation.data.DataUtilities.getTwoIntersectedList;
import edu.basic.preparation.data.Node;
import edu.basic.preparation.list.MyList;
import static edu.basic.preparation.list.MyList.findIntersectedNode;
import static edu.basic.preparation.list.MyList.printFromNode;
import static edu.basic.preparation.list.MyList.removeDuplicates;
import edu.basic.preparation.string.StringUtilities;
import org.springframework.stereotype.Service;

/**
 * @author Kartik Mahaley
 */
@Service
public class DependencyService {

    public void listFunctionality(){
        final MyList listForBasicOperation = getListForBasicOperation();
        System.out.println("********* basic list operation ***********");
        listForBasicOperation.print();

        final Node middleElement = listForBasicOperation.middleElement();
        System.out.println("Middle : "+ middleElement.getKey());

        System.out.println("********* delete list node operation ***********");
        listForBasicOperation.delete(10);
        listForBasicOperation.print();

        System.out.println("********* reverse list operation ***********");
        final Node reverseHead = listForBasicOperation.reverse();
        printFromNode(reverseHead);

        System.out.println("********* remove duplicate elements *******");
        final MyList duplicatedElementList = getDuplicatedElementList();
        System.out.print("original list : ");
        printFromNode(duplicatedElementList.getHead());
        removeDuplicates(duplicatedElementList.getHead());

        System.out.println("********* find intersected node from list *******");
        Node intersection = findIntersectedNode(getTwoIntersectedList());
        printFromNode(intersection);
    }

    public void stringFunctionality(){

//        StringUtilities.getDuplicateInArrayWindow(DataUtilities.getIntegerArray(), 4);
//        StringUtilities.isStringUnique(DataUtilities.getString());
//        StringUtilities.stringURLify("Mr John Smith apple banana     ",26);
        StringUtilities.isPermutationPalindrome("apaa");
    }
}
