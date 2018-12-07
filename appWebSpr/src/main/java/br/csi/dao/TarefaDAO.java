package br.csi.dao;

import br.csi.modelo.Tarefa;
import br.csi.util.ConectaPostgres;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;


/*
create table tarefa(
id_tarefa serial,
nome varchar(40) not null,
descricao varchar(100),
primary key (id_tarefa)
)
insert into tarefa( nome, descricao) values ('assistir tv','olhar desenho');
insert into tarefa( nome, descricao) values ('fazer churrasco','festa do projeto')
insert into tarefa( nome, descricao) values ('tomar cerveja','tarefa necessária para manter o equilibrio mental')
select * from tarefa
*/

@Repository
public class TarefaDAO {

public ArrayList<Tarefa> getTarefas() throws Exception{
    ArrayList<Tarefa> tarefas = new ArrayList<>();
    
    String sql = "SELECT * FROM tarefa";
    
    PreparedStatement stmt = 
            ConectaPostgres
                    .getConexao().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Tarefa t = new Tarefa();
            t.setId( rs.getInt("id_tarefa"));
            t.setNome(rs.getString("nome"));
            t.setDescricao(rs.getString("descricao"));
            tarefas.add(t);
            
        }
    
    return tarefas;
}
    
public Tarefa getTarefa(int id) throws Exception{
    String sql = "select * from tarefa where id_tarefa =?";
        PreparedStatement stmt = ConectaPostgres.getConexao().prepareCall(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Tarefa u = new Tarefa();
        u.setId(id);
        while(rs.next()){
            u.setNome(rs.getString("nome"));
            u.setDescricao(rs.getString("descricao"));
        }
        return u;
}

    public boolean inserir(Tarefa t) throws Exception{
         String sql = "insert into tarefa(nome, descricao) "
                + "values(?,?)";
        
        PreparedStatement stmt = 
                ConectaPostgres.getConexao().prepareStatement(sql);
        stmt.setString(1, t.getNome());
        stmt.setString(2, t.getDescricao());
        stmt.execute();
        
        return true;
    }
    
       public boolean atualizar(Tarefa t)throws Exception{
           System.out.println("vai alterar");
           String sql = "update tarefa set nome =?, descricao =? "
                + "where id_tarefa = ?";
        PreparedStatement stmt = 
                ConectaPostgres.getConexao()
                        .prepareStatement(sql);
        
    stmt.setString(1, t.getNome());
    stmt.setString(2, t.getDescricao());
    stmt.setInt(3, t.getId());
           System.out.println("sql: "+stmt.toString());
    stmt.executeUpdate();
        return true;
    }

}
