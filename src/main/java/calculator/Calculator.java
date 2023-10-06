package calculator;

public class Calculator implements CalcInterface {
    private String operator;
    private int oper1;
    private int oper2;
    private String[] operators;
    private boolean isOperator = false;

    public Calculator() {
    }

    public String[] addNumbers(String value) {
        if (!isOperator) {
            operators = value.split(" ");
        }
        return operators;
    }

    private String[] getResult() throws MyException {
        int check;
        try {
            check = Integer.parseInt(operators[0]);
            check = Integer.parseInt(operators[2]);
        } catch (NumberFormatException ex) {
            throw new MyException("Неверный формат");
        }
        return operators;
    }

    public int process() throws MyException {
        getResult();
        oper1 = Integer.parseInt(operators[0]);
        oper2 = Integer.parseInt(operators[2]);
        operator = operators[1];
        switch (operator) {
            case "+":
                return add(oper1, oper2);
            case "-":
                return sub(oper1, oper2);
            case "*":
                return mul(oper1, oper2);
            case "/":
                return div(oper1, oper2);
        }
        return 0;
    }
    public String[] clear() {
        for (int i = 0; i < operators.length; i++) {
            i = 0;
        }
        return operators;
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        return a * b;
    }

    @Override
    public int div(int a, int b) throws MyException {
        try {
            return a / b;
        } catch (ArithmeticException ex) {
            throw new MyException("Деление на ноль.");
        }
    }
}
