package hello.core.order;

import hello.core.discount.DiscountPoliciy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPoliciy discountPoliciy;
    // 생성자 주입을 사용하면 final 키워드를 넣을 수 있음.
    // final: 생성할 때 한 번 딱 정해지면 바뀌지 않음. 생성자에서만 값을 세팅할 수 있음.

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPoliciy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
