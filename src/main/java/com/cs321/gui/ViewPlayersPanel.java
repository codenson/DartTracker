/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.cs321.gui;

import javax.swing.DefaultListModel;

import com.cs321.core.Player;
import com.cs321.gui.GUIState.PanelName;

/**
 *
 * @author Hasna
 */
public class ViewPlayersPanel extends UpdateableJPanel {

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
    }

    /**
     * Displays the player in the content panel
     *
     * @param player
     */
    private void displayPlayer(Player player) {
        CurrentIDLabel.setText(player.getId());
        CurrentNameLabel.setText(player.getName());
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
            .addGap(0, 120, Short.MAX_VALUE)
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
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 16);
        PropertiesPanel.add(IDLabel, gridBagConstraints);

        CurrentIDLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        PropertiesPanel.add(CurrentIDLabel, gridBagConstraints);

        NameLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        NameLabel.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 16);
        PropertiesPanel.add(NameLabel, gridBagConstraints);

        CurrentNameLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        PropertiesPanel.add(CurrentNameLabel, gridBagConstraints);

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
        gridBagConstraints.weightx = 2.0;
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
        // TODO add your handling code here:
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
        // TODO add your handling code here:
        
    }//GEN-LAST:event_NewButtonActionPerformed

    private void ImportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ImportButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_EditButtonActionPerformed

    private void ExportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_ExportButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void QuitToMainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitToMainMenuButtonActionPerformed
        // TODO add your handling code here:
        state.panels.get(PanelName.MainMenuPanel).updateComponents();
        state.contentPaneCardLayout.show(state.contentPane, PanelName.MainMenuPanel.toString());
    }//GEN-LAST:event_QuitToMainMenuButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel ContentSpacerPanel;
    private javax.swing.JLabel CurrentIDLabel;
    private javax.swing.JLabel CurrentNameLabel;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JPanel ExplorerHolderPanel;
    private javax.swing.JList<String> ExplorerList;
    private javax.swing.JPanel ExplorerMenu;
    private javax.swing.JScrollPane ExplorerScrollPane;
    private javax.swing.JButton ExportButton;
    private javax.swing.JPanel FooterPanel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JButton ImportButton;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JButton NewButton;
    private javax.swing.JPanel PropertiesHolderPanel;
    private javax.swing.JPanel PropertiesMenu;
    private javax.swing.JPanel PropertiesPanel;
    private javax.swing.JScrollPane PropertiesScrollPane;
    private javax.swing.JButton QuitToMainMenuButton;
    private javax.swing.JLabel TitleLabel;
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
