package controlefrete.repositories;

import controlefrete.models.FreteModel;

import java.util.ArrayList;
import java.util.List;

public class FreteRepository {

    private static FreteRepository instance;
    private static List<FreteModel> lista = new ArrayList<>();

    private FreteRepository() {}

    public static FreteRepository getInstance() {
        if(instance == null) {
            instance = new FreteRepository();
        }
        return instance;
    }

    public void salvar(FreteModel freteModel) {
        lista.add(freteModel);
    }

    public List<FreteModel> buscarTudo() {
        return lista;
    }
}
