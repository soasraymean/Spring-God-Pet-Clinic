package com.tyjohntompson.springgodpetclinic.repository;

import com.tyjohntompson.springgodpetclinic.model.Owner;

import java.util.List;

public interface OwnerRepository {
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
