package P05_Calculator;

public class AdvanceInterpreter extends InputInterpreter {
    private MemorySaveOperation currentMemory;

    public AdvanceInterpreter(CalculationEngine engine) {
        super(engine);
        this.currentMemory = new MemorySaveOperation(engine);
    }

    @Override
    public Operation getOperation(String operation) {
        Operation currentOperation;

        switch (operation) {
            case "/":
                currentOperation = new DivisionOperation();
                break;
            case "ms":
                this.currentMemory.addOperand(0);
                currentOperation = this.currentMemory;
                break;
            case "mr":
                currentOperation = new MemoryRecallOperation(this.currentMemory);
                break;
            default:
                currentOperation = super.getOperation(operation);
                break;
        }
        return currentOperation;
    }
}
