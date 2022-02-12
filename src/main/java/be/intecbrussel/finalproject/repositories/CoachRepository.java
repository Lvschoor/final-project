package be.intecbrussel.finalproject.repositories;

import be.intecbrussel.finalproject.data.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach,String> {
}