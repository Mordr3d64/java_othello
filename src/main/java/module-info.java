module com.socialnet.java_othello {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.socialnet.java_othello to javafx.fxml;
    exports com.socialnet.java_othello;
}