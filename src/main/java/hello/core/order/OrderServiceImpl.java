package hello.core.order;

import hello.core.discount.DiscountPoliciy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPoliciy discountPoliciy;

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
}
