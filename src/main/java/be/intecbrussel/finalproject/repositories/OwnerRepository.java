package be.intecbrussel.finalproject.repositories;

import be.intecbrussel.finalproject.data.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,String> {


}
