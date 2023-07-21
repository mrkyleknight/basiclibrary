package basiclibrary;

import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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

    public String analyzeWeatherData(int[][] weatherData) {
        int minTemp = Integer.MAX_VALUE;
        int maxTemp = Integer.MIN_VALUE;
        Set<Integer> uniqueTemps = new HashSet<>();

        for (int[] week : weatherData) {
            for (int temp : week) {
                if (temp < minTemp) {
                    minTemp = temp;
                }
                if (temp > maxTemp) {
                    maxTemp = temp;
                }
                uniqueTemps.add(temp);
            }
        }

        StringBuilder output = new StringBuilder();
        output.append("High: ").append(maxTemp).append("\n");
        output.append("Low: ").append(minTemp).append("\n");

        for (int i = minTemp; i <= maxTemp; i++) {
            if (!uniqueTemps.contains(i)) {
                output.append("Never saw temperature: ").append(i).append("\n");
            }
        }

        return output.toString();
    }

    public String tally(List<String> votes) {
        Map<String, Integer> voteCount = new HashMap<>();

        // Count the votes for each candidate
        for (String candidate : votes) {
            voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        }

        // Find the candidate with the most votes
        String winner = "";
        int maxVotes = 0;
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            String candidate = entry.getKey();
            int votesCounted = entry.getValue();

            if (votesCounted > maxVotes) {
                winner = candidate;
                maxVotes = votesCounted;
            }
        }

        return winner;
    }


}

