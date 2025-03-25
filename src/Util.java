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
                }
            }
        } while(opcao != 4);
    }

    // método para emitir um bilhete --> gerar um objeto e armazenar no vetor
    private void emitirBilhete() {
        String nome, perfil;
        long cpf;
    }
}
