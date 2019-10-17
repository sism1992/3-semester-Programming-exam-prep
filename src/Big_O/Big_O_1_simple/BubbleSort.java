package Big_O.Big_O_1_simple;


// Bubble Sort is one of the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
// Den bruges ikke særlig ofte i praksis hverken på små eller store lister
// BigO = n^2
// When the SWAPPED Boolean is used:
// Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
// Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
public class BubbleSort
{
    // Driver method to test the methods below
    public static void main(String args[])
    {
        BubbleSort bs = new BubbleSort();
        int arr[] = {64,14,52,25,52,63,14,12};
        bs.bubbleSort(arr);
        System.out.println("Sorted array");
        bs.printArray(arr);
    }

    public void bubbleSort(int arr[])
    {
        int n = arr.length;
        //boolean swapped;
        for (int i = 0; i < n; i++) {
            //swapped = false;
            for (int j = 0; j < n - i - 1; j++) { //j til længden minus i og minus 1
                if (arr[j] > arr[j + 1]) {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //swapped = true;
                }
            }
            //IF no two elements were
            //swapped by inner loop, then break
//             if (swapped == false)
//             break;
        }
    }

    /* Prints the array */
    public void printArray(int arr[])
    {

        for (int sortedNumbers:arr) {
            System.out.print(sortedNumbers + ", ");
        }
    }

}
