import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServidorFTP {
    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(45232)) {
            System.out.println("Aguardando conexão...");

            try (Socket conexao = servidor.accept(); BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()))) {
                Scanner sc = new Scanner(System.in);

                System.out.println("Cliente conectado!\n");

                System.out.print("Digite em qual caminho está arquivo que quer receber: ");
                String arquivo = sc.nextLine();

                File destino = new File(arquivo);

                try (BufferedWriter escritor = new BufferedWriter(new FileWriter(destino))) {
                    String linha;
                    System.out.println("Arquivo Recebido\n");

                    while ((linha = in.readLine()) != null) {
                        escritor.write(linha);
                        escritor.newLine();

                        System.out.println(linha);
                    }
                }
                System.out.println("\nArquivo salvo com sucesso em: " + destino.getAbsolutePath());

                System.out.print("\nDigite o caminho do arquivo que deseja ENVIAR ao cliente: ");
                String caminhoArquivo = sc.nextLine();

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
                    boolean isWriting = true;

                    while (isWriting) {
                        System.out.print("Escreva uma linha: ");
                        String frase = sc.nextLine();
                        bw.write(frase);
                        bw.newLine();

                        System.out.println("Deseja escrever mais uma linha (S/N) ?");
                        char resp = sc.next().toUpperCase().charAt(0);
                        sc.nextLine();

                        if (resp == 'S') isWriting = true;
                        else isWriting = false;
                    }

                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }

                try (PrintWriter out = new PrintWriter(conexao.getOutputStream(), true); BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
                    System.out.println("Enviando arquivo para o cliente...");
                    String linhaSaida;

                    while ((linhaSaida = br.readLine()) != null) out.println(linhaSaida);

                    System.out.println("Envio finalizado!");
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}