package be.intecbrussel.finalproject.services.implementations;

import be.intecbrussel.finalproject.data.Owner;
import be.intecbrussel.finalproject.repositories.OwnerRepository;
import be.intecbrussel.finalproject.services.interfaces.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void CreateOwner(Owner owner) {
        ownerRepository.save(owner);
    }



}
