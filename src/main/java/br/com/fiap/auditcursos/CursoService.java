package br.com.fiap.auditcursos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CursoService {

    private final CursoStore store;

    @Inject
    public CursoService(CursoStore store) {
        this.store = store;
    }

    public ConsultaCursosResponse listar() {
        return ConsultaCursosResponse.ok(store.listarTodos());
    }
}
