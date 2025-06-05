<vscode_annotation details='%5B%7B%22title%22%3A%22hardcoded-credentials%22%2C%22description%22%3A%22Embedding%20credentials%20in%20source%20code%20risks%20unauthorized%20access%22%7D%5D'>php</vscode_annotation>```` <?php $servername = "localhost"; $username = "seu_usuario"; $password = "sua_senha"; $dbname = "seu_banco";

// Cria conexão $conn = new mysqli($servername, $username, $password, $dbname);

// Checa conexão if ($conn->connect_error) { die("Conexão falhou: " . $conn->connect_error); }

// Consulta SQL $sql = "SELECT nome, email FROM usuarios"; $result = $conn->query($sql);

if ($result->num_rows > 0) { // Saída dos dados de cada linha while($row = $result->fetch_assoc()) { echo "<tr><td>".$row["nome"]."</td><td>".$row["email"]."</td></tr>"; } } else { echo "<tr><td colspan='2'>Nenhum resultado</td></tr>"; } $conn->close(); ?>