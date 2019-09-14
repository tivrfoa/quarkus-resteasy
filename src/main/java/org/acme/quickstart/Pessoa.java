package org.acme.quickstart;

import java.util.List;

/**
 * Pessoa
 */
public class Pessoa {

    private String nome;
    private String idade;

    private Address address;
    private List<Profession> professions;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Profession> getProfessions() {
        return professions;
    }

    public void setProfessions(List<Profession> professions) {
        this.professions = professions;
    }

    @Override
    public String toString() {
        String s = nome + " is " + idade + 
            " years old and lives in " +
            address;
        
        if (professions != null && professions.size() > 0) {
            s += " and does ";

            for (Profession p : professions) {
                s += p + "\n";
            }

            s += " for a living.";
        }

        return s;
    }
}