package org.uni.lu;

public class Function {

    public enum FUNCTION_TYPE {
        ADD,
        SUBTRACT
    }

    private final FUNCTION_TYPE functionType;
    private final int valueOne;
    private final int valueTwo;

    public Function(FUNCTION_TYPE functionType, int valueOne, int valueTwo) {
        this.functionType = functionType;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    public int solve() {
        switch (functionType) {
            case ADD:
                return valueOne + valueTwo;
            case SUBTRACT:
                return valueOne - valueTwo;
        }
        return 0;
    }
}
