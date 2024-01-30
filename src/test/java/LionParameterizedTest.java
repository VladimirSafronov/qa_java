import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

  @Mock
  private Feline feline;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Parameter()
  public String sex;
  @Parameter(1)
  public boolean hasMane;

  @Parameters
  public static Object[][] getLionParameterizedTestData() {
    return new Object[][]{
        {"Самец", true},
        {"Самка", false}
    };
  }

  /**
   * Проверка на наличие гривы у Lion в зависимости от пола
   */
  @Test
  public void whenSexEqualMaleThenHasMane() throws Exception {
    Lion lion = new Lion(feline, sex);
    Assert.assertEquals("У " + sex + " ожидается наличие гривы = " + hasMane,
        hasMane, lion.doesHaveMane());
  }
}
