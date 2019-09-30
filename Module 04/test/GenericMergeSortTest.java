import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class GenericMergeSortTest {
    private GenericMergeSort genericMergeSort = new GenericMergeSort();
    String[] stringToTest = {"9", "8", "7" ,"6", "5", "4", "3", "2", "1"};
    String[] stringSorted = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};


    @Test
    void mergeSortIntegers() {
        /*int[] intArray = {9,8,7,6,5,4,3,2,1};
        List<Integer> intList = new ArrayList<>(intArray.length);
        for (int i : intArray)
            intList.add(Integer.valueOf(i));
        genericMergeSort.mergeSort(intList);*/
        GenericMergeSort.mergeSort(stringToTest);
        assertThat(stringToTest, is(equalTo(stringSorted)));

    }
}