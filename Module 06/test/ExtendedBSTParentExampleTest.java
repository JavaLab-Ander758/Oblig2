import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ExtendedBSTParentExampleTest {
    /**
     * Check that getNoOfLeaves() returns 1 for tree with only 1 Node in total
     */
    @Test
    void getNoOfLEaves_Returns1ForTreeWithOnlyOneNode() {
        ExtendedBSTParentExample<Integer> tree = new ExtendedBSTParentExample<>();
        tree.insert(10);
        assertThat(tree.getNoOfLeaves(), equalTo(1));
    }

    /**
     * Check that method getNoOfLeaves() returns 2 for a tree with 2 leaves
     */
    @Test
    void getNoOfLeaves_Returns2ForTreeWith2Leaves() {
        Integer[] testIntegers = {5, 15, 2, 4};
        ExtendedBSTParentExample<Integer> tree = new ExtendedBSTParentExample<>(testIntegers);
        assertThat(tree.getNoOfLeaves(), equalTo(2));
    }


}