package be.intecbrussel.finalproject.services.interfaces;

import be.intecbrussel.finalproject.data.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {

    List<Member> getAllMembers();
    void addMember(Member member);
    Member getMember(String email);
    void deleteMember(Member member);

}
