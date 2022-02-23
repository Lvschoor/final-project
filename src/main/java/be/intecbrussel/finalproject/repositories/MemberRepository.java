package be.intecbrussel.finalproject.repositories;

import be.intecbrussel.finalproject.data.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
}
