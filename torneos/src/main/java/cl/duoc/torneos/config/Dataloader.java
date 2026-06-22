package cl.duoc.torneos.config;

import cl.duoc.torneos.model.Torneo;
import cl.duoc.torneos.repository.TorneoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements CommandLineRunner {

    @Autowired
    private TorneoRepositoy torneoRepositoy;

    @Override
    public void run(String... args) throws Exception {
        if (torneoRepositoy.count() == 0) {
            Torneo torneo1 = new Torneo(null, "Super Mega Liga de Unova", 8, "ABIERTA", null);
            Torneo torneo2 = new Torneo(null, "Increible Liga de Kalos", 8, "ABIERTA", null);
            Torneo torneo3 = new Torneo(null, "Ultima Mega Liga de Hoenn", 8, "ABIERTA", null);

            torneoRepositoy.save(torneo1);
            torneoRepositoy.save(torneo2);
            torneoRepositoy.save(torneo3);
        }
    }
}
