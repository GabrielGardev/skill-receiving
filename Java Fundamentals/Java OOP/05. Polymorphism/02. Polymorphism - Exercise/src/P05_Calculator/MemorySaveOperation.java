package P05_Calculator;

import java.util.ArrayDeque;

public class MemorySaveOperation implements Operation {
    private ArrayDeque<Integer> memory;
    private CalculationEngine engineCopy;

    public MemorySaveOperation(CalculationEngine engine) {
        this.memory = new ArrayDeque<>();
        this.engineCopy = engine;
    }

    @Override
    public void addOperand(int operand) {
        operand = this.engineCopy.getCurrentResult();
        this.memory.push(operand);
    }

    @Override
    public int getResult() {
        if (!this.memory.isEmpty()) {
            return this.memory.peek();
        }
        throw new IllegalArgumentException("Memory is empty");
    }

    @Override
    public boolean isCompleted() {
        return true;
    }

    public ArrayDeque<Integer> getMemory() {
        return memory;
    }
}
