import java.util.Scanner;

public class PythagoreanSquareCalculator {

    public static int digitalRoot(int n) { //сумма цифр даты рождения до цифры
        while (n > 9) {
            n = sumOfDigits(n);
        }
        return n;
    }

    public static int sumOfDigits(int n) { //просто сумма цифр
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int[] calculatePythagoreanSquare(String birthDate) {
        String[] parts = birthDate.split("\\\\.");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        int sumDayMonth = sumOfDigits(day) + sumOfDigits(month);
        int sumYear = sumOfDigits(year);


        int firstWorkingNumber = sumDayMonth + sumYear;
        int secondWorkingNumber = digitalRoot(firstWorkingNumber);
        int firstDigitDay = Integer.parseInt(Integer.toString(day).substring(0, 1));
        int thirdWorkingNumber = firstWorkingNumber - 2 * firstDigitDay;
        int fourthWorkingNumber = digitalRoot(thirdWorkingNumber);


        String firstRow = String.format("%d%d%d", day, month, year);
        String secondRow = String.format("%d%d%d%d", firstWorkingNumber, secondWorkingNumber, thirdWorkingNumber, fourthWorkingNumber);


        int[] countDigits = new int[10];

        for (char c : (firstRow + secondRow).toCharArray()) {
            countDigits[Character.getNumericValue(c)]++;
        }

        return countDigits;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // объект, который будет использоваться для чтения пользовательского ввода из консоли
        System.out.print("Введите дату рождения в формате дд.мм.гггг: ");
        String birthDate = scanner.nextLine();

        int[] pythagoreanSquare = calculatePythagoreanSquare(birthDate);

        System.out.println("Квадрат Пифагора по дате рождения:");

        System.out.println("Таблица:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d: %d%n", i, pythagoreanSquare[i]);
        }

        scanner.close(); //commit test
    }
}

