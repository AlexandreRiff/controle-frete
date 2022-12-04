package controlefrete.views;

import controlefrete.enums.FreteEstadosEnum;
import controlefrete.services.FreteService;
import controlefrete.models.FreteModel;
import controlefrete.strategies.TaxaFrete;
import controlefrete.strategies.TaxaFreteContext;

import javax.swing.*;
import java.util.List;

public class MenuFrete {

    private static final int CADASTRAR_FRETE = 1;
    private static final int MOSTRAR_INFORMACOES = 2;
    private static final int SAIR = 3;

    private FreteModel freteModel;
    private FreteService freteService;

    public MenuFrete() {
        this.freteService = new FreteService();
    }

    private static String retornarTextoMenu() {
        StringBuilder menu = new StringBuilder();

        menu.append("Menu Frete");
        menu.append("\n");
        menu.append("[ 1 ] - Cadastrar Frete");
        menu.append("\n");
        menu.append("[ 2 ] - Mostrar informacoes Fretes");
        menu.append("\n");
        menu.append("[ 3 ] - Sair");
        menu.append("\n\n");
        menu.append("Informe sua opcao: ");

        return menu.toString();
    }

    private int mostrarMenuEretornarOpcao() {
        String opcaoSelecionada = JOptionPane.showInputDialog(null, retornarTextoMenu());
        return Integer.parseInt(opcaoSelecionada);
    }

    public void verificarOpcaoSelecionada() {
        while (true) {
            int opcaoSelecionada = mostrarMenuEretornarOpcao();
            if (opcaoSelecionada == CADASTRAR_FRETE) {
                cadastrarFrete();
            } else if (opcaoSelecionada == MOSTRAR_INFORMACOES) {
                mostrarInformacoesFretes();
            } else if (opcaoSelecionada == SAIR) {
                JOptionPane.showMessageDialog(null, "Programa sera encerrado!");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Opcao invalida!");
            }
        }
    }

    private void cadastrarFrete() {
        StringBuilder menuDestino = new StringBuilder();

        menuDestino.append("Selecione o Destino");
        menuDestino.append("\n");
        menuDestino.append("[ 1 ] - Santa Catarina");
        menuDestino.append("\n");
        menuDestino.append("[ 2 ] - Sao Paulo");
        menuDestino.append("\n");
        menuDestino.append("[ 3 ] - Sair");
        menuDestino.append("\n\n");
        menuDestino.append("Informe sua opcao: ");

        String opcaoDestinoString = JOptionPane.showInputDialog(null, menuDestino.toString());
        String pesoString = JOptionPane.showInputDialog(null, "Digite o peso da carga (Kg):");

        int opcaoDestino = Integer.parseInt(opcaoDestinoString);
        double peso = Double.parseDouble(pesoString);

        TaxaFreteContext taxaFreteContext = new TaxaFreteContext();
        TaxaFrete taxaFrete = taxaFreteContext.getStrategy(opcaoDestino);
        double valor = taxaFrete.calcularTaxa(peso);

        String destino = "";

        for(FreteEstadosEnum freteEstadosEnum : FreteEstadosEnum.values()) {
            if(freteEstadosEnum.getValor() == opcaoDestino) {
                destino = freteEstadosEnum.getDescricao();
            }
        }

        freteModel = new FreteModel();
        freteModel.setDestino(destino);
        freteModel.setPeso(peso);
        freteModel.setValor(valor);

        freteService.salvar(freteModel);
    }

    private void mostrarInformacoesFretes() {
        List<FreteModel> listaFrete = freteService.buscarTudo();

        StringBuilder informacoesFrete = new StringBuilder();

        if(listaFrete.isEmpty()) {
            informacoesFrete.append("Nenhum frete cadastrado!");
        } else {
            for (FreteModel frete : listaFrete) {
                informacoesFrete.append("Destino: " + frete.getDestino());
                informacoesFrete.append("\n");
                informacoesFrete.append("Peso: " + frete.getPeso());
                informacoesFrete.append("\n");
                informacoesFrete.append("Valor: " + frete.getValor());
                informacoesFrete.append("\n\n");
            }
        }

        JOptionPane.showMessageDialog(null, informacoesFrete.toString());
    }

}
