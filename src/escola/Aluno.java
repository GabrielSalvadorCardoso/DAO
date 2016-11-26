package escola;
public class Aluno {
    private int matricula;
    private String nome;
    private String sexo;

    public Aluno(int matricula, String nome, String sexo) {
        this.setMatricula(matricula);
        this.setNome(nome);
        this.setSexo(sexo);
    }

    public int getMatricula() {
        return matricula;
    }
    public String getNome() {
        return nome;
    }
    public String getSexo() {
        return sexo;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
}
