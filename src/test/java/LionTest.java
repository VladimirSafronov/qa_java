import static org.mockito.Mockito.when;

import com.example.Feline;
import com.example.Lion;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

  @Mock
  private Feline feline;

  /**
   * Ожидается Exception.class при инициализации объкта типа Lion с отличным параметром от значений
   * "Самец" или "Самка"
   */
  @Test(expected = Exception.class)
  public void whenSexDifferentThenException() throws Exception {
    new Lion(feline, "Инопланетянин");
  }

  /**
   * При вызове getKittens() ожидаем значение 1
   */
  @Test
  public void whenGetKittensThenReturn1() {
    int expectedCount = 1;
    Lion lion;
    int result = 0;
    try {
      lion = new Lion(feline, "Самец");
      when(feline.getKittens()).thenReturn(expectedCount);
      result = lion.getKittens();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    Assert.assertEquals("При вызове getKittens() получили: " + result, expectedCount, result);
  }

  /**
   * При вызове getFood() ожидаем "Животные", "Птицы", "Рыба"
   */
  @Test
  public void whenGetFoodThenResultEqualsFelineGetFood() {
    List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
    List<String> actualResult = new ArrayList<>();
    Lion lion;
    try {
      lion = new Lion(feline, "Самка");
      when(feline.getFood("Хищник")).thenReturn(expectedResult);
      actualResult = lion.getFood();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    Assert.assertEquals(
        "Список полученой еды: " + actualResult + ", не совпадает с ожидаемым: " + expectedResult,
        expectedResult, actualResult);
  }

}
