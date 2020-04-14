package com.moses.leet.n0760;

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target >= letters[letters.length-1] ||letters[0] > target){
            return letters[0];
        }

        int left = 0, right = letters.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(letters[left]<=target && letters[left+1]>target){
                return letters[left+1];
            }
            if(target < letters[mid]){
                right = mid;
            }else if(target >= letters[mid]){
                left = mid;
            }
        }
        return 'Z';
    }


    public static void main(String[] args) {
        char[] letters;
        char target;
        letters = new char[]{'c','c','c','c','c','c','f','j'};
        target = 'f';
        System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(letters, target));


        letters = new char[]{'c','f','j'};
        target = 'a';
        System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(letters, target));

        target = 'c';
        System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(letters, target));

        target = 'd';
        System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(letters, target));

        target = 'g';
        System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(letters, target));

        target = 'j';
        System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(letters, target));

        target = 'k';
        System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(letters, target));
    }
}
