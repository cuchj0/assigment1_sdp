package com.questforge.director;

import com.questforge.builder.QuestBuilder;
import com.questforge.model.Quest;
import com.questforge.model.Reward;

public class QuestDirector {
    private final QuestBuilder builder;

    public QuestDirector(QuestBuilder builder){
        if (builder == null){
            throw new IllegalArgumentException("Builder must not be null");
        }
        this.builder = builder;
    }

    public Quest constructTutorialQuest(){
        return builder
                .setTitle("A New Beginning")
                .setDescription("Learn the basics of adventuring in Eldoria.")
                .setLocation("Eldoria Village")
                .setRequiredLevel(1)
                .addObjective("Talk to the village elder")
                .addObjective("Defeat 3 training dummies")
                .addReward(new Reward("Gold", 50))
                .addReward(new Reward("Wooden Sword", 1))
                .build();
    }
    public Quest constructHerbGatheringQuest() {
        return builder
                .setTitle("Herbs for the Healer")
                .setDescription("Collect healing herbs for the village healer.")
                .setLocation("Whispering Forest")
                .setRequiredLevel(3)
                .setTimeLimitMinutes(30)
                .addObjective("Collect 5 Moonpetal flowers")
                .addReward(new Reward("Gold", 30))
                .addReward(new Reward("Health Potion", 2))
                .build();
    }
    public Quest constructWolfHuntDailyQuest() {
        return builder
                .setTitle("Daily Wolf Hunt")
                .setDescription("Cull the wolf population threatening the roads.")
                .setLocation("Northern Road")
                .setRequiredLevel(5)
                .addObjective("Slay 10 wolves")
                .addReward(new Reward("Gold", 40))
                .addReward(new Reward("Wolf Pelt", 1))
                .build();
    }
}
