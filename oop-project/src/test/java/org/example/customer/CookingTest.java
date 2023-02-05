package org.example.customer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CookingTest {

    @DisplayName("요리를 생성한다.")
    @Test
    void makeCooking() {
        //given
        Cooking cooking = new Cooking();
        MenuItem menuItem = new MenuItem("돈까스", 5000);

        //when
        Cook cook= cooking.makeCook(menuItem);

        //then
        assertThat(cook).isEqualTo(new Cook("돈까스", 5000));
    }
}
