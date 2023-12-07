package kr.ac.mjc.kiosk.service;

public interface MangerService {
    /**
     * 관리자 상품 등록
     */
    void productInsert(Product product) throws SQLException;

    /**
     * 관리자 상품 수정
     */
    void productUpdate(Product product) throws SQLException;

    /**
     * 관리자 상품 삭제
     */
    void productDelete(String productCode) throws SQLException;

    /**
     * 관리자 세트 등록
     */
    void bundleInsert(Bundle bundle) throws SQLException;

    /**
     * 관리자 세트 수정
     */
    void bundleUpdate(Bundle bundle) throws SQLException;

    /**
     * 관리자 세트 삭제
     */
    void bundleDelete(String bundleCode) throws SQLException;

    /**
     * 판매 내역 조회
     * */
    List<Orders> ordersSelect() throws SQLException;

}
