# Siedler von Catan (text version) — consolidated spec

Consolidated from the original PM1 Projekt 3 Anleitung and Kick-Off. This is the single input document for generating the AI version of the game. The original PDFs are at `../PM1 Projekt 3 Anleitung.pdf` and `../PM1 Projekt 3 Kick-Off.pdf` for reference.

## 1. Task

Implement a text-based Java version of *Siedler von Catan* (Catan). Input/output via the TextIO library. No GUI.

## 2. Scope

Implement all three parts of the original assignment, for a total of 30 points:

- **Teilaufgabe 1 — Base functionality (18 P).** The core game.
- **Teilaufgabe 2 — Cities extension (5 P).** Added via inheritance of the Structure concept.
- **Teilaufgabe 3 — Robber extension (7 P).** The simplified Räuber variant (see Section 8). We are **not** implementing "longest road"; pick robber.

## 3. Out of scope

Do not implement: event cards (Ereigniskarten), knights (Ritter), trading with other players (nur 4:1 mit Bank), harbors (Häfen), longest road (längste Strasse).

## 4. Game phases

1. **Phase 1 — Fixed board setup.** No random generation. Use the fixed coordinates in Section 7.
2. **Phase 2 — Founding phase (2 rounds).** See Section 5.
3. **Phase 3 — Main game.** See Section 6.

## 5. Founding phase

1. Prompt for number of players [2-4].
2. Each player, in turn order (e.g. RED, BLUE, GREEN, YELLOW by seating), places one settlement plus one connected road. The settlement distance rule applies (no two settlements on adjacent corners).
3. Each player, in **reverse** order, places a second settlement plus road.
4. Immediately after a player places their second settlement, they receive one resource per adjacent land field (water/desert give nothing) from the bank.
5. The player who placed their second settlement **last** becomes the starting player for Phase 3.

## 6. Main game turn

Flow per turn:

1. **Roll two dice (sum 2-12).**
   - If the sum is **7** and the robber extension is implemented: see Section 8.
   - If the sum is 7 and the robber is not implemented: every player with more than 7 resource cards discards half (round down), discarded cards chosen randomly.
   - Else: every player receives resources for each of their settlements (1 card) or cities (2 cards) on a field whose number chip matches the rolled sum. No payout if the bank runs out of that resource for the full demand.
2. **Build and/or trade, in any order, any number of times**, as long as the player has the resources:
   - **Build road.** Attached to one of the player's existing roads or a settlement/city. Cost: 1 WOOD + 1 CLAY (1 LUMBER + 1 BRICK).
   - **Build settlement.** On an empty corner adjacent to one of the player's roads. Distance rule: no neighboring corner may already have a settlement or city. Cost: 1 WOOD + 1 CLAY + 1 WOOL + 1 GRAIN.
   - **Build city.** Replaces one of the player's own settlements. Cost: 2 GRAIN + 3 STONE (2 GRAIN + 3 ORE).
   - **Trade 4:1 with bank.** Give 4 identical resources to the bank, receive 1 of any resource (provided the bank has it).
3. **End turn.** Next player (fixed clockwise rotation, i.e. RED → BLUE → GREEN → YELLOW → RED).

The game ends the moment any player reaches **7 victory points** at the end of their own turn's build phase. Settlement = 1 VP, City = 2 VP.

## 7. Fixed board layout

The board uses the hex coordinate system of `ch.zhaw.hexboard.HexBoard`. Each land field is at an even row and a column that depends on the row. Land fields and their dice numbers are fixed:

### Land placement

| Land           | Coordinates (x,y)                                    |
|---             |---                                                   |
| FOREST         | (5,5), (3,11), (10,8), (8,14)                        |
| MEADOW         | (7,5), (9,5), (10,14), (5,17)                        |
| GRAINFIELD     | (4,8), (8,8), (11,11), (4,14)                        |
| MOUNTAIN       | (6,8), (9,11), (6,14)                                |
| CLAYSOIL       | (5,11), (7,17), (9,17)                               |
| DESERT         | (7,11)                                                |
| WATER (ring)   | (4,2), (6,2), (8,2), (10,2), (3,5), (11,5), (2,8), (12,8), (1,11), (13,11), (2,14), (12,14), (3,17), (11,17), (4,20), (6,20), (8,20), (10,20) |

### Dice number chips

| Chip | Coordinates (x,y)    |
|---   |---                   |
| 2    | (4,8)                |
| 3    | (7,5), (8,14)        |
| 4    | (6,8), (7,17)        |
| 5    | (3,11), (8,8)        |
| 6    | (5,5), (9,11)        |
| 7    | (7,11) — desert, initial robber position |
| 8    | (9,5), (5,17)        |
| 9    | (5,11), (11,11)      |
| 10   | (4,14), (10,8)       |
| 11   | (6,14), (9,17)       |
| 12   | (10,14)              |

The DESERT at (7,11) is the initial position of the robber. No resources are produced there and no chip payout occurs for 7.

## 8. Robber extension (Teilaufgabe 3, simplified)

When a 7 is rolled:

