/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Kazuto
 */
public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private LocalDate dataNasc;

    

    public Usuario() {
    }

    public Usuario(String nome, String senha, LocalDate dataNasc) {
        this.nome = nome;
        this.senha = senha;
        this.dataNasc = dataNasc;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }
    public int getIdade(){
        if (dataNasc == null)return 0;
        return Period.between(dataNasc, LocalDate.now()).getYears();
    }
    
}
