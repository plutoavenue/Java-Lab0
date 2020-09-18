public class Variant10 {

    public static class TaskSpecialReturn {
        public int a;
        public int b;

        public TaskSpecialReturn(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public boolean equals(TaskSpecialReturn numbers) {
            return (this.a == numbers.a && this.b == numbers.b);
        }
    }


    public static class ArrayClass {
        public int count1;
        public int[] array1;
        public int count2;
        public int[] array2;
        public ArrayClass(int in_count1, int[] in_array1, int in_count2, int[] in_array2) {
            this.count1 = in_count1;
            this.array1 = new int[this.count1];
            if (this.count1 >= 0)
                System.arraycopy(in_array1, 0, this.array1, 0, this.count1);
            this.count2 = in_count2;
            this.array2 = new int[this.count2];
            if (this.count2 >= 0)
                System.arraycopy(in_array2, 0, this.array2, 0, this.count2);
        }

        public boolean equals(ArrayClass elem) {
            if (this.count1 == elem.count1&&this.count2 == elem.count2) {
                for (int i = 0; i < this.array1.length && i < elem.array1.length; i++) {
                    if (this.array1[i] != elem.array1[i])
                        return false;
                }

                for (int i = 0; i < this.array2.length && i < elem.array2.length; i++) {
                    if (this.array2[i] != elem.array2[i])
                        return false;
                }
                return true;
            }
            return false;
        }
    }



    //1.	Все входные и выходные данные в заданиях этой группы являются целыми числами. Все числа, для которых
    // указано количество цифр (двузначное число, трехзначное число и т. д.), считаются положительными.
    //Integer10. Дано трехзначное число. Вывести вначале его последнюю цифру (единицы), а затем — его
    // среднюю цифру (десятки).

    public TaskSpecialReturn integerNumbersTask(int a) {
        System.out.println("Input: " + a);
        System.out.println("Last number: " + a % 10);
        System.out.println("Middle number: " + (a/10)%10);
        return new TaskSpecialReturn(a % 10, (a/10)%10);
    }

    //2.	Во всех заданиях данной группы требуется вывести логическое значение True, если приведенное высказывание
    // для предложенных исходных данных является истинным, и значение False в противном случае. Все числа, для которых
    // указано количество цифр (двузначное число, трехзначное число и т. д.), считаются целыми положительными.
    //Boolean10*. Даны два целых числа: A, B. Проверить истинность высказывания: «Ровно одно из чисел A и B нечетное».

    public boolean booleanTask(int a, int b) {
        return ((Math.abs(a) % 2 == 1) == true && (Math.abs(b) % 2 == 1) == false)
                || ((Math.abs(a) % 2 == 1) == false && (Math.abs(b) % 2 == 1) == true);
    }


    //3.	If10. Даны две переменные целого типа: A и B. Если их значения не равны, то присвоить каждой переменной
    // сумму этих значений, а если равны, то присвоить переменным нулевые значения.
    // Вывести новые значения переменных A и B.

    public TaskSpecialReturn ifTask(int a, int b) {
        if (a != b) {
            return new TaskSpecialReturn(a+b, a+b);
        }
        else {
            return new TaskSpecialReturn(0, 0);
        }
    }

    //4.	Case10. Робот может перемещаться в четырех направлениях («С» — север, «З» — запад, «Ю» — юг, «В» — восток)
    // и принимать три цифровые команды: 0 — продолжать движение, 1 — поворот налево, –1 — поворот направо.
    // Дан символ C — исходное направление робота и целое число N — посланная ему команда.
    // Вывести направление робота после выполнения полученной команды.

    public char switchTask(char c, int n) {
        switch (n) {
            case 0:
                break;
            case 1:
                if (c == 'С') {
                    c = 'З';
                }
                else  if (c == 'З') {
                    c = 'Ю';
                }
                else  if (c == 'Ю') {
                    c = 'В';
                }
                else  if (c == 'В') {
                    c = 'С';
                }
                break;
            case -1:
                if (c == 'З') {
                    c = 'С';
                }
                else  if (c == 'Ю') {
                    c = 'З';
                }
                else  if (c == 'В') {
                    c = 'Ю';
                }
                else  if (c == 'С') {
                    c = 'В';
                }
                break;
        }
        return c;
    }

    //5.	For10. Дано целое число N (> 0). Найти сумму
    //      1 + 1/2 + 1/3 + … + 1/N (вещественное число).

    public double forTask(int n) {
        double res = 0;
        for (int i = 1; i <= n; i++ ) {
            res += 1./i;
        }
        return res;
    }

    //6.	While10. Дано целое число N (> 1). Найти наибольшее целое число K,
    //      при котором выполняется неравенство 3K < N.
    public int whileTask(int n) {
        int k = 0;
        while (3 * k < n) {
            k++;
        }
        return k - 1;
    }

    //7.	Минимумы и максимумы
    // Для решения заданий из данной группы следует использовать «однопроходные» алгоритмы, позволяющие
    // получить требуемый результат после однократного просмотра набора исходных данных. Однопроходные
    // алгоритмы обладают важным преимуществом: для них не требуется хранить в памяти одновременно весь
    // набор данных, поэтому при программной реализации этих алгоритмов можно не использовать массивы.
    // Во всех заданиях данной группы предполагается, что исходный набор содержит ненулевое количество
    // элементов (в частности, число N всегда больше нуля).

    // Minmax10. Дано целое число N и набор из N целых чисел. Найти номер первого
    // экстремального (то есть минимального или максимального) элемента из данного набора.
    public TaskSpecialReturn minMaxTask(int n, int[] mas) {
        int min = mas[0];
        int max = mas[0];
        int startMin = 0;
        int startMax = 0;
        for (int i = 1; i < mas.length; i++) {
            if (mas[i] < min && min!=mas[i]) {
                min = mas[i];
                startMin = i;
            }
            if (mas[i] > max && max!=mas[i]) {
                max = mas[i];
                startMax = i;
            }
        }
        return new TaskSpecialReturn(startMin, startMax);
    }


    // 8.	Одномерные массивы
    // Условие вида «дан массив размера N» означает, что вначале дается фактический размер массива (целое число N),
    // а затем приводятся все его элементы. Если в задании явно не указывается, какие значения может принимать
    // размер исходного массива, то предполагается, что размер может изменяться в пределах от 2 до 10. Индекс
    // начального элемента массива считается равным 1.
    // Если в задании, связанном с созданием (преобразованием) массива, не описан результирующий набор данных,
    // то предполагается, что этим набором является созданный (преобразованный) массив, и необходимо вывести все
    // его элементы в порядке возрастания их индексов.

    // Array10. Дан целочисленный массив размера N. Вывести вначале все содержащиеся в данном массиве
    // четные числа в порядке возрастания их индексов, а затем — все нечетные числа в порядке убывания их индексов.

    public ArrayClass arrayTask(int[] array) {
        int k = 0, l = 0;
        int[] result_even = new int[array.length];
        System.out.print("Input: ");
        for (int el:array){
            System.out.print(el+" ");
        }
        System.out.print("\nOutput even: ");

        for (int j : array) {
            if (Math.abs(j % 2) == 0) {
                result_even[k] = j;
                System.out.print(result_even[k]+" ");
                k++;
            }
        }
        l=array.length-k;
        int[] result_uneven = new int[l];
        l--;
        System.out.print("\nOutput uneven: ");
        for (int j : array) {
            if (Math.abs(j % 2) == 1) {
                result_uneven[l] = j;
                l--;
            }
        }
        for (int el:result_uneven){
            System.out.print(el+" ");
        }
        return new ArrayClass(k, result_even, array.length-k, result_uneven);
    }

    // 9.	Двумерные массивы (матрицы)
    // Условие вида «дана матрица размера M ґ N» означает, что вначале дается фактический размер двумерного
    // массива-матрицы (количество строк M и количество столбцов N), а затем приводятся элементы этого массива
    // (количество элементов равно M·N). Если в задании явно не указывается, какие значения могут принимать размеры
    // исходной матрицы, то предполагается, что и число строк, и число столбцов может изменяться в пределах от 2 до 10.
    // Начальные значения как первого, так и второго индекса двумерного массива-матрицы всегда считаются равными 1.
    // Ввод и вывод элементов матрицы осуществляются по строкам.
    // Квадратной матрицей порядка M называется двумерный массив-матрица размера M ґ M.
    // Если в задании, связанном с созданием или преобразованием матрицы, не описан результирующий набор данных,
    // то предполагается, что этим набором является созданная (преобразованная) матрица, и необходимо вывести
    // все ее элементы.

    // Matrix10. Дана матрица размера M ґ N. Вывести ее элементы, расположенные в столбцах
    // с нечетными номерами (1, 3, …). Вывод элементов производить по столбцам, условный оператор не использовать.
    public int[][] twoDimensionArrayTask(int[][] array, int n, int m) {
        int newN = (n%2==1)?(n/2+1):n/2;
        int [][] result = new int [newN][m];
        int l=0;


        System.out.print("\nOutput: \n");

            for (int i=0; i<n; i+=2){
                 for (int j=0; j<m; j++){
                        System.out.print(array[j][i]+"\t");
                        result[l][j]=array[j][i];
                    }
               l++;
              System.out.print("\n");
          }

        return result;
    }


}
