package hello.core;

import hello.core.discount.DiscountPoliciy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //@Bean memberService -> MemoryMemberRepository()
    //@Bean orderSerice -> MemoryMemberRepository()
    // 이로써 new가 2번이나 호출됨. 그러면 싱글톤이 깨지는 것 아닐까?

    // 각 메서드에 @Bean 적어주기 -> 그러면 spring container에 등록이 된다.
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
        // 생성자 주입
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPoliciy());
    }

    @Bean
    public DiscountPoliciy discountPoliciy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
