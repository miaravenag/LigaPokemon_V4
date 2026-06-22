package cl.duoc.pokedex.config;

import cl.duoc.pokedex.model.Pokedex;
import cl.duoc.pokedex.repository.PokedexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements CommandLineRunner {

    @Autowired
    private PokedexRepository pokedexRepository;

    @Override
    public void run(String... args) throws Exception {
        if(pokedexRepository.count()==0){
            System.out.println("Datos de prueba");
            Pokedex pokemon1= new Pokedex(null, "bulbasaur", "planta", null, 80);
            Pokedex pokemon2= new Pokedex(null, "pikachu", "electrico", null, 65);
            Pokedex pokemon3= new Pokedex(null, "metagross", "acero", "psiquico", 300);
            Pokedex pokemon4= new Pokedex(null, "lunatone", "roca", "psiquico", 90);
            Pokedex pokemon5= new Pokedex(null, "larvesta", "bicho", "fuego", 70);

            pokedexRepository.save(pokemon1);
            pokedexRepository.save(pokemon2);
            pokedexRepository.save(pokemon3);
            pokedexRepository.save(pokemon4);
            pokedexRepository.save(pokemon5);
        }
    }
}
