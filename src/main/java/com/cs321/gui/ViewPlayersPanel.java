/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.cs321.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.cs321.core.GameStats;
import com.cs321.core.Player;
import com.cs321.gui.GUIState.PanelName;
import com.cs321.io.IOUtils;

/**
 *
 * @author Hasna
 */
public class ViewPlayersPanel extends UpdateableJPanel {

    // The global GUI state
    private GUIState state;

    /**
     * Creates new form ViewPlayersPanel
     */
    public ViewPlayersPanel(GUIState state) {
        initComponents();

        this.state = state;
    }

    /**
     * Updates the components to reflect the current state
     */
    @Override
    public void updateComponents() {
        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        for (Player player : state.players) {
            defaultListModel.addElement(player.getName());
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
        CurrentGamesPlayedLabel.setText("----");
        CurrentWinsLabel.setText("----");
        CurrentLossesLabel.setText("----");
        CurrentWinRateLabel.setText("----");
        CurrentWinLossRatioLabel.setText("----");
    }

    /**
     * Displays the player in the content panel
     *
     * @param player
     */
    private void displayPlayer(Player player) {
        CurrentIDLabel.setText(player.getId());
        CurrentNameLabel.setText(player.getName());
        CurrentGamesPlayedLabel.setText(Integer.toString(player.getGamesPlayed()));
        CurrentWinsLabel.setText(Integer.toString(player.getWins()));
        CurrentLossesLabel.setText(Integer.toString(player.getLosses()));
        CurrentWinRateLabel.setText(String.format("%.2f", player.getWinRate()));
        CurrentWinLossRatioLabel.setText(String.format("%.2f", player.getWinLossRatio()));

        PropertiesPanel.setMinimumSize(new Dimension(232, 262 + 100 * player.getGameStats().length));
        PropertiesPanel.setPreferredSize(new Dimension(232, 262 + 100 * player.getGameStats().length));

        GameStatsPanel.removeAll();
        for (GameStats gameStats : player.getGameStats()) {
            GameStatsPanel.add(generateGameStatsPropertiesPanel(gameStats));
        }
        GameStatsPanel.setMinimumSize(new Dimension(200, 100 * player.getGameStats().length));
        GameStatsPanel.setPreferredSize(new Dimension(200, 100 * player.getGameStats().length));
    }

    /**
     * Generates a new game stats properties panel
     * 
     * @param gameStats The game stats to generate the panel for
     * @return The generated panel
     */
    private JPanel generateGameStatsPropertiesPanel(GameStats gameStats) {
        GridBagConstraints gridBagConstraints = null;

        JPanel gameStatsPropertiesPanel = new JPanel();
        gameStatsPropertiesPanel.setMinimumSize(new java.awt.Dimension(200, 100));
        gameStatsPropertiesPanel.setPreferredSize(new java.awt.Dimension(200, 100));
        gameStatsPropertiesPanel.setLayout(new java.awt.GridBagLayout());

        JLabel roundsPlayedLabel = new JLabel();
        roundsPlayedLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        roundsPlayedLabel.setText("Rounds Played:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 8);
        gameStatsPropertiesPanel.add(roundsPlayedLabel, gridBagConstraints);

        JLabel currentRoundsPlayedLabel = new JLabel();
        currentRoundsPlayedLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 4, 4);
        gameStatsPropertiesPanel.add(currentRoundsPlayedLabel, gridBagConstraints);

        JLabel playerWonLabel = new JLabel();
        playerWonLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        playerWonLabel.setText("Player Won:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 8);
        gameStatsPropertiesPanel.add(playerWonLabel, gridBagConstraints);

        JLabel currentPlayerWonLabel = new JLabel();
        currentPlayerWonLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 4, 4);
        gameStatsPropertiesPanel.add(currentPlayerWonLabel, gridBagConstraints);

        JLabel gamemodeIdLabel = new JLabel();
        gamemodeIdLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        gamemodeIdLabel.setText("Gamemode ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 8);
        gameStatsPropertiesPanel.add(gamemodeIdLabel, gridBagConstraints);

        JLabel currentGamemodeIdLabel = new JLabel();
        currentGamemodeIdLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 4, 4);
        gameStatsPropertiesPanel.add(currentGamemodeIdLabel, gridBagConstraints);

        currentRoundsPlayedLabel.setText(Integer.toString(gameStats.getRoundsPlayed()));
        currentPlayerWonLabel.setText(Boolean.toString(gameStats.isPlayerWon()));
        currentGamemodeIdLabel.setText(gameStats.getGamemodeId());

        return gameStatsPropertiesPanel;
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

        ImportPlayerChooser = new javax.swing.JFileChooser();
        ExportFolderChooser = new javax.swing.JFileChooser();
        GameStatsPropertiesPanel = new javax.swing.JPanel();
        RoundsPlayedLabel = new javax.swing.JLabel();
        CurrentRoundsPlayedLabel = new javax.swing.JLabel();
        PlayerWonLabel = new javax.swing.JLabel();
        CurrentPlayerWonLabel = new javax.swing.JLabel();
        GamemodeIdLabel = new javax.swing.JLabel();
        CurrentGamemodeIdLabel = new javax.swing.JLabel();
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
        GamesPlayedLabel = new javax.swing.JLabel();
        CurrentGamesPlayedLabel = new javax.swing.JLabel();
        WinsLabel = new javax.swing.JLabel();
        CurrentWinsLabel = new javax.swing.JLabel();
        LossesLabel = new javax.swing.JLabel();
        CurrentLossesLabel = new javax.swing.JLabel();
        WinRateLabel = new javax.swing.JLabel();
        CurrentWinRateLabel = new javax.swing.JLabel();
        WinLossRatioLabel = new javax.swing.JLabel();
        CurrentWinLossRatioLabel = new javax.swing.JLabel();
        GameStatsLabel = new javax.swing.JLabel();
        GameStatsPanel = new javax.swing.JPanel();
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

        ImportPlayerChooser.setDialogTitle("Choose a Player");

        ExportFolderChooser.setDialogTitle("Choose a Folder");
        ExportFolderChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        GameStatsPropertiesPanel.setMinimumSize(new java.awt.Dimension(200, 100));
        GameStatsPropertiesPanel.setPreferredSize(new java.awt.Dimension(200, 100));
        GameStatsPropertiesPanel.setLayout(new java.awt.GridBagLayout());

        RoundsPlayedLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        RoundsPlayedLabel.setText("Rounds Played:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 8);
        GameStatsPropertiesPanel.add(RoundsPlayedLabel, gridBagConstraints);

        CurrentRoundsPlayedLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 4, 4);
        GameStatsPropertiesPanel.add(CurrentRoundsPlayedLabel, gridBagConstraints);

        PlayerWonLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        PlayerWonLabel.setText("Player Won:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 8);
        GameStatsPropertiesPanel.add(PlayerWonLabel, gridBagConstraints);

        CurrentPlayerWonLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 4, 4);
        GameStatsPropertiesPanel.add(CurrentPlayerWonLabel, gridBagConstraints);

        GamemodeIdLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GamemodeIdLabel.setText("Gamemode ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 8);
        GameStatsPropertiesPanel.add(GamemodeIdLabel, gridBagConstraints);

        CurrentGamemodeIdLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 4, 4);
        GameStatsPropertiesPanel.add(CurrentGamemodeIdLabel, gridBagConstraints);

        setMinimumSize(new java.awt.Dimension(1, 1));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1, 1));
        setLayout(new java.awt.GridBagLayout());

        HeaderPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        HeaderPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        HeaderPanel.setLayout(new javax.swing.BoxLayout(HeaderPanel, javax.swing.BoxLayout.X_AXIS));
        HeaderPanel.add(filler1);

        TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TitleLabel.setText("View Players");
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

        PropertiesPanel.setPreferredSize(new java.awt.Dimension(232, 262));
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

        GamesPlayedLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GamesPlayedLabel.setText("Games Played:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 16, 2, 16);
        PropertiesPanel.add(GamesPlayedLabel, gridBagConstraints);

        CurrentGamesPlayedLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 16);
        PropertiesPanel.add(CurrentGamesPlayedLabel, gridBagConstraints);

        WinsLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        WinsLabel.setText("Wins:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 16, 2, 16);
        PropertiesPanel.add(WinsLabel, gridBagConstraints);

        CurrentWinsLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 16);
        PropertiesPanel.add(CurrentWinsLabel, gridBagConstraints);

        LossesLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LossesLabel.setText("Losses:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 16, 2, 16);
        PropertiesPanel.add(LossesLabel, gridBagConstraints);

        CurrentLossesLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 16);
        PropertiesPanel.add(CurrentLossesLabel, gridBagConstraints);

        WinRateLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        WinRateLabel.setText("Win Rate:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 16, 2, 16);
        PropertiesPanel.add(WinRateLabel, gridBagConstraints);

        CurrentWinRateLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 16);
        PropertiesPanel.add(CurrentWinRateLabel, gridBagConstraints);

        WinLossRatioLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        WinLossRatioLabel.setText("Win Loss Ratio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 16, 2, 16);
        PropertiesPanel.add(WinLossRatioLabel, gridBagConstraints);

        CurrentWinLossRatioLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 16);
        PropertiesPanel.add(CurrentWinLossRatioLabel, gridBagConstraints);

        GameStatsLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GameStatsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GameStatsLabel.setText("GameStats");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(16, 8, 4, 16);
        PropertiesPanel.add(GameStatsLabel, gridBagConstraints);

        GameStatsPanel.setMinimumSize(new java.awt.Dimension(200, 100));
        GameStatsPanel.setPreferredSize(new java.awt.Dimension(200, 100));
        GameStatsPanel.setLayout(new java.awt.GridLayout(0, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 16, 16, 16);
        PropertiesPanel.add(GameStatsPanel, gridBagConstraints);

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

    private void ExplorerListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ExplorerListValueChanged
        int index = ExplorerList.getSelectedIndex();
        if (index == -1) {
            clearContentPanel();
            disablePropertiesMenu();
            return;
        }

        enablePropertiesMenu();
        Player player = state.players.get(index);
        displayPlayer(player);
    }//GEN-LAST:event_ExplorerListValueChanged

