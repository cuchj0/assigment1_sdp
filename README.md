# assigment1_sdp

# Indie Game Quest Builder

A Java demonstration of the **Builder** creational design pattern
applied to an indie game quest system.

## What is the product?

The product is a `Quest` — an immutable, complex object that describes
a task a player can undertake. Quests have many optional and required
fields, which makes the Builder pattern a natural fit.

## Why the Builder pattern fits

- **Many optional fields**: a `Quest` has 9+ fields, most of them optional.
  Telescoping constructors would be unreadable.
- **Multiple representations**: `MAIN`, `SIDE`, and `DAILY` quests share
  the same structure but differ in defaults and validation rules — which
  maps naturally onto multiple `ConcreteBuilder`s.
- **Validated construction**: `build()` throws `InvalidQuestException`
  when the accumulated state violates a rule for the given quest type.
- **Reusable recipes**: `QuestDirector` encapsulates well-known quest
  configurations so the client does not repeat the same steps.

## Project structure
src/com/questforge/
model/ — Quest, QuestType, Reward;
builder/ — QuestBuilder (interface), AbstractQuestBuilder, ;
MainQuestBuilder, SideQuestBuilder, DailyQuestBuilder ;
director/ — QuestDirector with reusable recipes ;
exception/ — InvalidQuestException ;
Main.java — demo client

docs/
uml.puml — PlantUML source of the class diagram  ;
uml.png — rendered UML diagram


## How to build each representation

| Builder              | Quest type | Special rules                                  |
|----------------------|------------|------------------------------------------------|
| `MainQuestBuilder`   | MAIN       | ≥ 2 objectives, no time limit, not repeatable  |
| `SideQuestBuilder`   | SIDE       | ≤ 60 min time limit, level ≤ 20                |
| `DailyQuestBuilder`  | DAILY      | Always repeatable, fixed 24-hour limit         |

## How to run

### In IntelliJ IDEA

1. Open the project.
2. Ensure a JDK 17+ is configured in **File → Project Structure → Project**.
3. Open `src/com/questforge/Main.java` and click the green ▶ next to `main`.

### From the command line

```bash
javac -d out $(find src -name "*.java")
java -cp out com.questforge.Main
```

### UML
The class diagram is available as docs/uml.puml (source) and docs/uml.png (rendered).
