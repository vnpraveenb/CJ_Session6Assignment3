package binarysearch;

import java.util.Scanner;

/**
 * @author Praveen
 * 
 *
 */
class BinarySearch{
	
	int size;
	int[] intArray;
	
 
	public BinarySearch(int size)
	{
		this.size = size;
		this.intArray = new int[size];
		
		System.out.println("Initializing the elements of the array from 1 to " + size);

		for(int i =0; i<intArray.length; i++)
		{
			intArray[i] = i+1;
		}
	}
	
	/**
	 * @param startIndex
	 * @param lastIndex
	 * @param searchElement
	 * @return returns the index of the element in the array if found else returns -1
	 */
	public int binarySearchAlgorithm(int startIndex, int lastIndex, int searchElement)
	{
	    if (lastIndex>=startIndex)
	    {
	        int mid = startIndex + (lastIndex - startIndex)/2;
	
	        // If the element is present at the middle itself
	        if (intArray[mid] == searchElement)
	        {
	           return mid;
	        }
	        
	        // If element is smaller than mid, would be present in left subarray
	        if (intArray[mid] > searchElement)
	        {
	        	return binarySearchAlgorithm(startIndex, mid-1, searchElement);
	        }
	        else{	       
	        // Else the element can only be present in right subarray
	        return binarySearchAlgorithm(mid+1, lastIndex, searchElement);
	        }
	    }
	
	    // We reach here when element is not present in array
	    return -1;
	}

	 
	public static void main(String[] args) {
 		
		System.out.println("This program prints searches for an element in the array");
        
		Scanner scan = new Scanner(System.in);

		System.out.println("Input the size of the array");
		int size = scan.nextInt();
		
		BinarySearch binarySearchObj = new BinarySearch(size); // Creates and Initialises the binary search object
	
 		System.out.println("Input the the number you want to search");
				int searchElement = scan.nextInt();
		
		// Calling the binarySearchAlgorithm on a Binary Search Object
        int result = binarySearchObj.binarySearchAlgorithm(0,size-1,searchElement);
        
        if (result == -1)
        {
        	System.out.println("Did not find the element in the array");
        }
        else
        {
        	System.out.println("Element found at index "+ result);
        }
	}

}
