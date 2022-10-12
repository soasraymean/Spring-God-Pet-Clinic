package com.tyjohntompson.springgodpetclinic.service.map;

import com.tyjohntompson.springgodpetclinic.model.Owner;
import com.tyjohntompson.springgodpetclinic.model.Pet;
import com.tyjohntompson.springgodpetclinic.service.OwnerService;
import com.tyjohntompson.springgodpetclinic.service.PetService;
import com.tyjohntompson.springgodpetclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null) {

            if (object.getPets() != null) {
                for (Pet pet : object.getPets()) {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().isNew()) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if (pet.isNew()) {
                        pet.setId(petService.save(pet).getId());
                    }
                }
            }

            return super.save(object);

        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
