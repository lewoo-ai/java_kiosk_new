package kr.ac.mjc.kiosk.view;




public class ManagerMenuView {
    ManagerController managerController = new ManagerController();
    Scanner sc = new Scanner(System.in);

    /**
     * 메뉴 선택
     * */
    public void menu() {
        System.out.println("===== 관리자 프로그램 =====");

        while(true) {
            System.out.println("\n메뉴를 선택해주세요.");
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.println("1.상품등록  |  2.상품수정  |  3.상품삭제  |   4.판매조회  |  5.종료");
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.print("> ");
            int menuNo = Integer.parseInt(sc.nextLine());
            switch(menuNo) {
                case 1 : productInsert(); break;
                case 2 : productUpdate(); break;
                case 3 : productDelete(); break;
                case 4 : ordersSelect(); break; //판매조회
                case 5 : System.out.println("프로그램 종료");
                    System.exit(0);
                default : System.out.println("메뉴는 숫자 '1 ~ 4' 또는 '5'를 입력해주세요");
            }
        }
    }

    /**
     * 1.상품등록
     * */
    public void productInsert() {
        System.out.print("\n상품 코드 : ");
        String productCode = sc.nextLine();
        System.out.print("\n상품 이름 : ");
        String productName = sc.nextLine();
        System.out.print("\n카테고리 코드 : ");
        String categoryCode = sc.nextLine();
        System.out.print("\n상품 가격 : ");
        int productPrice = Integer.parseInt(sc.nextLine());
        System.out.print("\n상품 설명 : ");
        String productDetails = sc.nextLine();
        System.out.print("\n상품 이미지 : ");
        String productImage = sc.nextLine();
        System.out.print("\n상품 옵션 : "); //상품 코드(재귀적 관계)
        String productOptions = sc.nextLine();



        managerController.productInsert(new Product(productCode, productName, categoryCode, productPrice, productDetails, productImage, productOptions, isBundle));
    }

    /**
     * 2.상품수정
     * */
    public void productUpdate() {
        System.out.print("\n상품 코드 : ");
        String productCode = sc.nextLine();
        System.out.print("\n상품 가격 : ");
        int productPrice = Integer.parseInt(sc.nextLine());

        managerController.productUpdate(new Product(productCode, null, productPrice, null, null, null, false));
    }

    /**
     * 3.상품삭제
     * */
    public void productDelete() {
        System.out.print("\n상품 코드 : ");
        String productCode = sc.nextLine();

        managerController.productDelete(productCode);
    }


    /**
     * 4.판매조회
     * */
    public void ordersSelect() {
        managerController.ordersSelect();
    }
}
