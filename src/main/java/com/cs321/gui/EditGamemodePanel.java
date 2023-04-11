/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.cs321.gui;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.cs321.core.GameConfiguration;
import com.cs321.core.GameConfiguration.GameConfigurationBuilder;
import com.cs321.gui.GUIState.PanelName;
import com.cs321.io.IOUtils;

/**
 *
 * @author Hasna
 */
public class EditGamemodePanel extends UpdateableJPanel {

    private GUIState state;

    /**
     * Creates new form EditGamemodePanel
     */
    public EditGamemodePanel(GUIState state) {
        initComponents();

        this.state = state;
    }

    /**
     * Updates the components to reflect the current state
     */
    @Override
    public void updateComponents() {
        fillForm();
    }

    /**
     * Fills the form with the current game configuration
     */
    private void fillForm() {
        GameConfiguration gameConfiguration = state.gameConfigurations.get(state.toEditGameConfigurationIndex);

        NameTextField.setText(gameConfiguration.getName());
        DartsPerRoundTextField.setText(Integer.toString(gameConfiguration.getDartsPerRound()));
        MaximumRoundsTextField.setText(Integer.toString(gameConfiguration.getMaximumRounds()));
        StartingScoreTextField.setText(Integer.toString(gameConfiguration.getStartingScore()));
        OffboardPenaltyTextField.setText(Integer.toString(gameConfiguration.getOffboardPenalty()));

        StringBuilder scoreListBuilder = new StringBuilder();
        for (int score : gameConfiguration.getScoreList()) {
            scoreListBuilder.append(score);
            scoreListBuilder.append(",");
        }
        if (scoreListBuilder.length() > 0) {
            scoreListBuilder.delete(scoreListBuilder.length() - 1, scoreListBuilder.length());
        }
        ScoreListTextField.setText(scoreListBuilder.toString());

        StringBuilder multipliersBuilder = new StringBuilder();
        for (float multiplier : gameConfiguration.getMultipliers()) {
            multipliersBuilder.append(multiplier);
            multipliersBuilder.append(",");
        }
        if (multipliersBuilder.length() > 0) {
            multipliersBuilder.delete(multipliersBuilder.length() - 1, multipliersBuilder.length());
        }
        MultipliersTextField.setText(multipliersBuilder.toString());

        ExactZeroWinCheckBox.setSelected(gameConfiguration.isExactZeroWin());
        SubtractPointsCheckBox.setSelected(gameConfiguration.isSubtractPoints());
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

        HeaderPanel = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        TitleLabel = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        BodyPanel = new javax.swing.JPanel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        ContentPanel = new javax.swing.JPanel();
        FormPanel = new javax.swing.JPanel();
        FormLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        NameTextField = new javax.swing.JTextField();
        DartsPerRoundLabel = new javax.swing.JLabel();
        DartsPerRoundTextField = new javax.swing.JTextField();
        MaximumRoundsLabel = new javax.swing.JLabel();
        MaximumRoundsTextField = new javax.swing.JTextField();
        StartingScoreLabel = new javax.swing.JLabel();
        StartingScoreTextField = new javax.swing.JTextField();
        OffboardPenaltyLabel = new javax.swing.JLabel();
        OffboardPenaltyTextField = new javax.swing.JTextField();
        ScoreListLabel = new javax.swing.JLabel();
        ScoreListTextField = new javax.swing.JTextField();
        ScoreListHelpLabel = new javax.swing.JLabel();
        MultipliersTextLabel = new javax.swing.JLabel();
        MultipliersTextField = new javax.swing.JTextField();
        MultipliersHelpLabel = new javax.swing.JLabel();
        ExactZeroWinCheckBox = new javax.swing.JCheckBox();
        SubtractPointsCheckBox = new javax.swing.JCheckBox();
        MenuPanel = new javax.swing.JPanel();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        RestoreButton = new javax.swing.JButton();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        SaveButton = new javax.swing.JButton();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        FooterPanel = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        BackButton = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        setMinimumSize(new java.awt.Dimension(1, 1));
        setPreferredSize(new java.awt.Dimension(1, 1));
        setLayout(new java.awt.GridBagLayout());

        HeaderPanel.setMaximumSize(new java.awt.Dimension(65744, 65744));
        HeaderPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        HeaderPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        HeaderPanel.setLayout(new javax.swing.BoxLayout(HeaderPanel, javax.swing.BoxLayout.X_AXIS));
        HeaderPanel.add(filler1);

        TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TitleLabel.setText("Edit Gamemode");
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

        FormPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        FormPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        FormPanel.setLayout(new java.awt.GridBagLayout());

        FormLabel.setText("Leave blanks empty for default values");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        FormPanel.add(FormLabel, gridBagConstraints);

        NameLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        NameLabel.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        FormPanel.add(NameLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        FormPanel.add(NameTextField, gridBagConstraints);

        DartsPerRoundLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        DartsPerRoundLabel.setText("Darts Per Round:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        FormPanel.add(DartsPerRoundLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 64;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 12);
        FormPanel.add(DartsPerRoundTextField, gridBagConstraints);

        MaximumRoundsLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        MaximumRoundsLabel.setText("Maximum Rounds:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 12, 4, 4);
        FormPanel.add(MaximumRoundsLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        FormPanel.add(MaximumRoundsTextField, gridBagConstraints);

        StartingScoreLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        StartingScoreLabel.setText("Starting Score:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        FormPanel.add(StartingScoreLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 64;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 12);
        FormPanel.add(StartingScoreTextField, gridBagConstraints);

        OffboardPenaltyLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        OffboardPenaltyLabel.setText("Offboard Penalty:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 12, 4, 4);
        FormPanel.add(OffboardPenaltyLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        FormPanel.add(OffboardPenaltyTextField, gridBagConstraints);

        ScoreListLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ScoreListLabel.setText("Score List:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        FormPanel.add(ScoreListLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        FormPanel.add(ScoreListTextField, gridBagConstraints);

        ScoreListHelpLabel.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        ScoreListHelpLabel.setText("21 comma separated integer values for scores going clockwise from 12 o' clock and with bullseye at the end");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        FormPanel.add(ScoreListHelpLabel, gridBagConstraints);

        MultipliersTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        MultipliersTextLabel.setText("Multipliers:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        FormPanel.add(MultipliersTextLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 64;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        FormPanel.add(MultipliersTextField, gridBagConstraints);

        MultipliersHelpLabel.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        MultipliersHelpLabel.setText("3 comma separated numbers for bigger to smaller rings");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        FormPanel.add(MultipliersHelpLabel, gridBagConstraints);

        ExactZeroWinCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ExactZeroWinCheckBox.setText("Exact Zero Win");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        FormPanel.add(ExactZeroWinCheckBox, gridBagConstraints);

        SubtractPointsCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        SubtractPointsCheckBox.setText("Subtract Points");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        FormPanel.add(SubtractPointsCheckBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 8.0;
        ContentPanel.add(FormPanel, gridBagConstraints);

        MenuPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        MenuPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        MenuPanel.setLayout(new javax.swing.BoxLayout(MenuPanel, javax.swing.BoxLayout.LINE_AXIS));
        MenuPanel.add(filler7);

        RestoreButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        RestoreButton.setText("Restore");
        RestoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestoreButtonActionPerformed(evt);
            }
        });
        MenuPanel.add(RestoreButton);
        MenuPanel.add(filler8);

        SaveButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        MenuPanel.add(SaveButton);
        MenuPanel.add(filler9);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        ContentPanel.add(MenuPanel, gridBagConstraints);

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

        BackButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        FooterPanel.add(BackButton);
        FooterPanel.add(filler4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(FooterPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        String nameText = NameTextField.getText().trim();
        String dartsPerRoundText = DartsPerRoundTextField.getText().trim();
        String maximumRoundsText = MaximumRoundsTextField.getText().trim();
        String startingScoreText = StartingScoreTextField.getText().trim();
        String offboardPenaltyText = OffboardPenaltyTextField.getText().trim();
        String scoreListText = ScoreListTextField.getText().trim();
        String multipliersText = MultipliersTextField.getText().trim();
        boolean exactZeroWin = ExactZeroWinCheckBox.isSelected();
        boolean subtractPoints = SubtractPointsCheckBox.isSelected();

        GameConfigurationBuilder gameConfigurationBuilder = new GameConfigurationBuilder();
        
        // Parse name
        if (nameText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name can not be empty or whitespace", "Input Format Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        gameConfigurationBuilder.withName(nameText);
        
        // Parse darts per round
        if (!dartsPerRoundText.isEmpty()) {
            int dartsPerRound;

            try {
                dartsPerRound = Integer.parseInt(dartsPerRoundText);
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Darts per round must be an integer", "Input Format Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            gameConfigurationBuilder.withDartsPerRound(dartsPerRound);
        }

        // Parse maximum rounds
        if (!maximumRoundsText.isEmpty()) {
            int maximumRounds;

            try {
                maximumRounds = Integer.parseInt(maximumRoundsText);
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Maximum rounds must be an integer", "Input Format Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            gameConfigurationBuilder.withMaximumRounds(maximumRounds);
        }

        // Parse starting score
        if (!startingScoreText.isEmpty()) {
            int startingScore;

            try {
                startingScore = Integer.parseInt(startingScoreText);
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Starting score must be an integer", "Input Format Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            gameConfigurationBuilder.withStartingScore(startingScore);
        }

        // Parse offboard penalty
        if (!offboardPenaltyText.isEmpty()) {
            int offboardPenalty;

            try {
                offboardPenalty = Integer.parseInt(offboardPenaltyText);
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Offboard penalty must be an integer", "Input Format Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            gameConfigurationBuilder.withOffboardPenalty(offboardPenalty);
        }

        // Parse score list
        if (!scoreListText.isEmpty()) {
            String[] scoreListSplit = scoreListText.split(",");

            if (scoreListSplit.length != 21) {
                JOptionPane.showMessageDialog(null, "Score list must contain 21 integers", "Input Format Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int[] scoreList = new int[21];

            for (int i = 0; i < 21; i++) {
                try {
                    scoreList[i] = Integer.parseInt(scoreListSplit[i].trim());
                } catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Score list must contain 21 integers", "Input Format Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            gameConfigurationBuilder.withScoreList(scoreList);
        }

        // Parse multipliers
        if (!multipliersText.isEmpty()) {
            String[] multipliersSplit = multipliersText.split(",");

            if (multipliersSplit.length != 3) {
                JOptionPane.showMessageDialog(null, "Multipliers must contain 3 numbers", "Input Format Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            float[] multipliers = new float[3];

            for (int i = 0; i < 3; i++) {
                try {
                    multipliers[i] = Float.parseFloat(multipliersSplit[i].trim());
                } catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Multipliers must contain 3 numbers", "Input Format Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }

        gameConfigurationBuilder.withExactZeroWin(exactZeroWin);
        gameConfigurationBuilder.withSubtractPoints(subtractPoints);
        int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to overwrite this gamemode?", "Save Gamemode", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirmation == JOptionPane.YES_OPTION) {
            GameConfiguration oldGameConfiguration = state.gameConfigurations.get(state.toEditGameConfigurationIndex);
            GameConfiguration newGameConfiguration = gameConfigurationBuilder.build();
            newGameConfiguration.setId(oldGameConfiguration.getId());
            
            try {
                IOUtils.deleteGameConfiguration(oldGameConfiguration);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Could not delete old gamemode file", "Save Gamemode Error", JOptionPane.ERROR_MESSAGE);
            }

            try {
                IOUtils.saveGameConfiguration(newGameConfiguration);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Could not save gamemode file", "Save Gamemode Error", JOptionPane.ERROR_MESSAGE);
            }

            state.gameConfigurations.remove(state.toEditGameConfigurationIndex);
            state.gameConfigurations.add(state.toEditGameConfigurationIndex, newGameConfiguration);

            state.panels.get(PanelName.ViewGamemodesPanel).updateComponents();
            state.contentPaneCardLayout.show(state.contentPane, PanelName.ViewGamemodesPanel.toString());
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        state.panels.get(PanelName.ViewGamemodesPanel).updateComponents();
        state.contentPaneCardLayout.show(state.contentPane, PanelName.ViewGamemodesPanel.toString());
    }//GEN-LAST:event_BackButtonActionPerformed

    private void RestoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestoreButtonActionPerformed
        fillForm();
    }//GEN-LAST:event_RestoreButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JLabel DartsPerRoundLabel;
    private javax.swing.JTextField DartsPerRoundTextField;
    private javax.swing.JCheckBox ExactZeroWinCheckBox;
    private javax.swing.JPanel FooterPanel;
    private javax.swing.JLabel FormLabel;
    private javax.swing.JPanel FormPanel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JLabel MaximumRoundsLabel;
    private javax.swing.JTextField MaximumRoundsTextField;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JLabel MultipliersHelpLabel;
    private javax.swing.JTextField MultipliersTextField;
    private javax.swing.JLabel MultipliersTextLabel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JLabel OffboardPenaltyLabel;
    private javax.swing.JTextField OffboardPenaltyTextField;
    private javax.swing.JButton RestoreButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JLabel ScoreListHelpLabel;
    private javax.swing.JLabel ScoreListLabel;
    private javax.swing.JTextField ScoreListTextField;
    private javax.swing.JLabel StartingScoreLabel;
    private javax.swing.JTextField StartingScoreTextField;
    private javax.swing.JCheckBox SubtractPointsCheckBox;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.Box.Filler filler1;
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
