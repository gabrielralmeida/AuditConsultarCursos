package br.com.fiap.auditcursos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoServiceTest {

    private MemoriaCursoStore store;
    private CursoService service;

    @BeforeEach
    void setUp() {
        store = new MemoriaCursoStore();
        service = new CursoService(store);
    }

    @Test
    void listaVaziaDevolveSucessoSemCursos() {
        ConsultaCursosResponse resposta = service.listar();

        assertTrue(resposta.sucesso());
        assertEquals(List.of(), resposta.cursos());
        assertEquals(List.of(), resposta.mensagens());
    }

    @Test
    void listaTodosOsCursosNaOrdemDoCodigo() {
        store.adicionar(new Curso(3, "Banco de dados MySQL", 60));
        store.adicionar(new Curso(1, "Arquitetura Cloud Native", 40));
        store.adicionar(new Curso(2, "Desenvolvimento Java com Quarkus", 80));

        ConsultaCursosResponse resposta = service.listar();

        assertTrue(resposta.sucesso());
        assertEquals(List.of(), resposta.mensagens());
        assertEquals(
                List.of(
                        new ConsultaCursosResponse.CursoItem(1, "Arquitetura Cloud Native", 40),
                        new ConsultaCursosResponse.CursoItem(2, "Desenvolvimento Java com Quarkus", 80),
                        new ConsultaCursosResponse.CursoItem(3, "Banco de dados MySQL", 60)),
                resposta.cursos());
    }
}
