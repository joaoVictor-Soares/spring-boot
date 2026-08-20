package br.com.awebmeu.sistema_aluno.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;


@Entity
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotBlank(message = "A data de nascimento é obrigaória")
    @Past(message = "A data de nascimento deve ser no passado")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateBirthday;

    @CPF(message = "CPF inválido")
    @NotBlank(message = "O CPF é obrigatório")
    private String CPF;

    public Aluno() {
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

    public LocalDate getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(LocalDate dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    
}
