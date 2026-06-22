package cl.duoc.centropokemon.config;

import cl.duoc.centropokemon.model.CentroPk;
import cl.duoc.centropokemon.repository.CentroPkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements CommandLineRunner {

    @Autowired
    private CentroPkRepository centroPkRepository;

    @Override
    public void run(String... args) throws Exception {
        if (centroPkRepository.count() == 0) {
            CentroPk centroPk = new CentroPk(null, "Centro PK", "Pueblo Lavanda", "Kanto", "calle ghastly", 5, true);
            centroPkRepository.save(centroPk);
        }
    }
}