    private void NewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewButtonActionPerformed
        String name = JOptionPane.showInputDialog("Enter a name for the new player");
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name can not be empty or whitespace", "Input Format Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Player player = new Player(name);
        try {
            IOUtils.savePlayer(player);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to save player", "Save Error", JOptionPane.ERROR_MESSAGE);
        }
        state.players.add(player);
        updateComponents();
    }//GEN-LAST:event_NewButtonActionPerformed

    private void ImportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportButtonActionPerformed
        int result = ImportPlayerChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = ImportPlayerChooser.getSelectedFile();
            Player player = null;

            try {
                player = IOUtils.loadPlayer(file);
                state.players.add(player);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error loading player: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            try {
                if (player != null) {
                    IOUtils.savePlayer(player);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving player: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            updateComponents();
        }
    }//GEN-LAST:event_ImportButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int index = ExplorerList.getSelectedIndex();
        Player player = state.players.get(index);

        String name = JOptionPane.showInputDialog("Enter a new name for the player", player.getName());
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name can not be empty or whitespace", "Input Format Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            IOUtils.deletePlayer(player);
        }   catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to delete player", "Delete Error", JOptionPane.ERROR_MESSAGE);
        }
        player.setName(name);
        try {
            IOUtils.savePlayer(player);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to save player", "Save Error", JOptionPane.ERROR_MESSAGE);
        }
        updateComponents();
    }//GEN-LAST:event_EditButtonActionPerformed

    private void ExportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportButtonActionPerformed
        int index = ExplorerList.getSelectedIndex();
        Player player = state.players.get(index);

        int result = ExportFolderChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            Path path = ExportFolderChooser.getSelectedFile().toPath();
            File file = path.resolve(IOUtils.getPlayerSaveFilename(player)).toFile();

            try {
                IOUtils.savePlayer(player, file);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error exporting player: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ExportButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this player?", "Delete Player", JOptionPane.YES_NO_OPTION);
        if (confirmation != JOptionPane.YES_OPTION) {
            return;
        }

        int index = ExplorerList.getSelectedIndex();
        Player player = state.players.get(index);
        state.players.remove(index);
        try {
            IOUtils.deletePlayer(player);
        }   catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to delete player", "Delete Error", JOptionPane.ERROR_MESSAGE);
        }

        updateComponents();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void QuitToMainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitToMainMenuButtonActionPerformed
        state.panels.get(PanelName.MainMenuPanel).updateComponents();
        state.contentPaneCardLayout.show(state.contentPane, PanelName.MainMenuPanel.toString());
    }//GEN-LAST:event_QuitToMainMenuButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel ContentSpacerPanel;
    private javax.swing.JLabel CurrentGamemodeIdLabel;
    private javax.swing.JLabel CurrentGamesPlayedLabel;
    private javax.swing.JLabel CurrentIDLabel;
    private javax.swing.JLabel CurrentLossesLabel;
    private javax.swing.JLabel CurrentNameLabel;
    private javax.swing.JLabel CurrentPlayerWonLabel;
    private javax.swing.JLabel CurrentRoundsPlayedLabel;
    private javax.swing.JLabel CurrentWinLossRatioLabel;
    private javax.swing.JLabel CurrentWinRateLabel;
    private javax.swing.JLabel CurrentWinsLabel;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JPanel ExplorerHolderPanel;
    private javax.swing.JList<String> ExplorerList;
    private javax.swing.JPanel ExplorerMenu;
    private javax.swing.JScrollPane ExplorerScrollPane;
    private javax.swing.JButton ExportButton;
    private javax.swing.JFileChooser ExportFolderChooser;
    private javax.swing.JPanel FooterPanel;
    private javax.swing.JLabel GameStatsLabel;
    private javax.swing.JPanel GameStatsPanel;
    private javax.swing.JPanel GameStatsPropertiesPanel;
    private javax.swing.JLabel GamemodeIdLabel;
    private javax.swing.JLabel GamesPlayedLabel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JButton ImportButton;
    private javax.swing.JFileChooser ImportPlayerChooser;
    private javax.swing.JLabel LossesLabel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JButton NewButton;
    private javax.swing.JLabel PlayerWonLabel;
    private javax.swing.JPanel PropertiesHolderPanel;
    private javax.swing.JPanel PropertiesMenu;
    private javax.swing.JPanel PropertiesPanel;
    private javax.swing.JScrollPane PropertiesScrollPane;
    private javax.swing.JButton QuitToMainMenuButton;
    private javax.swing.JLabel RoundsPlayedLabel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel WinLossRatioLabel;
    private javax.swing.JLabel WinRateLabel;
    private javax.swing.JLabel WinsLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler13;
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
