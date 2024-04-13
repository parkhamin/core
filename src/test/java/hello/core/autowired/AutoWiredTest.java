package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutoWiredTest {
    @Test
    void AutoWiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{
        // 호출이 아예 되지 않음.
        @Autowired(required = false)
        public void SetNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }

        // 호출은 되지만! null이 출력됨.
        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        // 스프링 빈이 없으면 옵션을 empty로 넣어줌.
        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
