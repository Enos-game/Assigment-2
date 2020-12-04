////////////////////////////////////////////////////////////////////
// [Lorenzo] [Piran] [1193526]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class User {
    private String id;
    private String Nome;
    private String Cognome;
    private int annoDiNascita;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public String getCognome() {
        return Cognome;
    }
    public void setCognome(String cognome) {
        Cognome = cognome;
    }
    public int getAnnoDiNascita() {
        return annoDiNascita;
    }
    public void setAnnoDiNascita(int annoDiNascita) {
        this.annoDiNascita = annoDiNascita;
    }
    public User(String id, String nome, String cognome, int annoDiNascita) {
        this.id = id;
        Nome = nome;
        Cognome = cognome;
        this.annoDiNascita = annoDiNascita;
    }
    
}