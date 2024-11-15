import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        while(!choice.equalsIgnoreCase("B")){
            System.out.println("\nWhat would you like to do? ");
            System.out.println("[A] Sort an array");
            System.out.println("[B] Exit program");
            System.out.print("Enter choice: ");
            choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("A")){
                System.out.print("Enter array delimited with commas: ");
                String input = scanner.nextLine();
                String[] array = input.split(", ");
                int[] arr = new int[array.length];
                for (int i = 0; i < array.length; i++){
                    arr[i] = Integer.parseInt(array[i]);
                }

                heapSort(arr);
                System.out.println("Sorted Array: " + Arrays.toString(arr));

            }

            else if (choice.equalsIgnoreCase("B")){
                System.out.println("You have exited the program");
            }
            else {
                System.out.println("Invalid choice. Try again");
            }
        }



    }

    static void heapSort(int[] arr) {
        buildMaxHeap(arr, arr.length);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }


    static void buildMaxHeap(int[] arr, int heapsize) {
        for (int i = heapsize / 2 - 1; i >= 0; i--) {
            heapify(arr, heapsize, i);
        }

    }

    static void heapify(int[] arr, int heapsize, int rootIndex) {
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;
        int maxIndex = rootIndex;

        if (leftChildIndex < heapsize && arr[leftChildIndex] > arr[rootIndex]) {
            maxIndex = leftChildIndex;
        }

        if(rightChildIndex < heapsize && arr[rightChildIndex] > arr[rootIndex]) {
            maxIndex = rightChildIndex;
        }

        if (maxIndex != rootIndex) {
            swap(arr, maxIndex, rootIndex);
            heapify(arr, heapsize, maxIndex);
        }


    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}