import java.util.*;


// TC -> Best/Avg/Worst => O(nlog(n)) 
// SC -> O(log(n) + n) => O(n) -> (Recursive stack space O(log(n)), Auxillary array O(n) used during merge() function)

public class MergeSort {

    private static List<Integer> merge(int start, int mid, int end, List<Integer> arr){
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i=start;i<=mid;i++){
            left.add(arr.get(i));
        }

        for(int i=mid+1;i<=end;i++){
            right.add(arr.get(i));
        }

        int i=0,j=0,k=start;

        while(i < left.size() && j < right.size()){
            if(left.get(i) <= right.get(j)){
                arr.set(k,left.get(i));
                i++;
            }
            else{
                arr.set(k,right.get(j));
                j++;
            }
            k++;
        }

        while(i < left.size()){
            arr.set(k,left.get(i));
            i++;
            k++;
        }

        while(j < right.size()){
            arr.set(k,right.get(j));
            j++;
            k++;
        }

        return arr;
    }

    public static void mergeSort(int start, int end, List<Integer> arr){
        if(start >= end){
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(start, mid, arr);
        mergeSort(mid+1, end, arr);
        merge(start, mid, end, arr);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5,3,4,6,1,2,3));

        System.err.println("Before Sorting arr - " + arr);

        int start = 0, end = arr.size()-1;
        mergeSort(start, end, arr);

        System.err.println("After Sorting arr - " + arr);        
    }
}

