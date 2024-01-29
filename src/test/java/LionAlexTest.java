import static org.mockito.Mockito.when;

import com.example.Feline;
import com.example.LionAlex;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {

  @Mock
  Feline feline;

  /**
   * Проверка списка друзей
   */
  @Test
  public void whenGetFriendsThenGetList() throws Exception {
    List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
    LionAlex lionAlex = new LionAlex(feline);
    List<String> actualFriends = lionAlex.getFriends();
    Assert.assertEquals("Ожидаемые друзья льва Алекса: " + expectedFriends + " , но пришло: " +
        actualFriends, expectedFriends, actualFriends);
  }

  /**
   * Проверка количества друзей
   */
  @Test
  public void getFriendsCountEqual3() throws Exception {
    int expectedSize = 3;
    LionAlex lionAlex = new LionAlex(feline);
    int result = lionAlex.getFriends().size();
    Assert.assertEquals("Список друзей равен " + result, expectedSize, result);
  }

  /**
   * Проверка места жительства
   */
  @Test
  public void whenGetPlaceOfLivingThenGet() throws Exception {
    String expectedPlace = "Нью-Йоркский зоопарк";
    LionAlex lionAlex = new LionAlex(feline);
    String actualPlace = lionAlex.getPlaceOfLiving();
    Assert.assertEquals("Метод getPlaceOfLiving вернул: " + actualPlace + " , ожидалось: " +
        expectedPlace, expectedPlace, actualPlace);
  }

  /**
   * Проверка количества детей
   */
  @Test
  public void whenGetKittensExpected0() throws Exception {
    int expectedKitten = 0;
    LionAlex lionAlex = new LionAlex(feline);
    int result = lionAlex.getKittens();
    Assert.assertEquals("Метод getKittens вернул: " + result + " , ожидалось: " +
        expectedKitten, expectedKitten, result);
  }

  /**
   * Тест наличия гривы
   */
  @Test
  public void whenDoesHaveManeThenReturnTrue() throws Exception {
    LionAlex lionAlex = new LionAlex(feline);
    boolean expected = true;
    boolean result = lionAlex.doesHaveMane();
    Assert.assertEquals(expected, result);
  }

  /**
   * При вызове getFood() ожидаем "Животные", "Птицы", "Рыба"
   */
  @Test
  public void whenGetFoodThenReturnList() throws Exception {
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    LionAlex lionAlex = new LionAlex(feline);
    when(feline.getFood("Хищник")).thenReturn(expectedFood);
    Assert.assertEquals(expectedFood, lionAlex.getFood());
  }
}
