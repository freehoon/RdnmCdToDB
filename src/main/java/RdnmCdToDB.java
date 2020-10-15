import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;

public class RdnmCdToDB {
    public static void main(String[] args) throws IOException, SQLException, InterruptedException {
        String filePath = "/Users/freehoon/IdeaProjects/RdnmCdToDB/jusoData/";

        //파일 목록을 가지고 온다.
        File dir = new File(filePath);
        List<String> fileLists = Arrays.asList(dir.list());

        List<RdnmCdVO> rdnmCdList = new ArrayList<>();
        RdnmCdVO rdnmCdVO = null;
        String filePathNm = "";
        for(String fileNm : fileLists){
            filePathNm = filePath + fileNm;
            System.out.println(filePathNm);
            if("개선_도로명코드_전체분.txt".equals(fileNm)){
                File file = new File(filePathNm);
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = "";
                while((line = bufferedReader.readLine()) != null ){
                    //System.out.println(line);
                    rdnmCdVO = new RdnmCdVO();
                    String[] parse = line.split("\\|", -1);
                    rdnmCdVO.setRdnmCd(parse[0]);
                    rdnmCdVO.setRdnm(parse[1]);
                    rdnmCdVO.setRdnmRmStr(parse[2]);
                    rdnmCdVO.setEmdSn(parse[3]);
                    rdnmCdVO.setCtprvnNm(parse[4]);
                    rdnmCdVO.setCtprvnRmStr(parse[5]);
                    rdnmCdVO.setSignguNm(parse[6]);
                    rdnmCdVO.setSignguRmStr(parse[7]);
                    rdnmCdVO.setEmdNm(parse[8]);
                    rdnmCdVO.setEmdRmStr(parse[9]);
                    rdnmCdVO.setEmdCl(parse[10]);
                    rdnmCdVO.setEmdCd(parse[11]);
                    rdnmCdVO.setUseYn(parse[12]);
                    rdnmCdVO.setAltRsn(parse[13]);
                    rdnmCdVO.setAltHstrInfo(parse[14]);
                    rdnmCdVO.setNotcDt(parse[15]);
                    rdnmCdVO.setErsDt(parse[16]);

                    rdnmCdList.add(rdnmCdVO);
                 //   System.out.println(rdnmCdList);
                }//while
                //   System.out.println(rdnmCdList);
                //파일을 파일 종류식에 따라 읽어와 저장한다.
                RdnmCdDAO dao = new RdnmCdDAO();
                dao.insertRdnmCd(rdnmCdList);
            }//end if 각 파일

        }//end for 파일 리스트

    }//end main
}
