package riggie.dto;

import lombok.Data;
import riggie.entity.Setmeal;
import riggie.entity.SetmealDish;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
