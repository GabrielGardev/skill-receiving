package ingredients;

public interface ChemicalIngredient extends Ingredient {
    void setChemicalFormula(String chemicalFormula);
    String getChemicalFormula();
}
