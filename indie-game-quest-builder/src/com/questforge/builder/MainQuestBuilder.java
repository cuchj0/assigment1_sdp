package com.questforge.builder;

import com.questforge.exception.InvalidQuestException;
import com.questforge.model.QuestType;

public class MainQuestBuilder extends AbstractQuestBuilder {

    private static final int MIN_OBJECTIVES_FOR_MAIN = 2;
    private static final int MIN_REQUIRED_LEVEL_FOR_MAIN = 1;

    @Override
    protected QuestType getQuestType() {
        return QuestType.MAIN;
    }

    @Override
    protected void validateSpecificState() {
        if (objectives.size() < MIN_OBJECTIVES_FOR_MAIN) {
            throw new InvalidQuestException(
                    "Main quest requires at least " + MIN_OBJECTIVES_FOR_MAIN + " objectives");
        }
        if (requiredLevel < MIN_REQUIRED_LEVEL_FOR_MAIN) {
            throw new InvalidQuestException(
                    "Main quest requires player level >= " + MIN_REQUIRED_LEVEL_FOR_MAIN);
        }
        if (repeatable) {
            throw new InvalidQuestException("Main quest cannot be repeatable");
        }
        if (timeLimitMinutes > 0) {
            throw new InvalidQuestException("Main quest cannot have a time limit");
        }
    }
}