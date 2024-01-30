import static org.mockito.Mockito.when;

import com.example.Cat;
import com.example.Feline;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

  @Mock
  Feline feline;

  /**
   * Тест провряет, что при вызове getSound() возвращается Мяу
   */
  @Test
  public void whenCatGetSoundThenSay() {
    Cat cat = new Cat(feline);
    Assert.assertEquals("Мяу", cat.getSound());
  }

  /**
   * Тест проверят рацион, получаемый при вызове getFood()
   */
  @Test
  public void whenCatGetFoodThenGetList() throws Exception {
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    Cat cat = new Cat(feline);
    when(feline.eatMeat()).thenReturn(expectedFood);
    Assert.assertEquals(expectedFood, cat.getFood());
  }

}
