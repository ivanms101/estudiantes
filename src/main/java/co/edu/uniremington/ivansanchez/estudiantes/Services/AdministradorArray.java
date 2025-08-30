package co.edu.uniremington.ivansanchez.estudiantes.Services;

import co.edu.uniremington.ivansanchez.estudiantes.Models.Estudiantes;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Data
@Service
public class AdministradorArray implements IAdministradorArray {
    private ArrayList<Estudiantes> estudiantes = new ArrayList<>();

    public AdministradorArray() {
        this.estudiantes.add(new Estudiantes(1, "Ivan", "ivan@gmail.com"));
        this.estudiantes.add(new Estudiantes(2, "Oscar", "oscar@gmail.com"));
        this.estudiantes.add(new Estudiantes(3, "Reinaldo", "reinaldo@gmail.com"));
        this.estudiantes.add(new Estudiantes(4, "Alberto", "alberto@gmial.com"));
    }

    //CREAR
    public boolean crear(Estudiantes estudiante) {
        if (buscar(estudiante.getId()) == null) {
            int idNuevo = crearId();
            estudiante.setId(idNuevo);
            estudiantes.add(estudiante);
            return true;
        }
        return false;
    }

    //LEER
    public Estudiantes buscar(int id) {
        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                return estudiante;
            }
        }
        return null;
    }

    public ArrayList<Estudiantes> listar() {
        return new ArrayList<>(estudiantes);
    }

    //ACTUALIZAR
    public boolean actualizar(Estudiantes estudiante, int id) {
        Estudiantes buscado = buscar(id);
        if (buscado == null) {
            return false;
        } else {
            buscado.setNombre(estudiante.getNombre());
            buscado.setCorreo(estudiante.getCorreo());
            return true;
        }
    }

    //ELIMINAR
    public boolean eliminar(int id) {
        Estudiantes buscado = buscar(id);
        if (buscado == null) {
            return false;
        } else {
            estudiantes.remove(buscado);
            return true;
        }

    }

    //CREAD ID
    private int crearId() {
        int maxId = 0;
        for (Estudiantes e : estudiantes) {
            if (e.getId() > maxId) {
                maxId = e.getId();
            }
        }
        return maxId + 1;
    }

}
