package dong.shop.web;

import dong.shop.domain.item.Item;
import dong.shop.domain.item.ItemRepository;
import dong.shop.domain.member.Account;
import dong.shop.domain.member.Member;
import dong.shop.domain.member.MemberRepository;
import dong.shop.domain.member.MemberStatus;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData {
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {
        itemRepository.saveItem(new Item(1L,"사과",10000,"사과를 할떈 사과를 건네세요",10));
        itemRepository.saveItem(new Item(2L,"귤",16000,"제주도에서 가져온듯하지만 대전에서 가져온 귤",500));
        itemRepository.saveItem(new Item(3L,"복숭아",45000,"청도에서 가져온 새콤달콤 딱복숭아",100));
        itemRepository.saveItem(new Item(4L,"자두",8000,"자두자두 생각나는 자두",100));

        Member member = new Member(1L,"test","test!","userA","서울 천호동", MemberStatus.BASIC,new Account());
        Member admin = new Member(2L,"aaa","1234","userA","서울 천호동", MemberStatus.ADMIN,new Account());

        memberRepository.save(member);
        memberRepository.save(admin);
    }

}
