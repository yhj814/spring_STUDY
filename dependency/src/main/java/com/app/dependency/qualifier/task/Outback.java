package com.app.dependency.qualifier.task;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@ToString
public class Outback implements Resturant{
    private int steak= Resturant.steak+10000;

    @Override
    public boolean isSaladBar() {
        return false;
    }
}
