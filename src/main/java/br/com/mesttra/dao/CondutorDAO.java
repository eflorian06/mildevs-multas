package br.com.mesttra.dao;

import br.com.mesttra.entity.Condutor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class CondutorDAO {
    private EntityManager em;

    public CondutorDAO() {
        this.em = Persistence.createEntityManagerFactory("multas2").createEntityManager();
    }

    public boolean criaCondutor(Condutor condutor) {

        this.em.getTransaction().begin();
        this.em.persist(condutor);
        this.em.getTransaction().commit();

        return true;
    }

    public Condutor buscaCondutor(int nroCnh) {
        return em.find(Condutor.class, nroCnh);
    }

    private Condutor buscaCondutorId(int nroCnh) {
        return em.find(Condutor.class, nroCnh);
    }

    public List<Condutor> buscarTodosCondutores() {
        return this.em.createQuery("SELECT c FROM Condutor c", Condutor.class).getResultList();
    }

    public boolean removeCondutor(int nroCnh) {
        Condutor condutor = this.buscaCondutor(nroCnh);

        if (condutor != null) {
            this.em.getTransaction().begin();
            this.em.remove(condutor);
            this.em.getTransaction().commit();
            return true;
        }

        return false;
    }

    public boolean atualizaCondutor(Condutor infrator, int pontosMulta) {
        Condutor condutorAtualizado = this.buscaCondutorId(infrator.getNroCnh());
        if (condutorAtualizado != null) {
            this.em.getTransaction().begin();
            condutorAtualizado.setPontuacao(condutorAtualizado.getPontuacao() + pontosMulta);
            this.em.getTransaction().commit();
            return true;
        }
        return false;
    }


}
