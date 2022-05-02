package br.com.gabriel;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Vinculo extends PanacheEntity{

    public String nome;

    public Integer idade;
}
