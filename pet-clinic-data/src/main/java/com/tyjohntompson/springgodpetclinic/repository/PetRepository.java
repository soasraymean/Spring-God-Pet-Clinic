package com.tyjohntompson.springgodpetclinic.repository;

import com.tyjohntompson.springgodpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
