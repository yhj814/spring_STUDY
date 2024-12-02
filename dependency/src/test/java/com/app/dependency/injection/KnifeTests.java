package com.app.dependency.injection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class KnifeTests {
    @Autowired
    public Food food;

    @Test
    public void testFood(){
       log.info("{}",food);

   }
}
