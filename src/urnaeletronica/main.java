package urnaeletronica;
import javax.swing.JOptionPane;

public class main {

    public static void main(String[] args) {
    
        String letras = "";
        int qtdCandidatos = 0;
        int escolha = 0;
        String continuar = "";
        String espaço = "\n";
        
        qtdCandidatos = Integer.parseInt(JOptionPane.showInputDialog("Quantos candidatos?"));
        String palavra[] = new String[qtdCandidatos];
        int votos[] = new int[qtdCandidatos]; 
        
      
        int numero = 0;
        for (int contador = 0; contador < qtdCandidatos; contador++) {
            palavra[contador] = JOptionPane.showInputDialog("Informe o nome do candidato " + (contador + 1));
            
            numero++;
            letras = letras + numero + ": " + palavra[contador] + espaço;
        }
        
        do {
            escolha = Integer.parseInt(JOptionPane.showInputDialog(null, "Os candidatos são:" + espaço + letras + "\nDigite o número do seu voto:"));
            
            int indiceVoto = escolha - 1;
            
            if (indiceVoto >= 0 && indiceVoto < qtdCandidatos) {
                votos[indiceVoto]++; 
                JOptionPane.showMessageDialog(null, "Voto registrado para: " + palavra[indiceVoto]);
            } else {
                JOptionPane.showMessageDialog(null, "Candidato inválido! Voto não computado.");
            }
            
            continuar = JOptionPane.showInputDialog("Deseja receber mais um voto?"
                    + "\nsim"
                    + "\nnão");
            
        } while(continuar.equalsIgnoreCase("sim"));

        String resultadoFinal = "=== RESULTADO DA VOTAÇÃO ===" + espaço + espaço;
        for (int i = 0; i < qtdCandidatos; i++) {
            resultadoFinal += "Candidato: " + palavra[i] + " -> Votos: " + votos[i] + espaço + espaço;
        }
        
        JOptionPane.showMessageDialog(null, resultadoFinal);
    }
}


