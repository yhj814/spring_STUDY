package com.app.dependency.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("laptop")
public class Labtop implements Computer{
    @Override
    public int getScreenSize() {
        return 1280;
    }
}
