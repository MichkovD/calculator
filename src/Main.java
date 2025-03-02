import java.util.Scanner;
import static java.lang.Character.*;


class InvalidFormatException extends Exception {

    InvalidFormatException() {}

    InvalidFormatException(String message) {
        super(message);
    }

    InvalidFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}


public class Main {
    public static boolean is_sign(char ch){
        return ch == '-' || ch == '+' || ch == '*' || ch == '/';
    }

    public static void main(String[] args) throws InvalidFormatException {
        Scanner sc = new Scanner(System.in);
        char[] data = sc.nextLine().trim().toCharArray();
        String num1, num2;
        num1 = new String();
        num2 = new String();
        char sign;
        int sign_index = 0;
        sign = 'x';
        for (int i = 0; i < data.length; i++){
            if (is_sign(data[i])) {
                if (sign == 'x') {
                    sign = data[i];
                    sign_index = i;
                } else {
                    try {
                        throw new InvalidFormatException("формат математической операции не удовлетворяет заданию - слишком много знаков действий");
                    }
                    catch (NullPointerException e) {
                        throw new InvalidFormatException("", e);
                    }
                }
            }
        }
        if (sign == 'x') {
            try {
                throw new InvalidFormatException("формат математической операции не удовлетворяет заданию - нет знака действия");
            }
            catch (NullPointerException e) {
                throw new InvalidFormatException("", e);
            }
        }
        for (int i = 0; i < sign_index; i++){
            if (data[i] == ' ' && i < sign_index - 1){
                try {
                    throw new InvalidFormatException("в первом числе содержатся лишние пробелы");
                }
                catch (NullPointerException e) {
                    throw new InvalidFormatException("", e);
                }
            }
            if (!isDigit(data[i]) && data[i] != ' '){
                try {
                    throw new InvalidFormatException("в первом числе содержатся некорректные символы");
                }
                catch (NullPointerException e) {
                    throw new InvalidFormatException("", e);
                }
            }
            num1 += data[i];
        }
        for (int i = sign_index + 1; i < data.length; i++){
            if (data[i] == ' ' && i > sign_index + 1){
                try {
                    throw new InvalidFormatException("во втором числе содержатся лишние пробелы");
                }
                catch (NullPointerException e) {
                    throw new InvalidFormatException("", e);
                }
            }
            if (!isDigit(data[i]) && data[i] != ' '){
                try {
                    throw new InvalidFormatException("во втором числе содержатся некорректные символы");
                }
                catch (NullPointerException e) {
                    throw new InvalidFormatException("", e);
                }
            }
            num2 += data[i];
        }
        num1 = num1.replaceAll("\\s", "");
        num2 = num2.replaceAll("\\s", "");

        if (num1.isEmpty() || (num1.length() > 1 && !(num1.toCharArray()[0] == '1' && num1.toCharArray()[1] == '0')) || num1.toCharArray()[0] == '0'){
            try {
                throw new InvalidFormatException("первое число должно быть целым в диапазоне от 1 до 10");
            }
            catch (NullPointerException e) {
                throw new InvalidFormatException("", e);
            }
        }
        if (num2.isEmpty() || (num2.length() > 1 && !(num2.toCharArray()[0] == '1' && num2.toCharArray()[1] == '0')) || num2.toCharArray()[0] == '0'){
            try {
                throw new InvalidFormatException("второе число должно быть целым в диапазоне от 1 до 10");
            }
            catch (NullPointerException e) {
                throw new InvalidFormatException("", e);
            }
        }
        switch (sign){
            case '+':
                System.out.printf("%d\n", Integer.parseInt(num1) + Integer.parseInt(num2));
                break;
            case '-':
                System.out.printf("%d\n", Integer.parseInt(num1) - Integer.parseInt(num2));
                break;
            case '*':
                System.out.printf("%d\n", Integer.parseInt(num1) * Integer.parseInt(num2));
                break;
            case '/':
                System.out.printf("%d\n", Integer.parseInt(num1) / Integer.parseInt(num2));
                break;
        }
    }
}