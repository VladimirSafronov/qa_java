import static org.mockito.Mockito.when;

import com.example.Feline;
import com.example.LionAlex;
import java.util.ArrayList;
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
  public void whenGetFriendsThenGetList() {
    List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
    LionAlex lionAlex = null;
    try {
      lionAlex = new LionAlex(feline);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    assert lionAlex != null;
    List<String> actualFriends = lionAlex.getFriends();
    Assert.assertEquals("Ожидаемые друзья льва Алекса: " + expectedFriends + " , но пришло: " +
        actualFriends, expectedFriends, actualFriends);
  }

  /**
   * Проверка количества друзей
   */
  @Test
  public void getFriendsCountEqual3() {
    int expectedSize = 3;
    LionAlex lionAlex = createLionAlex();
    assert lionAlex != null;
    int result = lionAlex.getFriends().size();
    Assert.assertEquals("Список друзей равен " + result, expectedSize, result);
  }

  /**
   * Проверка места жительства
   */
  @Test
  public void whenGetPlaceOfLivingThenGet() {
    String expectedPlace = "Нью-Йоркский зоопарк";
    LionAlex lionAlex = createLionAlex();
    assert lionAlex != null;
    String actualPlace = lionAlex.getPlaceOfLiving();
    Assert.assertEquals("Метод getPlaceOfLiving вернул: " + actualPlace + " , ожидалось: " +
        expectedPlace, expectedPlace, actualPlace);
  }

  /**
   * Проверка количества детей
   */
  @Test
  public void whenGetKittensExpected0() {
    int expectedKitten = 0;
    LionAlex lionAlex = createLionAlex();
    assert lionAlex != null;
    int result = lionAlex.getKittens();
    Assert.assertEquals("Метод getKittens вернул: " + result + " , ожидалось: " +
        expectedKitten, expectedKitten, result);
  }

  /**
   * Тест наличия гривы
   */
  @Test
  public void whenDoesHaveManeThenReturnTrue() {
    LionAlex lionAlex = createLionAlex();
    boolean expected = true;
    boolean result = lionAlex.doesHaveMane();
    Assert.assertEquals(expected, result);
  }

  /**
   * При вызове getFood() ожидаем "Животные", "Птицы", "Рыба"
   */
  @Test
  public void whenGetFoodThenReturnList() {
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    List<String> result = new ArrayList<>();
    try {
      LionAlex lionAlex = new LionAlex(feline);
      when(feline.getFood("Хищник")).thenReturn(expectedFood);
      result = lionAlex.getFood();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    Assert.assertEquals(expectedFood, result);
  }

  private LionAlex createLionAlex() {
    LionAlex lionAlex = null;
    try {
      lionAlex = new LionAlex(feline);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return lionAlex;
  }
}
