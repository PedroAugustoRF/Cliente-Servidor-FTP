import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteFTP {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o caminho na qual o arquivo está: ");
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

        try (Socket socket = new Socket("127.0.0.1", 45232);

             BufferedReader leitorArquivo = new BufferedReader(new FileReader(caminhoArquivo)); PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Enviando arquivo: " + caminhoArquivo + "...");

            String linha;
            while ((linha = leitorArquivo.readLine()) != null) out.println(linha);

            System.out.println("Arquivo enviado com sucesso!");

            socket.shutdownOutput();

            System.out.print("\nDigite o caminho para salvar o arquivo que virá do SERVIDOR: ");
            String destinoRecebido = sc.nextLine();

            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); BufferedWriter escritorRecebido = new BufferedWriter(new FileWriter(destinoRecebido))) {

                System.out.println("Recebendo arquivo do servidor...\n");
                String linhaRecebida;

                while ((linhaRecebida = in.readLine()) != null) {
                    escritorRecebido.write(linhaRecebida);
                    escritorRecebido.newLine();
                    System.out.println("Servidor: " + linhaRecebida);
                }
                System.out.println("\nArquivo recebido e salvo com sucesso!");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}