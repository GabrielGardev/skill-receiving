package P05_Calculator;

public class Extensions {
    public static InputInterpreter buildInterpreter(CalculationEngine engine) {
        return new AdvanceInterpreter(engine);
    }
}
