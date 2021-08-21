package hu.ulyssys.java.course.food.delivery.converter;

import hu.ulyssys.java.course.food.delivery.entity.Food;
import hu.ulyssys.java.course.food.delivery.service.FoodService;

import javax.inject.Inject;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

@Converter
public class FoodListConverter implements AttributeConverter<List<Food>, String> {
    @Inject
    private FoodService foodService;
    private final String GROUP_DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(List<Food> foods) {
        StringJoiner stringJoiner = new StringJoiner(GROUP_DELIMITER);
        for (Food food : foods) {
            stringJoiner.add(food.getId().toString());
        }

        return stringJoiner.toString();
    }

    @Override
    public List<Food> convertToEntityAttribute(String s) {
        List<Food> foods = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s, GROUP_DELIMITER);
        while (!st.hasMoreTokens()) {
            Long id = Long.parseLong(st.nextToken());
            foods.add(foodService.findById(id));
        }
        return foods;
    }
}
