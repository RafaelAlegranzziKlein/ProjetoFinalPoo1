/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno.saolucas
 */
public class Funcionario {

    private String nome;
    private double salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }
    
    public void calculoPercentual(double percentual){
     if(percentual > 0){   
         salario += salario*(percentual/100);
        System.out.println("Salario foi reajustado");
     }else{
         System.out.println("Não foi possivel");
     }
    }
    public void exibirInfo(){
        System.out.println("Nome :"+ nome);
        System.out.println("Salário R$"+salario);
        System.out.println("Salario anual foi de :"+calcularMensal());
    }
    public double calcularMensal(){
        return salario*12;
    }
}
