package Persistencia;

import Modelo.Nasa;

import java.sql.*;
import java.util.ArrayList;

public class NasaDao implements InterfazDao{
    public NasaDao() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert="INSERT INTO Nasa(Nombre,Fecha,Funcion,Base,Url) VALUES(?,?,?,?,?)";
        int rowCount=0;
        PreparedStatement pstm=ConexionSingleton.getInstance("nasa.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1,((Nasa)obj).getNombre());
        pstm.setString(2,((Nasa)obj).getFecha());
        pstm.setString(3,((Nasa)obj).getFuncion());
        pstm.setString(4,((Nasa)obj).getBase());
        pstm.setString(5,((Nasa)obj).getUrl());
        rowCount= pstm.executeUpdate();
        return rowCount>0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate="UPDATE Nasa SET Nombre=?,Fecha=?,Funcion=?,Base=?, url=? WHERE Id=?;";
        int rowCount=0;
        PreparedStatement pstm=ConexionSingleton.getInstance("nasa.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1,((Nasa)obj).getNombre());
        pstm.setString(2,((Nasa)obj).getFecha());
        pstm.setString(3,((Nasa)obj).getFuncion());
        pstm.setString(4,((Nasa)obj).getBase());
        pstm.setString(5,((Nasa)obj).getUrl());
        pstm.setInt(6,((Nasa)obj).getId());
        rowCount= pstm.executeUpdate();
        return rowCount>0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete="DELETE FROM Nasa WHERE id=?;";
        int rowCout=0;
        PreparedStatement pstm= ConexionSingleton.getInstance("nasa.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1,Integer.parseInt(id));
        rowCout =pstm.executeUpdate();
        return rowCout>0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM Nasa";
        ArrayList<Nasa> resultado = new ArrayList<>();
        String dbPath = "D:/Jorge/untitled/src/main/resources/nasa.db";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                resultado.add(new Nasa(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql ="SELECT * FROM Nasa WHERE Id=?";
        Nasa nasa=null;

        PreparedStatement pstm = ConexionSingleton.getInstance("instrumentos.db").getConnection().prepareStatement(sql);
        pstm.setInt(1,Integer.parseInt(id));
        ResultSet rst= pstm.executeQuery();
        if (rst.next()) {
            nasa = new Nasa(rst.getInt(1), rst.getString(2), rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6));
            return nasa;
        }
        return null;
    }
}
