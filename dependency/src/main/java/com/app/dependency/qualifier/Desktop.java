package com.app.dependency.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//이걸써서 컴퓨터에 알려준다
//@Qualifier("desktop")

//디폴트 값 다른곳에서 쓸거면 지우고 다시정의
//@Primary
public class Desktop implements Computer{
    @Override
    public int getScreenSize() {
        return 2000;
    }
}
