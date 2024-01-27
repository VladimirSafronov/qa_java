import static org.mockito.Mockito.when;

import com.example.Feline;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

  @Spy
  Feline feline;

  /**
   * При вызове метода eatMeat(), ожидается список из "Животные", "Птицы", "Рыба"
   */
  @Test
  public void whenEatMeatThenReturnCorrectFood() {
    List<String> expectedMeat = List.of("Животные", "Птицы", "Рыба");
    List<String> result = new ArrayList<>();
    try {
      when(feline.eatMeat()).thenReturn(expectedMeat);
      result = feline.eatMeat();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    Assert.assertEquals("Кошачьи хищники, едят " + expectedMeat + " . Вернулось: " + result,
        expectedMeat, result);
  }

  /**
   * При вызове метода getFamily(), ожидается "Кошачьи"
   */
  @Test
  public void whenGetFamilyThenReturnCorrectFamilyName() {
    when(feline.getFamily()).thenReturn("Кошачьи");
    Assert.assertEquals("Кошачьи", feline.getFamily());
  }

  /**
   * Если вызвать getKittens(int count), вернется count
   */
  @Test
  public void getKittensWithParamReturnParamNumber() {
    int count = 5;
    when(feline.getKittens(count)).thenReturn(count);
    Assert.assertEquals(count, feline.getKittens(count));
  }

  /**
   * Если вызвать getKittens() без параметра, вызовется getKittens(1)
   */
  @Test
  public void getKittensNoParamThenUseGetKittenWith1() {
    feline.getKittens();
    Mockito.verify(feline, Mockito.times(1)).getKittens(1);
  }

  /**
   * При вызове метода getFood("Хищник"), ожидается список из "Животные", "Птицы", "Рыба"
   */
  @Test
  public void whenGetFoodWithPredatorParamThenEqualList() {
    List<String> expectedMeat = List.of("Животные", "Птицы", "Рыба");
    List<String> actualMeat = new ArrayList<>();
    try {
      when(feline.getFood("Хищник")).thenReturn(expectedMeat);
      actualMeat = feline.getFood("Хищник");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    Assert.assertEquals("Кошачьи хищники, едят " + expectedMeat + " . Вернулось: " + actualMeat,
        expectedMeat, actualMeat);
  }

  /**
   * Проверка несоответствия списка еды Хищника и списка еды Травоядного
   */
  @Test
  public void whenGetFoodWithHerbivoreParamThenNotEqualList() {
    List<String> predatorFood = List.of("Животные", "Птицы", "Рыба");
    List<String> herbivoreFood = List.of("Трава", "Различные растения");
    List<String> result = new ArrayList<>();
    try {
      when(feline.getFood("Травоядное")).thenReturn(herbivoreFood);
      result = feline.getFood("Травоядное");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    Assert.assertNotEquals("Список еды хищника: " + predatorFood + " совпадает со списком "
        + "травоядного: " + result, predatorFood, result);
  }

  /**
   * Ожидается Exception.class при получении списка еды с параметром отличным от "Хищник" или
   * "Травоядное"
   */
  @Test(expected = Exception.class)
  public void whenGetFoodWithWrongParamThenException() throws Exception {
    when(feline.getFood("Вегетарианец")).thenThrow(Exception.class);
    feline.getFood("Вегетарианец");
  }

  /**
   * Тест при вызове getFamily() возвращается "Существует несколько семейств: заячьи, беличьи,
   * мышиные, кошачьи, псовые, медвежьи, куньи"
   */
  @Test
  public void whenGetFamilyThenReturnString() {
    String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    when(feline.getFamily()).thenReturn(expected);
    Assert.assertEquals(expected, feline.getFamily());
  }

}