1. Every player with **more than 7** resource cards discards **half rounded down**, chosen randomly.
2. The current player **chooses a land field** (not water, not the robber's current field) and moves the robber there.
3. From all players (other than the current player) who have a settlement or city on a corner of that field, **one player is chosen randomly**. From that victim's hand, **one resource card is chosen randomly** and transferred to the current player. If no eligible victim or the victim has no cards, nothing is stolen.

As long as the robber sits on a land field, that field does not produce resources on its number.

## 9. Required public interface of `SiedlerGame`

From the Anleitung class diagram. This interface is fixed; the implementation behind it is yours.

```java
public class SiedlerGame {
    public SiedlerGame(int winPoints, int numberOfPlayers);

    public void switchToNextPlayer();
    public void switchToPreviousPlayer();
    public List<Config.Faction> getPlayerFactions();
    public SiedlerBoard getBoard();
    public Config.Faction getCurrentPlayerFaction();
    public int getCurrentPlayerResourceStock(Config.Resource resource);

    public boolean placeInitialSettlement(Point position, boolean payout);
    public boolean placeInitialRoad(Point roadStart, Point roadEnd);

    public Map<Config.Faction, List<Config.Resource>> throwDice(int diceValue);

    public boolean buildSettlement(Point position);
    public boolean buildCity(Point position);
    public boolean buildRoad(Point roadStart, Point roadEnd);

    public boolean tradeWithBankFourToOne(Config.Resource offer, Config.Resource want);

    public Config.Faction getWinner();

    // Robber extension
    public boolean placeThiefAndStealCard(Point field);
}
```

`Point` is `java.awt.Point`.

## 10. Config (allowed to define yourself, but shape fixed)

The `Config` class must expose at least:

- `MIN_NUMBER_OF_PLAYERS = 2`
- `MAX_CARDS_IN_HAND_NO_DROP = 7`
- `INITIAL_THIEF_POSITION = new Point(7, 11)`
- `INITIAL_RESOURCE_CARDS_BANK`: 19 of each resource
- `getStandardLandPlacement(): Map<Point, Land>` — returns the table in Section 7
- `getStandardDiceNumberPlacement(): Map<Point, Integer>` — returns the table in Section 7
- Enums: `Faction { RED, BLUE, GREEN, YELLOW }`, `Resource { GRAIN, WOOL, WOOD, STONE, CLAY }`, `Land { FOREST, MEADOW, GRAINFIELD, MOUNTAIN, CLAYSOIL, WATER, DESERT }`, `Structure { SETTLEMENT, CITY, ROAD }` (each with cost list and stock per player).

Stock per player: 15 roads, 5 settlements, 4 cities.

Costs:
- ROAD: WOOD, CLAY
- SETTLEMENT: WOOD, CLAY, WOOL, GRAIN
- CITY: GRAIN, GRAIN, STONE, STONE, STONE

## 11. Required JUnit 5 tests on `SiedlerGame`

At minimum, include and pass these three tests (names are required, behaviour is described in the Anleitung):

- `requirementPlayerSwitching` — exercises `switchToNextPlayer` and `switchToPreviousPlayer`.
- `requirementSetupTestBoardUsedWithTheTests` — verifies the fixed board layout matches Section 7.
- `requirementResourcePayoutAndReturnValueForDiceThrow` — verifies payout reporting from `throwDice`.

Add further tests at your discretion (structure placement, distance rule, build cost, 4:1 trade, victory condition, robber behaviour).

## 12. Constraints on allowed Java constructs

This is a first-semester Java project. To match the original student version's constraints:

- Permitted: everything up to and including BlueJ book chapter 12 (classes, inheritance, polymorphism, interfaces, exceptions, generics, collections).
- Permitted dependencies: `java.util.*`, `java.awt.Point`, `org.beryx.text-io` (TextIO), `ch.zhaw.hexboard`.
- **Not permitted**: Strategy pattern, stubs/mocks in production code, heavy use of streams or functional chains where a simple loop works, `java.time`/`java.nio.*`/reactive libraries, third-party dependencies beyond TextIO.
- Java 17 language level is allowed (as set in `pom.xml`) but prefer plain OO constructs over modern sugar.

## 13. Files you must not modify

The `ch.zhaw.hexboard` package under `src/main/java/ch/zhaw/hexboard/` is fixed library code distributed with the original assignment. Treat it as read-only. Use its public API:

- `HexBoard<F, C, E, A>` — parametric hex board with field, corner, edge and annotation payloads.
- `HexBoardTextView<F, C, E, A, B extends HexBoard<F, C, E, A>>` — text renderer.
- `Edge`, `Label`, `FieldAnnotationPosition` — supporting types.

Your `SiedlerBoard` should extend `HexBoard`; your `SiedlerBoardTextView` should extend `HexBoardTextView`.

## 14. Suggested user command set

Interactive console commands (names are suggestions from the original student implementations, not binding):

`DISPLAY_BOARD`, `DISPLAY_PLAYER_RESOURCES`, `DISPLAY_BANK_RESOURCES`, `DISPLAY_STRUCTURE_COSTS`, `DISPLAY_SCORES`, `BUILD_ROAD`, `BUILD_SETTLEMENT`, `BUILD_CITY`, `TRADE`, `NEXT_TURN`, `QUIT`.

For commands that take coordinates (BUILD_*), follow the Anleitung's advice: prompt for the command first, then for x, then for y, one at a time.

## 15. Deliverable

A buildable Maven project under `catan-ai/`:

- `mvn compile` passes.
- `mvn test` passes, including the three required tests from Section 11.
- A `main` method (e.g. in `App.java`) starts an interactive game.

## 16. On action failure

If a player's requested action cannot be executed (insufficient resources, placement rule violation, distance rule, etc.), it is enough to report that the action is not possible. The precise reason does not need to be surfaced.
