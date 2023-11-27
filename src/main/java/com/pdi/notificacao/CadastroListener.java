package com.pdi.notificacao;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CadastroListener {
	
	@RabbitListener (queues = "queue.v1.cadastro-criado")
	public void onCadastroCreated (dtoCadastro mensagem) {
		
		System.out.println("Novo Cadastro Realizado com Id " + mensagem.getId());
		System.out.println("Nome do Cliente " + mensagem.getName());
		
	}
}