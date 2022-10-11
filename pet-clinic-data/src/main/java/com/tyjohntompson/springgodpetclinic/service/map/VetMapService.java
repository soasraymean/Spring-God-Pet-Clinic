package com.tyjohntompson.springgodpetclinic.service.map;

import com.tyjohntompson.springgodpetclinic.model.Speciality;
import com.tyjohntompson.springgodpetclinic.model.Vet;
import com.tyjohntompson.springgodpetclinic.service.SpecialityService;
import com.tyjohntompson.springgodpetclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size() > 0) {
            for (Speciality speciality : object.getSpecialities()) {
                if (speciality.isNew()) {
                    speciality.setId(specialityService.save(speciality).getId());
                }
            }
        }
        return super.save(object);
    }

}
