package com.app.dependency.qualifier;

import com.app.dependency.qualifier.task.Resturant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@SpringBootTest
@Slf4j
public class ResturantTests {
    
//    여기에 아웃백을 기본키로 둬서 아웃백이 나온다
    @Autowired
    private Resturant resturant;
    
    @Test
    public void testResturant() {
        log.info("{}", resturant);
        log.info("{}" ,resturant.isSaladBar());
    }
}
