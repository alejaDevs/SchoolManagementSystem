package org.innova;

import org.exceptions.EstudianteNoInscritoEnCursoException;
import org.exceptions.EstudianteYaInscritoException;
import org.src.model.Curso;
import org.src.model.Estudiante;
import org.src.model.GestorAcademico;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        // Instanciando el gestor académico
        GestorAcademico gestor = new GestorAcademico();

        // Creación de dos estudiantes
        Estudiante estudiante1 = new Estudiante(1, "Juan", "Pérez", LocalDate.of(2000, 1, 15), Estudiante.Estado.MATRICULADO);
        Estudiante estudiante2 = new Estudiante(2, "Ana", "López", LocalDate.of(1999, 5, 22), Estudiante.Estado.INACTIVO);

        // Creación de dos cursos
        Curso curso1 = new Curso(1, "Matemáticas", "Curso de matemáticas básicas", 5, "1.0");
        Curso curso2 = new Curso(2, "Historia", "Historia mundial", 4, "2.1");

        // Prueba de los métodos del gestor académico
        try {
            // Matricular estudiantes
            System.out.println("Matriculando estudiantes:");
            gestor.matricularEstudiante(estudiante1);
            gestor.matricularEstudiante(estudiante2);

            // Mostrar estudiantes matriculados
            System.out.println("\nEstudiantes matriculados:");
            gestor.mostrarEstudiantes();

            // Agregar cursos
            System.out.println("\nAgregando cursos:");
            gestor.agregarCurso(curso1);
            gestor.agregarCurso(curso2);

            // Mostrar cursos
            System.out.println("\nCursos disponibles:");
            gestor.mostrarCursos();

            // Inscribir estudiantes en cursos
            System.out.println("\nInscribiendo estudiantes en cursos:");
            gestor.inscribirEstudianteCurso(estudiante1, 1);  // Inscribir estudiante1 en Matemáticas
            gestor.inscribirEstudianteCurso(estudiante2, 2);  // Inscribir estudiante2 en Historia

            // Intentar inscribir al mismo estudiante en el mismo curso
            System.out.println("\nIntentando inscribir nuevamente a Juan en Matemáticas:");
            gestor.inscribirEstudianteCurso(estudiante1, 1);  // Esto lanzará la excepción

        } catch (EstudianteYaInscritoException e) {
            System.out.println("Excepción: " + e.getMessage());
        }

        try {
            // Desinscribir un estudiante de un curso
            System.out.println("\nDesinscribiendo estudiante 2 (Ana) del curso de Historia:");
            gestor.desinscribirEstudianteCurso(2, 2);

            // Intentar desinscribir un estudiante que no está inscrito
            System.out.println("\nIntentando desinscribir a un estudiante que no está inscrito:");
            gestor.desinscribirEstudianteCurso(2, 1);  // Esto lanzará la excepción

        } catch (EstudianteNoInscritoEnCursoException e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
}