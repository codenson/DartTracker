/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.cs321.gui;

import javax.swing.JOptionPane;

import com.cs321.core.DartboardUtils;
import com.cs321.gui.GUIState.Gametype;
import com.cs321.gui.GUIState.PanelName;

/**
 *
 * @author Hasna
 */
public class PlayPanel extends UpdateableJPanel {

    // The global GUI state
    private GUIState state;

    // The current score on the dartboard
    private int score = -1;

    /**
     * Creates new form PlayPanel
     */
    public PlayPanel(GUIState state) {
        initComponents();

        this.state = state;
    }

    /**
     * Updates the components to reflect the current state
     */
    @Override
    public void updateComponents() {
        state.gameManager.beginRound();
        updateGUIElements();
    }

    /**
     * Update the GUI elements to reflect the current state
     */
    private void updateGUIElements() {
        if (state.chosenGametype == Gametype.FreeForAll) {
            updateFreeForAllGUIElements();
        } else if (state.chosenGametype == Gametype.Teams) {
            updateTeamsGUIElements();
        }

        // Round
        if (state.gameManager.isGameFinished()) {
            CurrentRoundLabel.setText("----");
        } else {
            if (state.gameManager.getGameConfiguration().getMaximumRounds() == -1) {
                CurrentRoundLabel.setText(Integer.toString(state.gameManager.getRoundsManager().getTotalRounds()));
            } else {
                int totalRounds = state.gameManager.getGameConfiguration().getMaximumRounds();
                int currentRounds = state.gameManager.getRoundsManager().getTotalRounds();
                CurrentRoundLabel.setText(Integer.toString(currentRounds) + "/" + Integer.toString(totalRounds));
            }
        }

        // Throw
        int totalThrows = state.gameManager.getGameConfiguration().getDartsPerRound();
        if (state.gameManager.isGameFinished()) {
            CurrentThrowLabel.setText("----/" + Integer.toString(totalThrows));
        } else {
            int currentThrows = state.gameManager.getCurrentRound().getTotalThrows();
            CurrentThrowLabel.setText(Integer.toString(currentThrows) + "/" + Integer.toString(totalThrows));
        }

        // Required Score
        if (state.gameManager.isGameFinished()) {
            CurrentRequiredScoreLabel.setText("----");
        } else {
            int totalRequiredScore = state.gameManager.getGameConfiguration().getStartingScore();
            int currentScore = state.gameManager.getRoundsManager().getTeamTotalScore(state.gameManager.getCurrentTeam());

            if (state.gameManager.getGameConfiguration().isSubtractPoints()) {
                int currentRequiredScore = totalRequiredScore - currentScore;
                CurrentRequiredScoreLabel.setText(Integer.toString(currentRequiredScore));
            } else {
                CurrentRequiredScoreLabel.setText(Integer.toString(currentScore) + "/" + Integer.toString(totalRequiredScore));
            }
        }

        // Round Score
        if (state.gameManager.isGameFinished()) {
            CurrentRoundScoreLabel.setText("----");
        } else {
            CurrentRoundScoreLabel.setText(Integer.toString(state.gameManager.getCurrentRound().getTotalScore()));
        }

        // Playing Player
        if (state.gameManager.isGameFinished()) {
            CurrentPlayerNameLabel.setText("----");
        } else {
            CurrentPlayerNameLabel.setText(state.gameManager.getCurrentPlayer().getName());
        }

        // Throw Score
        if (score == -1) {
            CurrentThrowScoreLabel.setText("?");
        } else {
            CurrentThrowScoreLabel.setText(Integer.toString(score));
        }

        // Buttons
        ConfirmThrowButton.setEnabled(!state.gameManager.isGameFinished() && !state.gameManager.isThrowsDone());
        FinishRoundButton.setEnabled(!state.gameManager.isGameFinished());
        FinishGameButton.setEnabled(state.gameManager.isGameFinished());
    }

