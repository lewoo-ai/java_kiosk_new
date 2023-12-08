package kr.ac.mjc.kiosk.view;

public class BrowserPane extends AnchorPane {
    private final WebView webView = new WebView();
    private final WebEngine webEngine = webView.getEngine();


    /**
     * 웹뷰를 노드로 가지고 있는 ArchorPane을 생성합니다.
     * @param initURL
     * @param x
     * @param y
     * @throws MalformedURLException
     */
    public BrowserPane(String initURL, double width, double height) throws MalformedURLException {
        webView.setFontSmoothingType(FontSmoothingType.GRAY);
        webView.setContextMenuEnabled(false);
        webView.setMinWidth(width);
        webView.setMinHeight(height);
        webEngine.setJavaScriptEnabled(true);

        this.setMinWidth(width);
        this.setMinHeight(height);

        File file = new File(initURL);
        URL url = file.toURI().toURL();

        webEngine.load(url.toString());
        this.getChildren().add(webView);
    }


    /**
     * UNDECORATED 상황에서도 윈도우 창을 움직일 수 있는 패널 및 이벤트를 추가합니다.
     * @param stage
     * @param x
     * @param y
     */
    public void setWindowMover(Stage stage, double width, double height) {
        Pane pane = new Pane();
        pane.setPrefSize(width, height);
        Scene scene = stage.getScene();
        pane.setOnMouseDragged(e->{
            scene.setCursor(Cursor.MOVE);
            stage.setX(e.getScreenX());
            stage.setY(e.getScreenY());
        });

        pane.setOnMousePressed(e->{
            scene.setCursor(Cursor.MOVE);
            stage.setX(e.getScreenX());
            stage.setY(e.getScreenY());
        });

        pane.setOnMouseReleased(e->scene.setCursor(Cursor.DEFAULT));

        this.getChildren().add(pane);
    }

    public WebView getWebView() {
        return webView;
    }

    public WebEngine getWebEngine() {
        return webEngine;
    }
}
