class Solution {

    // Function to calculate area below a given horizontal line `mid`
    public double areaBelow(double mid, int[][] squares) {
        double area = 0.0;

        for (int[] square : squares) {
            double y = square[1];
            double len = square[2];

            // Entire square is below mid
            if (mid >= y + len) {
                area += len * len;
            }
            // Partially covered square
            else if (mid > y && mid < y + len) {
                area += len * (mid - y);
            }
        }
        return area;
    }

    // Main function
    public double separateSquares(int[][] squares) {
        double totalArea = 0.0;

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        // Find total area and vertical bounds
        for (int[] square : squares) {
            double y = square[1];
            double len = square[2];

            totalArea += len * len;
            min = Math.min(min, y);
            max = Math.max(max, y + len);
        }

        double target = totalArea / 2.0;
        double low = min, high = max;

        // Binary search
        while (low < high) {
            if (high - low < Math.pow(10, -5)) {
                break;
            }

            double mid = (low + high) / 2.0;

            if (areaBelow(mid, squares) < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
