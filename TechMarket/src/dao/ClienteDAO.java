package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Clientes;
import model.Produtos;

public class ClienteDAO {
	//Estabelecendo conexão com o banco de dados
		public static String url = "jdbc:mysql://localhost:3306/techmarket";
	    public static String login = "root";
	    public static String senha = "";
	    
	    public static boolean cadastrar(Clientes obj ) {
	    	
	    	boolean retorno = false;
	    	Connection conexao = null;
	    	
	    	try {
	    		
	    		conexao = DriverManager.getConnection(url, login, senha);
	    		 			
	    		
		    		//Instaciando o comando SQL numa variavel
		    		PreparedStatement comandoSQL = conexao.prepareStatement("insert into clientes (nome,sexo,cpf,email,dataNasc,telefone,estadoCivil)values(?,?,?,?,?,?,?)");
		    		
		    		//Parametros do comandoSQL
		    		comandoSQL.setString(1, obj.getNome());
		    		comandoSQL.setString(2, obj.getSexo());
		    		comandoSQL.setString(3, obj.getCpf());
		    		comandoSQL.setString(4, obj.getEmail());
		    		comandoSQL.setString(5, obj.getDataNasc());
		    		comandoSQL.setString(6, obj.getTelefone());
		    		comandoSQL.setString(7, obj.getEstadoCivil());
		    		
		    		
		    		int linhasAfetadas = comandoSQL.executeUpdate();
	    		
		    		PreparedStatement comandoSQL2 = conexao.prepareStatement("SELECT id FROM clientes where cpf = ?");
		    		comandoSQL2.setString(1, obj.getCpf());
		    		ResultSet rs = comandoSQL2.executeQuery();
		    		
		    		if(rs!=null){
		    			rs.next();
		    			obj.setIdCliente(rs.getInt("id"));
		    		}
		    		
	    		PreparedStatement comandoSQL3 = conexao.prepareStatement("insert into enderecos (rua,cidade,estado,numero,cep,fk_id_cliente)values(?,?,?,?,?,?)");
		    		
		    		comandoSQL3.setString(1, obj.getRua());
		    		comandoSQL3.setString(2, obj.getCidade());
		    		comandoSQL3.setString(3, obj.getEstado());
		    		comandoSQL3.setString(4, obj.getNumero());
		    		comandoSQL3.setString(5, obj.getCep());
		    		comandoSQL3.setInt(6, obj.getIdCliente());
		    		
		    		int linhasAfetadas2 = comandoSQL3.executeUpdate();
	    		
	    		
		    		if(linhasAfetadas>0 && linhasAfetadas2>0 ){
		                retorno = true;
		            }
	    		
	    		
	    	}catch(Exception ex){System.out.println(ex.getMessage());}
	    	
	    	return retorno;
	    }
	    
