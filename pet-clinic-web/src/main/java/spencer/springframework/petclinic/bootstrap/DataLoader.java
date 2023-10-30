package spencer.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spencer.springframework.petclinic.model.Owner;
import spencer.springframework.petclinic.model.Pet;
import spencer.springframework.petclinic.model.PetType;
import spencer.springframework.petclinic.model.Vet;
import spencer.springframework.petclinic.services.OwnerService;
import spencer.springframework.petclinic.services.PetTypeService;
import spencer.springframework.petclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("1715 Poplar Lane");
        owner1.setCity("Miami");
        owner1.setTelephone("3055522715");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogPetType);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("JJ");
        pet1.setOwner(owner1);
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gray");
        owner2.setAddress("643 Ottis Street");
        owner2.setCity("Stillwater");
        owner2.setTelephone("4053328553");

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatPetType);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("caption");
        pet2.setOwner(owner2);
        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Alex");
        vet1.setLastName("Moon");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Rod");
        vet2.setLastName("Book");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
