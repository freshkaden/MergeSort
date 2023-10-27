import java.util.ArrayList;
import java.util.Random;

public class SortCompare {
    public static void main(String[] args){
        // create random array list of 5000 integers
        ArrayList<Integer> list = generateRand(5000);

        ArrayList<Integer> bubSortList = new ArrayList<>(list);
        ArrayList<Integer> mergeSortList = new ArrayList<>(list);


        // keep track of how long it takes to complete the bubble sort function and then output
        long start = System.nanoTime();
        bubbleSort(bubSortList);
        long end = System.nanoTime();
        long bubbleTime = end - start;
        System.out.println("Time to complete bubble sort: " + bubbleTime);

        // keep track of how long it takes to complete the merge sort function and then output

        start = System.nanoTime();
        mergeSort(mergeSortList);
        end = System.nanoTime();
        long mergeTime = end - start;
        System.out.println("Time to complete merge sort: " + mergeTime);

    }

    public static ArrayList<Integer> generateRand(int size) {
        ArrayList<Integer> list = new ArrayList<>();

        Random random = new Random();
        // populate array with random number between 0 and 100
        int i;
        for (i=0; i < size; i++){
            list.add(random.nextInt(100));
        }

        return list;
    }

    public static void bubbleSort(ArrayList<Integer> list){
        int n = list.size();
        boolean is_swapped;

        for (int i = 0; i < n -1; i++){
            is_swapped = false;

            for (int j = 0; j < n-1; j++){
                if (list.get(j) > list.get(j+1)){

                    int temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);

                    is_swapped = true;
            }
            }
        }
    }

    public static void mergeSort(ArrayList<Integer> list){
        int size = list.size();
        
        if (size<2){
            return;
        }

        int middle = size / 2;

        ArrayList<Integer> left = new ArrayList<>(list.subList(0,middle));
        ArrayList<Integer> right = new ArrayList<>(list.subList(middle, size));

        mergeSort(left);
        mergeSort(right);


        merge(list,left,right);
    }
    public static void merge(ArrayList<Integer> list, ArrayList<Integer> left, ArrayList<Integer> right){

        int a = 0, b = 0, k = 0;
        //int[] mergedArray = new int[end-start];
        
        while (a < left.size() && b < right.size()){

            if (left.get(a) <= right.get(b)) {
                list.set(k, left.get(a));
                k++;
                a++;
            }

            else {
                list.set(k, right.get(b));
                k++;
                b++;
            }


        }
        while (a < left.size()){
            list.set(k, left.get(a));
            a++;
            k++;
        }

        while (b < right.size()){
            list.set(k, right.get(b));
            k++;
            b++;
        }   
        



}
}