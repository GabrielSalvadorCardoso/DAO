package escola;
/*AVISO: devido ao fato de a matricula ter sido definida como chave primaria
 no banco de dados, este programa não permite que o mesmo aluno seja instanciado
duas vezes. Por esse motivo o método que adiciona um aluno ao banco de dados
(dao.adiciona()) deve ser comentada no caso de se desejar fazer a consulta
(dao.mostrar()) mais de uma vez*/
public class Escola {
    public static void main(String[] args) {
        AlunoDAO dao = new AlunoDAO();
        Aluno aluno = new Aluno(12345678, "Gabriel Cardoso", "Masculino");
        Aluno aluno2 = new Aluno(87654321, "Joana Abraao", "Feminino");
        Aluno aluno3 = new Aluno(11111111, "Carlos Alberto", "Masculino");
        
        
        //dao.adiciona(aluno);
        //dao.adiciona(aluno2);
        dao.adiciona(aluno3);
        
        dao.mostrar();
    }    
}
