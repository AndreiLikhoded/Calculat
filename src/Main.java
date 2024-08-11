import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите значения, например 1 + 3");
        String input = sc.nextLine();

        try {
            String result = calc(input);
            System.out.println("Результат" + result);
        }catch (IllegalArgumentException e){
            System.out.println("Ошибка" + e.getMessage());
        }finally {
            sc.close();
        }

    }

    public static String calc(String input){
        String[] parts = input.split(" ");

        if(parts.length != 3){
            throw new IllegalArgumentException("вводите данные как указано выше");
        }

        int a;
        int b;

        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("вводите числа от 1 дл 10");
        }

        if(a < 1 || a > 10 || b < 1 || b > 10){
            throw new IllegalArgumentException("числа должны быть в диапазоне от 1 до 10 включительно");
        }

        String operator = parts[1];
        int result;
        switch (operator){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if(b == 0) {
                    throw new IllegalArgumentException("нельзя делить на ноль");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Недопустимая операция. Используйте +, -, * или /.");
        }
        return String.valueOf(result);
    }
}
