package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Produtos;
import model.RelatorioAnalitico;
import model.RelatorioSintetico;

public class RelatorioDAO {
	//Estabelecendo conexão com o banco de dados
		public static String url = "jdbc:mysql://localhost:3306/techmarket";
	    public static String login = "root";
	    public static String senha = "";
	    
	    public static ArrayList<RelatorioSintetico> listarTodosSinteticos() throws ClassNotFoundException, SQLException{
	    	
	    	Connection conexao = null;
	    	ArrayList<RelatorioSintetico> lista = new ArrayList<RelatorioSintetico>();
	    	
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	
	    	conexao = DriverManager.getConnection(url,login,senha);
	    	
	    	PreparedStatement comandoSQL = conexao.prepareStatement("select carrinho.id, clientes.nome, carrinho.total, carrinho.dataEhora_venda  from carrinho inner join clientes on carrinho.fk_id_cliente = clientes.id");
	    	
	    	ResultSet rs = comandoSQL.executeQuery();
	    	
	    	if(rs!=null){
	            while(rs.next()){
	            	RelatorioSintetico novoRelatorioSintetico = new RelatorioSintetico();
	            	novoRelatorioSintetico.setIdCarrinho(rs.getInt("id"));
	            	novoRelatorioSintetico.setCliente(rs.getString("nome"));
	            	novoRelatorioSintetico.setValorTotal(rs.getDouble("total"));
	            	novoRelatorioSintetico.setData(rs.getString("dataEhora_venda"));
	                
	                lista.add(novoRelatorioSintetico);
	                
	            }
	        }
	    	return lista;
	    
	    }
	    
	    public static ArrayList<RelatorioSintetico> listarPorDataSinteticos(String data) throws ClassNotFoundException, SQLException{
	    	
	    	Connection conexao = null;
	    	ArrayList<RelatorioSintetico> lista = new ArrayList<RelatorioSintetico>();
	    	
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	
	    	conexao = DriverManager.getConnection(url,login,senha);
	    	
	    	PreparedStatement comandoSQL = conexao.prepareStatement("select carrinho.id, clientes.nome, carrinho.total, carrinho.dataEhora_venda  from carrinho inner join clientes on carrinho.fk_id_cliente = clientes.id  where carrinho.dataEhora_venda like ?");
	    	comandoSQL.setString(1,data+"%");
	    	ResultSet rs = comandoSQL.executeQuery();
	    	
	    	if(rs!=null){
	            while(rs.next()){
	            	RelatorioSintetico novoRelatorioSintetico = new RelatorioSintetico();
	            	novoRelatorioSintetico.setIdCarrinho(rs.getInt("id"));
	            	novoRelatorioSintetico.setCliente(rs.getString("nome"));
	            	novoRelatorioSintetico.setValorTotal(rs.getDouble("total"));
	            	novoRelatorioSintetico.setData(rs.getString("dataEhora_venda"));
	                
	                lista.add(novoRelatorioSintetico);
	                
	            }
	        }
	    	return lista;
	    
	    }
	    
	    
	    public static ArrayList<RelatorioAnalitico> listarTodosAnaliticos(int idCarrinho) throws ClassNotFoundException, SQLException{
	    	
	    	Connection conexao = null;
	    	ArrayList<RelatorioAnalitico> lista = new ArrayList<RelatorioAnalitico>();
	    	
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	
	    	conexao = DriverManager.getConnection(url,login,senha);
	    	
	    	PreparedStatement comandoSQL = conexao.prepareStatement("select produtos.nome, item_carrinho.quantidade, item_carrinho.valor_unit  from item_carrinho inner join produtos on item_carrinho.fk_id_produto = produtos.id where item_carrinho.fk_id_carrinho = ?");
	    	comandoSQL.setInt(1, idCarrinho);
	    	ResultSet rs = comandoSQL.executeQuery();
	    	
	    	if(rs!=null){
	            while(rs.next()){
	            	RelatorioAnalitico novoRelatorioAnalitico = new RelatorioAnalitico();
	            	novoRelatorioAnalitico.setNomeProduto(rs.getNString("nome"));
	            	novoRelatorioAnalitico.setQuantidade(rs.getInt("quantidade"));
	            	novoRelatorioAnalitico.setValorUnit(rs.getDouble("valor_unit"));
	                
	                lista.add(novoRelatorioAnalitico);
	                
	            }
	        }
	    	return lista;
	    
	    }
	    
}
