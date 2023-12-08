package kr.ac.mjc.kiosk.view;

public class MainApp extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
        double x = 765.0;
        double y = 1025.0;

        BrowserPane pane = new BrowserPane("resources/html/index.html", x, y);

        System.setProperty("prism.lcdtext", "false");

        Scene scene = new Scene(pane);
        stage.setScene(scene);

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Kiosk");

        pane.setWindowMover(stage, 300.0, 75.0);
        stage.setWidth(x);
        stage.setHeight(y);

        stage.show();

        FrontController fc = FrontController.getInstance();
        fc.setWebView(pane.getWebView());
        Worker<Void> worker= pane.getWebEngine().getLoadWorker();

        worker.stateProperty().addListener((ob, ov, nv) -> {
            if (nv == Worker.State.SUCCEEDED) {
                fc.initialize();
                JSObject jsobj = (JSObject) fc.getWebView().getEngine().executeScript("window");
                jsobj.setMember("controller", fc);
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }

}