/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.cs321.gui;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.cs321.core.GameConfiguration;
import com.cs321.gui.GUIState.PanelName;
import com.cs321.io.IOUtils;

/**
 *
 * @author Hasna
 */
public class ViewGamemodesPanel  extends UpdateableJPanel {

    // The global GUI state
    private GUIState state;
    
    /**
     * Creates new form ViewGamemodesPanel
     */
    public ViewGamemodesPanel(GUIState state) {
        initComponents();
        
        this.state = state;
    }
    
    /**
     * Updates the components to reflect the current state
     */
    @Override
    public void updateComponents() {
        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        for (GameConfiguration gameConfiguration : state.gameConfigurations) {
            defaultListModel.addElement(gameConfiguration.getName());
        }
        ExplorerList.setModel(defaultListModel);

        int index = ExplorerList.getSelectedIndex();
        if (index == -1) {
            disablePropertiesMenu();
        } else {
            enablePropertiesMenu();
        }
    }

    /**
     * Clears the content panel
     */
    private void clearContentPanel() {
        CurrentIDLabel.setText("----");
        CurrentNameLabel.setText("----");
        CurrentDartsPerRoundLabel.setText("----");
        CurrentMaximumRoundsLabel.setText("----");
        CurrentStartingScoreLabel.setText("----");
        CurrentOffboardPenaltyLabel.setText("----");
        
        ScoreLabel1.setText("-");
        ScoreLabel2.setText("-");
        ScoreLabel3.setText("-");
        ScoreLabel4.setText("-");
        ScoreLabel5.setText("-");
        ScoreLabel6.setText("-");
        ScoreLabel7.setText("-");
        ScoreLabel8.setText("-");
        ScoreLabel9.setText("-");
        ScoreLabel10.setText("-");
        ScoreLabel11.setText("-");
        ScoreLabel12.setText("-");
        ScoreLabel13.setText("-");
        ScoreLabel14.setText("-");
        ScoreLabel15.setText("-");
        ScoreLabel16.setText("-");
        ScoreLabel17.setText("-");
        ScoreLabel18.setText("-");
        ScoreLabel19.setText("-");
        ScoreLabel20.setText("-");
        ScoreLabelBullseye.setText("-");

        CurrentMultipliersLabel.setText("----");
        CurrentExactZeroWinLabel.setText("----");
        CurrentSubtractPointsLabel.setText("----");
    }

    /**
     * Displays the game configuration in the content panel
     * 
     * @param gameConfiguration the game configuration to display
     */
    private void displayGameConfiguration(GameConfiguration gameConfiguration) {
        if (gameConfiguration == null) {
            clearContentPanel();
            return;
        }

        CurrentIDLabel.setText(gameConfiguration.getId());
        CurrentNameLabel.setText(gameConfiguration.getName());
        CurrentDartsPerRoundLabel.setText(String.valueOf(gameConfiguration.getDartsPerRound()));
        CurrentMaximumRoundsLabel.setText(String.valueOf(gameConfiguration.getMaximumRounds()));
        CurrentStartingScoreLabel.setText(String.valueOf(gameConfiguration.getStartingScore()));
        CurrentOffboardPenaltyLabel.setText(String.valueOf(gameConfiguration.getOffboardPenalty()));

        int[] scoreList = gameConfiguration.getScoreList();
        ScoreLabel1.setText(String.valueOf(scoreList[0]));
        ScoreLabel2.setText(String.valueOf(scoreList[1]));
        ScoreLabel3.setText(String.valueOf(scoreList[2]));
        ScoreLabel4.setText(String.valueOf(scoreList[3]));
        ScoreLabel5.setText(String.valueOf(scoreList[4]));
        ScoreLabel6.setText(String.valueOf(scoreList[5]));
        ScoreLabel7.setText(String.valueOf(scoreList[6]));
        ScoreLabel8.setText(String.valueOf(scoreList[7]));
        ScoreLabel9.setText(String.valueOf(scoreList[8]));
        ScoreLabel10.setText(String.valueOf(scoreList[9]));
        ScoreLabel11.setText(String.valueOf(scoreList[10]));
        ScoreLabel12.setText(String.valueOf(scoreList[11]));
        ScoreLabel13.setText(String.valueOf(scoreList[12]));
        ScoreLabel14.setText(String.valueOf(scoreList[13]));
        ScoreLabel15.setText(String.valueOf(scoreList[14]));
        ScoreLabel16.setText(String.valueOf(scoreList[15]));
        ScoreLabel17.setText(String.valueOf(scoreList[16]));
        ScoreLabel18.setText(String.valueOf(scoreList[17]));
        ScoreLabel19.setText(String.valueOf(scoreList[18]));
        ScoreLabel20.setText(String.valueOf(scoreList[19]));
        ScoreLabelBullseye.setText(String.valueOf(scoreList[20]));

        StringBuilder multipliersBuilder = new StringBuilder();
        for (float multiplier : gameConfiguration.getMultipliers()) {
            multipliersBuilder.append(multiplier);
            multipliersBuilder.append(",");
        }
        if (multipliersBuilder.length() > 0) {
            multipliersBuilder.delete(multipliersBuilder.length() - 1, multipliersBuilder.length());
        }
        CurrentMultipliersLabel.setText(multipliersBuilder.toString());

        CurrentExactZeroWinLabel.setText(String.valueOf(gameConfiguration.isExactZeroWin()));
        CurrentSubtractPointsLabel.setText(String.valueOf(gameConfiguration.isSubtractPoints()));
    }

