import java.util.*;

interface MealPlan {
    String getMealPlan();
}

class VegetarianMeal implements MealPlan {
    private String planName;

    public VegetarianMeal(String planName) {
        this.planName = planName;
    }

    public String getMealPlan() {
        return "Vegetarian Meal Plan: " + planName;
    }

    public String toString() {
        return planName;
    }
}

class VeganMeal implements MealPlan {
    private String planName;

    public VeganMeal(String planName) {
        this.planName = planName;
    }

    public String getMealPlan() {
        return "Vegan Meal Plan: " + planName;
    }

    public String toString() {
        return planName;
    }
}

class HighProteinMeal implements MealPlan {
    private String planName;

    public HighProteinMeal(String planName) {
        this.planName = planName;
    }

    public String getMealPlan() {
        return "High Protein Meal Plan: " + planName;
    }

    public String toString() {
        return planName;
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public String toString() {
        return mealPlan.toString();
    }

}

class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T plan) {
        if (validatePlan(plan)) {
            return new Meal<>(plan);
        }
        throw new IllegalArgumentException("Invalid meal plan");
    }

    private static <T extends MealPlan> boolean validatePlan(T plan) {
        return plan.getMealPlan() != null && !plan.getMealPlan().isEmpty();
    }
}

public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generateMealPlan(new VegetarianMeal("Healthy Veg Delight"));
        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(new VeganMeal("Green Energy"));
        Meal<HighProteinMeal> highProteinMeal = MealPlanGenerator
                .generateMealPlan(new HighProteinMeal("Muscle Builder"));
        System.out.println(vegMeal);
        System.out.println(veganMeal);
        System.out.println(highProteinMeal);
    }
}