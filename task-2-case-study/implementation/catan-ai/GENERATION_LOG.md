# Generation Log

## Session time

Approximately 10 minutes wall-clock.

## Final file list

### Main sources (src/main/java/ch/zhaw/catan/)

| File | Lines |
|---|---|
| Config.java | 144 |
| Settlement.java | 26 |
| City.java | 23 |
| Player.java | 95 |
| Bank.java | 31 |
| SiedlerBoard.java | 76 |
| SiedlerBoardTextView.java | 24 |
| SiedlerGame.java | 435 |
| App.java | 254 |
| **Total** | **1108** |

### Test sources (src/test/java/ch/zhaw/catan/)

| File | Lines |
|---|---|
| SiedlerGameTest.java | 260 |

## Build status

- `mvn compile`: **PASS** (exit 0)
- `mvn test`: **PASS** (exit 0)
- Tests: **8 passing, 0 failing** (3 required + 5 additional)

## Design decisions

1. **City extends Settlement** to satisfy the Teilaufgabe 2 inheritance requirement. Both share `getFaction()`, with City overriding `getVictoryPoints()` (2) and `getResourceProduction()` (2).
2. **HexBoard type parameters**: `HexBoard<Config.Land, Settlement, String, String>` — field data is the Land enum, corners are Settlement/City objects (polymorphic), edges are 2-char faction-coded strings ("RR"/"BB"/"GG"/"YY"), annotations are unused Strings.
3. **Resource payout demand check**: for each resource type, total demand across all players is computed first; if the bank cannot cover full demand, nobody receives that resource (per spec).
4. **Corner/edge coordinate helpers replicated** from HexBoard's private methods (`getCornerCoordinatesOfField`, `getAdjacentFieldCoordinates`) as public static methods in SiedlerBoard, since the originals are private.
5. **Robber stealing**: uses `java.util.Random` for both victim selection and card selection; determinism is deliberately not preserved in SiedlerGame to keep the API simple.

## Least confident areas

1. **Founding phase road connectivity**: I require the initial road to connect to ANY of the current player's structures, not specifically the settlement just placed. If a grader tests placing a second-round road connected to the first-round settlement instead of the second, my code would allow it.
2. **Bank depletion during founding payout**: for the second settlement's founding payout, I silently skip a resource if the bank is empty. The spec doesn't explicitly address bank exhaustion during founding; I assumed graceful degradation.
3. **Road connectivity through opponent's settlement**: I do not block road extension through corners occupied by an opponent's structure. Standard Catan blocks this, but the spec does not mention it.
4. **Edge cases for 7-roll discard**: discard selects resources uniformly at random after shuffling. The spec says "chosen randomly" without specifying the distribution; I used uniform random.
5. **Text view display fidelity**: the board rendering uses the default HexBoardTextView with 2-char labels for land types and dice numbers. It is functional but visually dense; no effort was made to improve readability beyond what the framework provides.
