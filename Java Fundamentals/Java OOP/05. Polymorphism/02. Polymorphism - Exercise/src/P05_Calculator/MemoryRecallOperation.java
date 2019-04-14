package P05_Calculator;

public class MemoryRecallOperation implements Operation {
    private MemorySaveOperation memory;

    public MemoryRecallOperation(MemorySaveOperation memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {

    }

    @Override
    public int getResult() {
        if (!this.memory.getMemory().isEmpty()) {
            return this.memory.getMemory().pop();
        }
        throw new IllegalArgumentException("Memory is empty");
    }

    @Override
    public boolean isCompleted() {
        return true;
    }
}
