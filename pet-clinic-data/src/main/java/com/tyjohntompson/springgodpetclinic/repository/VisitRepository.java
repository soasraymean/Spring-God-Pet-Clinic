package com.tyjohntompson.springgodpetclinic.repository;

import com.tyjohntompson.springgodpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
