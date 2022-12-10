package br.com.mesttra.dao;

import br.com.mesttra.entity.Condutor;
import br.com.mesttra.entity.Multa;
import br.com.mesttra.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class VeiculoDAO {

    private EntityManager em;

    public VeiculoDAO() {
        this.em = Persistence.createEntityManagerFactory("multas2").createEntityManager();
    }

    public boolean criaVeiculo(Veiculo veiculo) {


        this.em.getTransaction().begin();
        this.em.persist(veiculo);
        this.em.getTransaction().commit();

        return true;
    }

    public Veiculo buscaVeiculo(String placa) {
        return em.find(Veiculo.class, placa);
    }

//    public boolean addMultas(String placa, Multa multa) {
//
//        Veiculo veiculo = this.buscaVeiculo(placa);
//
//        if (veiculo != null) {
//            this.em.getTransaction().begin();
//            veiculo.getMultas().add(multa);
//            this.em.getTransaction().commit();
//            return true;
//        }
//
//        return false;
//
//
//    }

    public boolean removeVeiculo(String placa) {
        Veiculo veiculo = this.buscaVeiculo(placa);

        if (veiculo != null) {
            this.em.getTransaction().begin();
            this.em.remove(veiculo);
            this.em.getTransaction().commit();
            return true;
        }

        return false;
    }

    public List<Veiculo> todosVeiculos() {
        return this.em.createQuery("SELECT v FROM Veiculo v", Veiculo.class).getResultList();
    }


}
