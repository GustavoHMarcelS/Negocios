const express = require('express');
const mysql = require('mysql2');
const bodyParser = require('body-parser');

const app = express();
const port = 3306;

// Configuração do Body Parser para lidar com JSON
app.use(bodyParser.json());

// Conexão com o banco de dados MySQL
const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',  // Substitua pelo seu usuário
    password: '',  // Substitua pela sua senha
    database: 'alexandria1' // Substitua pelo seu banco de dados
});

connection.connect((err) => {
    if (err) {
        console.error('Erro de conexão com o banco de dados:', err.stack);
        return;
    }
    console.log('Conectado ao banco de dados.');
});

// Rota para executar a consulta SQL
app.post('/executar-sql', (req, res) => {
    const { sql } = req.body;

    connection.query(sql, (err, results) => {
        if (err) {
            res.status(500).json({ error: 'Erro ao executar consulta SQL', details: err });
            return;
        }
        res.json({ results });
    });
});

// Iniciar o servidor
app.listen(port, () => {
    console.log(`Servidor rodando na porta ${port}`);
});