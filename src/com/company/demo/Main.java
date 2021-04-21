package com.company.demo;

public class Main {

    public static void main(String[] args) {

		System.out.println("Remove Even Numbers");
    	int[] arr = {2,3,1,4,5,6};

	    RemoveEvenNumbersWithZero removeEvenNumbersWithZero =
                new RemoveEvenNumbersWithZero();

	    removeEvenNumbersWithZero.removeEvenNumbers(arr);

		System.out.println("\nUnion Of sorted Arrays");

	    int[] firstArray = {2,4,5,7,8};
	    int[] secondArray = {4,8,9,11};

	    UnionOfSortedArrays unionOfSortedArrays =
                new UnionOfSortedArrays();

	    unionOfSortedArrays.unionOfSortedArrays(firstArray,secondArray);

		System.out.println("\nGroom and bride");

	    GroomAndBride groomAndBride = new GroomAndBride();

	    String brideName = "Divya";
		System.out.println("Grooms for "+ brideName);
	    groomAndBride.showAuntiesSon(brideName);
	    groomAndBride.showUnclesSon(brideName);

		System.out.println();

	    String groomName = "Ajay";
		System.out.println("Brides for "+ groomName);
	    groomAndBride.showAuntiesDaughter(groomName);
	    groomAndBride.showUnclesDaughter(groomName);
	    groomAndBride.showSisterDaughter(groomName);


    }
}
