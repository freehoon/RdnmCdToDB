import lombok.Data;

@Data
public class RdnmAdrVO {
    String admNo;           //관리번호
    String rdnmCd;          //도로명코드
    String emdSn;           //읍면동일련번호
    String bsmtYn;          //지하여부
    String bldMnno;         //건물본번
    String bldSlno;         //건물부번
    String bsLocNo;         //기초구역번호
    String altRsnCd;        //기초구역번호
    String notcDt;          //고시일자
    String bfRdnm;          //변경전도로명주소
    String dadrGratYn;      //상세주소부여 여부
}
