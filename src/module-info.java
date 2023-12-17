module internetCLafes {
	requires javafx.graphics;
	requires javafx.controls;
	requires java.sql;
	requires javafx.base;

	opens view;
	opens database;
	opens model;
}