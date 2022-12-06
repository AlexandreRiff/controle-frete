package controlefrete.thread;

import controlefrete.repositories.FreteRepository;

public class RelatorioDiarioThread extends Thread {

    public void gerarRelatorio() {
        new RelatorioDiarioThread().start();
    }

    @Override
    public void run() {
        final long DIA_EM_MILISEGUNDOS = 86400000;
        while (true) {
            FreteRepository instanciaFreteRepository = FreteRepository.getInstance();
            System.out.println(instanciaFreteRepository.buscarTudo().toString());
            try {
                sleep(DIA_EM_MILISEGUNDOS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}