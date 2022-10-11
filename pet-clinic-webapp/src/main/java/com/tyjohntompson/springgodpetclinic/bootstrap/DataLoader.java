package com.tyjohntompson.springgodpetclinic.bootstrap;

import com.tyjohntompson.springgodpetclinic.model.*;
import com.tyjohntompson.springgodpetclinic.service.OwnerService;
import com.tyjohntompson.springgodpetclinic.service.PetTypeService;
import com.tyjohntompson.springgodpetclinic.service.SpecialityService;
import com.tyjohntompson.springgodpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Dan");
        owner1.setLastName("Kozyrev");
        owner1.setAddress("123 Prikol");
        owner1.setCity("Minsk");
        owner1.setMobile("+375 777");

        Pet pet1 = new Pet();
        pet1.setPetType(dog);
        pet1.setOwner(owner1);
        pet1.setName("Ri");
        pet1.setBirthDate(LocalDate.now());

        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Egor");
        owner2.setLastName("Creed");
        owner2.setAddress("Tryba");
        owner2.setCity("Uganda");
        owner2.setMobile("+123 lambo");

        Pet pet2 = new Pet();
        pet2.setPetType(cat);
        pet2.setOwner(owner2);
        pet2.setName("Jack");
        pet2.setBirthDate(LocalDate.now());

        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        specialityService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Robert");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(radiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Michael");
        vet2.setLastName("Fork");
        vet2.getSpecialities().add(surgery);

        vetService.save(vet2);

        System.out.println("Data was loaded successfully");
    }
}
