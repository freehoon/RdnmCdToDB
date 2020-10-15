import org.mariadb.jdbc.internal.com.read.resultset.SelectResultSet;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.*;
import java.util.Iterator;
import java.util.List;

import static java.lang.Class.forName;

public class RdnmCdDAO {
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL="jdbc:mariadb://localhost:3306/mgootgoo?useSSL=false";
    static final String USERNAME = "root";
    static final String PASSWORD = "12341234";
    
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet= null;
    
    public RdnmCdDAO() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) connection.close();
        }
    }
    
    public void insertRdnmCd(List<RdnmCdVO> lists) throws InterruptedException {
        Iterator iterator = lists.iterator();
        StringBuffer strSql = new StringBuffer();
        strSql.append("INSERT INTO tblRdnmCd(rdnmCd, rdnm, rdnmRmStr, emdSn, ctprvnNm, ctprvnRmStr, signguNm, signguRmStr, emdNm, emdRmStr, emdCl, emdCd, useYn, altRsn, altHstrInfo, notcDt, ersDt) VALUES" );
        int cnt = 0;
        RdnmCdVO rdnmCdVO = null;
        while(iterator.hasNext()){
            rdnmCdVO = (RdnmCdVO) iterator.next();
            strSql.append("(");
            strSql.append("'" + rdnmCdVO.getRdnmCd() + "',");
            strSql.append("'" + rdnmCdVO.getRdnm() + "',");
            strSql.append("'" + rdnmCdVO.getRdnmRmStr() + "',");
            strSql.append("'" + rdnmCdVO.getEmdSn() + "',");
            strSql.append("'" + rdnmCdVO.getCtprvnNm() + "',");
            strSql.append("'" + rdnmCdVO.getCtprvnRmStr() + "',");
            strSql.append("'" + rdnmCdVO.getSignguNm() + "',");
            strSql.append("'" + rdnmCdVO.getSignguRmStr() + "',");
            strSql.append("'" + rdnmCdVO.getEmdNm() + "',");
            strSql.append("'" + rdnmCdVO.getEmdRmStr() + "',");
            strSql.append("'" + rdnmCdVO.getEmdCl() + "',");
            strSql.append("'" + rdnmCdVO.getEmdCd() + "',");
            strSql.append("'" + rdnmCdVO.getUseYn() + "',");
            strSql.append("'" + rdnmCdVO.getAltRsn() + "',");
            strSql.append("'" + rdnmCdVO.getAltHstrInfo() + "',");
            strSql.append("'" + rdnmCdVO.getNotcDt() + "',");
            strSql.append("'" + rdnmCdVO.getErsDt() + "')");
            cnt++;

            if(cnt == 4999 || !iterator.hasNext()){
                strSql.append(";");
                System.out.println(strSql);
                try{
                    Class.forName(JDBC_DRIVER);
                    connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    statement = connection.createStatement();
                    statement.executeUpdate(strSql.toString());

                    statement.close();
                    connection.close();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Thread.sleep(3000);
                strSql.setLength(0);
                strSql.append("INSERT INTO tblRdnmCd(rdnmCd, rdnm, rdnmRmStr, emdSn, ctprvnNm, ctprvnRmStr, signguNm, signguRmStr, emdNm, emdRmStr, emdCl, emdCd, useYn, altRsn, altHstrInfo, notcDt, ersDt) VALUES" );
                cnt = 0;
            } else {
                strSql.append(",");
            }

        }
    }
}
