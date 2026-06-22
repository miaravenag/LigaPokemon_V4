package cl.duoc.medallas.config;

import cl.duoc.medallas.model.Medalla;
import cl.duoc.medallas.repository.MedallasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements CommandLineRunner {

    @Autowired
    private MedallasRepository medallasRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verificamos si ya existen datos para no duplicar en cada reinicio
        if (medallasRepository.count() == 0) {
            System.out.println("--> Cargando datos iniciales en MS Medallas...");

            Medalla medalla1 = new Medalla(null, "1", "Medalla Roca", true);
            Medalla medalla2 = new Medalla(null, "2", "Medalla Cascada", true);
            Medalla medalla3 = new Medalla(null, "2", "Medalla Trueno", false);
            Medalla medalla4 = new Medalla(null, "3", "Medalla Trueno ", true);

            medallasRepository.save(medalla1);
            medallasRepository.save(medalla2);
            medallasRepository.save(medalla3);
            medallasRepository.save(medalla4);

            System.out.println("--> ¡Ficheros de Medallas inicializados con éxito!");

        }
    }
}
