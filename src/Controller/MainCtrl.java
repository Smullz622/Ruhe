/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.stage.Stage;
import View.MainUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Sarah
 */
public class MainCtrl //implements Initializable
{

    MainUI homepage;
    JournalController journalCtrl;
    HabitController habitCtrl;
    MoodCtrl moodCtrl;
    SleepController sleepCtrl;
//    @FXML
//    private Button sleepBtn;
//    @FXML
//    private Button journalBtn;

    public MainCtrl()
    {
        homepage = new MainUI();
        mainButtons();
        homepage.setVisible(true);
    }

//    @FXML
//    public void mainButtons()
//    {
//      
//    }
    public MainUI getHomepage()
    {
        return homepage;
    }

//    @Override
//    public void initialize(URL location, ResourceBundle resources)
//    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
    private void mainButtons()
    {
        homepage.journalBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (journalCtrl == null){
                journalCtrl = new JournalController();
                }
                else{
                    journalCtrl.mainUI.setVisible(true);
                }
                homepage.setVisible(false);
    
                journalCtrl.mainUI.homeButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {                        
                        journalCtrl.mainUI.setVisible(false);
                        homepage.setVisible(true);           
                    }

                });
            }
        });
        homepage.habitBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (habitCtrl == null){
                habitCtrl = new HabitController();
                }
                else{
                    habitCtrl.habitUI.setVisible(true);
                }                    
                homepage.setVisible(false);
                habitCtrl.habitUI.homeButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {                        
                        habitCtrl.habitUI.setVisible(false);
                        homepage.setVisible(true);           
                    }

                });
            }
            
        });
        
        homepage.moodBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (moodCtrl == null)
                {
                    moodCtrl = new MoodCtrl();
                }
                else{
                    moodCtrl.moodUI.setVisible(true);
                }
                homepage.setVisible(false);
                moodCtrl.moodUI.homeBtn.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                         moodCtrl.moodUI.setVisible(false);
                         homepage.setVisible(true);
                    }
                    
                });
            }
            
        }
        );
        
        homepage.sleepBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (sleepCtrl == null){
                sleepCtrl = new SleepController();
                }
//                else{
//                    habitCtrl.habitUI.setVisible(true);
//                }                    
                homepage.setVisible(false);
//                habitCtrl.habitUI.homeButton.addActionListener(new ActionListener()
//                {
//                    @Override
//                    public void actionPerformed(ActionEvent e)
//                    {                        
//                        habitCtrl.habitUI.setVisible(false);
//                        homepage.setVisible(true);           
//                    }
//
//                });
            }
            
        });
      
    }
     public JournalController getJournalCtrl()
        {
            return journalCtrl;
        }
}
