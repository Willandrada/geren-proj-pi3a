/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Johnathan
 */
public class ProdutoDAO {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String SERVIDOR = "localhost";
    private static final String BASEDADOS = "geren";
    private static final String LOGIN = "root";
    private static final String SENHA = "";
    private static String url = "";
    private static Connection conexao;

    public static boolean SalvarProduto(model.Produto produto) {
        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            url = "jdbc:mysql://localhost:3306/" + "geren";
            conexao = DriverManager.getConnection(url, "root", "");

            PreparedStatement comando = conexao.prepareStatement("INSERT INTO PRODUTOS (NOME, DESCRICAO, PRECOCOMPRA, PRECOVENDA, QUANTIDADE, STATUS)"
                    + " VALUES(?,?,?,?,?,?);");

            comando.setString(1, produto.getNome());
            comando.setString(2, produto.getdescricao());
            comando.setFloat(3, produto.getPrecoCompra());
            comando.setFloat(4, produto.getPrecoVenda());
            comando.setInt(5, produto.getQuantidade());
            comando.setBoolean(6, produto.isStatus());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }
        }
        return retorno;
    }

    public static boolean AtualizarProduto(model.Produto produto) {

        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            url = "jdbc:mysql://localhost:3306/" + "geren";
            conexao = DriverManager.getConnection(url, "root", "");
            Statement comando = conexao.createStatement();
            int linhasAfetadas = comando.executeUpdate("UPDATE PRODUTOS SET "
                    + " NOME ='" + produto.getNome() + "'" + ","
                    + " DESCRICAO ='" + produto.getdescricao() + "'"
                    + " PRECOCOMPRA ='" + produto.getPrecoCompra() + "'"
                    + " PRECOVENDA ='" + produto.getPrecoVenda() + "'"
                    + " QUANTIDADE ='" + produto.getQuantidade() + "'"
                    + " STATUS ='" + produto.isStatus() + "'"
                    + " WHERE IDPRODUTO =" + produto.getIdProduto()
            );

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }
        }

        return retorno;

    }

    public static boolean ExcluirProduto(int ID) {

        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            url = "jdbc:mysql://localhost:3306/" + "geren";
            conexao = DriverManager.getConnection(url, "root", "");
            Statement comando = conexao.createStatement();
            int linhasAfetadas = comando.executeUpdate("DELETE FROM PRODUTOS "
                    + " WHERE IDPRODUTO = " + ID
            );

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }
        }
        return retorno;
    }

    public static ArrayList<model.Produto> getProdutos() {
        ArrayList<model.Produto> listaProdutos = new ArrayList<model.Produto>();

        try {
            Class.forName(DRIVER);
            url = "jdbc:mysql://" + "localhost:3306" + "/geren";
            conexao = DriverManager.getConnection(url, "root", "");
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM PRODUTOS;");
            while (rs.next()) {
                model.Produto produto = new model.Produto();
                produto.setIdProduto(rs.getInt("IDPRODUTO"));
                produto.setNome(rs.getString("NOME"));
                produto.setdescricao(rs.getString("DESCRICAO"));
                produto.setPrecoCompra(rs.getFloat("PRECOCOMPRA"));
                produto.setPrecoVenda(rs.getFloat("PRECOVENDA"));
                produto.setQuantidade(rs.getInt("QUANTIDADE"));
                produto.setStatus(rs.getBoolean("STATUS"));
                listaProdutos.add(produto);
            }

        } catch (ClassNotFoundException ex) {
            listaProdutos = null;
        } catch (SQLException ex) {
            listaProdutos = null;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                listaProdutos = null;
            }
        }

        return listaProdutos;
    }

    public static ArrayList<model.Produto> ConsultarProdutoNome(String nome) {
        ArrayList<model.Produto> listaProduto = new ArrayList<model.Produto>();

        try {
            Class.forName(DRIVER);
            url = "jdbc:mysql://" + "localhost:3306" + "/geren";
            conexao = DriverManager.getConnection(url, "root", "");
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM PRODUTOS WHERE NOME LIKE ?;");
            comando.setString(1, "%" + nome);
            ResultSet rs = comando.executeQuery();

            while (rs.next()) {

                model.Produto produto = new model.Produto();
                produto.setIdProduto(rs.getInt("IDPRODUTO"));
                produto.setNome(rs.getString("NOME"));
                produto.setdescricao(rs.getString("DESCRICAO"));
                produto.setPrecoCompra(rs.getFloat("PRECOCOMPRA"));
                produto.setPrecoVenda(rs.getFloat("PRECOVENDA"));
                produto.setQuantidade(rs.getInt("QUANTIDADE"));
                produto.setStatus(rs.getBoolean("STATUS"));
                listaProduto.add(produto);

            }

        } catch (ClassNotFoundException ex) {
            listaProduto = null;
        } catch (SQLException ex) {
            listaProduto = null;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                listaProduto = null;
            }
        }
        return listaProduto;
    }
}
