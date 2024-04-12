package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: 사용자 A 10000원 주문
        statefulService1.order("userA", 10000);
        //ThreadB: 사용자 B 20000원 주문
        statefulService2.order("userB", 20000);

        //ThreadA: 사용자 A 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);
        assertThat(statefulService1.getPrice()).isEqualTo(20000);
        // 원래 기대하던 결과값은 10000원이지만
        // statefulService1과 statefulService2는 같은 객체기 때문에(싱글톤 패턴이기 때문에)
        // B가 주문을 했을 때 20000원으로 바꿔치기됨.
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }

    }

}