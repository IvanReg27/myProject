package com.vkatit;

import com.vkatit.applicationContext.ApplicationContext;
import com.vkatit.applicationContext.Inject;
import com.vkatit.applicationContext.InjectToClassAppContext;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class InjectToClassAppContextTest {
    @Test
    void InjectToClass() {
        InjectToClassAppContext injectToClassAppContext = new InjectToClassAppContext();
        ApplicationContext context = new ApplicationContext();

        for (Field field : InjectToClassAppContext.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldClass = field.getType();
                Object value = context.getInjectToClassAppContext(fieldClass);

                if (value != null) {
                    field.setAccessible(true);
                    //Проверяем, что изначально приходит из context
                    //System.out.println(field.get(injectToClassAppContext));
                    try {
                        field.set(injectToClassAppContext, value);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        System.out.println(injectToClassAppContext.getList());
        System.out.println(injectToClassAppContext.getInteger());
        System.out.println(injectToClassAppContext.getString());
    }
}