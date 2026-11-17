package br.com.fiap.auditcursos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

@ApplicationScoped
@Named("consultarCursos")
public class AuditConsultarCursosLambda implements RequestHandler<Object, ConsultaCursosResponse> {

    private final CursoService service;

    @Inject
    public AuditConsultarCursosLambda(CursoService service) {
        this.service = service;
    }

    @Override
    public ConsultaCursosResponse handleRequest(Object input, Context context) {
        return service.listar();
    }
}
