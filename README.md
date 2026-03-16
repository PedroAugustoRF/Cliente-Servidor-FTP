---

# 📡 Java FTP Client-Server

Sistema de **transferência de arquivos em Java** baseado em arquitetura **Cliente–Servidor**, utilizando **Sockets TCP** para envio e recebimento de arquivos `.txt`.

O projeto simula um **mini servidor FTP**, permitindo que um cliente se conecte ao servidor para **enviar e receber arquivos** através de comunicação de rede.

---

# 🚀 Tecnologias Utilizadas

* ☕ **Java**
* 📡 **Sockets TCP**
* 📂 **Java IO (Streams)**
* 🧠 **Arquitetura Cliente-Servidor**
* 💻 **Programação Orientada a Objetos**

---

# 🏗 Arquitetura do Sistema

O sistema segue o modelo clássico **Cliente-Servidor**:

```
Cliente FTP
     │
     │ Conexão TCP
     ▼
Servidor FTP
     │
     ├── Recebe arquivos enviados pelo cliente
     └── Envia arquivos solicitados pelo cliente
```

### Componentes

| Componente  | Responsabilidade                                        |
| ----------- | ------------------------------------------------------- |
| ClienteFTP  | Conectar ao servidor e enviar/receber arquivos          |
| ServidorFTP | Aguardar conexões e gerenciar transferência de arquivos |

---

# 📂 Estrutura do Projeto

```
FTP
│
├── ClienteFTP.java
│
├── ServidorFTP.java
│
└── README.md
```

---

# ⚙️ Como Funciona

### 1️⃣ Inicialização do Servidor

O servidor inicia um **ServerSocket** e fica aguardando conexões.

```java
ServerSocket servidor = new ServerSocket(12345);
Socket cliente = servidor.accept();
```

Quando um cliente se conecta, o servidor:

* recebe arquivos enviados
* pode enviar arquivos de volta ao cliente

---

### 2️⃣ Conexão do Cliente

O cliente se conecta ao servidor através de um **Socket**.

```java
Socket socket = new Socket("localhost", 12345);
```

Após conectar, ele pode:

* enviar um arquivo `.txt`
* receber um arquivo do servidor

---

### 3️⃣ Transferência de Arquivos

A transferência utiliza **streams de leitura e escrita**:

* `BufferedReader`
* `BufferedWriter`
* `PrintWriter`
* `FileReader`
* `FileWriter`

Exemplo de envio de dados:

```java
while ((linha = leitorArquivo.readLine()) != null) {
    out.println(linha);
}
```

---

# 📥 Como Executar o Projeto

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/seuusuario/seu-repositorio.git
```

---

### 2️⃣ Compilar os arquivos

```bash
javac ServidorFTP.java
javac ClienteFTP.java
```

---

### 3️⃣ Iniciar o servidor

```bash
java ServidorFTP
```

---

### 4️⃣ Executar o cliente

Em outro terminal:

```bash
java ClienteFTP
```

---

# 📌 Funcionalidades

✔ Conexão cliente-servidor via TCP
✔ Envio de arquivos `.txt`
✔ Recebimento de arquivos
✔ Comunicação via sockets
✔ Uso de **Java IO Streams**
✔ Encerramento seguro da conexão

---

# 🧠 Conceitos Aplicados

Este projeto demonstra na prática conceitos importantes de desenvolvimento:

* **Programação em Redes**
* **Sockets TCP**
* **Transferência de Arquivos**
* **Arquitetura Cliente-Servidor**
* **Gerenciamento de Streams**
* **Tratamento de Exceções**

---

# 📈 Possíveis Melhorias

Algumas evoluções futuras para o projeto:

* suporte a **múltiplos clientes simultâneos (Threads)**
* envio de **arquivos binários (PDF, imagens, ZIP)**
* criação de **protocolo de comandos (GET, PUT, LIST)**
* autenticação de usuários
* interface gráfica

---

# 👨‍💻 Autor

**Pedro Augusto Ribeiro Ferreira e colaboração de Eduardo Santana Cruz Almeida**

Estudante de **Engenharia de Software** com foco em desenvolvimento backend e conceitos de programação orientada a objetos.

---

# ⭐ Contribuição

Contribuições são bem-vindas.

1. Faça um fork do projeto
2. Crie uma branch
3. Faça suas alterações
4. Envie um Pull Request

---

# 📜 Licença

Este projeto é de uso educacional.

---
