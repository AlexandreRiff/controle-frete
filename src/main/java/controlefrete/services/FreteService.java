package controlefrete.services;

import controlefrete.repositories.FreteRepository;
import controlefrete.models.FreteModel;

import java.util.List;

public class FreteService {

    FreteRepository freteRepository;

    public FreteService() {
        this.freteRepository = FreteRepository.getInstance();
    }

    public void salvar(FreteModel freteModel) {
        freteRepository.salvar(freteModel);
    }

    public List<FreteModel> buscarTudo() {
        return freteRepository.buscarTudo();
    }

}
