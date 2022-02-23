package be.intecbrussel.finalproject.services.interfaces;

import be.intecbrussel.finalproject.data.Owner;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService {


    void CreateOwner(Owner owner);
    Owner GetOwner();
}
