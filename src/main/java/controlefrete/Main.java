package controlefrete;

import controlefrete.thread.RelatorioDiarioThread;
import controlefrete.views.MenuFrete;

public class Main {

    public static void main(String[] args) {
        new RelatorioDiarioThread().gerarRelatorio();
        MenuFrete menuFrete = new MenuFrete();
        menuFrete.verificarOpcaoSelecionada();

    }

}
