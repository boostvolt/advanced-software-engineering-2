# Structural comparison: catan-human vs catan-ai

Pre-scan baseline. Counts exclude the shared `ch.zhaw.hexboard` library (identical in both trees).

## Main source

| Metric | Human (boostvolt) | AI (Claude Opus) | Ratio |
|---|---|---|---|
| Files | 17 | 9 | 1.9x |
| LOC | 2,718 | 1,108 | 2.5x |
| Avg LOC per file | 160 | 123 | — |
| Largest file | `SiedlerGame` 518 | `SiedlerGame` 435 | — |

## Tests

| Metric | Human | AI | Ratio |
|---|---|---|---|
| Files | 12 | 1 | 12x |
| LOC | 2,060 | 260 | 7.9x |
| Test-to-main LOC ratio | 0.76 | 0.23 | — |

## Package organisation

- **Human:** three subpackages (`board/`, `game/`, `structure/`). Abstract `Structure` base class with `Settlement`, `City`, `Road` extending it.
- **AI:** one flat package (`catan/`). No `Structure`, no `Road`, no `Field`, no `Activity`, no `DiceResult`, no `InventoryOwner`. Settlement and City form the only inheritance chain.

## Notable gaps in the AI version

- **No `Road` class.** Roads are represented as two-character strings on hex edges (e.g. `"RR"`, `"BB"`). The human version has a full `Road extends Structure` class.
- **No abstract `Structure` base.** `City extends Settlement` directly rather than both extending a common `Structure`. Satisfies the Teilaufgabe 2 inheritance requirement on the letter but not on the spirit.
- **One test file versus twelve.** The AI's eight passing tests cover the three required `requirement*` cases plus five additional ones. The human version has dedicated test classes for each major component (`BankTest`, `PlayerTest`, `RoadTest`, `CityTest`, `SettlementTest`, two `SiedlerGameTest` variants, etc.).
- **Self-reported edge cases.** `GENERATION_LOG.md` lists five rule interpretations the AI guessed at (founding-phase road connectivity, bank depletion during founding payout, road extension through opponent structures, 7-roll discard distribution, text view fidelity). These are plausible grader-push-back points.

## Implications for the scan phase

- The AI codebase has less surface for static analysis tools to find issues in. Smaller is not automatically better but it is smaller. Scan finding counts must be read alongside the size asymmetry, not normalised against it.
- Most logic concentrates in `SiedlerGame` (435 of 1,108 LOC, roughly 39%). Tools that flag "class too large" or "god object" may behave differently on the AI version.
- Coverage tools (JaCoCo or similar) will show a wide gap by LOC. This is worth running even if CodeQL or Dependabot report little.

## Reading against Task 1 claims

The structural asymmetry lines up with the Task 1 thesis:

- **Quality drift.** GitClear's "4x growth in cloned code blocks" and the shift from refactoring to copy/paste appear here as missing abstraction depth: no `Structure` base, no `Road` class, one flat package.
- **Security baseline.** Independent of any scan output, the thinner test coverage (0.23 vs 0.76) narrows the surface on which the AI version is self-validated.
- **Review bottleneck.** The AI produced a runnable 30-point implementation in roughly 10 minutes of wall-clock time. The human team's commit history spans weeks. The asymmetry in production speed relative to verification speed is exactly what the Task 1 motivation frames as the problem.
