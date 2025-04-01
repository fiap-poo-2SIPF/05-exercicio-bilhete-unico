import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {

    // vetor para armazenar os objetos do tipo bilhete
    private Bilhete[] bilhete = new Bilhete[3];
    private int index = 0;

    // método para exibir o menu principal da aplicação
    public void menuPrincipal() {
        int opcao;
        String menu = "1. Administrador\n2. Usuário\n3. Finalizar";
        do {
            opcao = parseInt(showInputDialog(menu));
            if(opcao < 1 || opcao > 3) {
                showMessageDialog(null, "Opção inválida");
            }
            else {
                switch(opcao) {
                    case 1:
                        menuAdministrador();
                        break;
                    case 2:
                        menuUsuario();
                        break;
                }
            }
        } while(opcao != 3);
    }

    // método para exibir o menu do administrador
    private void menuAdministrador() {
        int opcao;
        String menu = "1. Emitir bilhete\n2. Listar bilhetes\n3. Remover bilhete\n4. Sair";
        do {
            opcao = parseInt(showInputDialog(menu));
            if(opcao < 1 || opcao > 4) {
                showMessageDialog(null, "opção inválida");
            }
            else {
                switch(opcao) {
                    case 1:
                        emitirBilhete();
                        break;
                    case 2:
                        listarBilhetes();
                        break;
                    case 3:
                        removerBilhete();
                        break;
                }
            }
        } while(opcao != 4);
    }

    // método para emitir um bilhete --> gerar um objeto e armazenar no vetor
    private void emitirBilhete() {
        String nome, perfil;
        long cpf;
        if(index < bilhete.length) {
            nome = showInputDialog("Nome do usuário: ");
            cpf = parseLong(showInputDialog("CPF:"));
            perfil = showInputDialog("Perfil --> professor ou estudante ou comum");
            bilhete[index] = new Bilhete(new Usuario(nome, cpf, perfil));
            index++;
        }
        else {
            showMessageDialog(null, "Entre em contato com a administração");
        }
    }

    // método para listar os dados de cada um dos objetos armazenados
    private void listarBilhetes() {
        DecimalFormat df = new DecimalFormat("0.00");
        String aux = "";
        for(int i = 0; i < index; i++) {
            aux += "Número do bilhete: " + bilhete[i].numero + "\n";
            aux += "Nome do usuário: " + bilhete[i].usuario.nome + "\n";
            aux += "Perfil (tipo de tarifa): " + bilhete[i].usuario.perfil + "\n";
            aux += "Saldo R$ " + df.format(bilhete[i].saldo) + "\n";
            aux += "-----------------------------------------\n";
        }
        showMessageDialog(null, aux);
    }

    // método para exibir o menu do usuário do bilhete
    private void menuUsuario() {
        int opcao;
        String menu = "1. Carregar bilhete\n2. Consultar saldo\n" +
                      "3. Passar na catraca\n4. Sair";
        do {
            opcao = parseInt(showInputDialog(menu));
            if(opcao < 1 || opcao > 4) {
                showMessageDialog(null, "Opção inválida");
            }
            else {
                switch (opcao) {
                    case 1:
                        carregarBilhete();
                        break;
                    case 2:
                        consultarSaldo();
                        break;
                    case 3:
                        passarNaCatraca();
                        break;
                }
            }
        } while(opcao != 4);
    }

    // método para carregar o bilhete com um valor informado pelo usuário
    private void carregarBilhete() {
        int posicao = pesquisar();
        double valor;
        if(posicao != -1) {
            valor = parseDouble(showInputDialog("Valor da recarga"));
            bilhete[posicao].carregar(valor);
        }
    }

    // método para consultar o saldo de um bilhete --> usuário informa o cpf
    private void consultarSaldo() {
        int posicao = pesquisar();
        if(posicao != -1) {
            showMessageDialog(null, "Saldo R$ " + bilhete[posicao].consultarSaldo());
        }
    }

    // método para simular a passagem na catraca do metrô
    private void passarNaCatraca() {
        int posicao = pesquisar();
        if(posicao != -1) {
            bilhete[posicao].passarNaCatraca();
        }
    }

    // método para pesquisar um bilhete pelo cpf do usuário
    private int pesquisar() {
        int posicao = -1;
        long cpf = parseLong(showInputDialog("CPF"));
        for(int i = 0; i < index; i++) {
            if(bilhete[i].usuario.cpf == cpf) {
                posicao = i;
                return posicao;
            }
        }
        showMessageDialog(null, cpf + "não encontrado");
        return posicao;
    }

    // método para remover um bilhete a partir de um cpf
    private void removerBilhete() {
        int resposta;
        int posicao = pesquisar();

        if(posicao != -1) {
            resposta = showConfirmDialog(null, "Tem certeza que deseja remover o bilhete?");
            if(resposta == YES_OPTION) {
                bilhete[posicao] = bilhete[index - 1];
                index--;
            }
        }
    }
}
