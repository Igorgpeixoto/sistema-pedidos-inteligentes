package Pedidos.mensageria;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String FILA_PEDIDO_CRIADO = "pedido.criado";
    public static final String FILA_PAGAMENTO_CONCLUIDO = "pagamento.concluido";
    public static final String FILA_ESTOQUE_ATUALIZADO = "estoque.atualizado";

    @Bean
    public Queue filaPedidoCriado() { return new Queue(FILA_PEDIDO_CRIADO, true); }

    @Bean
    public Queue filaPagamentoConcluido() { return new Queue(FILA_PAGAMENTO_CONCLUIDO, true); }

    @Bean
    public Queue filaEstoqueAtualizado() { return new Queue(FILA_ESTOQUE_ATUALIZADO, true); }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    //ENTENDER ISSO ASSIM QUE POSSIVEL
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory cf, Jackson2JsonMessageConverter converter) {
        RabbitTemplate rt = new RabbitTemplate(cf);
        rt.setMessageConverter(converter);
        return rt;
    }
}