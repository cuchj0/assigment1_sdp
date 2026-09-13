package com.questforge;

import com.questforge.builder.DailyQuestBuilder;
import com.questforge.builder.MainQuestBuilder;
import com.questforge.builder.SideQuestBuilder;
import com.questforge.director.QuestDirector;
import com.questforge.exception.InvalidQuestException;
import com.questforge.model.Quest;
import com.questforge.model.Reward;

public class Main {
    public static void main(String[] args) {
        System.out.println("### Using Director with a MainQuestBuilder ###");
        QuestDirector mainDirector = new QuestDirector(new MainQuestBuilder());
        Quest tutorial = mainDirector.constructTutorialQuest();
        System.out.println(tutorial);

        System.out.println("### Using Director with a SideQuestBuilder ###");
        QuestDirector sideDirector = new QuestDirector(new SideQuestBuilder());
        Quest herbs = sideDirector.constructHerbGatheringQuest();
        System.out.println(herbs);

        System.out.println("### Using Director with a DailyQuestBuilder ###");
        QuestDirector dailyDirector = new QuestDirector(new DailyQuestBuilder());
        Quest wolves = dailyDirector.constructWolfHuntDailyQuest();
        System.out.println(wolves);

        System.out.println("### Manual building without Director ###");
        Quest customSide = new SideQuestBuilder()
                .setTitle("Lost Kitten")
                .setDescription("Find the blacksmith's lost kitten.")
                .setLocation("Eldoria Village")
                .setRequiredLevel(2)
                .setTimeLimitMinutes(15)
                .addObjective("Search the barn")
                .addObjective("Search the well")
                .addReward(new Reward("Gold", 10))
                .build();
        System.out.println(customSide);

        System.out.println("### Demonstrating validation failure ###");
        try {
            new MainQuestBuilder()
                    .setTitle("Broken Main Quest")
                    .setDescription("Missing objectives on purpose.")
                    .setLocation("Nowhere")
                    .setRequiredLevel(1)
                    .addReward(new Reward("Gold", 1))
                    .build();
        } catch (InvalidQuestException ex) {
            System.out.println("Expected failure: " + ex.getMessage());
        }
    }
}