    /**
     * Enables the properties menu
     */
    private void enablePropertiesMenu() {
        EditButton.setEnabled(true);
        ExportButton.setEnabled(true);
        DeleteButton.setEnabled(true);
    }

    /**
     * Disables the properties menu
     */
    private void disablePropertiesMenu() {
        EditButton.setEnabled(false);
        ExportButton.setEnabled(false);
        DeleteButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        ImportGameConfigurationChooser = new javax.swing.JFileChooser();
        ExportFolderChooser = new javax.swing.JFileChooser();
        HeaderPanel = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        TitleLabel = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        BodyPanel = new javax.swing.JPanel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        ContentPanel = new javax.swing.JPanel();
        ExplorerHolderPanel = new javax.swing.JPanel();
        ExplorerScrollPane = new javax.swing.JScrollPane();
        ExplorerList = new javax.swing.JList<>();
        ExplorerMenu = new javax.swing.JPanel();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        NewButton = new javax.swing.JButton();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        ImportButton = new javax.swing.JButton();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        ContentSpacerPanel = new javax.swing.JPanel();
        PropertiesHolderPanel = new javax.swing.JPanel();
        PropertiesScrollPane = new javax.swing.JScrollPane();
        PropertiesPanel = new javax.swing.JPanel();
        IDLabel = new javax.swing.JLabel();
        CurrentIDLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        CurrentNameLabel = new javax.swing.JLabel();
        DartsPerRoundLabel = new javax.swing.JLabel();
        CurrentDartsPerRoundLabel = new javax.swing.JLabel();
        MaximumRoundsLabel = new javax.swing.JLabel();
        CurrentMaximumRoundsLabel = new javax.swing.JLabel();
        StartingScoreLabel = new javax.swing.JLabel();
        CurrentStartingScoreLabel = new javax.swing.JLabel();
        OffboardPenaltyLabel = new javax.swing.JLabel();
        CurrentOffboardPenaltyLabel = new javax.swing.JLabel();
        ScoreListLabel = new javax.swing.JLabel();
        ScoreListDartboardHolderPanel = new javax.swing.JPanel();
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        ScoreListDartboardPanel = new javax.swing.JPanel();
        ScoreLabelBullseye = new javax.swing.JLabel();
        ScoreLabel20 = new javax.swing.JLabel();
        ScoreLabel19 = new javax.swing.JLabel();
        ScoreLabel18 = new javax.swing.JLabel();
        ScoreLabel17 = new javax.swing.JLabel();
        ScoreLabel16 = new javax.swing.JLabel();
        ScoreLabel15 = new javax.swing.JLabel();
        ScoreLabel14 = new javax.swing.JLabel();
        ScoreLabel13 = new javax.swing.JLabel();
        ScoreLabel12 = new javax.swing.JLabel();
        ScoreLabel11 = new javax.swing.JLabel();
        ScoreLabel10 = new javax.swing.JLabel();
        ScoreLabel9 = new javax.swing.JLabel();
        ScoreLabel8 = new javax.swing.JLabel();
        ScoreLabel7 = new javax.swing.JLabel();
        ScoreLabel6 = new javax.swing.JLabel();
        ScoreLabel5 = new javax.swing.JLabel();
        ScoreLabel4 = new javax.swing.JLabel();
        ScoreLabel3 = new javax.swing.JLabel();
        ScoreLabel2 = new javax.swing.JLabel();
        ScoreLabel1 = new javax.swing.JLabel();
        ScoreListDartboardLabel = new javax.swing.JLabel();
        filler15 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        MultipliersLabel = new javax.swing.JLabel();
        CurrentMultipliersLabel = new javax.swing.JLabel();
        ExactZeroWinLabel = new javax.swing.JLabel();
        CurrentExactZeroWinLabel = new javax.swing.JLabel();
        SubtractPointsLabel = new javax.swing.JLabel();
        CurrentSubtractPointsLabel = new javax.swing.JLabel();
        PropertiesMenu = new javax.swing.JPanel();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        EditButton = new javax.swing.JButton();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        ExportButton = new javax.swing.JButton();
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        DeleteButton = new javax.swing.JButton();
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        FooterPanel = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        QuitToMainMenuButton = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        ImportGameConfigurationChooser.setDialogTitle("Choose a Gamemode");
        ImportGameConfigurationChooser.setMinimumSize(new java.awt.Dimension(640, 480));
        ImportGameConfigurationChooser.setPreferredSize(new java.awt.Dimension(640, 480));

        ExportFolderChooser.setDialogTitle("Choose a Folder");
        ExportFolderChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        ExportFolderChooser.setMinimumSize(new java.awt.Dimension(640, 480));
        ExportFolderChooser.setPreferredSize(new java.awt.Dimension(640, 480));

        setMinimumSize(new java.awt.Dimension(1, 1));
        setPreferredSize(new java.awt.Dimension(1, 1));
        setLayout(new java.awt.GridBagLayout());

        HeaderPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        HeaderPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        HeaderPanel.setLayout(new javax.swing.BoxLayout(HeaderPanel, javax.swing.BoxLayout.X_AXIS));
        HeaderPanel.add(filler1);

        TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TitleLabel.setText("View Gamemodes");
        HeaderPanel.add(TitleLabel);
        HeaderPanel.add(filler2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(HeaderPanel, gridBagConstraints);

        BodyPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        BodyPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        BodyPanel.setLayout(new javax.swing.BoxLayout(BodyPanel, javax.swing.BoxLayout.X_AXIS));
        BodyPanel.add(filler5);

        ContentPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        ContentPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        ContentPanel.setLayout(new java.awt.GridBagLayout());

        ExplorerHolderPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        ExplorerHolderPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        ExplorerHolderPanel.setLayout(new java.awt.GridBagLayout());

        ExplorerScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ExplorerScrollPane.setMinimumSize(new java.awt.Dimension(1, 1));
        ExplorerScrollPane.setPreferredSize(new java.awt.Dimension(1, 1));

        ExplorerList.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ExplorerList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ExplorerList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ExplorerListValueChanged(evt);
            }
        });
        ExplorerScrollPane.setViewportView(ExplorerList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 8.0;
        ExplorerHolderPanel.add(ExplorerScrollPane, gridBagConstraints);

        ExplorerMenu.setMinimumSize(new java.awt.Dimension(1, 1));
        ExplorerMenu.setPreferredSize(new java.awt.Dimension(1, 1));
        ExplorerMenu.setLayout(new javax.swing.BoxLayout(ExplorerMenu, javax.swing.BoxLayout.X_AXIS));
        ExplorerMenu.add(filler7);

        NewButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        NewButton.setText("New");
        NewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewButtonActionPerformed(evt);
            }
        });
        ExplorerMenu.add(NewButton);
        ExplorerMenu.add(filler8);

        ImportButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ImportButton.setText("Import");
        ImportButton.setToolTipText("");
        ImportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportButtonActionPerformed(evt);
            }
        });
        ExplorerMenu.add(ImportButton);
        ExplorerMenu.add(filler9);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        ExplorerHolderPanel.add(ExplorerMenu, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 1.0;
        ContentPanel.add(ExplorerHolderPanel, gridBagConstraints);

        ContentSpacerPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        ContentSpacerPanel.setPreferredSize(new java.awt.Dimension(1, 1));

        javax.swing.GroupLayout ContentSpacerPanelLayout = new javax.swing.GroupLayout(ContentSpacerPanel);
        ContentSpacerPanel.setLayout(ContentSpacerPanelLayout);
        ContentSpacerPanelLayout.setHorizontalGroup(
            ContentSpacerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );
        ContentSpacerPanelLayout.setVerticalGroup(
            ContentSpacerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        ContentPanel.add(ContentSpacerPanel, gridBagConstraints);

        PropertiesHolderPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        PropertiesHolderPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        PropertiesHolderPanel.setLayout(new java.awt.GridBagLayout());

        PropertiesScrollPane.setMinimumSize(new java.awt.Dimension(1, 1));
        PropertiesScrollPane.setPreferredSize(new java.awt.Dimension(1, 1));

        PropertiesPanel.setLayout(new java.awt.GridBagLayout());

        IDLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        IDLabel.setText("ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(16, 16, 2, 16);
        PropertiesPanel.add(IDLabel, gridBagConstraints);

        CurrentIDLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(16, 0, 0, 16);
        PropertiesPanel.add(CurrentIDLabel, gridBagConstraints);

        NameLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        NameLabel.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 16, 2, 16);
        PropertiesPanel.add(NameLabel, gridBagConstraints);

        CurrentNameLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 16);
        PropertiesPanel.add(CurrentNameLabel, gridBagConstraints);

        DartsPerRoundLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        DartsPerRoundLabel.setText("Darts Per Round:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 16, 2, 16);
        PropertiesPanel.add(DartsPerRoundLabel, gridBagConstraints);

        CurrentDartsPerRoundLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 16);
        PropertiesPanel.add(CurrentDartsPerRoundLabel, gridBagConstraints);

        MaximumRoundsLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        MaximumRoundsLabel.setText("Maximum Rounds:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 16, 2, 16);
        PropertiesPanel.add(MaximumRoundsLabel, gridBagConstraints);

        CurrentMaximumRoundsLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 16);
        PropertiesPanel.add(CurrentMaximumRoundsLabel, gridBagConstraints);

        StartingScoreLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        StartingScoreLabel.setText("Starting Score:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 16, 2, 16);
        PropertiesPanel.add(StartingScoreLabel, gridBagConstraints);

        CurrentStartingScoreLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 16);
        PropertiesPanel.add(CurrentStartingScoreLabel, gridBagConstraints);

        OffboardPenaltyLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        OffboardPenaltyLabel.setText("Offboard Penalty:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 16, 2, 16);
        PropertiesPanel.add(OffboardPenaltyLabel, gridBagConstraints);

        CurrentOffboardPenaltyLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 16);
        PropertiesPanel.add(CurrentOffboardPenaltyLabel, gridBagConstraints);

        ScoreListLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ScoreListLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreListLabel.setText("Score List");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 16, 2, 16);
        PropertiesPanel.add(ScoreListLabel, gridBagConstraints);

        ScoreListDartboardHolderPanel.setPreferredSize(new java.awt.Dimension(200, 200));
        ScoreListDartboardHolderPanel.setLayout(new javax.swing.BoxLayout(ScoreListDartboardHolderPanel, javax.swing.BoxLayout.X_AXIS));
        ScoreListDartboardHolderPanel.add(filler14);

        ScoreListDartboardPanel.setMaximumSize(new java.awt.Dimension(200, 200));
        ScoreListDartboardPanel.setMinimumSize(new java.awt.Dimension(200, 200));
        ScoreListDartboardPanel.setPreferredSize(new java.awt.Dimension(200, 200));
        ScoreListDartboardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ScoreLabelBullseye.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabelBullseye.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabelBullseye.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabelBullseye.setText("-");
        ScoreLabelBullseye.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabelBullseye, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 20, 20));

        ScoreLabel20.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel20.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel20.setText("-");
        ScoreLabel20.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 20, 20));

        ScoreLabel19.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel19.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel19.setText("-");
        ScoreLabel19.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 20, 20));

        ScoreLabel18.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel18.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel18.setText("-");
        ScoreLabel18.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 20, 20));

        ScoreLabel17.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel17.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel17.setText("-");
        ScoreLabel17.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 20, 20));

        ScoreLabel16.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel16.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel16.setText("-");
        ScoreLabel16.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 20, 20));

        ScoreLabel15.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel15.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel15.setText("-");
        ScoreLabel15.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 20, 20));

        ScoreLabel14.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel14.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel14.setText("-");
        ScoreLabel14.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 20, 20));

        ScoreLabel13.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel13.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel13.setText("-");
        ScoreLabel13.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 20, 20));

        ScoreLabel12.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel12.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel12.setText("-");
        ScoreLabel12.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 20, 20));

        ScoreLabel11.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel11.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel11.setText("-");
        ScoreLabel11.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 20, 20));

        ScoreLabel10.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel10.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel10.setText("-");
        ScoreLabel10.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 20, 20));

        ScoreLabel9.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel9.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel9.setText("-");
        ScoreLabel9.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 20, 20));

        ScoreLabel8.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel8.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel8.setText("-");
        ScoreLabel8.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 20, 20));

        ScoreLabel7.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel7.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel7.setText("-");
        ScoreLabel7.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 20, 20));

        ScoreLabel6.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel6.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel6.setText("-");
        ScoreLabel6.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 20, 20));

        ScoreLabel5.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel5.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel5.setText("-");
        ScoreLabel5.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 20, 20));

        ScoreLabel4.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel4.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel4.setText("-");
        ScoreLabel4.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 20, 20));

        ScoreLabel3.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel3.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel3.setText("-");
        ScoreLabel3.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 20, 20));

        ScoreLabel2.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel2.setText("-");
        ScoreLabel2.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 20, 20));

        ScoreLabel1.setBackground(new java.awt.Color(255, 255, 255));
        ScoreLabel1.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScoreLabel1.setText("-");
        ScoreLabel1.setOpaque(true);
        ScoreListDartboardPanel.add(ScoreLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 20, 20));

        ScoreListDartboardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dartboard_200x200.png"))); // NOI18N
        ScoreListDartboardPanel.add(ScoreListDartboardLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        ScoreListDartboardHolderPanel.add(ScoreListDartboardPanel);
        ScoreListDartboardHolderPanel.add(filler15);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(8, 16, 8, 16);
        PropertiesPanel.add(ScoreListDartboardHolderPanel, gridBagConstraints);

        MultipliersLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        MultipliersLabel.setText("Multipliers:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 16, 2, 16);
        PropertiesPanel.add(MultipliersLabel, gridBagConstraints);

        CurrentMultipliersLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 16);
        PropertiesPanel.add(CurrentMultipliersLabel, gridBagConstraints);

        ExactZeroWinLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ExactZeroWinLabel.setText("Exact Zero Win:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 16, 2, 16);
        PropertiesPanel.add(ExactZeroWinLabel, gridBagConstraints);

        CurrentExactZeroWinLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 16);
        PropertiesPanel.add(CurrentExactZeroWinLabel, gridBagConstraints);

        SubtractPointsLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        SubtractPointsLabel.setText("Subtract Points:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 16, 16, 16);
        PropertiesPanel.add(SubtractPointsLabel, gridBagConstraints);

        CurrentSubtractPointsLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 16, 16);
        PropertiesPanel.add(CurrentSubtractPointsLabel, gridBagConstraints);

        PropertiesScrollPane.setViewportView(PropertiesPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 8.0;
        PropertiesHolderPanel.add(PropertiesScrollPane, gridBagConstraints);

        PropertiesMenu.setMinimumSize(new java.awt.Dimension(1, 1));
        PropertiesMenu.setPreferredSize(new java.awt.Dimension(1, 1));
        PropertiesMenu.setLayout(new javax.swing.BoxLayout(PropertiesMenu, javax.swing.BoxLayout.X_AXIS));
        PropertiesMenu.add(filler10);

        EditButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        EditButton.setText("Edit");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });
        PropertiesMenu.add(EditButton);
        PropertiesMenu.add(filler11);

        ExportButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ExportButton.setText("Export");
        ExportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportButtonActionPerformed(evt);
            }
        });
        PropertiesMenu.add(ExportButton);
        PropertiesMenu.add(filler12);

        DeleteButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        PropertiesMenu.add(DeleteButton);
        PropertiesMenu.add(filler13);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        PropertiesHolderPanel.add(PropertiesMenu, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 4.0;
        gridBagConstraints.weighty = 1.0;
        ContentPanel.add(PropertiesHolderPanel, gridBagConstraints);

        BodyPanel.add(ContentPanel);
        BodyPanel.add(filler6);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 3.0;
        add(BodyPanel, gridBagConstraints);

        FooterPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        FooterPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        FooterPanel.setLayout(new javax.swing.BoxLayout(FooterPanel, javax.swing.BoxLayout.X_AXIS));
        FooterPanel.add(filler3);

        QuitToMainMenuButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        QuitToMainMenuButton.setText("Quit to Main Menu");
        QuitToMainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitToMainMenuButtonActionPerformed(evt);
            }
        });
        FooterPanel.add(QuitToMainMenuButton);
        FooterPanel.add(filler4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(FooterPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void QuitToMainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitToMainMenuButtonActionPerformed
        state.panels.get(PanelName.MainMenuPanel).updateComponents();
        state.contentPaneCardLayout.show(state.contentPane, PanelName.MainMenuPanel.toString());
    }//GEN-LAST:event_QuitToMainMenuButtonActionPerformed

    private void NewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewButtonActionPerformed
        state.panels.get(PanelName.CreateGamemodePanel).updateComponents();
        state.contentPaneCardLayout.show(state.contentPane, PanelName.CreateGamemodePanel.toString());
    }//GEN-LAST:event_NewButtonActionPerformed

    private void ExplorerListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ExplorerListValueChanged
        int index = ExplorerList.getSelectedIndex();
        if (index == -1) {
            clearContentPanel();
            disablePropertiesMenu();
            return;
        }

        enablePropertiesMenu();
        GameConfiguration gameConfiguration = state.gameConfigurations.get(index);
        displayGameConfiguration(gameConfiguration);
    }//GEN-LAST:event_ExplorerListValueChanged

    private void ImportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportButtonActionPerformed
        int result = ImportGameConfigurationChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = ImportGameConfigurationChooser.getSelectedFile();
            GameConfiguration gameConfiguration = null;

            try {
                gameConfiguration = IOUtils.loadGameConfiguration(file);
                state.gameConfigurations.add(gameConfiguration);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error loading game configuration: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            try {
                if (gameConfiguration != null) {
                    IOUtils.saveGameConfiguration(gameConfiguration);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving game configuration: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            updateComponents();
        }
    }//GEN-LAST:event_ImportButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this game configuration?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirmation != JOptionPane.YES_OPTION) {
            return;
        }

        int index = ExplorerList.getSelectedIndex();
        GameConfiguration gameConfiguration = state.gameConfigurations.get(index);
        state.gameConfigurations.remove(index);
        try {
            IOUtils.deleteGameConfiguration(gameConfiguration);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error deleting game configuration: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        updateComponents();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void ExportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportButtonActionPerformed
        int index = ExplorerList.getSelectedIndex();
        GameConfiguration gameConfiguration = state.gameConfigurations.get(index);

        int result = ExportFolderChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            Path path = ExportFolderChooser.getSelectedFile().toPath();
            File file = path.resolve(IOUtils.getGameConfigurationSaveFilename(gameConfiguration)).toFile();

            try {
                IOUtils.saveGameConfiguration(gameConfiguration, file);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error exporting game configuration: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ExportButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int index = ExplorerList.getSelectedIndex();
        state.toEditGameConfigurationIndex = index;

        state.panels.get(PanelName.EditGamemodePanel).updateComponents();
        state.contentPaneCardLayout.show(state.contentPane, PanelName.EditGamemodePanel.toString());
    }//GEN-LAST:event_EditButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel ContentSpacerPanel;
    private javax.swing.JLabel CurrentDartsPerRoundLabel;
    private javax.swing.JLabel CurrentExactZeroWinLabel;
    private javax.swing.JLabel CurrentIDLabel;
    private javax.swing.JLabel CurrentMaximumRoundsLabel;
    private javax.swing.JLabel CurrentMultipliersLabel;
    private javax.swing.JLabel CurrentNameLabel;
    private javax.swing.JLabel CurrentOffboardPenaltyLabel;
    private javax.swing.JLabel CurrentStartingScoreLabel;
    private javax.swing.JLabel CurrentSubtractPointsLabel;
    private javax.swing.JLabel DartsPerRoundLabel;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JLabel ExactZeroWinLabel;
    private javax.swing.JPanel ExplorerHolderPanel;
    private javax.swing.JList<String> ExplorerList;
    private javax.swing.JPanel ExplorerMenu;
    private javax.swing.JScrollPane ExplorerScrollPane;
    private javax.swing.JButton ExportButton;
    private javax.swing.JFileChooser ExportFolderChooser;
    private javax.swing.JPanel FooterPanel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JButton ImportButton;
    private javax.swing.JFileChooser ImportGameConfigurationChooser;
    private javax.swing.JLabel MaximumRoundsLabel;
    private javax.swing.JLabel MultipliersLabel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JButton NewButton;
    private javax.swing.JLabel OffboardPenaltyLabel;
    private javax.swing.JPanel PropertiesHolderPanel;
    private javax.swing.JPanel PropertiesMenu;
    private javax.swing.JPanel PropertiesPanel;
    private javax.swing.JScrollPane PropertiesScrollPane;
    private javax.swing.JButton QuitToMainMenuButton;
    private javax.swing.JLabel ScoreLabel1;
    private javax.swing.JLabel ScoreLabel10;
    private javax.swing.JLabel ScoreLabel11;
    private javax.swing.JLabel ScoreLabel12;
    private javax.swing.JLabel ScoreLabel13;
    private javax.swing.JLabel ScoreLabel14;
    private javax.swing.JLabel ScoreLabel15;
    private javax.swing.JLabel ScoreLabel16;
    private javax.swing.JLabel ScoreLabel17;
    private javax.swing.JLabel ScoreLabel18;
    private javax.swing.JLabel ScoreLabel19;
    private javax.swing.JLabel ScoreLabel2;
    private javax.swing.JLabel ScoreLabel20;
    private javax.swing.JLabel ScoreLabel3;
    private javax.swing.JLabel ScoreLabel4;
    private javax.swing.JLabel ScoreLabel5;
    private javax.swing.JLabel ScoreLabel6;
    private javax.swing.JLabel ScoreLabel7;
    private javax.swing.JLabel ScoreLabel8;
    private javax.swing.JLabel ScoreLabel9;
    private javax.swing.JLabel ScoreLabelBullseye;
    private javax.swing.JPanel ScoreListDartboardHolderPanel;
    private javax.swing.JLabel ScoreListDartboardLabel;
    private javax.swing.JPanel ScoreListDartboardPanel;
    private javax.swing.JLabel ScoreListLabel;
    private javax.swing.JLabel StartingScoreLabel;
    private javax.swing.JLabel SubtractPointsLabel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler15;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    // End of variables declaration//GEN-END:variables
}
