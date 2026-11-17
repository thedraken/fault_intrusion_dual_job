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
        return switch (functionType) {
            case ADD -> valueOne + valueTwo;
            case SUBTRACT -> valueOne - valueTwo;
        };
    }

    /**
     * Generates a message digest
     *
     * @return The hex string for the current message
     */
    public String canonical() {
        return functionType.name() + "|" + valueOne + "|" + valueTwo;
    }
}
