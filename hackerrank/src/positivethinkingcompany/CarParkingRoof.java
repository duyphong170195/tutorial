package positivethinkingcompany;

import java.util.Arrays;

public class CarParkingRoof {

    public static int carParkingRoof(int[] cars, int k) {
        // Sort the parking spots
        Arrays.sort(cars);

        // Initialize the minimum roof length with a large value
        int minRoofLength = Integer.MAX_VALUE;

        // Slide the window of size k over the sorted positions
        for (int i = 0; i <= cars.length - k; i++) {
            // Calculate the length of the roof for the current window
            int roofLength = cars[i + k - 1] - cars[i] + 1;
            // Update the minimum roof length
            minRoofLength = Math.min(minRoofLength, roofLength);
        }

        return minRoofLength;
    }
}
