////////////////////////////////////////////////////////////////////
// [Lorenzo] [Piran] [1193526]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class User {
    private String id;
    private String Nome;
    private String Cognome;
    private int annoDiNascita;
    
    public int getAnnoDiNascita() {
        return annoDiNascita;
    }
    public User(String id, String nome, String cognome, int annoDiNascita) {
        this.id = id;
        Nome = nome;
        Cognome = cognome;
        this.annoDiNascita = annoDiNascita;
    }
    
}