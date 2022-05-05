package br.com.gabriel.Model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vinculo extends PanacheEntity{

    public String nome;

    
}
