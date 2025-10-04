

 import java.util.Scanner;
 import java.util.Arrays;
 public class ArrayTask {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int [] arrayNum={2,5,8,3,4,6,10,15,20,1,11};
        
        System.out.println("Enter the index of the wanted value:");
        int userIndex= input.nextInt();
        System.out.println("Value at index "+userIndex +" is :"+ arrayNum[userIndex]);
        //to switch array using index
        System.out.println("Enter index 1:");
        int i= input.nextInt();
        System.out.println("Enter index 2: ");
        int j= input.nextInt();
        
        if (i >= 0 && i < arrayNum.length && j >= 0 && j < arrayNum.length){
            int temporaryArray= arrayNum[i];
            arrayNum[i]=arrayNum[j];
            arrayNum[j]=temporaryArray;
            System.out.println("After swapping two values:");
            for (int num: arrayNum){
                System.out.print(num + "");
            }
            } else{
            System.out.println("Invalid index");
            }
        Arrays.sort(arrayNum);
        System.out.println("Numbers in ascending order:");
        for (int num: arrayNum){
            System.out.print(num+ " ");
        }
        System.out.println("Number in descending order:");
        for (int h= arrayNum.length-1;i>=0;i--){
            System.out.print(arrayNum[i] + " ");
        }
         System.out.println("\n\nEnter a number to search for:");
        int target = input.nextInt();
        boolean found = false;

        for (int k = 0; k < arrayNum.length; k++) {
            if (arrayNum[k] == target) {
                System.out.println("Number " + target + " found at index " + k);
                found = true;
                break; // Stop once found
            }
        }

        if (!found) {
            System.out.println("Number " + target + " not found in the array.");
        }
        System.out.println("\n\nEnter a number to search for (binary search):");
        

        int left = 0;
        int right = arrayNum.length - 1;
        

        while (left <= right) {
            int mid = (left + right) / 2; 

            if (arrayNum[mid] == target) {
                System.out.println("Number " + target + " found at index " + mid);
                found = true;
                break;
            } else if (arrayNum[mid] < target) {
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Number " + target + " not found in the array.");
        }
        }
        
 
       
    }