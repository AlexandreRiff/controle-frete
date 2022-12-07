package controlefrete.thread;

import controlefrete.repositories.FreteRepository;
import controlefrete.services.FreteService;

public class RelatorioDiarioThread extends Thread {

    private FreteService freteService;

    public RelatorioDiarioThread() {
        freteService = new FreteService();
    }

    public void gerarRelatorio() {
        new RelatorioDiarioThread().start();
    }

    @Override
    public void run() {
        final long DIA_EM_MILISEGUNDOS = 86400000;
        while (true) {
            System.out.println(freteService.buscarTudo().toString());
            try {
                sleep(DIA_EM_MILISEGUNDOS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
