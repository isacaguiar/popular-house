package br.com.house;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HouseApplicationTests {

  @Test
  void testConfigure() {
    String[] args = new String[]{};
    Runnable runnable = () -> HouseApplication.main(args);
    HouseApplication.main(args);
    assertNotNull(runnable);
  }

}
