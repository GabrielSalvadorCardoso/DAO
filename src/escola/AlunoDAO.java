package escola;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AlunoDAO {
    /*perceba que não existe construtor, ou seja, só será aberta uma conexão caso:
    * seja adicionado um novo aluno (com o metodo adiciona)
    * seja feita um consulta a tabela 'aluno' (com o método select)
    */
    Connection conexao;
    PreparedStatement stm;
    ResultSet rs;
    
    public Connection getConexao(){
        return this.conexao;
    }    
    private void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void abrirConexao(){
        try{
            this.setConexao(DriverManager.getConnection("jdbc:mysql://localhost/escola", "root", ""));
        }catch(SQLException s){
            System.err.println("ERRO 1001: Impossivel abrir conexao");
        }        
    }    

    public void adiciona(Aluno aluno) { 
        this.abrirConexao();
        String query = "insert into aluno (matricula, nome, sexo)"
                + "values(?, ?, ?)";
        try {
            stm = this.getConexao().prepareStatement(query);
            stm.setInt(1, aluno.getMatricula());
            stm.setString(2, aluno.getNome());
            stm.setString(3, aluno.getSexo());
            stm.execute();            
            this.fechar();
        } catch (SQLException ex) {
            this.fechar();
            System.err.println("ERRO 2001: Impossivel exectar insercao de dados");
        }        
    }
    
    private void select(){
        this.abrirConexao();
        String query = "select * from aluno";
        try {
            stm = this.getConexao().prepareStatement(query);
            rs = stm.executeQuery();
        } catch (SQLException ex) {
            this.fechar();            
            System.err.println("ERRO 2002: Impossivel executar consulta");
        }
    }
    
    public void mostrar(){
        this.select();
        System.out.println("----------------------");
        try {
            while(rs.next()){
                System.out.println("Matricula: "+rs.getInt("matricula"));
                System.out.println("Nome: "+rs.getString("nome"));
                System.out.println("Sexo: "+rs.getString("sexo"));                
                System.out.println("----------------------");
            }            
            this.fechar();
        } catch (SQLException ex) {
            this.fechar();
            System.err.println("ERRO 3001: Impossivel mostrar dados");
        }
    }
    
    public void fechar(){
        System.out.println("Encerrando conexao...");
        try {
            stm.close();            
        } catch (SQLException ex) {            
            System.err.println("ERRO 4001: Impossivel fechar query");
            System.exit(1);
        }
        try {            
            rs.close();            
        } catch (SQLException ex) {
            System.err.println("ERRO 4002: Impossivel fechar ResultSet");
            System.exit(1);
        }
        try {            
            this.getConexao().close();
        } catch (SQLException ex) {
            System.err.println("ERRO 4003: Impossivel fechar conexao");
            System.exit(1);
        }
    }
}
