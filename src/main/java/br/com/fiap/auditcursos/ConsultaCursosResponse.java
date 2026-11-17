package br.com.fiap.auditcursos;

import java.util.List;

public record ConsultaCursosResponse(
        boolean sucesso,
        List<CursoItem> cursos,
        List<String> mensagens) {

    public ConsultaCursosResponse {
        cursos = cursos == null ? List.of() : List.copyOf(cursos);
        mensagens = mensagens == null ? List.of() : List.copyOf(mensagens);
    }

    public static ConsultaCursosResponse ok(List<Curso> cursos) {
        List<CursoItem> itens = cursos.stream()
                .map(curso -> new CursoItem(curso.getCodigoCurso(), curso.getNomeCurso(), curso.getQtdeHoras()))
                .toList();
        return new ConsultaCursosResponse(true, itens, List.of());
    }

    public record CursoItem(Integer codigoCurso, String nomeCurso, Integer qtdeHoras) {
    }
}
