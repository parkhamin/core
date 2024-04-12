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

    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository
    // memberRepository가 3번 호출됨.

    // 하지만 test를 직접 실행해보면!
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // 스프링은 싱글톤을 보장해준다 !!!!!

    // 각 메서드에 @Bean 적어주기 -> 그러면 spring container에 등록이 된다.
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
        // 생성자 주입
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPoliciy());
    }

    @Bean
    public DiscountPoliciy discountPoliciy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
