import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;


public class Game{

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtoPanel, playerPanel;

    JLabel titleNameLabel, hpLabel, hpLJLabelNumber, weaponLabel, weaponLJLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font nomalFont = new Font("Times New Roman",Font.PLAIN, 30 );
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHp, MonsterHP, SilverRing;
    String Weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler(); 


    public static void main(String[] args){
    new Game();
}


public Game() {
    window = new JFrame();
    window.setSize(800,600);
    //창 크기 넓이 셋팅
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //윈도우창 닫게 해주는거
    window.getContentPane().setBackground(Color.black);
    window.setLayout(null);
    //
    window.setVisible(true);
    //
    con = window.getContentPane();
    //ㄴ여기까지가 window 셋팅하는법


    titleNamePanel = new JPanel();
    titleNamePanel.setBounds(100,100,600,150);
    titleNamePanel.setBackground(Color.black);
    titleNameLabel = new JLabel("ADVENTURE");
    titleNameLabel.setForeground(Color.white);
    titleNameLabel.setFont(titleFont);
    titleNamePanel.add(titleNameLabel);
    con.add(titleNamePanel);
    //ㄴ title 만들기

    startButtonPanel = new JPanel();
    startButtonPanel.setBounds(300, 400, 200, 100);
    startButtonPanel.setBackground(Color.black);
    con.add(startButtonPanel);
    startButton = new JButton("START");
    startButton.setBackground(Color.black);
    startButton.setForeground(Color.white);
    startButton.setFont(nomalFont);
    startButtonPanel.add(startButton);
    // ㄴ button 만들기 (외형적인 부분)
    startButton.addActionListener(tsHandler);
    startButton.setFocusPainted(false);
}

public void createGameScreen(){

    titleNamePanel.setVisible(false);
    startButtonPanel.setVisible(false);

    mainTextPanel = new JPanel();
    mainTextPanel.setBounds(100,100,600,250);
    mainTextPanel.setBackground(Color.black);
    con.add(mainTextPanel);

    mainTextArea = new JTextArea("The Enemy is comming...\n You are the 'Chosen One'\n What will you do...? ");
    mainTextArea.setBounds(100,100,600,250);
    mainTextArea.setBackground(Color.black);
    mainTextArea.setForeground(Color.white);
    mainTextArea.setFont(nomalFont);
    mainTextArea.setLineWrap(true); //자동적으로 줄길이를 조정
    mainTextPanel.add(mainTextArea);
//

    choiceButtoPanel = new JPanel();
    choiceButtoPanel.setBounds(250,350,300,150);
    choiceButtoPanel.setBackground(Color.black);
    choiceButtoPanel.setLayout(new GridLayout(4,1));
    //영역들 간의 사이에 간격이 없는 GridLayout을 생성한다.
    con.add(choiceButtoPanel);

    choice1 = new JButton("one");
    choice1.setBackground(Color.black);
    choice1.setForeground(Color.white);
    choice1.setFont(nomalFont);
    choiceButtoPanel.add(choice1);
    choice1.setFocusPainted(false);
    choice1.addActionListener(choiceHandler);
    choice1.setActionCommand("c1");
    // 선택 버튼1

    choice2 = new JButton("two");
    choice2.setBackground(Color.black);
    choice2.setForeground(Color.white);
    choice2.setFont(nomalFont);
    choiceButtoPanel.add(choice2);
    choice2.setFocusPainted(false);
    choice2.addActionListener(choiceHandler);
    choice2.setActionCommand("c2");
    // 선택 버튼2

    choice3 = new JButton("three");
    choice3.setBackground(Color.black);
    choice3.setForeground(Color.white);
    choice3.setFont(nomalFont);
    choiceButtoPanel.add(choice3);
    choice3.setFocusPainted(false);
    choice3.addActionListener(choiceHandler);
    choice3.setActionCommand("c3");
    // 선택 버튼3

    choice4 = new JButton("four");
    choice4.setBackground(Color.black);
    choice4.setForeground(Color.white);
    choice4.setFont(nomalFont);
    choiceButtoPanel.add(choice4);
    choice4.setFocusPainted(false);
    choice4.addActionListener(choiceHandler);
    choice4.setActionCommand("c4");
    // 선택 버튼4


    playerPanel = new JPanel();
    playerPanel.setBounds(100,15,600,50);
    playerPanel.setBackground(Color.black);
    playerPanel.setLayout(new GridLayout(1,4));
    con.add(playerPanel);
    hpLabel = new JLabel("HP: ");
    hpLabel.setFont(nomalFont);
    hpLabel.setForeground(Color.white);
    playerPanel.add(hpLabel);
    hpLJLabelNumber = new JLabel();
    hpLJLabelNumber.setFont(nomalFont);
    hpLJLabelNumber.setForeground(Color.white);
    playerPanel.add(hpLJLabelNumber);

    weaponLabel = new JLabel("Weapon:");
    weaponLabel.setFont(nomalFont);
    weaponLabel.setForeground(Color.white);
    playerPanel.add(weaponLabel);
    weaponLJLabelName = new JLabel();
    weaponLJLabelName.setFont(nomalFont);
    weaponLJLabelName.setForeground(Color.white);
    playerPanel.add(weaponLJLabelName);

    playerSetup();
}

public void playerSetup(){
    playerHp = 15;
    Weapon = "gun";

    MonsterHP = 20;

    hpLJLabelNumber.setText(""+playerHp);
    weaponLJLabelName.setText(Weapon);

    townGate();

}

public void townGate(){

    position = "townGate";

    mainTextArea.setText("you are gate of the town\nthere is enemy in frot of you.\n\nwhat will you do???");

    choice1.setText("Talk to Enemy");
    choice2.setText("Attack the Enemy");
    choice3.setText("Leave this place");
    choice4.setText("");
}

public void talkEnemy(){

    position = "townEnemy"; //플레이어 현재 위치
    mainTextArea.setText("Enemy: rahhhhahah!!!\n\n you must Run.");
    
    choice1.setText(">");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
}

public void AttacktownEnemy(){
    position = "AttacktownEnemy";
    mainTextArea.setText("Enemy: rahhhhahah!!!\n\n you recieved three damamge.");
    playerHp = playerHp-3;
    hpLJLabelNumber.setText(""+playerHp);
    choice1.setText(">");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");

}

public void crossRoad(){
    position = "crossRoad";
    mainTextArea.setText("you are at a crossRoad\n if you go south, you will back to the town.");
    choice1.setText("Go North");
    choice2.setText("Go East");
    choice3.setText("Go South");
    choice4.setText("Go West");
}

public void North(){
    position = "North";
    mainTextArea.setText("there is a healling river \n\n your HP is recovered by 3");
    playerHp = playerHp + 3;
    hpLJLabelNumber.setText(""+playerHp);
    choice1.setText("Go South");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
}

public void East(){
    position = "East";
    mainTextArea.setText("you walked into a forest\n\n you found Long Sword.\n\n [you obtained Long Sword.]");
    Weapon = "Long Sword";
    weaponLJLabelName.setText(Weapon);
    choice1.setText("Go West");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
}

public void West(){
    position = "West";
    mainTextArea.setText("you encounter a Goblin!!");
    choice1.setText("Fight");
    choice2.setText("Run");
    choice3.setText("-");
    choice4.setText("-");
}

public void Fight(){
    position = "Fight";
    mainTextArea.setText("MonsterHP: "+ MonsterHP+"\n\n What will you do???");
    choice1.setText("Attack");
    choice2.setText("Run");
    choice3.setText("-");
    choice4.setText("-");
}

public void PlayerAttack(){
    position = "PlayerAttack";
    int playerDamage = 0;

    if(Weapon.equals("gun")){
    playerDamage = new java.util.Random().nextInt(3);
    }
    else if(Weapon.equals("Long Sword")){
    playerDamage = new java.util.Random().nextInt(8);
    }

    mainTextArea.setText("you attacked a Monster and you gave "+playerDamage+" damaged!!");

    MonsterHP = MonsterHP - playerDamage;

    choice1.setText("Attack");
    choice2.setText("Run");
    choice3.setText("-");
    choice4.setText("-");


}

public void MonsterAttack(){
    position = "MonsterAttack";

    int MonsterDamage = 0;
    MonsterDamage = new java.util.Random().nextInt(4);

    mainTextArea.setText("The Monster attacked you and gave "+MonsterDamage+" damage!!");
    playerHp = playerHp - MonsterDamage;
    hpLJLabelNumber.setText(""+playerHp);

    choice1.setText(">");
    choice2.setText("-");
    choice3.setText("-");
    choice4.setText("-");

}



public void lose(){
    position ="lose";

    mainTextArea.setText("you are dead\n\n Game Over...");

    choice1.setText("");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
    choice1.setVisible(false);
    choice2.setVisible(false);
    choice3.setVisible(false);
    choice4.setVisible(false);
}

public void win(){
    position ="win";

    mainTextArea.setText("you are win!! you defeated the Monster!!\nThe Monster dropped a ring!\n You obtained a Silver Ring!!!");

    SilverRing = 1;

    choice1.setText("Go East");
    choice2.setText("-");
    choice3.setText("-");
    choice4.setText("-");
}

public void ending(){
    position = "ending";
    mainTextArea.setText("townMonster: you killed my Boss!! Runnnn!!!\n\n You Win! the Town is safe now...\n\n\n                              <THE END>");

    choice1.setText("");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
    choice1.setVisible(false);
    choice2.setVisible(false);
    choice3.setVisible(false);
    choice4.setVisible(false);
}



public class TitleScreenHandler implements ActionListener{
    public void actionPerformed(ActionEvent event){

        createGameScreen();
    }
}


public class ChoiceHandler implements ActionListener{
    public void actionPerformed(ActionEvent event){

        String yourChoice = event.getActionCommand();

        switch(position){
        case "townGate": 
           switch(yourChoice){
            case "c1": 
            if(SilverRing==1){
                ending();
            }
            else{
            talkEnemy();
            }
            break;
            case "c2": AttacktownEnemy(); break;
            case "c3": crossRoad(); break;
           }
           break;

        case "townEnemy":
           switch(yourChoice){
            case "c1": townGate(); break;
            case "c2":
            case "c3":
           }
           break;

        case "AttacktownEnemy":
        switch(yourChoice){
            case "c1": townGate(); break;
        }
        break;

        case "crossRoad":
        switch(yourChoice){
            case "c1": North(); break;
            case "c2": East(); break;
            case "c3":townGate(); break;
            case "c4": West(); break;
        }
        break;
       
        case "North":
        switch(yourChoice){
            case "c1":crossRoad(); break;
        }
        break;
       
        case "East":
        switch(yourChoice){
            case "c1":crossRoad(); break;
        }
        break;
       
        case "West":
        switch(yourChoice){
            case "c1": Fight(); break;
            case "c2":crossRoad(); break;
        }
        break;

        case "Fight":
        switch(yourChoice){
            case "c1": PlayerAttack(); break;
            case "c2":crossRoad(); break;
        }
        break;

        case "PlayerAttack":
        switch(yourChoice){
            case "c1": 
            if(MonsterHP<1){
                win();
            }
            else{
            MonsterAttack(); 
            }
            break;
        }
        break;

        case "MonsterAttack":
        switch(yourChoice){
            case "c1": 
            if(playerHp<1){
                lose();
            }
            else{
            Fight(); 
            }
            break;
        }
        break;

        case "win":
        switch(yourChoice){
            case "c1":crossRoad(); break;
        }
        break;






        }


        
    }
}
    


} 