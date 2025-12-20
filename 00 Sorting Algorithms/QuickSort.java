import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TC -> Best/Avg => O(nlog(n)) 
//    -> Worst => O(n*n) (quadratic) -> if pivot is maximum or minimum element of the array happens when the array already sorted in either of ascending or descending order 

// SC -> Best/Avg  => O(log(n)) (Recursive stack space O(log(n)))
//       Worst  => O(n) (Recursive stack space O(n), because highly unbalanced partiions as a result recursive depth increases)

public class QuickSort {

    private static int partition(int start, int end, List<Integer> arr){
        int i = start;
        int j = end;
        int pivot = start;

        while(i < j){
            // from left we need to find a element greater than pivot element
            while(i < j && arr.get(i) < arr.get(pivot)){
                i++;
            }

            // from right we need to find a element lower than pivot element
            while(i < j && arr.get(j) >= arr.get(pivot)){
                j--;
            }

            // swap if i < j
            if(i < j){
                Integer temp = arr.get(i); // temp = arr[i]
                arr.set(i, arr.get(j)); // arr[i] = arr[j]
                arr.set(j, temp); // arr[j] = temp
            }
        }

        // swap pivot with jth index
        Integer temp = arr.get(pivot);
        arr.set(pivot, arr.get(j)); 
        arr.set(j, temp); 

        // now we partitoned array such that, all elements before pivot's new position are lower and all elements after pivot's new position are greater than pivot

        return j;
    }

    private static void quickSort(int start, int end, List<Integer> arr){
        if(start >= end){
            return;
        }
        

        // Logic -> Consider the first element as Pivot and Partition the Array into 2 sub-parts such that left sub-part has elements lower than pivot and right sub-part has elements highr than pivot
        // apply the same logic on smaller sub-array as well until array is completely sorted

        int partitionIndex = partition(start, end, arr);
        quickSort(start, partitionIndex, arr);
        quickSort(partitionIndex+1, end, arr);
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5,3,4,6,1,2,3));

        System.err.println("Before Sorting arr - " + arr);

        int start = 0, end = arr.size()-1;
        quickSort(start, end, arr);

        System.err.println("After Sorting arr - " + arr);       
    }
}
