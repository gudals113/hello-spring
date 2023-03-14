package well.hellospring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import well.hellospring.domain.Member;
import well.hellospring.repository.MemberRepository;
import well.hellospring.repository.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }
    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("Summer");

        //when
        Long saveId = memberService.join(member);

        //then
        Member foundMember = memberService.findOne(saveId).get();
        assertEquals(member.getName(), foundMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("Summer1");

        Member member2 = new Member();
        member2.setName("Summer1");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertEquals(e.getMessage(), "오류 : 이미 존재하는 회원입니다.");
//        try {
//            memberService.join(member2);
//            fail("예외 발생입니다!");
//        } catch (IllegalStateException e) {
//            assertEquals(e.getMessage(), "오류 : 이미 존재하는 회원입니다.");
//        }
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}