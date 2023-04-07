package com.cs321.gui;

import com.cs321.core.GameConfiguration;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author guero
 */
public class dart extends javax.swing.JFrame {

    private GUIState state;
    HashMap<Integer, Integer> PlayerResults1; 
    /**
     * Total round score.
     */
    private int totalRoundScore = 0;
    /**
     * current throw score.
     */
    private int throwScore = 0;
    /**
     * how many throws happened.
     */
    private int throwRounds = 0;
    /**
     * actual round.
     */
    private int round = 0; //
    /**
     * how many scores were confirmed.
     */
    private int confirmed = 0;
    String teamA= null; 
    String teamB= null;
    private int MaximumRounds=0; 
    /**
     * Throws allowed per round. 
     */
    private int dartsPerRound=3; ///done 
    float [] multipliers; 
    int OffboardPenalty=0; 
     int [] scoreList= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,50};//done 
     int  startingScore=30; 
     String id=null;
     int xMouse=0; 
     int yMouse=0; 
     int xDart=0; 
     int yDart=0; 

    

  
    GameConfiguration gameMode; 

    /**
     * Creates new form dart
     */
     public dart() {
        initComponents();
         
      
       setPanels(); //sets the gui. 
             
        
        
    }
    /**
     * Constructor with GameConfig. 
     * @param gameMode game config to set up the game. 
     */
    public dart(GameConfiguration gameMode) {
        initComponents();
       
        this.gameMode = gameMode;
        MaximumRounds = gameMode.getMaximumRounds();
        dartsPerRound = gameMode.getDartsPerRound();
        id = gameMode.getId();//string
        multipliers = gameMode.getMultipliers();//float.
        OffboardPenalty = gameMode.getOffboardPenalty();//int
        scoreList = gameMode.getScoreList();//array of ints 
        startingScore = gameMode.getStartingScore(); //int
        
       
        setPanels(); //sets the gui. 
  
        //state.contentPane.add("frame", this.jPanel1);


       

        
    }
    private void setPanels(){
           
        setPanel2Color(changingLightsBoardPanel);//sets color shift for dart board. 
        //jPanel2.setVisible(true);
        roundScoreBoxValue.setText("0");
        teamAName.setText("A-34");// sets text for team A's name. 
        teamBName.setText("B-57");//sets text fot team B's name 
        roundValueBox.setText("0");// sets texts for round. 
        throwBoxValue.setText("0/" + dartsPerRound);//sets texts for Throw number. ex : 1/3
        roundScoreBoxValue.setText("0");//sets text for round score. 
        playingTeamBoxValue.setText("A");//sets text for current playing team. 
        playerNameBoxValue.setText("plr1");//sets text for player's name. 
        throwScoreBoxValue.setText("0");// sets current throw score. 
       // jPanel1.setToolTipText(startingScore+"");
        //jLabel3.setText(startingScore+"");
        startingScoreBoxValue.setText(startingScore+"");
        //this.setVisible(false);
        //jPanel1.setVisible(true);

       
        
    }

    /**
     * Method to change  panel's background calor randomly 
     * 
     */
    private void setPanel2Color(JPanel myPanel ) {
        float hue = (float) Math.random();
        float saturation = 0.9f; // Saturation value between 0.0 and 1.0
        float brightness = 1.0f; // Brightness value between 0.0 and 1.0
        Color randomColor = Color.getHSBColor(hue, saturation, brightness);
        JPanel tempMyPanel = myPanel;
        tempMyPanel.setBackground(randomColor);
        HashMap<Integer, Integer> PlayerResults1= new HashMap();
  

    }

    /**
     * C
     * Total round score getter.
     *
     * @return totalRound Score.
     */
    public int getScore() {

        return this.totalRoundScore;
    }

    public int throwScore() {
        return this.throwScore;
    }

    public int throwRounds() {
        return throwRounds;
    }

    /**
     * setter for round.
     *
     * @param round
     */
    public void setRound(int round) {
        this.round = round;

    }

    /**
     * getter for round.
     *
     * @return
     */
    public int getRound() {
        return round;
    }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        playingTeamBox = new javax.swing.JLabel();
        playerNameBox = new javax.swing.JLabel();
        roundScoreBox = new javax.swing.JLabel();
        roundScoreBoxValue = new java.awt.Label();
        playingTeamBoxValue = new java.awt.Label();
        playerNameBoxValue = new java.awt.Label();
        label5 = new java.awt.Label();
        teamABox = new java.awt.Label();
        teamBBox = new java.awt.Label();
        teamAName = new java.awt.Label();
        teamBName = new java.awt.Label();
        roundBox = new java.awt.Label();
        roundValueBox = new java.awt.Label();
        throwBox = new java.awt.Label();
        throwBoxValue = new java.awt.Label();
        QuitToMainMenuButton = new java.awt.Button();
        confirmNowButton = new java.awt.Button();
        undoThrowButton = new java.awt.Button();
        throwScoreBox = new javax.swing.JLabel();
        throwScoreBoxValue = new java.awt.Label();
        changingLightsBoardPanel = new javax.swing.JPanel();
        dartBoardPicture = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        startingScoreBoxValue = new java.awt.Label();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel1.setText("Required Score: ");

        label1.setText("label1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        label1.getAccessibleContext().setAccessibleName("310");

        jPanel4.setBackground(new java.awt.Color(51, 255, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        playingTeamBox.setBackground(new java.awt.Color(204, 0, 51));
        playingTeamBox.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        playingTeamBox.setForeground(new java.awt.Color(204, 0, 51));
        playingTeamBox.setText("Playing Team: ");

        playerNameBox.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        playerNameBox.setForeground(new java.awt.Color(204, 0, 51));
        playerNameBox.setText("Player's name: ");

        roundScoreBox.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        roundScoreBox.setForeground(new java.awt.Color(204, 0, 51));
        roundScoreBox.setText("Round Score: ");

        roundScoreBoxValue.setText("label1");

        playingTeamBoxValue.setText("label2");

        playerNameBoxValue.setText("label4");

        label5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label5.setText("__________________________________________________________________________________________________________");

        teamABox.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        teamABox.setText("Team ");

        teamBBox.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        teamBBox.setText("Team ");

        teamAName.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        teamAName.setText("A -34");

        teamBName.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        teamBName.setText("B-57");

        roundBox.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        roundBox.setText("Round");

        roundValueBox.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        roundValueBox.setText("1");

        throwBox.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        throwBox.setText("Throw");

        throwBoxValue.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        throwBoxValue.setText("1/3");

        QuitToMainMenuButton.setBackground(new java.awt.Color(204, 255, 204));
        QuitToMainMenuButton.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        QuitToMainMenuButton.setLabel("Quit to Main Menu");
        QuitToMainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitToMainMenuButtonActionPerformed(evt);
            }
        });

        confirmNowButton.setBackground(new java.awt.Color(204, 255, 204));
        confirmNowButton.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        confirmNowButton.setLabel("Confirm Throw");
        confirmNowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmNowButtonActionPerformed(evt);
            }
        });

        undoThrowButton.setBackground(new java.awt.Color(204, 255, 204));
        undoThrowButton.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        undoThrowButton.setLabel("Undo Throw");
        undoThrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoThrowButtonActionPerformed(evt);
            }
        });

        throwScoreBox.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        throwScoreBox.setForeground(new java.awt.Color(153, 0, 153));
        throwScoreBox.setText("Throw Score: ");

        throwScoreBoxValue.setText("label1");

        dartBoardPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dartBoardPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dartBoard_1.png"))); // NOI18N
        dartBoardPicture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dartBoardPictureMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout changingLightsBoardPanelLayout = new javax.swing.GroupLayout(changingLightsBoardPanel);
        changingLightsBoardPanel.setLayout(changingLightsBoardPanelLayout);
        changingLightsBoardPanelLayout.setHorizontalGroup(
            changingLightsBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changingLightsBoardPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(dartBoardPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        changingLightsBoardPanelLayout.setVerticalGroup(
            changingLightsBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changingLightsBoardPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(dartBoardPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        label2.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label2.setForeground(new java.awt.Color(102, 102, 102));
        label2.setText("Required Score: ");

        startingScoreBoxValue.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        startingScoreBoxValue.setForeground(new java.awt.Color(102, 102, 102));
        startingScoreBoxValue.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startingScoreBoxValue, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startingScoreBoxValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        label2.getAccessibleContext().setAccessibleName("Required Score:");

        jLabel2.setBackground(new java.awt.Color(255, 51, 51));
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Dart/I can move ");
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel2MouseDragged(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(teamABox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(teamAName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(teamBBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(teamBName, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(249, 249, 249))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(roundBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roundValueBox, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(throwBox, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(throwBoxValue, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(232, 232, 232)
                                .addComponent(throwScoreBox)
                                .addGap(19, 19, 19)
                                .addComponent(throwScoreBoxValue, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addComponent(playerNameBox)
                                                            .addGap(6, 6, 6))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                            .addComponent(playingTeamBox)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(roundScoreBox)
                                                        .addGap(14, 14, 14)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(roundScoreBoxValue, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(playingTeamBoxValue, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(playerNameBoxValue, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(QuitToMainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(undoThrowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(confirmNowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(changingLightsBoardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60))))
                    .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(teamABox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(teamAName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(teamBName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(teamBBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundValueBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(throwBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(throwBoxValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(throwScoreBoxValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(throwScoreBox))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(roundScoreBox)
                            .addComponent(roundScoreBoxValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playingTeamBox)
                            .addComponent(playingTeamBoxValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerNameBox)
                            .addComponent(playerNameBoxValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(changingLightsBoardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmNowButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuitToMainMenuButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(undoThrowButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        label5.getAccessibleContext().setAccessibleName("_________________________________________________________________________________________________________________________");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 848, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 726, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 132, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * This method is responsible for clicking on the dartboard. The method uses
     * Random class to give a score.
     *
     * @param evt
     */
    private void dartBoardPictureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dartBoardPictureMouseClicked
        // TODO add your handling code here:
       // System.out.println("throw round : "+ throwRounds);
        if (throwRounds > dartsPerRound-1) {
            javax.swing.JOptionPane.showMessageDialog(null, "You completed all 3 Throws ", "Message", javax.swing.JOptionPane.INFORMATION_MESSAGE);
//            this.round+=1;
//            
//            roundScoreBoxValue.setText("0");
//            this.roundValueBox.setText(round+"");
//            throwScore=0; 
//            throwRounds=0; 
//            this.throwBoxValue.setText(0+"");
//            
//            confirmed=0;
//            PlayerResults1.put(round, totalRoundScore);
//            totalRoundScore=0;
            
          
       // System.out.println("PlayerResults1: "+ PlayerResults1);
            return;
        }
        setPanel2Color(changingLightsBoardPanel);////changes panel's color for fun. 
        
   
        Random rand = new Random();
        int score = rand.nextInt(scoreList.length-1) ;
        System.out.println("score: "+ score);
        throwScore= scoreList[score];
       
       
        
        throwScoreBoxValue.setText(throwScore + "");


    }//GEN-LAST:event_dartBoardPictureMouseClicked

    private void QuitToMainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitToMainMenuButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();   // closes the current Jframe window. 
       // DartDashGUI gui = new DartDashGUI(); 
        //.setVisible(true);
        //gui.dispose();
        //this.dispose();
        //jPanel1.setVisible(false);
        //state.contentPaneCardLayout.show(state.contentPane, "MainMenuPanel");
        
        state.contentPaneCardLayout.show(state.contentPane, "ViewGamemodesPanel");
    }//GEN-LAST:event_QuitToMainMenuButtonActionPerformed
    /**
     * method to confirm score.
     *
     * @param evt
     */
    private void confirmNowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmNowButtonActionPerformed
        // TODO add your handling code here:
        if (throwRounds > dartsPerRound || throwRounds < 0 || confirmed > 2 || throwScore==0 ) {
            javax.swing.JOptionPane.showMessageDialog(null, "You cannot confim this round ", "Message", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return; 
        }
        setPanel2Color(changingLightsBoardPanel);////changes panel's color for fun. 
        throwRounds += 1;
        String s = throwRounds + "/"+dartsPerRound;
        throwBoxValue.setText(s);
        totalRoundScore += throwScore();
        throwScore = 0;
        throwScoreBoxValue.setText(throwScore+"");
       
        roundScoreBoxValue.setText( totalRoundScore+"");
        confirmed += 1;
        //confimredLast = true;

    }//GEN-LAST:event_confirmNowButtonActionPerformed
    /**
     * Method to undo score.
     *
     * @param evt
     */
    private void undoThrowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoThrowButtonActionPerformed
        // TODO add your handling code here:
       
        
        if ((throwRounds == 0 && throwScore==0) || confirmed > 2 || throwScore== 0 ) {  ///this is debatable, since I think throws are going to be controllded by the game's manager's control flow. 
            javax.swing.JOptionPane.showMessageDialog(null, "You cannot undo a throw ", "Message", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    
            return;

            //throwRounds=0;
        }

        setPanel2Color(changingLightsBoardPanel);////changes panel's color for fun. 
        throwScore = 0;
        /*throwRounds -= 1;
        if (throwRounds < 0){
        throwRounds =0; 
        }*/
        throwScoreBoxValue.setText("0");

        String s = throwRounds + "/"+dartsPerRound;
        throwBoxValue.setText(s);
        roundScoreBoxValue.setText(totalRoundScore + "");
    }//GEN-LAST:event_undoThrowButtonActionPerformed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:
        xDart=  evt.getX();
        yDart= evt.getY();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseDragged
        // TODO add your handling code here:
          int x = evt.getXOnScreen() - xMouse;
   int y = evt.getYOnScreen() - yMouse;
   evt.getComponent().setLocation(x, y);
    }//GEN-LAST:event_jLabel2MouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button QuitToMainMenuButton;
    private javax.swing.JPanel changingLightsBoardPanel;
    private java.awt.Button confirmNowButton;
    private javax.swing.JLabel dartBoardPicture;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label5;
    private javax.swing.JLabel playerNameBox;
    private java.awt.Label playerNameBoxValue;
    private javax.swing.JLabel playingTeamBox;
    private java.awt.Label playingTeamBoxValue;
    private java.awt.Label roundBox;
    private javax.swing.JLabel roundScoreBox;
    private java.awt.Label roundScoreBoxValue;
    private java.awt.Label roundValueBox;
    private java.awt.Label startingScoreBoxValue;
    private java.awt.Label teamABox;
    private java.awt.Label teamAName;
    private java.awt.Label teamBBox;
    private java.awt.Label teamBName;
    private java.awt.Label throwBox;
    private java.awt.Label throwBoxValue;
    private javax.swing.JLabel throwScoreBox;
    private java.awt.Label throwScoreBoxValue;
    private java.awt.Button undoThrowButton;
    // End of variables declaration//GEN-END:variables
}
