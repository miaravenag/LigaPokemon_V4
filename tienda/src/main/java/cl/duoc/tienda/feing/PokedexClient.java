package cl.duoc.tienda.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pokedex")
public interface PokedexClient {
    @GetMapping("/api/pokedex/{id}")
    Object getPokemonById(@PathVariable("id") Long id);
}