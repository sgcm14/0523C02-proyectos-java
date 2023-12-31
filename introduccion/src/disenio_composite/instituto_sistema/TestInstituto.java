package disenio_composite.instituto_sistema;

import java.util.List;

public class TestInstituto {
    public static void main(String[] args) {
        Curso frontEnd = new Frontend("Front End", "Curso de Front End", 16, 2, 1000);
        Curso backEnd = new Backend("Back End", "Curso de Back End", 20, 2, 900);

        ProgramaIntensivo fullStack = new ProgramaIntensivo("FullStack", "Programa Full Stack", 20);

        fullStack.agregarCurso(frontEnd);
        fullStack.agregarCurso(backEnd);


        TallerIntensivo tallerJava = new TallerIntensivo("Taller de Java", "Aprende Java con prácticos", 10, 500);
        TallerIntensivo tallerPython = new TallerIntensivo("Taller de Python", "Aprende Python con prácticos", 8, 450);

        Carrera ingenieriaInformatica = new Carrera("Ingeniería Informática", "Carrera de Ingeniería Informática", 5000);

        ingenieriaInformatica.agregarCursoOTaller(new IntroduccionProgramacion("Introducción a la Programación", "Curso introductorio", 12, 2, 800));
        ingenieriaInformatica.agregarCursoOTaller(new EstructuraDatos("Estructuras de Datos", "Curso avanzado", 15, 3, 1000));
        ingenieriaInformatica.agregarCursoOTaller(tallerJava);
        ingenieriaInformatica.agregarCursoOTaller(tallerPython);

        System.out.println("Informe de Ofertas Académicas:");
        mostrarInforme(frontEnd);
        mostrarInforme(backEnd);
        mostrarInforme(fullStack);

        mostrarInforme(tallerJava);
        mostrarInforme(tallerPython);
        mostrarInforme(ingenieriaInformatica);

    }

    private static void mostrarInforme(Curso curso) {
        System.out.println("Nombre: " + curso.getNombre());
        System.out.println("Descripción: " + curso.getDescripcion());
        System.out.println("Precio: " + curso.calcularPrecio() + " pesos");

        if (curso instanceof Carrera) {
            Carrera carrera = (Carrera) curso;
            List<Curso> cursosYTalleres = carrera.getCursosYTalleres();

            if (!cursosYTalleres.isEmpty()) {
                System.out.println("Cursos y Talleres en la Carrera:");
                for (Curso cursoOTaller : cursosYTalleres) {
                    System.out.println("- " + cursoOTaller.getNombre() + ": " + cursoOTaller.getDescripcion());
                }
            } else {
                System.out.println("La carrera no contiene cursos ni talleres.");
            }
        } else if (curso instanceof ProgramaIntensivo) {
            ProgramaIntensivo programaIntensivo = (ProgramaIntensivo) curso;
            List<Curso> nombresCursos = programaIntensivo.obtenerNombresCursos();

            if (!nombresCursos.isEmpty()) {
                System.out.println("Cursos en el Programa Intensivo:");
                for (Curso nombreCurso : nombresCursos) {
                    System.out.println("- " + nombreCurso.getNombre()+ ": " + nombreCurso.getDescripcion());
                }
            } else {
                System.out.println("El programa intensivo no contiene cursos.");
            }
        }

        System.out.println();
    }
}
