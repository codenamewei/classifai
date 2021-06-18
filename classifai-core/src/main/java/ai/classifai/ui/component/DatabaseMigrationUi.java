package ai.classifai.ui.component;

import ai.classifai.util.ParamConfig;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class DatabaseMigrationUi
{
    private static Dimension dimension = new Dimension(750, 400);
    private JDialog mainFrame;
    private JPanel mainPanel;
    private JTextArea titleText;
    private List<ProjectPanel> projectPanels;
    private JButton doneButton;
    @Getter private Map<String, String> newProjectPathDict;

    public DatabaseMigrationUi(List<String> projectNameList)
    {
        mainFrame = new JDialog();
        mainPanel = new JPanel();
        titleText = new JTextArea("Project listed below are having multiple source of image folders, where this is not allowed in v2.\n" +
                "Please specify the new project folder to store the images." +
                " Or leave the selection window empty to skip the migration of the project.");
        projectPanels =  projectNameList.stream()
                .map(ProjectPanel::new)
                .collect(Collectors.toList());
        doneButton = new JButton();
    }

    private void configure()
    {
        configureTitleText();

        configureMainPanel();

        configureMainFrame();

        configureDoneButton();
    }

    private void configureDoneButton()
    {
        doneButton.setText("Ok");
        doneButton.addActionListener(this::savePathAndExit);
    }

    private void savePathAndExit(ActionEvent e)
    {
        newProjectPathDict = new HashMap<>();

        projectPanels.forEach(panel -> newProjectPathDict.put(panel.projectName, panel.projectPathText.getText()));
    }

    private void configureMainFrame()
    {
        mainFrame.setTitle("Migration Options");
        mainFrame.setLocationRelativeTo(null);  // set to center
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setResizable(true);
        mainFrame.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    }

    private void configureMainPanel()
    {
        mainPanel.setPreferredSize(dimension);
        mainPanel.add(titleText);
        projectPanels.forEach(mainPanel::add);
    }

    private void configureTitleText()
    {
        configureTextArea(titleText);
    }

    public void run()
    {
        configure();
        mainFrame.setVisible(true);
    }

    private static class ProjectPanel extends JPanel
    {
        private String projectName;
        private JTextArea projectNameText;
        private JTextArea projectPathText;
        private JButton openSelectionWindowButton;
        private JFileChooser projectPathSelector;

        public ProjectPanel(String projectName)
        {
            this.projectName = projectName;
            projectNameText = new JTextArea();
            projectPathText = new JTextArea();
            openSelectionWindowButton = new JButton();
            projectPathSelector = new JFileChooser();
            this.setPreferredSize(new Dimension(dimension.width, 20));
            this.configure();
            this.setVisible(true);
        }

        private void configure()
        {
            configureProjectName();
            configureSelectionWindowButton();
            configureProjectPath();
            configureSelectionWindow();
        }

        private void configureProjectName()
        {
            projectNameText.setText(this.projectName);
            configureTextArea(projectNameText);
            this.add(projectNameText);
        }

        private void configureProjectPath()
        {
            projectPathText.setText("No Path Selected");
            configureTextArea(projectPathText);

            this.add(projectPathText);
        }

        private void configureSelectionWindowButton()
        {
            openSelectionWindowButton.addActionListener(this::triggerSelectionWindow);
            this.add(openSelectionWindowButton);
        }

        private void configureSelectionWindow()
        {
            projectPathSelector.addActionListener(this::setSelectedPath);
            projectPathSelector.setSelectedFile(null);
            projectPathSelector.setCurrentDirectory(ParamConfig.getRootSearchPath());
            projectPathSelector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            projectPathSelector.setDialogTitle("Select Project Path");
            projectPathSelector.setMultiSelectionEnabled(false);
        }

        private void triggerSelectionWindow(ActionEvent e)
        {
            projectPathSelector.setVisible(true);
            projectPathSelector.showOpenDialog(this);
        }

        private void setSelectedPath(ActionEvent event)
        {
            JFileChooser chooser = (JFileChooser) event.getSource();
            if (event.getActionCommand().equals(JFileChooser.APPROVE_SELECTION))
            {
                projectPathText.setText(chooser.getSelectedFile().getAbsolutePath());
            }
        }
    }

    public static void main(String[] args)
    {
        List<String> nameList = Arrays.asList("a", "b", "c");
        DatabaseMigrationUi ui = new DatabaseMigrationUi(nameList);
        ui.run();
    }

    private static void configureTextArea(JTextArea textArea)
    {
        textArea.setBackground(null);
        textArea.setEditable(false);
    }

}