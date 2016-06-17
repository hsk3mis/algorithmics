package com.gryglicki.google;

/**
 * Rotating element-by-elementy allows us not to use additional space.
 * @author Michal Gryglicki, PL
 */
public class RotateSquareMatrixClockwiseInPlace {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < ceilOfDivision(n, 2); layer++) {
            int firstInLayer = layer;
            int lastInLayer = n - layer - 1;
            for (int i=firstInLayer; i < lastInLayer; i++) {
                rotateSingleElementClockwise(matrix, n, layer, i);
            }
        }
    }

    private static void rotateSingleElementClockwise(int[][] matrix, int n, int layer, int i) {
        //TODO: maybe simpler formuals using int offset = i - firstInLayer ?

        //save top
        int top = matrix[layer][i];
        //left -> top
        matrix[layer][i] = matrix[n-1 - i][layer];
        //bottom -> left
        matrix[n-1 - i][layer] = matrix[n-1 - layer][n-1 - i];
        //right -> bottom
        matrix[n-1 - layer][n-1 - i] = matrix[i][n-1 - layer];
        //top -> right
        matrix[i][n-1 - layer] = top;

    }

    /**
     * SIMPLE SOLUTION: return a / b + (a %b == 0 ? 0 : 1);
     * MORE MATHEMATICS: ceil(a,b) = floor(a/b + s) = floor(a/b + (b-1)/b) = floor((a+b-1)/b) = floor((a-1)/b + 1)
     */
    private static int ceilOfDivision(int a, int b) {
        return (a-1)/b + 1;
    }
}
