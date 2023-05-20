package com.application.application;
import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public String GetQuestionFromDB(int id, int a) {
        String s = "";

        String returnText = "";
        String query = "";
        try {
            Connection conn = getDbConnection();
            Statement statement = conn.createStatement();

            if(a == 0)
            {
                query = "SELECT " + Const.QUESTION + " FROM " + Const.USER_TABLE + " WHERE " + Const.ID + " = " + id;
            }
            else if(a == 1)
            {
                query = "SELECT " + Const.ANSWER_A + " FROM " + Const.USER_TABLE + " WHERE " + Const.ID + " = " + id;
            }
            else if(a == 2)
            {
                query = "SELECT " + Const.ANSWER_B + " FROM " + Const.USER_TABLE + " WHERE " + Const.ID + " = " + id;
            }
            else if(a == 3)
            {
                query = "SELECT " + Const.ANSWER_C + " FROM " + Const.USER_TABLE + " WHERE " + Const.ID + " = " + id;
            }
            else if(a == 4)
            {
                query = "SELECT " + Const.ANSWER_D + " FROM " + Const.USER_TABLE + " WHERE " + Const.ID + " = " + id;
            }
            else if(a == 5)
            {
                query = "SELECT " + Const.TYPE + " FROM " + Const.USER_TABLE + " WHERE " + Const.ID + " = " + id;
            }


            ResultSet resultSet = statement.executeQuery(query);


            if (resultSet.next()) {
                if(a == 0)
                {
                    s = resultSet.getString(Const.QUESTION);
                }
                else if(a == 1)
                {
                    s = resultSet.getString(Const.ANSWER_A);
                }
                else if(a == 2)
                {
                    s = resultSet.getString(Const.ANSWER_B);
                }
                else if(a == 3)
                {
                    s = resultSet.getString(Const.ANSWER_C);
                }
                else if(a == 4)
                {
                    s = resultSet.getString(Const.ANSWER_D);
                }
                else if(a == 5)
                {
                    s = resultSet.getString(Const.TYPE);
                }
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        returnText = s;
        return returnText;
    }

    public void SavePlayerData(String name, int score)
    {
        try {
            Connection conn = getDbConnection();
            Statement statement = conn.createStatement();
            String query = "INSERT INTO " + Const.USER_NAME + "(" + Const.NAME_USER + "," + Const.SCORE + ") VALUES('" + name + "'," + score + ")";
            statement.executeUpdate(query);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getTopPlayers() throws SQLException {
        Configs configs = new Configs();
        String dbURL = "jdbc:mysql://" + configs.dbHost + ":" + configs.dbPort + "/" + configs.dbName;

        Connection dbConnection = DriverManager.getConnection(dbURL, configs.dbUser, configs.dbPass);

        String query = "SELECT " + Const.NAME_USER + "," + Const.SCORE +" FROM " + Const.USER_NAME +" ORDER BY " + Const.SCORE+ " DESC LIMIT 3";
        PreparedStatement pstmt = dbConnection.prepareStatement(query);
        System.out.println(query);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }



}