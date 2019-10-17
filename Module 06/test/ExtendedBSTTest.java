import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;


class ExtendedBSTTest {

    //<editor-fold desc="Method test: int getNumberOfLeaves()">
    /** Check that getNumberOfLeaves() returns 1 for tree with only 1 Node in total */
    @Test
    void getNumberOfLEaves_Returns1ForTreeWithOnlyOneNode() {
        ExtendedBST<Integer> tree = new ExtendedBST<>();
        tree.insert(10);
        assertThat(tree.getNumberOfLeaves(), equalTo(1));
    }

    /** * Check that method getNumberOfLeaves() returns 2 for a tree with 2 leaves */
    @Test
    void getNumberOfLeaves_Returns2ForTreeWith2Leaves() {
        Integer[] testIntegers = {5, 15, 2, 4};
        ExtendedBST<Integer> tree = new ExtendedBST<>(testIntegers);
        assertThat(tree.getNumberOfLeaves(), equalTo(2));
    }
    //</editor-fold>

    //<editor-fold desc="Method test: int getNumberOfNonLeaves()">
    /** Check that method getNumberOfNonLeaves() returns 0 for a tree with only 1 Node in total */
    @Test
    void getNumberOfNonLeaves_Returns0ForTreeWithOnlyOneNode() {
        ExtendedBST<Integer> tree = new ExtendedBST<>();
        tree.insert(10);
        assertThat(tree.getNumberOfNonLeaves(), equalTo(0));
    }

    /** Check that method getNumberOfNonLeaves() returns 1 for a tree with 4 non-leaf nodes */
    @Test
    void getNumberOfNonLeaves_Returns1ForTreeWith4NonLeaves() {
        Integer[] testIntegers = {123, 10, 140, 70, 5, 155, 27, 124, 75};
        ExtendedBST<Integer> tree = new ExtendedBST<>(testIntegers);
        assertThat(tree.getNumberOfNonLeaves(), equalTo(4));
    }
    //</editor-fold>

    //<editor-fold desc="Method test: TreeNode<E> getNode(E element)">

    /** Check that method getNode() returns given node from given element search */
    @Test
    void getNode_ReturnsNodeInTheTree (){
        Integer[] testIntegers = {15, 30, 1, 7, 8, 44, 140};
        ExtendedBST<Integer> tree = new ExtendedBST<>(testIntegers);
        assertThat(tree.getNode(140).element, equalTo(140));
    }

    /** Check that method getNode() returns null if node for given element is not in tree */
    @Test
    void getNode_ReturnsNull (){
        Integer[] testIntegers = {15, 30, 1, 7, 8, 44, 140};
        ExtendedBST<Integer> tree = new ExtendedBST<>(testIntegers);
        assertThat(tree.getNode(68), is(IsNull.nullValue()));
    }
    //</editor-fold>

    //<editor-fold desc="Method test: ArrayList<E> getPath()">

    /** Check that method getPath() returns path as ArrayList to given element in tree */
    @Test
    void getPath_ReturnsArrayListOfPathToElementInTree() {
        Integer[] testIntegers = {15, 30, 1, 7, 8, 44, 140, 142, 14221, 123, 77, 88};
        ExtendedBST<Integer> tree = new ExtendedBST<>(testIntegers);
        var correctPath = List.of(15, 30, 44, 140, 123, 77, 88);
        assertThat(tree.getPath(88), equalTo(correctPath));
    }

    /** Check that method getPath() returns empty ArrayList if element is not in tree */
    @Test
    void getPath_ReturnsEmptyArrayListIfElementIsNotInTree() {
        Integer[] testIntegers = {15, 30, 1, 7, 8, 44, 140, 142, 14221, 123, 77, 88};
        ExtendedBST<Integer> tree = new ExtendedBST<>(testIntegers);
        var emptyArrayList = List.of();
        assertThat(tree.getPath(9999), equalTo(emptyArrayList));
    }
    //</editor-fold>

    /**
     * Check delete funconaliteten, remove from list and show the path.
     */
    @Test
    void deleteOneIntegerInList_ReturnListWithPath(){
        Integer[] testIntegers = {15, 30, 1, 7, 8, 44, 140, 142, 14221, 123, 77, 88};
        ExtendedBST<Integer> tree = new ExtendedBST<>(testIntegers);
        var correctPath = List.of(15, 30, 44, 140, 88, 77);
        tree.delete(123);
        assertThat(tree.getPath(77), is(correctPath));
    }

    /**
     * Check delete funconaltiten, remove some not in the list and return false.
     */
    @Test
    void deleteOneInteger_NotInList_ReturnFalse(){
        Integer[] testIntegers = {15, 30, 1, 7, 8, 44, 140, 142, 14221, 123, 77, 88};
        ExtendedBST<Integer> tree = new ExtendedBST<>(testIntegers);
        assertThat(tree.delete(1222), is(false));

    }

}