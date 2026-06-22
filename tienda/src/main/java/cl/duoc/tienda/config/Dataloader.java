package cl.duoc.tienda.config;

import cl.duoc.tienda.model.Tienda;
import cl.duoc.tienda.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Dataloader implements CommandLineRunner {

    @Autowired
    private TiendaRepository tiendaRepository;

    @Override
    public void run(String... args) throws Exception {
        if(tiendaRepository.count()==0){
            System.out.println("Datos de Prueba");
            Tienda tienda1=new Tienda(null,"Ash-Ketchum-uuid",25L,500, LocalDate.now());
            Tienda tienda2=new Tienda(null,"Misy-Mamani-uuid",150L,150, LocalDate.now());

            tiendaRepository.save(tienda1);
            tiendaRepository.save(tienda2);
        }
    }
}
