package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import model.Carrinho;
import model.ItemCarrinho;

public class CarrinhoDAO {
	//Estabelecendo conexão com o banco de dados
			public static String url = "jdbc:mysql://localhost:3306/techmarket";
		    public static String login = "root";
		    public static String senha = "";
		    
		    public static int verificarCpf(String cpf) throws SQLException {
		    	
		    	Connection conexao = null;
		    	conexao = DriverManager.getConnection(url, login, senha);
		    	
		    	PreparedStatement comandoSQL = conexao.prepareStatement("SELECT id FROM clientes where cpf = ?");
	    		comandoSQL.setString(1,cpf);
	    		ResultSet rs = comandoSQL.executeQuery();
	    		
	    		if(rs!=null){
	    			rs.next();
	    			return rs.getInt("id");    
	    		}
	    		return 0;
		    }
		    
		    public static boolean verificarProduto(String id) throws SQLException {
		    	
		    	Connection conexao = null;
		    	conexao = DriverManager.getConnection(url, login, senha);
		    	
		    	boolean retorno = false;
		    	
		    	PreparedStatement comandoSQL = conexao.prepareStatement("SELECT id FROM produtos where id = ?");
		    	
		    	comandoSQL.setString(1,id);
	    		ResultSet rs = comandoSQL.executeQuery();
	    		int idInt = Integer.parseInt(id);
	    		if(rs!=null){
	    			rs.next();
	    			if(rs.getInt("id") == idInt){
	    			retorno = true;
	    			return retorno;    
	    			}
	    		}
		    	
		    	return retorno;
		    }
		    
		    public static boolean vender (int id, int quantidadeRetirada) throws ClassNotFoundException, SQLException {
		    	Connection conexao = null;
		        boolean retorno = false;
		        
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        conexao = DriverManager.getConnection(url,login,senha);
		        
		        PreparedStatement comandoSQL = conexao.prepareStatement("update produtos set estoque = estoque - ? where id = ?");
		        comandoSQL.setInt(1,quantidadeRetirada);
		        comandoSQL.setInt(2,id);
		        
		        int linhasAfetadas = comandoSQL.executeUpdate();
		        if(linhasAfetadas>0){
		        	return true;
		        }else {
				return false;
		        }
		        
		    }
		    
		    public static boolean salvar(Carrinho obj) {
		    	boolean retorno = false;
		    	try {
		    	 Connection conexao = null;
		    	 Class.forName("com.mysql.cj.jdbc.Driver");
		    	 conexao = DriverManager.getConnection(url, login, senha);
		    	 
		    	 PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO Carrinho (fk_id_cliente,dataEhora_venda,total) VALUES (?,?,?)");
		    	 comandoSQL.setInt(1, obj.getIdCliente());
		    	 comandoSQL.setString(2, obj.getDataEhora());
		    	 comandoSQL.setDouble(3, obj.getTotal());
		    	 
		    	 comandoSQL.executeUpdate();
		    	 
		    	 PreparedStatement comandoSQL2 = conexao.prepareStatement("SELECT id FROM carrinho where fk_id_cliente = ? and dataEhora_venda = ? and total = ?");
		    	comandoSQL2.setInt(1, obj.getIdCliente());
		    	comandoSQL2.setString(2, obj.getDataEhora());
		    	comandoSQL2.setDouble(3, obj.getTotal());
		    	
		    	ResultSet rs = comandoSQL2.executeQuery();
		    		
		    		if(rs!=null){
		    			rs.next();
		    			obj.setId(rs.getInt("id"));
		    		}
		    	
		    	for (ItemCarrinho item : obj.getListaItens()){
                      PreparedStatement comandoSQLItem = conexao.prepareStatement("INSERT INTO Item_Carrinho (fk_id_carrinho,fk_id_produto,valor_unit,quantidade) VALUES (?,?,?,?)");
                      comandoSQLItem.setInt(1, obj.getId());
                      comandoSQLItem.setInt(2, item.getIdProduto());
                      comandoSQLItem.setDouble(3, item.getValor());
                      comandoSQLItem.setInt(4,item.getQuantidade());

                      int linhasAfetadasItem = comandoSQLItem.executeUpdate();
                        if(linhasAfetadasItem>0){
                            retorno = true;
                        }
                    }	
		    	 
		    	 
		    	}catch(ClassNotFoundException | SQLException e) {
		    		System.out.println(e.getMessage());
		    	}
		    	return retorno;
		    	
		    }
		    
}
