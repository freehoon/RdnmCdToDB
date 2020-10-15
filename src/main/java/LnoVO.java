import lombok.Data;

@Data
public class LnoVO {
    String admNo;           //관리번호
    String lnoSn;           //일련번호
    String ldongCd;         //법정동코드
    String ctprvnNm;        //시도명
    String signguNm;        //시군구명
    String lemdNm;          //법정읍면동
    String lriNm;           //법정리명
    String plotSctCd;       //산여부
    String lnoMnno;         //지번본번(번지)
    String lnoSlno;         //지번부번(호)
    String rpnYn;           //대표여부
    String altRsnCd;        //변경사유코드
}
