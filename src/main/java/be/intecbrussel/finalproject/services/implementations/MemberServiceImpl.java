package be.intecbrussel.finalproject.services.implementations;

import be.intecbrussel.finalproject.data.Member;
import be.intecbrussel.finalproject.repositories.MemberRepository;
import be.intecbrussel.finalproject.services.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void addMember(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member getMember(String email) {
        return memberRepository.getById(email);
    }

    @Override
    public void deleteMember(Member member) {
        memberRepository.delete(member);

    }
}