    /**
     * Updates the GUI elements to reflect the current state for Free For All
     */
    private void updateFreeForAllGUIElements() {
        // Total Competitors
        TotalCompetitorsLabel.setText("Total Players:");
        CurrentTotalCompetitorsLabel.setText(Integer.toString(state.gameManager.getTeamsManager().getTeams().length));

        // Next Team
        NextTeamLabel.setVisible(false);
        CurrentNextTeamLabel.setVisible(false);

        // Next Player
        if (state.gameManager.isGameFinished()) {
            CurrentNextPlayerLabel.setText("----");
        } else {
            CurrentNextPlayerLabel.setText(state.gameManager.getNextPlayer().getName());
        }

        // Playing Team
        PlayingTeamLabel.setVisible(false);
        CurrentPlayingTeamLabel.setVisible(false);
    }

    /**
     * Updates the GUI elements to reflect the current state for Teams
     */
    private void updateTeamsGUIElements() {
        // Total Competitors
        TotalCompetitorsLabel.setText("Total Teams:");
        CurrentTotalCompetitorsLabel.setText(Integer.toString(state.gameManager.getTeamsManager().getTeams().length));

        // Next Team
        NextTeamLabel.setVisible(true);
        CurrentNextTeamLabel.setVisible(true);
        if (state.gameManager.isGameFinished()) {
            CurrentNextTeamLabel.setText("----");
        } else {
            CurrentNextTeamLabel.setText(state.gameManager.getNextTeam().getName());
        }

        // Next Player
        if (state.gameManager.isGameFinished()) {
            CurrentNextPlayerLabel.setText("----");
        } else {
            CurrentNextPlayerLabel.setText(state.gameManager.getNextPlayer().getName());
        }

        // Playing Team
        PlayingTeamLabel.setVisible(true);
        CurrentPlayingTeamLabel.setVisible(true);
        if (state.gameManager.isGameFinished()) {
            CurrentPlayingTeamLabel.setText("----");
        } else {
            CurrentPlayingTeamLabel.setText(state.gameManager.getCurrentTeam().getName());
        }
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
        HeaderTopPanel = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        TitleLabel = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        HeaderBottomPanel = new javax.swing.JPanel();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        TotalCompetitorsLabel = new javax.swing.JLabel();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        CurrentTotalCompetitorsLabel = new javax.swing.JLabel();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        NextTeamLabel = new javax.swing.JLabel();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        CurrentNextTeamLabel = new javax.swing.JLabel();
        filler29 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        NextPlayerLabel = new javax.swing.JLabel();
        filler30 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        CurrentNextPlayerLabel = new javax.swing.JLabel();
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        DividerPanel = new javax.swing.JPanel();
        BodyPanel = new javax.swing.JPanel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        ContentPanel = new javax.swing.JPanel();
        GameInformationPanel = new javax.swing.JPanel();
        GameInformationHeaderPanel = new javax.swing.JPanel();
        filler23 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        RoundLabel = new javax.swing.JLabel();
        filler24 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        CurrentRoundLabel = new javax.swing.JLabel();
        filler25 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        ThrowLabel = new javax.swing.JLabel();
        filler26 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        CurrentThrowLabel = new javax.swing.JLabel();
        filler27 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        GameInformationBodyPanel = new javax.swing.JPanel();
        RequiredScoreLabel = new javax.swing.JLabel();
        CurrentRequiredScoreLabel = new javax.swing.JLabel();
        RoundScoreLabel = new javax.swing.JLabel();
        CurrentRoundScoreLabel = new javax.swing.JLabel();
        PlayingTeamLabel = new javax.swing.JLabel();
        CurrentPlayingTeamLabel = new javax.swing.JLabel();
        PlayerNameLabel = new javax.swing.JLabel();
        CurrentPlayerNameLabel = new javax.swing.JLabel();
        GameInformationSpacerPanel = new javax.swing.JPanel();
        ContentSpacerPanel = new javax.swing.JPanel();
        GamePlayPanel = new javax.swing.JPanel();
        GamePlayInformationPanel = new javax.swing.JPanel();
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        ThrowScoreLabel = new javax.swing.JLabel();
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        CurrentThrowScoreLabel = new javax.swing.JLabel();
        filler15 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        GamePlayBoardPanel = new javax.swing.JPanel();
        filler16 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        DartBoardPanel = new javax.swing.JPanel();
        filler18 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        DartBoardLabel = new javax.swing.JLabel();
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler17 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        GamePlayMenuPanel = new javax.swing.JPanel();
        filler20 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        ConfirmThrowButton = new javax.swing.JButton();
        filler21 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        FinishRoundButton = new javax.swing.JButton();
        filler22 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        FooterPanel = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        QuitToMainMenuButton = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        FinishGameButton = new javax.swing.JButton();
        filler28 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));

        setMinimumSize(new java.awt.Dimension(1, 1));
        setPreferredSize(new java.awt.Dimension(1, 1));
        setLayout(new java.awt.GridBagLayout());

        HeaderPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        HeaderPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        HeaderPanel.setLayout(new java.awt.GridBagLayout());

        HeaderTopPanel.setLayout(new javax.swing.BoxLayout(HeaderTopPanel, javax.swing.BoxLayout.X_AXIS));
        HeaderTopPanel.add(filler1);

        TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TitleLabel.setText("DartDash");
        HeaderTopPanel.add(TitleLabel);
        HeaderTopPanel.add(filler2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        HeaderPanel.add(HeaderTopPanel, gridBagConstraints);

        HeaderBottomPanel.setLayout(new javax.swing.BoxLayout(HeaderBottomPanel, javax.swing.BoxLayout.X_AXIS));
        HeaderBottomPanel.add(filler8);

        TotalCompetitorsLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TotalCompetitorsLabel.setText("Total Teams:");
        HeaderBottomPanel.add(TotalCompetitorsLabel);
        HeaderBottomPanel.add(filler9);

        CurrentTotalCompetitorsLabel.setText("----");
        HeaderBottomPanel.add(CurrentTotalCompetitorsLabel);
        HeaderBottomPanel.add(filler10);

        NextTeamLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NextTeamLabel.setText("Next Team:");
        HeaderBottomPanel.add(NextTeamLabel);
        HeaderBottomPanel.add(filler11);

        CurrentNextTeamLabel.setText("----");
        HeaderBottomPanel.add(CurrentNextTeamLabel);
        HeaderBottomPanel.add(filler29);

        NextPlayerLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NextPlayerLabel.setText("Next Player:");
        HeaderBottomPanel.add(NextPlayerLabel);
        HeaderBottomPanel.add(filler30);

        CurrentNextPlayerLabel.setText("----");
        HeaderBottomPanel.add(CurrentNextPlayerLabel);
        HeaderBottomPanel.add(filler12);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        HeaderPanel.add(HeaderBottomPanel, gridBagConstraints);

        DividerPanel.setBackground(new java.awt.Color(0, 0, 0));
        DividerPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        DividerPanel.setPreferredSize(new java.awt.Dimension(1, 1));

        javax.swing.GroupLayout DividerPanelLayout = new javax.swing.GroupLayout(DividerPanel);
        DividerPanel.setLayout(DividerPanelLayout);
        DividerPanelLayout.setHorizontalGroup(
            DividerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );
        DividerPanelLayout.setVerticalGroup(
            DividerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        HeaderPanel.add(DividerPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        add(HeaderPanel, gridBagConstraints);

        BodyPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        BodyPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        BodyPanel.setLayout(new javax.swing.BoxLayout(BodyPanel, javax.swing.BoxLayout.X_AXIS));
        BodyPanel.add(filler5);

        ContentPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        ContentPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        ContentPanel.setLayout(new java.awt.GridBagLayout());

        GameInformationPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        GameInformationPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        GameInformationPanel.setLayout(new java.awt.GridBagLayout());

        GameInformationHeaderPanel.setLayout(new javax.swing.BoxLayout(GameInformationHeaderPanel, javax.swing.BoxLayout.X_AXIS));
        GameInformationHeaderPanel.add(filler23);

        RoundLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RoundLabel.setText("Round:");
        GameInformationHeaderPanel.add(RoundLabel);
        GameInformationHeaderPanel.add(filler24);

        CurrentRoundLabel.setText("----");
        GameInformationHeaderPanel.add(CurrentRoundLabel);
        GameInformationHeaderPanel.add(filler25);

        ThrowLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ThrowLabel.setText("Throw:");
        GameInformationHeaderPanel.add(ThrowLabel);
        GameInformationHeaderPanel.add(filler26);

        CurrentThrowLabel.setText("----");
        GameInformationHeaderPanel.add(CurrentThrowLabel);
        GameInformationHeaderPanel.add(filler27);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        GameInformationPanel.add(GameInformationHeaderPanel, gridBagConstraints);

        GameInformationBodyPanel.setLayout(new java.awt.GridBagLayout());

        RequiredScoreLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RequiredScoreLabel.setText("Required Score:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(16, 8, 8, 8);
        GameInformationBodyPanel.add(RequiredScoreLabel, gridBagConstraints);

        CurrentRequiredScoreLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(16, 8, 8, 8);
        GameInformationBodyPanel.add(CurrentRequiredScoreLabel, gridBagConstraints);

        RoundScoreLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RoundScoreLabel.setText("Round Score:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        GameInformationBodyPanel.add(RoundScoreLabel, gridBagConstraints);

        CurrentRoundScoreLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        GameInformationBodyPanel.add(CurrentRoundScoreLabel, gridBagConstraints);

        PlayingTeamLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PlayingTeamLabel.setText("Playing Team:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        GameInformationBodyPanel.add(PlayingTeamLabel, gridBagConstraints);

        CurrentPlayingTeamLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        GameInformationBodyPanel.add(CurrentPlayingTeamLabel, gridBagConstraints);

        PlayerNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PlayerNameLabel.setText("Player's Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        GameInformationBodyPanel.add(PlayerNameLabel, gridBagConstraints);

        CurrentPlayerNameLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        GameInformationBodyPanel.add(CurrentPlayerNameLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 5.0;
        GameInformationPanel.add(GameInformationBodyPanel, gridBagConstraints);

        javax.swing.GroupLayout GameInformationSpacerPanelLayout = new javax.swing.GroupLayout(GameInformationSpacerPanel);
        GameInformationSpacerPanel.setLayout(GameInformationSpacerPanelLayout);
        GameInformationSpacerPanelLayout.setHorizontalGroup(
            GameInformationSpacerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        GameInformationSpacerPanelLayout.setVerticalGroup(
            GameInformationSpacerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 4.0;
        GameInformationPanel.add(GameInformationSpacerPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 4.0;
        gridBagConstraints.weighty = 1.0;
        ContentPanel.add(GameInformationPanel, gridBagConstraints);

        ContentSpacerPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        ContentSpacerPanel.setPreferredSize(new java.awt.Dimension(1, 1));

        javax.swing.GroupLayout ContentSpacerPanelLayout = new javax.swing.GroupLayout(ContentSpacerPanel);
        ContentSpacerPanel.setLayout(ContentSpacerPanelLayout);
        ContentSpacerPanelLayout.setHorizontalGroup(
            ContentSpacerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );
        ContentSpacerPanelLayout.setVerticalGroup(
            ContentSpacerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        ContentPanel.add(ContentSpacerPanel, gridBagConstraints);

        GamePlayPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        GamePlayPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        GamePlayPanel.setLayout(new java.awt.GridBagLayout());

        GamePlayInformationPanel.setLayout(new javax.swing.BoxLayout(GamePlayInformationPanel, javax.swing.BoxLayout.X_AXIS));
        GamePlayInformationPanel.add(filler13);

        ThrowScoreLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ThrowScoreLabel.setText("Throw Score:");
        GamePlayInformationPanel.add(ThrowScoreLabel);
        GamePlayInformationPanel.add(filler14);

        CurrentThrowScoreLabel.setText("----");
        GamePlayInformationPanel.add(CurrentThrowScoreLabel);
        GamePlayInformationPanel.add(filler15);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        GamePlayPanel.add(GamePlayInformationPanel, gridBagConstraints);

        GamePlayBoardPanel.setLayout(new javax.swing.BoxLayout(GamePlayBoardPanel, javax.swing.BoxLayout.X_AXIS));
        GamePlayBoardPanel.add(filler16);

        DartBoardPanel.setPreferredSize(new java.awt.Dimension(200, 200));
        DartBoardPanel.setLayout(new javax.swing.BoxLayout(DartBoardPanel, javax.swing.BoxLayout.Y_AXIS));
        DartBoardPanel.add(filler18);

        DartBoardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dartboard_200x200.png"))); // NOI18N
        DartBoardLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DartBoardLabelMouseClicked(evt);
            }
        });
        DartBoardPanel.add(DartBoardLabel);
        DartBoardPanel.add(filler19);

        GamePlayBoardPanel.add(DartBoardPanel);
        GamePlayBoardPanel.add(filler17);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 5.0;
        GamePlayPanel.add(GamePlayBoardPanel, gridBagConstraints);

        GamePlayMenuPanel.setLayout(new javax.swing.BoxLayout(GamePlayMenuPanel, javax.swing.BoxLayout.X_AXIS));
        GamePlayMenuPanel.add(filler20);

        ConfirmThrowButton.setText("Confirm Throw");
        ConfirmThrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmThrowButtonActionPerformed(evt);
            }
        });
        GamePlayMenuPanel.add(ConfirmThrowButton);
        GamePlayMenuPanel.add(filler21);

        FinishRoundButton.setText("Finish Round");
        FinishRoundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishRoundButtonActionPerformed(evt);
            }
        });
        GamePlayMenuPanel.add(FinishRoundButton);
        GamePlayMenuPanel.add(filler22);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 4.0;
        GamePlayPanel.add(GamePlayMenuPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 6.0;
        gridBagConstraints.weighty = 1.0;
        ContentPanel.add(GamePlayPanel, gridBagConstraints);

        BodyPanel.add(ContentPanel);
        BodyPanel.add(filler6);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 5.0;
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

        FinishGameButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        FinishGameButton.setText("Finish Game");
        FinishGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishGameButtonActionPerformed(evt);
            }
        });
        FooterPanel.add(FinishGameButton);
        FooterPanel.add(filler28);

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

    private void FinishGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishGameButtonActionPerformed
        
    }//GEN-LAST:event_FinishGameButtonActionPerformed

    private void DartBoardLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DartBoardLabelMouseClicked
        if (state.gameManager.isGameFinished() || state.gameManager.isThrowsDone()) {
            return;
        }

        float nx = evt.getX() / (float)DartBoardLabel.getWidth();
        float ny = evt.getY() / (float)DartBoardLabel.getHeight();
        score = DartboardUtils.getTotalScore(nx, ny, state.gameManager.getGameConfiguration());
        updateGUIElements();
    }//GEN-LAST:event_DartBoardLabelMouseClicked

    private void ConfirmThrowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmThrowButtonActionPerformed
        if (score == -1) {
            JOptionPane.showMessageDialog(null, "Please select a score first", "Invalid Operation Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        state.gameManager.progressRound(score);
        score = -1;
        updateGUIElements();
    }//GEN-LAST:event_ConfirmThrowButtonActionPerformed

    private void FinishRoundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishRoundButtonActionPerformed
        if (!state.gameManager.isThrowsDone()) {
            int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to forfeit your turn? (Offboard penalty will be applied for the rest of your throws)",
                "Forfeit Turn", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (confirmation != JOptionPane.YES_OPTION) {
                return;
            }
        }

        state.gameManager.finishRound();
        if (!state.gameManager.isGameFinished()) {
            state.gameManager.beginRound();
        }
        updateGUIElements();

        if (state.gameManager.isGameFinished()) {
            if (state.chosenGametype == Gametype.FreeForAll) {
                JOptionPane.showMessageDialog(null, "Game finished! Winner: " + state.gameManager.getWinnerTeam().getPlayers()[0].getName(), "Game Finished", JOptionPane.INFORMATION_MESSAGE);
            } else if (state.chosenGametype == Gametype.Teams) {
                JOptionPane.showMessageDialog(null, "Game finished! Winner: " + state.gameManager.getWinnerTeam().getName(), "Game Finished", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_FinishRoundButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JButton ConfirmThrowButton;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel ContentSpacerPanel;
    private javax.swing.JLabel CurrentNextPlayerLabel;
    private javax.swing.JLabel CurrentNextTeamLabel;
    private javax.swing.JLabel CurrentPlayerNameLabel;
    private javax.swing.JLabel CurrentPlayingTeamLabel;
    private javax.swing.JLabel CurrentRequiredScoreLabel;
    private javax.swing.JLabel CurrentRoundLabel;
    private javax.swing.JLabel CurrentRoundScoreLabel;
    private javax.swing.JLabel CurrentThrowLabel;
    private javax.swing.JLabel CurrentThrowScoreLabel;
    private javax.swing.JLabel CurrentTotalCompetitorsLabel;
    private javax.swing.JLabel DartBoardLabel;
    private javax.swing.JPanel DartBoardPanel;
    private javax.swing.JPanel DividerPanel;
    private javax.swing.JButton FinishGameButton;
    private javax.swing.JButton FinishRoundButton;
    private javax.swing.JPanel FooterPanel;
    private javax.swing.JPanel GameInformationBodyPanel;
    private javax.swing.JPanel GameInformationHeaderPanel;
    private javax.swing.JPanel GameInformationPanel;
    private javax.swing.JPanel GameInformationSpacerPanel;
    private javax.swing.JPanel GamePlayBoardPanel;
    private javax.swing.JPanel GamePlayInformationPanel;
    private javax.swing.JPanel GamePlayMenuPanel;
    private javax.swing.JPanel GamePlayPanel;
    private javax.swing.JPanel HeaderBottomPanel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JPanel HeaderTopPanel;
    private javax.swing.JLabel NextPlayerLabel;
    private javax.swing.JLabel NextTeamLabel;
    private javax.swing.JLabel PlayerNameLabel;
    private javax.swing.JLabel PlayingTeamLabel;
    private javax.swing.JButton QuitToMainMenuButton;
    private javax.swing.JLabel RequiredScoreLabel;
    private javax.swing.JLabel RoundLabel;
    private javax.swing.JLabel RoundScoreLabel;
    private javax.swing.JLabel ThrowLabel;
    private javax.swing.JLabel ThrowScoreLabel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel TotalCompetitorsLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler15;
    private javax.swing.Box.Filler filler16;
    private javax.swing.Box.Filler filler17;
    private javax.swing.Box.Filler filler18;
    private javax.swing.Box.Filler filler19;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler20;
    private javax.swing.Box.Filler filler21;
    private javax.swing.Box.Filler filler22;
    private javax.swing.Box.Filler filler23;
    private javax.swing.Box.Filler filler24;
    private javax.swing.Box.Filler filler25;
    private javax.swing.Box.Filler filler26;
    private javax.swing.Box.Filler filler27;
    private javax.swing.Box.Filler filler28;
    private javax.swing.Box.Filler filler29;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler30;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    // End of variables declaration//GEN-END:variables
}
