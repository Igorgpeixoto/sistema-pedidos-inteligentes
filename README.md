🛒 Sistema de Processamento de Pedidos Inteligente

Este projeto simula um sistema distribuído de e-commerce com microsserviços, mensageria assíncrona via RabbitMQ e persistência em MongoDB. Cada etapa do fluxo de pedidos é tratada por um serviço independente, promovendo escalabilidade e desacoplamento.

🧱 Microsserviços:

order-service: Recebe e cadastra pedidos via API REST.  
payment-service: Processa o pagamento dos pedidos.  
inventory-service: Atualiza o estoque após pagamento.  
notifier-service: Registra notificações sobre o status final do pedido.  


🔄 Fluxo de Processamento:

*PedidosController* recebe o pedido e o *PedidosService* salva no MongoDB.  
*PedidosProdutor* publica na fila *pedido.criado*.  
*PagamentoConsumidor* processa o pagamento e envia para *pagamento.concluido*.  
*EstoqueConsumidor* atualiza o estoque e envia para *estoque.atualizado*.  
*NotificacaoConsumidor* salva a notificação no MongoDB.  

🛠️ Tecnologias Utilizadas:

Java 17 + Spring Boot 3  
Spring Web, Spring Data MongoDB, Spring AMQP  
RabbitMQ  
Docker & Docker Compose  
Lombok, MapStruc  

🐳 Como Executar:

RabbitMQ: http://localhost:15672  
order-service: http://localhost:8080  

📮 Testando com Postman  
*Criar pedidos*  
POST /pedidos  
json  
{
  "produto": "PROD-001",  
  "preco": 299.90,  
  "quantidade": 2,  
  "cliente": "João"  
}  

*Criar Estoque* (opcional)  
POST /estoque  
json  
{  
  "produto": "PROD-001",  
  "quantidade": 10  
}  
