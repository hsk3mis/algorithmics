package com.gryglicki.google;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Michal Gryglicki, PL
 */
public class RotateSquareMatrixClockwiseInPlaceTest {

    @Test
    public void rotate_empty_matrix() {
        int[][] matrix = {};
        int[][] rotatedMatrix = {};
        RotateSquareMatrixClockwiseInPlace.rotate(matrix);
        assertMatrixEquals(rotatedMatrix, matrix);
    }

    @Test
    public void rotate_matrix_of_size_1() {
        int[][] matrix = {{13}};
        int[][] rotatedMatrix = {{13}};
        RotateSquareMatrixClockwiseInPlace.rotate(matrix);
        assertMatrixEquals(rotatedMatrix, matrix);
    }

    @Test
    public void rotate_matrix_of_size_2() {
        int[][] matrix = {
                {1, 10},
                {1000, 100}
        };
        int[][] rotatedMatrix = {
                {1000, 1},
                {100, 10}
        };
        RotateSquareMatrixClockwiseInPlace.rotate(matrix);
        assertMatrixEquals(rotatedMatrix, matrix);
    }

    @Test
    public void rotate_matrix_of_size_3() {
        int[][] matrix = {
                {1, 10, 100},
                {2, 20, 200},
                {3, 30, 300}};
        int[][] rotatedMatrix = {
                {3, 2, 1},
                {30, 20, 10},
                {300, 200, 100}};
        RotateSquareMatrixClockwiseInPlace.rotate(matrix);
        assertMatrixEquals(rotatedMatrix, matrix);
    }

    @Test
    public void rotate_matrix_of_size_4() {
        int[][] matrix = {
                {1, 10, 100, 1000},
                {2, 20, 200, 2000},
                {3, 30, 300, 3000},
                {4, 40, 400, 4000},};
        int[][] rotatedMatrix = {
                {4, 3, 2, 1},
                {40, 30, 20, 10},
                {400, 300, 200, 100},
                {4000, 3000, 2000, 1000}};
        RotateSquareMatrixClockwiseInPlace.rotate(matrix);
        assertMatrixEquals(rotatedMatrix, matrix);
    }

    @Test
    public void rotate_matrix_of_size_5() {
        int[][] matrix = {
                {1, 10, 100, 1000, 10000},
                {2, 20, 200, 2000, 20000},
                {3, 30, 300, 3000, 30000},
                {4, 40, 400, 4000, 40000},
                {5, 50, 500, 5000, 50000}};
        int[][] rotatedMatrix = {
                {5, 4, 3, 2, 1},
                {50, 40, 30, 20, 10},
                {500, 400, 300, 200, 100},
                {5000, 4000, 3000, 2000, 1000},
                {50000, 40000, 30000, 20000, 10000}};
        RotateSquareMatrixClockwiseInPlace.rotate(matrix);
        assertMatrixEquals(rotatedMatrix, matrix);
    }


    private void printMatrix(int[][] matrix) {
        for (int i = 0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                System.out.print(String.format("%1$5s ", matrix[i][j]));
            }
            System.out.println("");
        }
    }

    private void assertMatrixEquals(int[][] expeced, int[][] actual) {
        assertEquals(expeced.length, actual.length);
        for (int i = 0; i < expeced.length; i++) {
            assertArrayEquals(expeced[i], actual[i]);
        }
    }
}