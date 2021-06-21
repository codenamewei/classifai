package ai.classifai.ui.component;

import ai.classifai.util.ParamConfig;
import ai.classifai.util.type.AnnotationType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class DbMigrationUi
{
    @Getter private JPanel mainPanel;
    private List<ProjectPanel> projectPanels;

    public DbMigrationUi(JSONArray projectNameList)
    {
        mainPanel = new JPanel(new GridLayout(0, 1));
        projectPanels = createProjectPanels(projectNameList);
        configureMainPanel();
    }

    private List<ProjectPanel> createProjectPanels(JSONArray projectNameList)
    {
        List<ProjectPanel> projectPanels = new ArrayList<>();
        for (Object obj : projectNameList)
        {
            JSONObject JsonObj = (JSONObject) obj;
            projectPanels.add(
                    new ProjectPanel(JsonObj.getString(ParamConfig.getProjectNameParam()),
                            AnnotationType.getByInt(JsonObj.getInt(ParamConfig.getAnnotationTypeParam()))));
        }
        return projectPanels;
    }

    public Map<String, String> getSavePath()
    {
        Map<String, String> newProjectPathDict = new HashMap<>();

        projectPanels.forEach(panel -> savePathAndCreateDirectory(panel, newProjectPathDict));

        return newProjectPathDict;
    }

    private void savePathAndCreateDirectory(ProjectPanel panel, Map<String, String> newProjectPathDict)
    {
        String newProjectDirectory = panel.projectPathText.getText();
        String projectName = panel.projectName;
        String newProjectPath = String.join(File.separator,newProjectDirectory, projectName);

        if (Paths.get(newProjectDirectory).isAbsolute())
        {
            newProjectPathDict.put(projectName, newProjectPath);
        }
    }

    private void configureMainPanel()
    {
        projectPanels.forEach(mainPanel::add);
        mainPanel.setPreferredSize(new Dimension(400, 70 * projectPanels.size()));
    }

    public void run()
    {
        this.mainPanel.setVisible(true);
    }

    private static class ProjectPanel extends JPanel
    {
        private String projectName;
        private String projectType;
        private JTextArea projectNameText;
        private JTextArea projectPathText;
        private JButton openSelectionWindowButton;
        private JFileChooser projectPathSelector;
        private GridBagConstraints gbc;

        public ProjectPanel(String projectName, String projectType)
        {
            setLayout(new GridBagLayout());
            gbc = new GridBagConstraints();
            this.projectName = projectName;
            this.projectType = projectType;

            projectNameText = new JTextArea();
            projectPathText = new JTextArea();
            openSelectionWindowButton = new JButton("Migrate");
            projectPathSelector = new JFileChooser();

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
            projectNameText.setText(String.format("[%s] %s", this.projectType, this.projectName));
            projectPathText.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            configureTextArea(projectNameText);
            gbc.gridx = 0;
            gbc.gridwidth = 5;
            this.add(projectNameText, gbc);

        }

        private void configureSelectionWindowButton()
        {
            openSelectionWindowButton.addActionListener(this::triggerSelectionWindow);
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            this.add(openSelectionWindowButton, gbc);

        }

        private void configureProjectPath()
        {
            projectPathText.setText("Project will not be migrated");
            configureTextArea(projectPathText);
            gbc.gridx = 3;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            this.add(projectPathText, gbc);
        }

        private void configureSelectionWindow()
        {
            projectPathSelector.addActionListener(this::setSelectedPath);
            projectPathSelector.setSelectedFile(null);
            projectPathSelector.setCurrentDirectory(ParamConfig.getRootSearchPath());
            projectPathSelector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            projectPathSelector.setDialogTitle("Select new project path to migrate");
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

    private static void configureTextArea(JTextArea textArea)
    {
        textArea.setBackground(null);
        textArea.setEditable(false);
    }
}