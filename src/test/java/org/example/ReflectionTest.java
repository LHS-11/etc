package org.example;

import org.example.annotation.Controller;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * @Controller 어노테이션에 설정돼 있는 모든 클래스를 찾아서 출력한다.
 */
class ReflectionTest {

    private static final Logger log = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    void controllerScan() {
        Reflections reflections = new Reflections("org.example");

        Set<Class<?>> beans = new HashSet<>();
        beans.addAll(reflections.getTypesAnnotatedWith(Controller.class));

        log.debug("beans: [{}]",beans);
    }
}