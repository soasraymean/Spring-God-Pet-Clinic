package com.tyjohntompson.springgodpetclinic.repository;

import com.tyjohntompson.springgodpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
