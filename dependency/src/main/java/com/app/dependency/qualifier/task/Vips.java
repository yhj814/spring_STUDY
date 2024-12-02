package com.app.dependency.qualifier.task;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("vips")
@ToString
public class Vips implements Resturant{
    private int steak= Resturant.steak+20000;

    @Override
    public boolean isSaladBar() {
        return true;
    }
}
