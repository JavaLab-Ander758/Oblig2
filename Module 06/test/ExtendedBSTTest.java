import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class ExtendedBSTTest {

    /**
     * Check that getNumberOfLeaves() returns 1 for tree with only 1 Node in total
     */
    @Test
    void getNumberOfLEaves_Returns1ForTreeWithOnlyOneNode() {
        ExtendedBST<Integer> tree = new ExtendedBST<>();
        tree.insert(10);
        assertThat(tree.getNumberOfLeaves(), equalTo(1));
    }

    /**
     * Check that method getNumberOfLeaves() returns 2 for a tree with 2 leaves
     */
    @Test
    void getNumberOfLeaves_Returns2ForTreeWith2Leaves() {
        Integer[] testIntegers = {5, 15, 2, 4};
        ExtendedBST<Integer> tree = new ExtendedBST<>(testIntegers);
        assertThat(tree.getNumberOfLeaves(), equalTo(2));
    }

    /**
     * Check that method getNumberOfNonLeaves() returns 0 for a tree with only 1 Node in total
     */
    @Test
    void getNumberOfNonLeaves_Returns0ForTreeWithOnlyOneNode() {
        ExtendedBST<Integer> tree = new ExtendedBST<>();
        tree.insert(10);
        assertThat(tree.getNumberOfNonLeaves(), equalTo(0));
    }

    /**
     * Check that method getNumberOfNonLeaves() returns 1 for a tree with 4 non-leaf nodes
     */
    @Test
    void getNumberOfNonLeaves_Returns1ForTreeWith4NonLeaves() {
        Integer[] testIntegers = {123, 10, 140, 70, 5, 155, 27, 124, 75};
        ExtendedBST<Integer> tree = new ExtendedBST<>(testIntegers);
        assertThat(tree.getNumberOfNonLeaves(), equalTo(4));
    }

    @Test
    void getTheElementfromNode_ReturnnotNull(){
        Integer[] testIntegers = {15, 30, 1, 7, 8, 44, 140};
        ExtendedBST<Integer> tree = new ExtendedBST<>(testIntegers);
        assertThat(tree.getNode(140).element, equalTo(140));
    }

    @Test
    void getTheElementfromNode_ReturnNull(){
        Integer[] testIntegers = {15, 30, 1, 7, 8, 44, 140};
        ExtendedBST<Integer> tree = new ExtendedBST<>(testIntegers);
        assertThat(tree.getNode(68), is(IsNull.nullValue()));
    }
}