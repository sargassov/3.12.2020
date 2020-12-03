package lesson2package;

public class Program {
    public static void main(String[] args) {
//        1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        short[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("1. It was before: ");
        for (short s : arr) System.out.print(s + " ");
        short step = 0;
        while (step < arr.length) {
            if (arr[step] == 0) arr[step] = 1;
            else if (arr[step] == 1) arr[step] = 0;
            step++;
        }
        System.out.print("\n1. After it looks like this: ");
        for (short s : arr) System.out.print(s + " ");


        //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.print("\n\n2. ");
        int[] arrMass = new int[8];
        for (int count = 0, value = count; count < arrMass.length; count++, value += 3) {
            arrMass[count] = value;
            System.out.print(arrMass[count] + " ");
        }


        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.print("\n\n3. It was before: ");
        int[] mass = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < mass.length; i++) {
            System.out.print(mass[i] + " ");
            if (mass[i] < 6) mass[i] *= 2;
        }
        System.out.print("\n3. After it looks like this: ");
        for (int i : mass) {
            System.out.print(i + " ");
        }

        //4. Создать квадратный двумерный целочисленный массив
        // (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("\n\n4.");
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (x == y) System.out.print(1 + " ");
                else if (y == (8 - x)) System.out.print(1 + " ");
                else System.out.print(0 + " ");
            }
            System.out.println();
        }

        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.print("\n\n5. ");
        for (int i : mass) System.out.print(i + " ");
        int min = 100, max = -100;
        for (int x = 0; x < mass.length; x++) {
            if (mass[x] < min) min = mass[x];
            if (mass[x] > max) max = mass[x];
        }
        System.out.println("\nminimum = " + min + "\nmaximun = " + max + "\n\n6.");


        //        6.** Написать метод, в который передается не пустой одномерный целочисленный массив,
        //        метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой
        //        части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
        //        checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
        int[] superMass = {9, 9, 7, 4, 3, 4};
        boolean[] isArrayHaveEqualParts = new boolean[superMass.length - 1];
        boolean didFindPlace = false;
        for (int coeff = 0; coeff < isArrayHaveEqualParts.length; coeff++) {
            isArrayHaveEqualParts[coeff] = equalPartsOfArray(superMass, coeff);
            if(isArrayHaveEqualParts[coeff]){
                didFindPlace = true;
                System.out.println("We have an equal place: ");
                for(int x = 0; x < superMass.length; x++){
                    System.out.print(superMass[x] + " ");
                    if(x == coeff) System.out.print("|| ");
                }
            }
        }
        if(!didFindPlace) System.out.println("We haven't equal place in array");


        //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
        // или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения
        // задачи нельзя пользоваться  вспомогательными массивами.
        System.out.print("\n\n7. It was before ");
        for(int i : superMass) System.out.print(i + " ");
        quake(superMass, 1);
        quake(superMass, 3);
        quake(superMass, -4);
        quake(superMass, -2);

    }

    private static void quake(int[] mass, int value){
        System.out.print("\nquake to " + value + ": ");
        if(value >= 0){
            for(int x = 0; x < value; x++){
                int temporary = mass[mass.length - 1];
                for(int y = mass.length - 1; y > 0; y--){
                    mass[y] = mass[y - 1];
                }
                mass[0] = temporary;
            }
        }
        else {
            value = -value;
            for(int x = 0; x < value; x++){
                int temporary = mass[0];
                for(int y = 0; y < mass.length - 1; y++){
                    mass[y] = mass[y + 1];
                }
                mass[mass.length - 1] = temporary;
            }
        }
        System.out.print("Then it going to: ");
        for(int i : mass) System.out.print(i + " ");
    }

    private static boolean equalPartsOfArray(int[] mass, int coeff) {
        int leftAmount = 0, rightAmount = 0;
        for (short x = 0; x < mass.length; x++) {
            if (x <= coeff) leftAmount += mass[x];
            else rightAmount += mass[x];
        }
        return leftAmount == rightAmount;
    }
}

