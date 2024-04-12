package hello.core.order;

import hello.core.discount.DiscountPoliciy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPoliciy discountPoliciy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPoliciy discountPoliciy) {
        this.memberRepository = memberRepository;
        this.discountPoliciy = discountPoliciy;
    }

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
