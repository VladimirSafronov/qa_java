import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import com.example.Feline;
import com.example.Lion;
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
  @Test
  public void whenSexDifferentThenException() {
    Exception thrown = assertThrows(Exception.class, () -> new Lion(feline, "Инопланетянин"));
    assertEquals("Используйте допустимые значения пола животного - самец или самка",
        thrown.getMessage());
  }

  /**
   * При вызове getKittens() ожидаем значение 1
   */
  @Test
  public void whenGetKittensThenReturn1() throws Exception {
    int expectedCount = 1;
    Lion lion = new Lion(feline, "Самец");
    when(feline.getKittens()).thenReturn(expectedCount);
    Assert.assertEquals(expectedCount, lion.getKittens());
  }

  /**
   * При вызове getFood() ожидаем "Животные", "Птицы", "Рыба"
   */
  @Test
  public void whenGetFoodThenResultEqualsFelineGetFood() throws Exception {
    List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
    Lion lion = new Lion(feline, "Самка");
    when(feline.getFood("Хищник")).thenReturn(expectedResult);
    Assert.assertEquals(expectedResult, lion.getFood());
  }

}
