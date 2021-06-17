package ai.classifai.ui.component;

import javax.swing.*;

public class DatabaseMigrationUi
{
    JFrame mainFrame;
    JPanel mainPanel;

    public DatabaseMigrationUi()
    {
        mainFrame = new JFrame("Migration Options");
        mainPanel = new JPanel();
    }

    public void run()
    {
        mainFrame.setVisible(true);
    }



    public static void main(String[] args)
    {
        DatabaseMigrationUi ui = new DatabaseMigrationUi();

    }

}