	    public static boolean verificarCpfExistente(String cpf) throws SQLException {
	    	boolean retorno = false;
	    	Connection conexao = null;
	    	
	    	conexao = DriverManager.getConnection(url, login, senha);
	    	
	    	PreparedStatement comandoSQL4 = conexao.prepareStatement("SELECT cpf FROM clientes where cpf = ?");
    		comandoSQL4.setString(1, cpf);
    		ResultSet rs2 = comandoSQL4.executeQuery();
    		
    		
    		
    		
    		Clientes objCliente2 = new Clientes();
    		if(rs2!=null){
    			
    			rs2.next();
    				
    	                
    	               
    	                objCliente2.setCpf(rs2.getString("cpf"));
    	                
    		}
    		       
    	                
    			 
    		if( objCliente2.getCpf().equals(cpf) ) 
    		{
    			
    			return retorno;
    		} 
    		
    		retorno = true;
    		return retorno;
	    }
	    
	    
	    public static ArrayList<Clientes> listarTodos() throws ClassNotFoundException, SQLException{
	    	
	    	Connection conexao = null;
	    	ArrayList<Clientes> lista = new ArrayList<Clientes>();
	    	
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	
	    	conexao = DriverManager.getConnection(url,login,senha);
	    	
	    	PreparedStatement comandoSQL = conexao.prepareStatement("SELECT id,nome,cpf FROM clientes");
	    	
	    	ResultSet rs = comandoSQL.executeQuery();
	    	
	    	if(rs!=null){
	            while(rs.next()){
	                Clientes novoCliente = new Clientes();
	                novoCliente.setIdCliente(rs.getInt("id"));
	                novoCliente.setNome(rs.getString("nome"));
	                novoCliente.setCpf(rs.getString("cpf"));
	                
	                
	                lista.add(novoCliente);
	                
	            }
	        }
	    	return lista;
	    	
	    	
	    	
	    }
	    
	    
	    public static ArrayList <Clientes> listarPorNome(String nome) throws ClassNotFoundException, SQLException{
	    	Connection conexao = null;
	    	ArrayList<Clientes> lista = new ArrayList<Clientes>();
	    	
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	
	    	conexao = DriverManager.getConnection(url,login,senha);
	    	
	    	PreparedStatement comandoSQL = conexao.prepareStatement("Select id,nome,cpf from clientes where nome like ?");
	    	
	        comandoSQL.setString(1,nome+"%");
	        
	        ResultSet rs = comandoSQL.executeQuery();
	        
	        if(rs!=null){
	            while(rs.next()){
	                Clientes novoCliente = new Clientes();
	                novoCliente.setIdCliente(rs.getInt("id"));
	                novoCliente.setNome(rs.getString("nome"));
	                novoCliente.setCpf(rs.getString("cpf"));
	                
	                lista.add(novoCliente);
	                
	            }
	        }
	    	return lista;
	    }
	    
	    
	    public static boolean excluir(int id) throws ClassNotFoundException, SQLException {
	    	
	    	Connection conexao = null;
	        boolean retorno = false;
	        
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        conexao = DriverManager.getConnection(url,login,senha);
	        
	        PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM clientes WHERE id=?");
	        
	        comandoSQL.setInt(1,id);            
	        
	        int linhasAfetadas = comandoSQL.executeUpdate();
	        if(linhasAfetadas>0){
	           retorno = true;
	        }
	        
	        return retorno;
	    }
	    
	    
public static Clientes listarPorID(int id) throws ClassNotFoundException, SQLException{
	    	
	    	Connection conexao = null;
	    	
	    	
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	
	    	conexao = DriverManager.getConnection(url,login,senha);
	    	
	    	PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM clientes where id = ?");
	    	comandoSQL.setInt(1, id);
	    	ResultSet rs = comandoSQL.executeQuery();
	    	Clientes cliente = new Clientes();
	    	
	    	if(rs!=null){
	    			rs.next();
	                cliente.setNome(rs.getString("nome"));
	                cliente.setSexo(rs.getString("sexo"));
	                cliente.setCpf(rs.getString("cpf"));
	                cliente.setEmail(rs.getString("email"));
	                cliente.setDataNasc(rs.getString("dataNasc"));
	                cliente.setTelefone(rs.getString("telefone"));
	                cliente.setEstadoCivil(rs.getString("estadoCivil"));
	                
	        }
	    	
	    	
	    	PreparedStatement comandoSQL2 = conexao.prepareStatement("SELECT * FROM enderecos where fk_id_cliente = ?");
	    	comandoSQL2.setInt(1, id);
	    	ResultSet rs2 = comandoSQL2.executeQuery();
	    	if(rs2!=null){
    			rs2.next();
                cliente.setRua(rs2.getString("rua"));
                cliente.setCidade(rs2.getString("cidade"));
                cliente.setEstado(rs2.getString("estado"));
                cliente.setNumero(rs2.getString("numero"));
                cliente.setCep(rs2.getString("cep"));

                }
	    	return cliente;
	    	
	    	
	    	
	    }


		public static boolean alterar(Clientes obj){
			Connection conexao = null;
		    boolean retorno = false;
		    
		    try {
		        
		        
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        
		        
		        conexao = DriverManager.getConnection(url,login,senha);
		        
		        
		        PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE clientes SET  nome=?, sexo=?, cpf=?, email=?, dataNasc=?,telefone=?,estadoCivil=?  WHERE id = ?");
		        
		        comandoSQL.setString(1,obj.getNome());
		        comandoSQL.setString(2,obj.getSexo());
		        comandoSQL.setString(3,obj.getCpf());
		        comandoSQL.setString(4,obj.getEmail());
		        comandoSQL.setString(5,obj.getDataNasc());
		        comandoSQL.setString(6,obj.getTelefone());
		        comandoSQL.setString(7,obj.getEstadoCivil());
		        comandoSQL.setInt(8,obj.getIdCliente());
		        
		        
		        PreparedStatement comandoSQL2 = conexao.prepareStatement("UPDATE enderecos SET  rua=?, cidade=?, estado=?, numero=?, cep=? WHERE fk_id_cliente = ?");
		        
		        comandoSQL2.setString(1,obj.getRua());
		        comandoSQL2.setString(2,obj.getCidade());
		        comandoSQL2.setString(3,obj.getEstado());
		        comandoSQL2.setString(4,obj.getNumero());
		        comandoSQL2.setString(5,obj.getCep());
		        comandoSQL2.setInt(6,obj.getIdCliente());
		        
		        int linhasAfetadas = comandoSQL.executeUpdate();
		        int linhasAfetadas2 = comandoSQL2.executeUpdate();
		        
		        if(linhasAfetadas >0 && linhasAfetadas2>0){
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
