package org.src.model;
import org.exceptions.EstudianteNoInscritoEnCursoException;
import org.exceptions.EstudianteYaInscritoException;
import org.interfaces.ServiciosAcademicosI;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicosI {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Integer, ArrayList<Estudiante>> estudiantesPorCurso;

    public GestorAcademico() {
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        estudiantesPorCurso = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) throws EstudianteYaInscritoException {
        for (Estudiante e : estudiantes) {
            if (e.getId() == estudiante.getId()) {
                throw new EstudianteYaInscritoException("El estudiante con ID " + estudiante.getId() + " ya está matriculado.");
            }
        }
        estudiantes.add(estudiante);
    }

    @Override
    public void agregarCurso(Curso curso) {
        for (Curso c : cursos) {
            if (c.getId() == curso.getId()) {
                System.out.println("El curso ya existe.");
                return;
            }
        }
        cursos.add(curso);
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        ArrayList<Estudiante> inscritos = estudiantesPorCurso.computeIfAbsent(idCurso, k -> new ArrayList<>());
        if (inscritos.contains(estudiante)) {
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
        }
        inscritos.add(estudiante);
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        ArrayList<Estudiante> inscritos = estudiantesPorCurso.get(idCurso);
        if (inscritos == null || inscritos.stream().noneMatch(e -> e.getId() == idEstudiante)) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso.");
        }
        inscritos.removeIf(e -> e.getId() == idEstudiante);
    }

    // Métodos para mostrar los datos
    public void mostrarEstudiantes() {
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }

    public void mostrarCursos() {
        for (Curso curso : cursos) {
            System.out.println(curso);
        }
    }
}