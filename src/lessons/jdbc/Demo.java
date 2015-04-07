package lessons.jdbc;


import java.sql.*;

public class Demo {



    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/infopulse";
        Connection con = DriverManager.getConnection(url, "root", "root");
        //simple sql (without answer)
        Statement st = con.createStatement();
        String sql = "insert into clients (name, surname) values ('Vasya', 'Pupkin')";
        st.execute(sql);
        sql = "SELECT * from clients";
        ResultSet rs = st.executeQuery(sql);
        ResultSetMetaData metaData = rs.getMetaData();
        DatabaseMetaData databaseMetaData = con.getMetaData();
        int columns = metaData.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columns ; i++) {
                rs.getString(i);
            }
        }

        //preparesr
        sql = "insert into clients (name, surname) values (?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, "Kolya");
        pst.setString(2, "Petrov");
        pst.execute();

        //callableSt -- for call sql-procedures

        sql = "{call getSurName(?, ?)}";
        CallableStatement cs = con.prepareCall(sql);
        cs.setInt(1,2);
        cs.registerOutParameter(2,Types.VARCHAR);
        cs.execute();
        String surName = cs.getString(2);


        //package executing
        st.addBatch("insert into clients (name, surname) values ('Vasya', 'Pupkin')");
        st.addBatch("insert into clients (name, surname) values ('Vasya', 'Pupkin')");
        st.addBatch("insert into clients (name, surname) values ('Vasya', 'Pupkin')");
        int[] ints = st.executeBatch();
        //>=0 -- success
        //No_inf0 -- unknown result
        //failure -- no success

        //transaction
        //principle: 1) atomarity : or all, or nothing
        //2) согласованность: если сбой -- в начало
        //isolaty -- изолированость
         //долговечность == необратимость



        //
        con.close();


    }
}
