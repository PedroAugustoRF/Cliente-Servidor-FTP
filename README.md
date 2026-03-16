# 📡 Java Socket File Transfer (Mini FTP)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge\&logo=java\&logoColor=white)
![Sockets](https://img.shields.io/badge/TCP-Sockets-blue?style=for-the-badge)
![Networking](https://img.shields.io/badge/Networking-Client--Server-green?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Working-success?style=for-the-badge)

Sistema de **transferência de arquivos em Java** baseado na arquitetura **Cliente-Servidor**, utilizando **Sockets TCP** para enviar e receber arquivos `.txt`.

O projeto simula um **mini servidor FTP**, permitindo comunicação direta entre cliente e servidor para transferência de dados através da rede.

---

# 🧠 Objetivo do Projeto

Este projeto foi desenvolvido com o objetivo de praticar conceitos fundamentais de:

* comunicação em rede
* sockets TCP
* transferência de arquivos
* arquitetura cliente-servidor
* manipulação de arquivos com Java IO

---

# 🏗 Arquitetura do Sistema

```
                +-------------------+
                |      Cliente      |
                |    ClienteFTP     |
                +---------+---------+
                          |
                          | Conexão TCP
                          |
                          v
                +-------------------+
                |      Servidor     |
                |    ServidorFTP    |
                +---------+---------+
                          |
                          |
                +-------------------+
                |  Sistema de Arquivos |
                |  (Envio / Recebimento) |
                +-------------------+
```

Fluxo do sistema:

1️⃣ Cliente conecta ao servidor
2️⃣ Cliente envia arquivo
3️⃣ Servidor recebe e salva
4️⃣ Servidor pode enviar arquivo de volta
5️⃣ Cliente recebe o arquivo

---

# 📂 Estrutura do Projeto

```
java-ftp-socket
│
├── ClienteFTP.java
├── ServidorFTP.java
│
└── README.md
```

---

# 🚀 Tecnologias Utilizadas

* **Java**
* **Java Networking (Sockets)**
* **TCP/IP**
* **Java IO**
* **Buffered Streams**

---

# ⚙️ Funcionamento

## Inicialização do Servidor

O servidor cria um `ServerSocket` e aguarda conexões de clientes.

```java
ServerSocket servidor = new ServerSocket(12345);
Socket cliente = servidor.accept();
```

Quando um cliente se conecta, o servidor inicia a transferência de dados.

---

## Conexão do Cliente

O cliente estabelece conexão com o servidor utilizando um `Socket`.

```java
Socket socket = new Socket("localhost", 12345);
```

Após conectar, o cliente pode:

* enviar arquivos
* receber arquivos

---

# 📤 Envio de Arquivo

O envio de arquivos utiliza **streams de leitura e escrita**:

```java
while ((linha = leitorArquivo.readLine()) != null) {
    out.println(linha);
}
```

Após o envio:

```java
socket.shutdownOutput();
```

Isso sinaliza ao servidor que o envio foi finalizado.

---

# 📥 Recebimento de Arquivo

O servidor recebe o conteúdo linha por linha:

```java
while ((linha = in.readLine()) != null) {
    writer.write(linha);
}
```

---

# ▶️ Como Executar

## 1️⃣ Clonar o repositório

```bash
git clone https://github.com/seuusuario/java-ftp-socket.git
```

---

## 2️⃣ Compilar o projeto

```bash
javac ServidorFTP.java
javac ClienteFTP.java
```

---

## 3️⃣ Iniciar o servidor

```bash
java ServidorFTP
```

---

## 4️⃣ Executar o cliente

Em outro terminal:

```bash
java ClienteFTP
```

---

# 📌 Funcionalidades

✔ Conexão via TCP
✔ Transferência de arquivos `.txt`
✔ Comunicação cliente-servidor
✔ Uso de Java IO
✔ Encerramento seguro da conexão

---

# 📚 Conceitos Aplicados

Durante o desenvolvimento foram aplicados conceitos importantes de engenharia de software:

* **Arquitetura Cliente-Servidor**
* **Sockets TCP**
* **Manipulação de arquivos**
* **Streams em Java**
* **Tratamento de exceções**
* **Comunicação em rede**

---

# 🔮 Melhorias Futuras

Algumas evoluções possíveis:

* suporte a **múltiplos clientes simultâneos (Threads)**
* envio de **arquivos binários**
* implementação de **comandos FTP (GET / PUT / LIST)**
* autenticação de usuários
* interface gráfica
* barra de progresso de upload

---

# 👨‍💻 Autor

**Pedro Augusto Ribeiro Ferreira e colaboração de Eduardo Santana Cruz Almeida**
Estudantes de **Engenharia de Software**

---

# ⭐ Se gostou do projeto

Deixe uma **⭐ no repositório** para apoiar o desenvolvimento.

---
