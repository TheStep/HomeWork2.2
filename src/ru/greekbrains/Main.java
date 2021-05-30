package ru.greekbrains;

public class Main {

    public static void main(String[] args) {
        result();
    }

    public static void result() {
        String[][] arr = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        try {
            int result = method(arr);
            System.out.println(result);
        } catch (MyArraySizeException e) {
            System.out.println("Превышенно количество чисел в массиве");
        } catch (MyArrayDataException e) {
            System.out.print ("Неправильный символ массива, ошибка в : " + e.i + " - " + e.j);
        }
    }

    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return count;
    }
}
