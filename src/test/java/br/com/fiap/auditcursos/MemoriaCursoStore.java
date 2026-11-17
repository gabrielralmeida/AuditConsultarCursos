package br.com.fiap.auditcursos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

final class MemoriaCursoStore implements CursoStore {

    private final List<Curso> cursos = new ArrayList<>();

    void adicionar(Curso curso) {
        cursos.add(curso);
    }

    @Override
    public List<Curso> listarTodos() {
        return cursos.stream()
                .sorted(Comparator.comparing(Curso::getCodigoCurso))
                .toList();
    }
}
