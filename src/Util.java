import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {

    // vetor para armazenar os objetos do tipo bilhete
    private Bilhete[] bilhete = new Bilhete[2];
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
}
