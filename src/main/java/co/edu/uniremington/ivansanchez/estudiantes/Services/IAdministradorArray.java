package co.edu.uniremington.ivansanchez.estudiantes.Services;

import co.edu.uniremington.ivansanchez.estudiantes.Models.Estudiantes;

import java.util.ArrayList;

public interface IAdministradorArray {
    boolean crear(Estudiantes estudiante);

    Estudiantes buscar(int id);

    ArrayList<Estudiantes> listar();

    boolean actualizar(Estudiantes estudiante, int id);

    boolean eliminar(int id);
}
