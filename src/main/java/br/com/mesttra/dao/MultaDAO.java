package br.com.mesttra.dao;

import br.com.mesttra.entity.Multa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class MultaDAO {

    private EntityManager em;

    public MultaDAO() {
        this.em = Persistence.createEntityManagerFactory("multas2").createEntityManager();
    }

    public boolean criaMulta(Multa multa) {

        this.em.getTransaction().begin();
        this.em.merge(multa);
        this.em.getTransaction().commit();

        return true;
    }

    public Multa buscaMulta(int codigoMulta) {
        return this.em.find(Multa.class, codigoMulta);
    }

    public boolean removeMulta(int codigoMulta) {
        Multa multa = this.buscaMulta(codigoMulta);

        if (multa != null) {
            this.em.getTransaction().begin();
            this.em.remove(multa);
            this.em.getTransaction().commit();
            em.close();
            return true;
        }

        return false;
    }

    public List<Multa> todasMultas() {
        return this.em.createQuery("SELECT m FROM Multa m", Multa.class).getResultList();
    }
}
