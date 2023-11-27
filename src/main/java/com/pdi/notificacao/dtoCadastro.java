package com.pdi.notificacao;

public class dtoCadastro {
	
	private Long id;
	
	private String name;
	
	
	
	public dtoCadastro(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public dtoCadastro() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}