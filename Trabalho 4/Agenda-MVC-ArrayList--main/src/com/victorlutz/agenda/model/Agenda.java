package com.victorlutz.agenda.model;
import com.victorlutz.agenda.view.Tela;

public class Agenda {
	
	public void iniciarAgenda() {
		Tela tela = new Tela();
		
		String menu = ":: Agenda de Contatos ::\n\n" + "1. Cadastrar\n" + "2. Buscar\n" + "3. Editar\n" + "4. Excluir";
		
		boolean isAtivo = true;
		
		while(isAtivo) {
			String opcao = tela.informar(menu, "Informe as opções", -1);
			
			switch(opcao) {
				case "1":
					cadastrarContato(tela);
					break;
				
				case "2":
					buscarContato(tela);
					break;
				
				case "3":
					editarContato(tela);
					break;
				
				case "4":
					excluirContato(tela);
					break;
				
				default:
					int sair = tela.confirmar("Você deseja mesmo encerrar?", "Encerrar", 3);
					
					if(sair == 0) {
						isAtivo = false;
						tela.mostrar("Encerrando o sistema. . .", "Encerrando", 1);
					}
			}
		}
	}
	
	private void cadastrarContato(Tela tela) {
		
		String nome = tela.informar("Informe o nome:", "Nome", 1);
		String email = tela.informar("Informe o e-mail:", "E-mail", 1);
		String fone = tela.informar("Informe o telefone:", "Telefone", 1);
		
		Contato contato = new Contato(nome, email, fone);
		Lista.getInstance().add(contato);
	}
	
	private void buscarContato(Tela tela) {
		int numeroRegistros = Lista.getInstance().size();
		
		if (numeroRegistros > 0) {
			String listaContatos = "";
			
			for (int i = 0; i < numeroRegistros; i++) {
				listaContatos += "ID: " + (i +1) + "\nNome: " + Lista.getInstance().get(i).getNome() + "\nE-mail: " + Lista.getInstance().get(i).getEmail() + "\nFone: " + Lista.getInstance().get(i).getFone() + "\n\n";
				}
			
			tela.mostrar(listaContatos, "Contatos", 1);
			
		} else {
			tela.mostrar("Nenhum registro encontrado", "Contatos", 1);
		}
	}
	
	private void editarContato(Tela tela) {
		int numeroRegistros = Lista.getInstance().size();
		
		if (numeroRegistros > 0) {
			String indice = tela.informar("Qual o ID do contato que deseja editar:", "ID", 3);
			int id = Integer.parseInt(indice);
			
			String nome = tela.informar("Informe o nome:", "Nome", 1);
			String fone = tela.informar("Informe o telefone:", "Telefone", 1);
			String email = tela.informar("Informe o e-mail:", "E-mail", 1);
			
			Lista.getInstance().get(id).setNome(nome);
			Lista.getInstance().get(id).setEmail(email);
			Lista.getInstance().get(id).setFone(fone);
			
		} else {
			tela.mostrar("Nada encontrado", "Contatos", 1);
		}
	}
	
	private void excluirContato(Tela tela) {
int numeroRegistros = Lista.getInstance().size();
		
		if (numeroRegistros > 0) {
			String indice = tela.informar("Informe o ID:", "ID", 3);
			int id = Integer.parseInt(indice);
			
			Lista.getInstance().remove(id);
			
		} else {
			tela.mostrar("Nenhum registro encontrado", "Contatos", 1);
		}
	}
}












