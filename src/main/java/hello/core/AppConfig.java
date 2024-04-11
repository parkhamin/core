package hello.core;

import hello.core.discount.DiscountPoliciy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(MemberRepository());
        // 생성자 주입
    }

    private static MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(MemberRepository(), discountPoliciy());
    }

    public DiscountPoliciy discountPoliciy(){
        return new FixDiscountPolicy();
    }

}
