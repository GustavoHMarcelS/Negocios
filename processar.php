<?php
// Defina suas credenciais do banco de dados
$servidor = "localhost"; // Ou o endereço do seu servidor
$usuario = "root"; // Seu nome de usuário do MySQL
$senha = ""; // Sua senha do MySQL
$database = "meu_banco_de_dados"; // Nome do banco de dados

// Criação da conexão
$conn = new mysqli($servidor, $usuario, $senha, $database);

// Verifique se a conexão foi bem-sucedida
if ($conn->connect_error) {
    die("Falha na conexão: " . $conn->connect_error);
}

// Pegando os dados do formulário
$nome = $_POST['nome'];
$email = $_POST['email'];

// Prepare e vincule os parâmetros
$stmt = $conn->prepare("INSERT INTO usuarios (nome, email) VALUES (?, ?)");
$stmt->bind_param("ss", $nome, $email);

// Execute a consulta
if ($stmt->execute()) {
    echo "Dados inseridos com sucesso!";
} else {
    echo "Erro ao inserir dados: " . $stmt->error;
}

// Feche a conexão
$stmt->close();
$conn->close();
?>