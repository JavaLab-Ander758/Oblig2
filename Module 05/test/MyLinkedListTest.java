import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyLinkedListTest {
    //<editor-fold desc="Method test: contains(Object e)">
    @Test
    void containsReturnsTrueIfObjectExists() {
        MyLinkedList myLinkedList = new MyLinkedList();
        String stringToAdd = "Los Angeles";
        String stringToFind = "Los Angeles";
        myLinkedList.add(stringToAdd);
        assertTrue(myLinkedList.contains(stringToFind));
        // Returns true as of 7. Oct 17:45 due to method not implemented yet..
    }
    @Test
    void containsReturnsFalseIfObjectDoesNotExist() {
        MyLinkedList myLinkedList = new MyLinkedList();
        String test = "This String does not exist in MyLinkedList";
        assertFalse(myLinkedList.contains(test));
    }
    //</editor-fold>

    //<editor-fold desc="Method test: get(int index)">
    @Test
    void getReturnsCorrectElementAtGivenIndex() {
        MyLinkedList myLinkedList = new MyLinkedList();
        String firstString = "First element";
        String secondsString = "Second element";
        myLinkedList.add(firstString);
        myLinkedList.add(secondsString);
        assertThat(myLinkedList.get(1), equalTo(secondsString));
    }
    @Test
    void getReturnsNullIFElementDoesNotExists() {
        MyLinkedList myLinkedList = new MyLinkedList();
        assertThat(myLinkedList.get(0), equalTo(null));
    }
    //</editor-fold>

    //<editor-fold desc="Method test: indexOf(Object e)">
    @Test
    void indexOfReturnsCorrectIndexOfGivenElement() {
        MyLinkedList myLinkedList = new MyLinkedList();
        String firstString = "First element";
        String secondString = "Second element";
        myLinkedList.add(firstString);
        myLinkedList.add(secondString);
        assertThat(myLinkedList.indexOf(secondString), equalTo(1));
    }
    @Test
    void indexOfReturnsErrorValueIfElementDoesNotExist() {
        MyLinkedList myLinkedList = new MyLinkedList();
        String test = "This String does not exist in MyLinkedList";
        assertThat(myLinkedList.indexOf(test), equalTo(-1));
    }
    //</editor-fold>

    //<editor-fold desc="Method test: lastIndexOf(E e)">
    @Test
    void lastIndexOfReturnsCorrectIndexOfElement() {
        MyLinkedList myLinkedList = new MyLinkedList();
        String firstString = "Anders";
        String secondString = "Alexander";
        String thirdString = "Alexander";
        myLinkedList.add(firstString);
        myLinkedList.add(secondString);
        myLinkedList.add(thirdString);
        assertThat(myLinkedList.lastIndexOf(thirdString), equalTo(2));
    }
    @Test
    void lastIndexOfReturnsErrorValueIfElementNotInList() {
        MyLinkedList myLinkedList = new MyLinkedList();
        String test = "This String does not exist in MyLinkedList";
        assertThat(myLinkedList.lastIndexOf(test), equalTo(-1));
    }
    //</editor-fold>

    //<editor-fold desc="Method test: set(int index, E e)">
    // TODO: add test for method: 'set'
    //</editor-fold>



}