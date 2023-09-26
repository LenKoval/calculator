package calculator;

public interface CalcInterface {
    int add(int a, int b);
    int sub(int a, int b);
    int mul(int a, int b);
    int div(int a, int b) throws MyException;
}
