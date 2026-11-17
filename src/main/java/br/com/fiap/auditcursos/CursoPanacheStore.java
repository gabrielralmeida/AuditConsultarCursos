package br.com.fiap.auditcursos;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class CursoPanacheStore implements CursoStore {

    private final CursoRepository repository;

    @Inject
    public CursoPanacheStore(CursoRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public List<Curso> listarTodos() {
        return repository.listAll(Sort.ascending("codigoCurso"));
    }
}
