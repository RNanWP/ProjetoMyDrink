package com.mydrink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mydrink.model.Produto;

public class ProdutoDao {
    public void cadastrarProduto(Produto produto) {
    	String sql = "INSERT INTO PRODUTO (descricao, quantidade, preco) VALUES (?, ?, ?)";

        PreparedStatement pStatement = null;
        Connection conn = null;

        try {
            conn = new Conexao().getConnection();
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, produto.getDescricao());
            pStatement.setInt(2, produto.getQuantidade());
            pStatement.setDouble(3, produto.getPreco());
            pStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (pStatement != null)
                    pStatement.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

            try {
                if (conn != null)
                    conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

		public Produto BuscarProdutoPorId(int id) {
		    String sql = "SELECT * FROM PRODUTO WHERE produto_id = ?";
			ResultSet rs = null;
			Connection conn = null;
			PreparedStatement pStatement = null;
			Produto produto = null;
			
			try {
				conn = new Conexao().getConnection();
				pStatement = conn.prepareStatement(sql);
				pStatement.setInt(1, id);
				rs = pStatement.executeQuery();
				if (rs != null && rs.next()) {
					produto = new Produto();
					produto.setProduto_id(rs.getInt("produto_id"));
					produto.setDescricao(rs.getString("descricao"));
					produto.setQuantidade(rs.getInt("quantidade"));
					produto.setPreco(rs.getDouble("preco"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pStatement != null) {
						pStatement.close();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			return produto;
	}
	
	public ArrayList<Produto> BuscarProdutosPorDescricao(String descricao){
		String sql = "SELECT * FROM PRODUTO WHERE descricao LIKE '%" + descricao + "%'";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Produto produto = null;
		ArrayList<Produto> produtos = null;
		try {
			conn = new Conexao().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			if (rs != null) {
				produtos = new ArrayList<Produto>();
				while (rs.next()) {
					produto = new Produto();
					produto.setProduto_id(rs.getInt("produto_id"));
					produto.setDescricao(rs.getString("descricao"));
					produto.setQuantidade(rs.getInt("quantidade"));
					produto.setPreco(rs.getDouble("preco"));
					produtos.add(produto);
				}
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pStatement!=null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return produtos;
	}
	
	
	public void ExcluirProduto(int Produto_id) {
		String sql = "DELETE FROM PRODUTO WHERE Produto_id = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			conn = new Conexao().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, Produto_id);
			pStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void AlterarProduto(Produto produto) {
		String sql = "UPDATE PRODUTO SET descricao = ?, quantidade = ?, preco= ? WHERE Produto_id = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			
			conn = new Conexao().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, produto.getDescricao());
			pStatement.setInt(2, produto.getQuantidade());
			pStatement.setDouble(3, produto.getPreco());
			pStatement.setInt(4, produto.getProduto_id());
			pStatement.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
