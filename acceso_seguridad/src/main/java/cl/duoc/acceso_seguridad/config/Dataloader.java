package cl.duoc.acceso_seguridad.config;

import cl.duoc.acceso_seguridad.model.AcsSeguridad;
import cl.duoc.acceso_seguridad.repository.AcsSeguridadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements CommandLineRunner {

    @Autowired
    private AcsSeguridadRepository acsSeguridadRepository;

    @Override
    public void run(String... args) throws Exception {
        if (acsSeguridadRepository.count() == 0) {
            System.out.println("--> Cargando datos iniciales en MS Acceso Seguridad...");

            // Estructura: (idUsuario, nombreUsuario, contrasenaEncriptada, rolAsignado)
            AcsSeguridad usuario1 = new AcsSeguridad(null, "juan_perez", "hash_juan_123456789123", "ENTRENADOR");
            AcsSeguridad usuario2 = new AcsSeguridad(null, "ash_ketchum", "hash_pika_3211234567891", "ENTRENADOR");
            AcsSeguridad usuario3 = new AcsSeguridad(null, "silver_rocket", "hash_silver_991234567890123", "ENTRENADOR");

            acsSeguridadRepository.save(usuario1);
            acsSeguridadRepository.save(usuario2);
            acsSeguridadRepository.save(usuario3);

            System.out.println("--> ¡Usuarios de seguridad creados con éxito!");
        }
    }
}
