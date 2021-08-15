class IterativeQuickSort { 
// Time Complexity :  O(n log n) 
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    void swap(int arr[], int i, int j) 
    { 
	//Try swapping without extra variable 
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } 
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[], int l, int h) 
    { 
        //Compare elements and swap.
        int pivot = arr[h];
        int i = l-1;
        for (int j=l; j<h; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;
                // swap arr[i] and arr[j]
                swap(arr, i ,j);
            }
        }
        
         // swap array[i+1] and pivot
        swap(arr, i+1, h);

        return i+1;
    }  
  
    // Sorts arr[l..h] using iterative QuickSort 
    void QuickSort(int arr[], int l, int h) 
    { 
        //Try using Stack Data Structure to remove recursion.
            int stack[] = new int[h - l + 1];

        // Top of the stack
        int top = -1;

        stack[++top] = l;
        stack[++top] = h;

        // Pop until the stack is empty
        while (top >= 0) {

            h = stack[top--];
            l = stack[top--];

            // Pivot
            int par = partition(arr, l, h);

            // If there are elements on right side of pivot, push right side to the stack
            if (par + 1 < h) {
                stack[++top] = par + 1;
                stack[++top] = h;
            }

            // If there are elements on left side of pivot, push left side to the stack
            if (par - 1 > l) {
                stack[++top] = l;
                stack[++top] = par - 1;
            }

          }

       } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 