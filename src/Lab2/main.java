package Lab2;
import java.io.*;


//var2
class main {
    public static void Main(String[] args) {

        int lenLine = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/Lab3/input.txt")))) {
            while ((reader.readLine()) != null) {
                lenLine++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int[][] matrix = new int[lenLine][lenLine];
        int rowIndex = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/Lab3/input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] numbers = line.split("\\s+");
                int colIndexElement = 0;

                for (String number : numbers) {
                    matrix[rowIndex][colIndexElement] = Integer.parseInt(number);
                    colIndexElement++;
                }
                rowIndex++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int[][] transposedMatrix = new int[lenLine][lenLine];

        for (int i = 0; i < lenLine; i++){
            for (int j = 0; j < lenLine; j++){
                transposedMatrix[i][j] = matrix[j][i];
            }
        }

        int sumOfDiagonal = sumDiagonal(matrix);

        StringBuilder result = new StringBuilder();

        for (int[] row : transposedMatrix){
            for (int element : row){
                result.append(element).append(" ");
            }
            result.append("\n");
        }
        result.append("Sum of diagonal elements: ").append(sumOfDiagonal);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Lab3/output.txt"))) {
            writer.write(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int sumDiagonal(int[][] tempMatrix) {
        int sum = 0;
        for (int i = 0; i < tempMatrix.length; i++){
            sum += tempMatrix[i][i];
        }
        return sum;
    }
}