////////////////////////////////////////////////////////////////////
// [Raul] [Seganfreddo] [1226293] 
// [Saad] [Mounib] [2052815] 
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

public class Cliente implements User{
	int age;
	String nome;
	String cognome;
	String luogoNascita;
	
	public Cliente(int age, String nome, String cognome, String luogoNascita) {
		if (nome == null) {
			throw new IllegalArgumentException("nome non può essere null");
		}
		if (cognome == null) {
			throw new IllegalArgumentException("cognome non può essere null");
		}
		if (luogoNascita == null) {
			throw new IllegalArgumentException("luogo di nascita non può essere null");
		}
		if (age < 10) {
			throw new IllegalArgumentException("l'età deve essere almeno 10");
		}
		this.nome = nome;
		this.cognome = cognome;
		this.luogoNascita = luogoNascita;
		this.age = age;
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getCognome() {
		return this.cognome;
	}
	public String getLuogoNascita() {
		return this.luogoNascita;
	}
	public int getAge() {
		return this.age;
	}
}