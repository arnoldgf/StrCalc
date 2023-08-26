import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку по примеру \"a\" + \"b\", \"a\" - \"b\", \"a\" * b, \"a\" / b : ");
        String expression = scanner.nextLine();
        String operator;
        String result = null;
        if(!expression.contains("\"")) throw new Exception("Нужно вводить с кавычками!");
        expression = expression.replace(" ", "");
        expression = expression.replace("\"", "");
        String[] operands = expression.split("[+\\-*/]");
        operator = detectOperation(expression);
        if(operator.equals("+")){
            System.out.println(operands[0] + operands[1]);
        }
        else if(operator.equals("-")){
            int index = operands[0].indexOf(operands[1]);
            if(index == -1){
                System.out.println(operands[0]);
            }else {
                result = operands[0].substring(0, index);
                result += operands[0].substring(index + operands[1].length());
                System.out.println(result);
            }

        }
        else if(operator.equals("*")) {
            int num = Integer.parseInt(operands[1]);
            int num1 = Integer.parseInt(operands[1]);
            if(num1 > 10 || num1 < 0) throw new Exception("Чисел должно быть от 0 до 10!");
            for(int i = 0; i < num; i++){
                System.out.print(operands[0]);
            }
        }

        else {
            int len = operands[0].length()/Integer.parseInt(operands[1]);
            int num1 = Integer.parseInt(operands[1]);
            if(num1 > 10 || num1 < 0) throw new Exception("Чисел должно быть от 0 до 10!");
            result = operands[0].substring(0, len);
            System.out.println(result);
        }
    }
    static String detectOperation(String expression){
        if(expression.contains("+")) return "+";
        else if(expression.contains("-")) return "-";
        else if(expression.contains("*")) return "*";
        else if(expression.contains("/")) return "/";
        else return null;
    }
}