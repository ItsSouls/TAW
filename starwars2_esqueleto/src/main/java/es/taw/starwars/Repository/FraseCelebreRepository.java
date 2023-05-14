package es.taw.starwars.Repository;

import es.taw.starwars.entity.FraseCelebre;
import es.taw.starwars.entity.Pelicula;
import es.taw.starwars.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FraseCelebreRepository extends JpaRepository<FraseCelebre,Integer> {
    @Query("select p from FraseCelebre p order by p.pelicula.titulo")
    public List<FraseCelebre> orderbypelicula();

    @Query("select p from FraseCelebre p order by p.personaje.nombre")
    public List<FraseCelebre> orderbypersonaje();

    @Query("select p from FraseCelebre p order by p.pelicula.titulo, p.personaje.nombre")
    public List<FraseCelebre> orderbypersonajepelicula();
}


