package basiclibrary;

import java.util.Random;

public class Library {
    public static void main(String[] args) {
    }

    public int[] roll(int n) {
        int[] rolls = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            rolls[i] = random.nextInt(6) + 1;
        }
        return rolls;
    }


    public boolean containsDuplicates(int[] arr) {
        for(int i = 0; i < arr.length -1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public double calculateAverage(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }

    public int[] findArrayWithLowestAverage(int[][] arrays) {
        double lowestAverage = Double.MAX_VALUE;
        int lowestIndex = -1;

        for (int i = 0; i < arrays.length; i++) {
            int[] innerArray = arrays[i];
            double sum = 0;
            for (int num : innerArray) {
                sum += num;
            }
            double average = sum / innerArray.length;
            if (average < lowestAverage) {
                lowestAverage = average;
                lowestIndex = i;
            }
        }

        return arrays[lowestIndex];
    }
}

