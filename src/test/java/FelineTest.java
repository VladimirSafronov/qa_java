import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import com.example.Feline;
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
  public void whenEatMeatThenReturnCorrectFood() throws Exception {
    List<String> expectedMeat = List.of("Животные", "Птицы", "Рыба");
    when(feline.eatMeat()).thenReturn(expectedMeat);
    Assert.assertEquals(expectedMeat, feline.eatMeat());
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
  public void whenGetFoodWithPredatorParamThenEqualList() throws Exception {
    List<String> expectedMeat = List.of("Животные", "Птицы", "Рыба");
    when(feline.getFood("Хищник")).thenReturn(expectedMeat);
    Assert.assertEquals(expectedMeat, feline.getFood("Хищник"));
  }

  /**
   * Проверка несоответствия списка еды Хищника и списка еды Травоядного
   */
  @Test
  public void whenGetFoodWithHerbivoreParamThenNotEqualList() throws Exception {
    List<String> predatorFood = List.of("Животные", "Птицы", "Рыба");
    List<String> herbivoreFood = List.of("Трава", "Различные растения");
    when(feline.getFood("Травоядное")).thenReturn(herbivoreFood);
    Assert.assertNotEquals(predatorFood, feline.getFood("Травоядное"));
  }

  /**
   * Ожидается Exception.class при получении списка еды с параметром отличным от "Хищник" или
   * "Травоядное". А также проверка сообщения полученного Exception
   */
  @Test
  public void whenGetFoodWithWrongParamThenException() {
    Exception thrown = assertThrows(Exception.class, () -> feline.getFood("Вегетарианец"));
    assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
        thrown.getMessage());
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
