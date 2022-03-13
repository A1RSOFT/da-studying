package lesson4.task1;

import java.util.Scanner;

//        3 3 5
//        1 2 3
//        4 5 6
//        7 8 9
//        g 3 2
//        r 3 2
//        c 2 3
//        g 2 2
//        g 3 2

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter matrix parameters: ");

        String sourceString = scanner.nextLine();
        String[] array = sourceString.split(" ");
        sourceString += "\n";

        System.out.println("Enter data: ");

        int linesCount = Integer.parseInt(array[0]) + Integer.parseInt(array[2]);

        for (int i = 0; i < linesCount; i++) {
            if (i == linesCount - 1) {
                sourceString += scanner.nextLine();
            } else {
                sourceString += scanner.nextLine() + "\n";
            }
        }

        String[] sourceArray = sourceString.split("\n");
        String[] metaInfo = sourceArray[0].split(" ");

        int rowsCount = Integer.parseInt(metaInfo[0]);
        int columnsCount = Integer.parseInt(metaInfo[1]);
        int requestsCount = Integer.parseInt(metaInfo[2]);

        String[] matrixData = getMatrixData(sourceArray, rowsCount, 1);
        String[] requestsData = getMatrixData(sourceArray, requestsCount, rowsCount + 1);
        int[][] matrix = getMatrix(matrixData, rowsCount, columnsCount);

        System.out.println("Result: ");
        executeRequests(requestsData, matrix);

        long endTime = System.currentTimeMillis();
        System.out.println("Executing time : " + (endTime - startTime));
    }

    public static void executeRequests(String[] requestsData, int[][] matrix) {
        for (int i = 0; i < requestsData.length; i++) {
            String[] strArr = requestsData[i].split(" ");
            String requestType = strArr[0];
            int firstValue = Integer.parseInt(strArr[1]) - 1;
            int secondValue = Integer.parseInt(strArr[2]) - 1;

            switch (requestType) {
                case ("g"):
                    System.out.println(getValueByCoordinate(matrix, firstValue, secondValue));

                case ("r"):
                    transposeRows(matrix, firstValue, secondValue);

                case ("c"):
                    transposeColumns(matrix, firstValue, secondValue);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + requestType);
            }
        }
    }

    public static int getValueByCoordinate(int[][] twoDemensionalArray, int row, int column) {
        return twoDemensionalArray[row][column];
    }

    public static void transposeRows(int[][] twoDemensionalArray, int firstRowIndex, int secondRowIndex) {
        int[] tempArray = twoDemensionalArray[firstRowIndex];
        twoDemensionalArray[firstRowIndex] = twoDemensionalArray[secondRowIndex];
        twoDemensionalArray[secondRowIndex] = tempArray;
    }

    public static void transposeColumns(int[][] twoDemensionalArray, int firstColumnIndex, int secondColumnIndex) {
        for (int i = 0; i < twoDemensionalArray.length; i++) {
            int temp;
            temp = twoDemensionalArray[i][firstColumnIndex];
            twoDemensionalArray[i][firstColumnIndex] = twoDemensionalArray[i][secondColumnIndex];
            twoDemensionalArray[i][secondColumnIndex] = temp;
        }
    }

    public static String[] getMatrixData(String[] sourceArray, int rowsCount, int step) {
        String[] matrixData = new String[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            matrixData[i] = sourceArray[step++];
        }

        return matrixData;
    }

    public static int[][] getMatrix(String[] matrixData, int rowsCount, int columnsCount) {
        int[][] matrix = new int[rowsCount][columnsCount];

        for (int i = 0; i < rowsCount; i++) {
            String[] tempArray = matrixData[i].split(" ");
            int counter = 0;

            for (int j = 0; j < columnsCount; j++) {
                matrix[i][j] = Integer.parseInt(tempArray[counter]);
                counter++;
            }
        }

        return matrix;
    }
}