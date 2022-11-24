package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Produtos;


public class ProdutoDAO {
	
	//Estabelecendo conexão com o banco de dados
	public static String url = "jdbc:mysql://localhost:3306/techmarket";
    public static String login = "root";
    public static String senha = "";
    
    
    
    public static boolean cadastrar(Produtos obj ) {
    	boolean retorno = false;
    	Connection conexao = null;
    	
    	try {
    		conexao = DriverManager.getConnection(url, login, senha);
    		
    		//Instaciando o comando SQL numa variavel
    		PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO produtos (nome, categoria, preco, estoque) VALUES (?,?,?,?)");
    		
    		//Parametros do comandoSQL
    		comandoSQL.setString(1, obj.getNome());
    		comandoSQL.setString(2, obj.getCategoria());
    		comandoSQL.setDouble(3, obj.getPreco());
    		comandoSQL.setInt(4, obj.getEstoque());
    		
    		int linhasAfetadas = comandoSQL.executeUpdate();
    		
    		if(linhasAfetadas>0){
                retorno = true;
            }
    		
    		
    	}catch(Exception ex){System.out.println(ex.getMessage());}
    	
    	return retorno;
    }
    public static ArrayList<Produtos> listarTodos() throws ClassNotFoundException, SQLException{
    	
    	Connection conexao = null;
    	ArrayList<Produtos> lista = new ArrayList<Produtos>();
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
    	conexao = DriverManager.getConnection(url,login,senha);
    	
    	PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM produtos");
    	
    	ResultSet rs = comandoSQL.executeQuery();
    	
    	if(rs!=null){
            while(rs.next()){
                Produtos novoProduto = new Produtos();
                novoProduto.setIdProduto(rs.getInt("id"));
                novoProduto.setNome(rs.getString("nome"));
                novoProduto.setCategoria(rs.getString("categoria"));
                novoProduto.setPreco(rs.getDouble("preco"));
                novoProduto.setEstoque(rs.getInt("estoque"));
                
                lista.add(novoProduto);
                
            }
        }
    	return lista;
    	
    	
    	
    }
    public static ArrayList <Produtos> listarPorCategoria(String categoria) throws ClassNotFoundException, SQLException{
    	
    	Connection conexao = null;
    	ArrayList<Produtos> lista = new ArrayList<Produtos>();
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
    	conexao = DriverManager.getConnection(url,login,senha);
    	
    	PreparedStatement comandoSQL = conexao.prepareStatement("Select * from produtos where categoria = ?");
    	
        comandoSQL.setString(1,categoria);
        
        ResultSet rs = comandoSQL.executeQuery();
        
        if(rs!=null){
            while(rs.next()){
                Produtos novoProduto = new Produtos();
                novoProduto.setIdProduto(rs.getInt("id"));
                novoProduto.setNome(rs.getString("nome"));
                novoProduto.setCategoria(rs.getString("categoria"));
                novoProduto.setPreco(rs.getDouble("preco"));
                novoProduto.setEstoque(rs.getInt("estoque"));
                
                lista.add(novoProduto);
                
            }
        }
    	return lista;
        
        
    }
    public static ArrayList <Produtos> listarPorNome(String nome) throws ClassNotFoundException, SQLException{
    	Connection conexao = null;
    	ArrayList<Produtos> lista = new ArrayList<Produtos>();
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
    	conexao = DriverManager.getConnection(url,login,senha);
    	
    	PreparedStatement comandoSQL = conexao.prepareStatement("Select * from produtos where nome like ?");
    	
        comandoSQL.setString(1,nome+"%");
        
        ResultSet rs = comandoSQL.executeQuery();
        
        if(rs!=null){
            while(rs.next()){
                Produtos novoProduto = new Produtos();
                novoProduto.setIdProduto(rs.getInt("id"));
                novoProduto.setNome(rs.getString("nome"));
                novoProduto.setCategoria(rs.getString("categoria"));
                novoProduto.setPreco(rs.getDouble("preco"));
                novoProduto.setEstoque(rs.getInt("estoque"));
                
                lista.add(novoProduto);
                
            }
        }
    	return lista;
    }
    
    public static Produtos listarPorID(int ID) {
    	Connection conexao = null;
    	Produtos produtoRetorno = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url,login,senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM Produtos WHERE id = ?");
            comandoSQL.setInt(1, ID);
            
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                if (rs .next()) {
                    produtoRetorno = new Produtos();
                    produtoRetorno.setNome(rs.getString("nome"));
                    produtoRetorno.setPreco(rs.getDouble("preco"));
                    produtoRetorno.setEstoque(rs.getInt("estoque"));
                }
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return produtoRetorno;
        
    
    }
    
    
    
    
    public static boolean restorno (int id, int quantidadeRetirada) throws ClassNotFoundException, SQLException {
    	Connection conexao = null;
        boolean retorno = false;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection(url,login,senha);
        
        PreparedStatement comandoSQL = conexao.prepareStatement("update produtos set estoque = estoque + ? where id = ?");
        comandoSQL.setInt(1,quantidadeRetirada);
        comandoSQL.setInt(2,id);
        
        int linhasAfetadas = comandoSQL.executeUpdate();
        if(linhasAfetadas>0){
        	return true;
        }else {
		return false;
        }
        
    }
    
    public static boolean excluir(int id) throws ClassNotFoundException, SQLException {
    	
    	Connection conexao = null;
        boolean retorno = false;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        conexao = DriverManager.getConnection(url,login,senha);
        
        PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM produtos WHERE id=?");
        
        comandoSQL.setInt(1,id);            
        
        int linhasAfetadas = comandoSQL.executeUpdate();
        if(linhasAfetadas>0){
           retorno = true;
        }
        
        return retorno;
    }
    public static boolean alterar(Produtos obj){
    		Connection conexao = null;
            boolean retorno = false;
            
            try {
                
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                
                conexao = DriverManager.getConnection(url,login,senha);
                
                
                PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE produtos SET  nome=?, categoria=?, preco=?, estoque=? WHERE id = ?");
                
                comandoSQL.setString(1,obj.getNome());
                comandoSQL.setString(2,obj.getCategoria());
                comandoSQL.setDouble(3,obj.getPreco());
                comandoSQL.setInt(4,obj.getEstoque());
                comandoSQL.setInt(5,obj.getIdProduto());
                
            
                int linhasAfetadas = comandoSQL.executeUpdate();
                if(linhasAfetadas>0){
                   retorno = true;
                }
                
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            return retorno;
    	}
}
