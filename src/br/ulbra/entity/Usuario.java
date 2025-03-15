package br.ulbra.entity;

/**
 *
 * @author Rafael Klein
 */
public class Usuario {

    private int idUso;
    private String nomeUso;
    private String cpfUso;
    private String emailUso;
    private String enderecoUso;
    private String foneUso;
    private String senhaUso;

    public Usuario() {
    }

    public Usuario(int idUso, String nomeUso, String cpfUso, String emailUso, String enderecoUso, String foneUso, String senhaUso) {
        this.nomeUso = nomeUso;
        this.cpfUso = cpfUso;
        this.emailUso = emailUso;
        this.enderecoUso = enderecoUso;
        this.foneUso = foneUso;
        this.senhaUso = senhaUso;
        this.idUso = idUso;
    }

    public String getNomeUso() {
        return nomeUso;
    }

    public String getCpfUso() {
        return cpfUso;
    }

    public String getEmailUso() {
        return emailUso;
    }

    public String getEnderecoUso() {
        return enderecoUso;
    }

    public String getFoneUso() {
        return foneUso;
    }

    public String getSenhaUso() {
        return senhaUso;
    }

    public void setNomeUso(String nomeUso) {
        this.nomeUso = nomeUso;
    }

    public void setCpfUso(String cpfUso) {
        this.cpfUso = cpfUso;
    }

    public void setEmailUso(String emailUso) {
        this.emailUso = emailUso;
    }

    public void setEnderecoUso(String enderecoUso) {
        this.enderecoUso = enderecoUso;
    }

    public void setFoneUso(String foneUso) {
        this.foneUso = foneUso;
    }

    public void setSenhaUso(String senhaUso) {
        this.senhaUso = senhaUso;
    }

    public int getIdUso() {
        return idUso;
    }

    public void setIdUso(int idUso) {
        this.idUso = idUso;
    }

    @Override
    public String toString() {
        return "ID       :" + idUso
                + "Nome     :" + nomeUso
                + "CPF      :" + cpfUso
                + "Email    :" + emailUso
                + "Endereço :" + enderecoUso
                + "Fone     :" + foneUso
                + "Senha    :" + senhaUso;
    }

    public static boolean validarSenha(String senha) {
        String regex = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=-_]).{8,}$";
        return senha.matches(regex);

    }
    // Função para validar o CPF

    public static boolean validarCPF(String cpf) {
       // Remover todos os caracteres não numéricos (pontuação, espaços)
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verificar se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verificar se todos os números são iguais (caso como 111.111.111.11, 222.222.222.22, etc)
        if (cpf.matches("(.)\\1{10}")) {
            return false;
        }

        // Calcular o primeiro dígito verificador
        int primeiroDigito = calcularDigito(cpf, 10);
        // Calcular o segundo dígito verificador
        int segundoDigito = calcularDigito(cpf, 11);

        // Comparar os dígitos calculados com os fornecidos
        return (primeiroDigito == Character.getNumericValue(cpf.charAt(9))) &&
               (segundoDigito == Character.getNumericValue(cpf.charAt(10)));
    }

    // Função para calcular o dígito verificador (1º ou 2º)
    private static int calcularDigito(String cpf, int peso) {
        int soma = 0;
        // Calcular a soma dos dígitos multiplicados pelos pesos correspondentes
        for (int i = 0; i < peso - 1; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (peso - i);
        }

        // Calcular o resto da divisão da soma por 11
        int resto = soma % 11;

        // Se o resto for menor que 2, o dígito é 0, caso contrário, o dígito é 11 - resto
        if (resto < 2) {
            return 0;
        } else {
            return 11 - resto;
        }
    }

}
