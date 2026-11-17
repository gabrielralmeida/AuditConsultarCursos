package br.com.fiap.auditcursos;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class CursoRepository implements PanacheRepositoryBase<Curso, Integer> {
}
