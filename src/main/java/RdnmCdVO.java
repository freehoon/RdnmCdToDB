import lombok.Data;

@Data
public class RdnmCdVO {
    String rdnmCd;              //도로명코드
    String rdnm;                //도로명
    String rdnmRmStr;           //도로명로마자
    String emdSn;               //읍면동일련번호
    String ctprvnNm;            //시도명
    String ctprvnRmStr;         //시도명 로마자
    String signguNm;            //시군구명
    String signguRmStr;         //시군구 로마자
    String emdNm;               //읍면동명
    String emdRmStr;            //읍면동 로마자
    String emdCl;               //읍면동구분
    String emdCd;               //읍면동코드
    String useYn;               //사용여부
    String altRsn;              //변경사유
    String altHstrInfo;         //변경이력정보
    String notcDt;              //고시일자
    String ersDt;               //말소일자
}
