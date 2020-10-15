import lombok.Data;

@Data
public class EtcInfoVO {
    String admNo;           //관리번호
    String adongCd;         //행정동코드
    String adongNm;         //행정동명
    String zipCode;         //우편번호
    String zipCodeSn;       //우편번호일련번호
    String largDlpcNm;      //다량배달처명
    String bdgAbBldNm;      //건축물대장건물명
    String signguBldNm;     //시군구 건물명
    String jntHsngYn;       //공동주택여부
    String altRsnCd;        //변경사유코드
}
