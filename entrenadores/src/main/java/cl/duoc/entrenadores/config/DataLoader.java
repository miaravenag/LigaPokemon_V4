package cl.duoc.entrenadores.config;

import cl.duoc.entrenadores.model.Entrenador;
import cl.duoc.entrenadores.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Override
    public void run(String... args) throws Exception {
        if (entrenadorRepository.count() == 0) {
            System.out.println("Datos de Prueba");
            Entrenador entrenador1=new Entrenador(null,"juan","perez","kanto",5,null);
            Entrenador entrenador2=new Entrenador(null,"ash","ketchum","kanto",1,null);
            Entrenador entrenador3=new Entrenador(null,"silver","rocket","sinoh",10,null);

            entrenadorRepository.save(entrenador1);
            entrenadorRepository.save(entrenador2);
            entrenadorRepository.save(entrenador3);
        }
    }
}
