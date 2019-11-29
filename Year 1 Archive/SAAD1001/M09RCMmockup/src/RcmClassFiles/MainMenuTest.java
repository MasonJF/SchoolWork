package RcmClassFiles;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;

import static org.junit.Assert.*;

public class MainMenuTest {

    @Test
    public void getFileString() {
        MainMenu testMain = new MainMenu();
        testMain.valueChanged2();
        String result = testMain.getFileString().getText();
        String expResult = "File: MainMenu.java";
        assertEquals(expResult, result);
    }

    @Test
    public void getFileAuthor() {
        MainMenu testMain = new MainMenu();
        testMain.valueChanged2();
        String result = testMain.getFileAuthor().getText();
        String expResult = "Author: Mason Fraser";
        assertEquals(expResult, result);
    }

    @Test
    public void getFileWNumber() {
        MainMenu testMain = new MainMenu();
        testMain.valueChanged2();
        String result = testMain.getFileWNumber().getText();
        String expResult = "W-number: w0422681";
        assertEquals(expResult, result);
    }

    @Test
    public void getFileDateRevLast() {
        MainMenu testMain = new MainMenu();
        testMain.valueChanged2();
        String result = testMain.getFileDateRevLast().getText();
        String expResult = "Date: This Will Fail";
        assertEquals(expResult, result);
    }

    @Test
    public void getFileDateFixLast() {
        MainMenu testMain = new MainMenu();
        testMain.valueChanged2();
        String result = testMain.getFileDateFixLast().getText();
        String expResult = "Date: This will Fail";
        assertEquals(expResult, result);
    }

    @Test
    public void getFileCommentList() {
        MainMenu testMain = new MainMenu();
        testMain.valueChanged2();
        String result = testMain.getFileCommentList().getText();
        String expResult = "Total Comments: 9";
        assertEquals(expResult, result);
    }

    @Test
    public void getFileNew() {
        MainMenu testMain = new MainMenu();
        testMain.valueChanged2();
        String result = testMain.getFileNew().getText();
        String expResult = "Total NEW Comments: 8";
        assertEquals(expResult, result);
    }

    @Test
    public void getFileFixed() {
        MainMenu testMain = new MainMenu();
        testMain.valueChanged2();
        String result = testMain.getFileFixed().getText();
        String expResult = "Total FIXED Comments: 0";
        assertEquals(expResult, result);
    }

    @Test
    public void getFileNA() {
        MainMenu testMain = new MainMenu();
        testMain.valueChanged2();
        String result = testMain.getFileNA().getText();
        String expResult = "Total NA Comments: 1";
        assertEquals(expResult, result);
    }
}