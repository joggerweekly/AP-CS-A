// AP computer science A
//array version
// will try ArrayList and generic sort
// https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#binarySearch-int:A-int-


import java.util.Arrays;

public class Sort {
  public static void main(String args[]) {


    //System.out.println("Sum of x+y = " + 10);
    
    
    int arr[] = { 3, 12, 11, 13, 5, 6 };
    int arr_sorted[] = InsertionSortRecursive(arr);
    System.out.println("insertion-sorted arr = " + arr_sorted);
  }

  public static int[] InsertionSortRecursive(int arr[]) {
    if (arr.length > 2)
    {
        //compare first element with the sorted sublist
        
        int[] sub = Arrays.copyOfRange(arr, 1, arr.length); 
        
        int[] sortedSublist = InsertionSortRecursive(sub);
        if (arr[0] > sortedSublist[0])
        {
            //insert first element at the right position in the sorted sublist to get the new sorted sublist


            //steps:
            //use binarySearch to find the insertion point as defined in Java SE api doc
            int index = Arrays.binarySearch(sortedSublist, arr[0] );           
            
            int insertion_point = index;
            if (insertion_point<0) //does not exist
            {
                insertion_point = -index - 1;
            }

            //three cases: head, tail, or middle
            // create the resultant array
            int[] sublist = new int[arr.length];


            
            //case1: head,  
            if (insertion_point == 0)
            {
                sublist = addElementToHead(arr[0], sortedSublist);
            }
            //case2: tail,  
            else if (insertion_point == sortedSublist.length)
            {
                sublist = addElementToTail(arr[0], sortedSublist);
            }
            //case3: middle
            else
            {
                //split the list into two sublists at the insertion point
                int[] sublist_lower = Arrays.copyOfRange(sortedSublist, 0, insertion_point); 
                int[] sublist_higher = Arrays.copyOfRange(sortedSublist, insertion_point, sortedSublist.length); 

                //add arr[0] to the head of the larger sublist to form a new sublist

                int[] sublist_higher_new = addElementToHead(arr[0], sublist_higher);
                //merge the two sublist into the new sublist
                // using the pre-defined function arraycopy
                System.arraycopy(sublist_lower, 0, sublist, 0, sublist_lower.length);
                System.arraycopy(sublist_higher_new, 0, sublist, sublist_lower.length, sublist_higher_new.length);                
            }
            return sublist;
        }

        // add arr[0] to the front of the sorted list and return the new list
        else
        {
            return addElementToHead(arr[0], sortedSublist);
            
        }
        
    }
    // sublist has 2 or less elements
    else 
    {
        //swap if first element is bigger
        if (arr[0]>arr[1])
        {
            int t = arr[0];
            arr[0] = arr[1];
            arr[1] = t;
        }
        return arr;
    }

  }  
  //array utility 
  public static int[] addElementToHead(int h, int arr1[]) {
    int[] arr2 = new int[arr1.length + 1];
    arr2[0] = h;
    for (int i = 0; i < arr1.length; i++) {
        arr2[i+1] = arr1[i];
    }    
     return arr2;
  }  

  public static int[] addElementToTail(int t, int arr1[]) {
    int[] arr2 = new int[arr1.length + 1];

    for (int i = 0; i < arr1.length; i++) {
        arr2[i] = arr1[i];
    }    
    arr2[arr1.length] = t;
     return arr2;
  }    

}
