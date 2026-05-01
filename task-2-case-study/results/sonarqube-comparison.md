# SonarQube comparison: catan-ai vs catan-human

Run summary captured from the SonarQube project overview on **2026-05-01 12:34**.

Public dashboards:

- `catan-ai`: [SonarCloud overview](https://sonarcloud.io/project/overview?id=catan-ai)
- `catan-human`: [SonarCloud overview](https://sonarcloud.io/project/overview?id=catan-human)

This file documents the metrics visible in the run. Both the AI-side and human-side issue lists were captured from SonarQube screenshots, so the comparison below includes a concrete breakdown for both projects.

## Overview metrics

| Metric | AI (`catan-ai`) | Human (`catan-human`) |
|---|---|---|
| Quality gate | Passed | Passed |
| Lines of code | 1.6k | 2.0k |
| Languages | Java, XML | Java, XML |
| Security rating | A | A |
| Security issues | 0 | 0 |
| Reliability rating | D | C |
| Reliability issues | 3 | 1 |
| Maintainability rating | A | A |
| Maintainability issues | 16 | 9 |
| Security hotspots reviewed | 0.0% (E) | 0.0% (E) |
| Coverage | 0.0% | 0.0% |
| Duplications | 0.0% | 0.0% |

## Direct findings

- **No direct security signal.** SonarQube reported zero security issues on both projects. For this specific input, the scan says nothing interesting about vulnerabilities.
- **The AI version carries more static quality debt.** Despite being the smaller codebase by SonarQube's own LOC count, `catan-ai` has more reliability issues (3 vs 1) and more maintainability issues (16 vs 9).
- **The quality gate is too weak to separate them.** Both projects passed the configured gate even though the AI side has a `D` reliability grade and both sides have `0%` coverage. For this study, the badge is less informative than the category counts.

## AI-side issue breakdown

### Security hotspots

- **3 hotspots, all the same rule:** `java:S2245`, "Make sure that using this pseudorandom number generator is safe here."
- **Category:** Weak Cryptography
- **Review priority:** Medium
- **Interpretation:** for an offline Catan game, these are almost certainly benign uses of randomness rather than actual cryptographic risk. They still count as unreviewed hotspots, which is why the project shows `0.0%` hotspots reviewed.

### Reliability issues

| File | Line | Rule | Severity |
|---|---|---|---|
| `src/main/java/ch/zhaw/catan/SiedlerGame.java` | 167 | Save and re-use this `Random`. | Critical |
| `src/main/java/ch/zhaw/catan/SiedlerGame.java` | 416 | Save and re-use this `Random`. | Critical |
| `src/main/java/ch/zhaw/hexboard/HexBoardTextView.java` | 316 | Remove this conditional structure or edit its code blocks so they are not all the same. | Major |

Two of the three reliability findings come from the same anti-pattern in `SiedlerGame`: creating a new `Random` instead of reusing one. That is not a security bug, but it is exactly the kind of "works, but sloppy" finding you expect in rushed generated code.

### Maintainability issues

Most maintainability findings also cluster around `App.java` and `SiedlerGame.java`, with a long tail of minor cleanup suggestions.

| File | Line | Finding | Severity |
|---|---|---|---|
| `src/main/java/ch/zhaw/catan/App.java` | 20 | Cognitive complexity 33, allowed 15 | Critical |
| `src/main/java/ch/zhaw/catan/App.java` | 20 | "Brain Method" detected: LOC 105, complexity 26, nesting 4, variables 20 | Info |
| `src/main/java/ch/zhaw/catan/Bank.java` | 10 | Convert this `Map` to an `EnumMap` | Minor |
| `src/main/java/ch/zhaw/catan/Config.java` | 12 | Make this member `protected` | Minor |
| `src/main/java/ch/zhaw/catan/Player.java` | 16 | Convert this `Map` to an `EnumMap` | Minor |
| `src/main/java/ch/zhaw/catan/Player.java` | 50 | Convert this `Map` to an `EnumMap` | Minor |
| `src/main/java/ch/zhaw/catan/SiedlerGame.java` | 160 | Cognitive complexity 49, allowed 15 | Critical |
| `src/main/java/ch/zhaw/catan/SiedlerGame.java` | 160 | "Brain Method" detected: LOC 78, complexity 20, nesting 5, variables 33 | Info |
| `src/main/java/ch/zhaw/catan/SiedlerGame.java` | 161 | Convert this `Map` to an `EnumMap` | Minor |
| `src/main/java/ch/zhaw/catan/SiedlerGame.java` | 192 | Convert this `Map` to an `EnumMap` | Minor |
| `src/main/java/ch/zhaw/catan/SiedlerGame.java` | 194 | Reduce break/continue statements in this loop to at most one | Minor |
| `src/main/java/ch/zhaw/catan/SiedlerGame.java` | 215 | Convert this `Map` to an `EnumMap` | Minor |
| `src/main/java/ch/zhaw/catan/SiedlerGame.java` | 385 | Cognitive complexity 21, allowed 15 | Critical |
| `src/main/java/ch/zhaw/hexboard/HexBoardTextView.java` | 185 | Use `isEmpty()` to check whether a `String` is empty | Minor |
| `src/main/java/ch/zhaw/hexboard/HexBoardTextView.java` | 317 | Use multiple calls to `append` instead of string concatenation | Minor |
| `src/main/java/ch/zhaw/hexboard/HexBoardTextView.java` | 319 | Use multiple calls to `append` instead of string concatenation | Minor |

Three patterns dominate:

- **God-method pressure:** `App.java` and `SiedlerGame.java` trigger the serious complexity findings.
- **Representation shortcuts:** repeated `Map` to `EnumMap` suggestions point to generic containers where the domain is actually enum-shaped.
- **Small cleanup smells:** string handling, loop control, and visibility issues fill out the rest of the count.

## Human-side issue breakdown

### Security hotspots

- **1 hotspot:** `java:S2245`, "Make sure that using this pseudorandom number generator is safe here."
- **Category:** Weak Cryptography
- **Review priority:** Medium
- **Interpretation:** same story as on the AI side. For a local game this is almost certainly harmless PRNG usage, not a real cryptographic problem.

### Reliability issues

| File | Line | Rule | Severity |
|---|---|---|---|
| `src/main/java/ch/zhaw/hexboard/HexBoardTextView.java` | 316 | Remove this conditional structure or edit its code blocks so they are not all the same. | Major |

The human project has only one reliability finding, and it sits in the shared text-view helper area rather than in core game logic.

### Maintainability issues

| File | Line | Finding | Severity |
|---|---|---|---|
| `src/main/java/ch/zhaw/catan/game/App.java` | 157 | Define a constant instead of duplicating this literal `"for the "` 4 times | Critical |
| `src/main/java/ch/zhaw/catan/game/Config.java` | 31 | Make this member `protected` | Minor |
| `src/main/java/ch/zhaw/catan/game/Config.java` | 163 | Add `since` and/or `forRemoval` arguments to the `@Deprecated` annotation | Major |
| `src/main/java/ch/zhaw/catan/game/Config.java` | 164 | Do not forget to remove this deprecated code someday | Info |
| `src/main/java/ch/zhaw/catan/game/Player.java` | 147 | Add the `@Override` annotation above this method signature | Major |
| `src/main/java/ch/zhaw/catan/game/SiedlerGame.java` | 203 | Do not forget to remove this deprecated code someday | Info |
| `src/main/java/ch/zhaw/hexboard/HexBoardTextView.java` | 185 | Use `isEmpty()` to check whether a `String` is empty | Minor |
| `src/main/java/ch/zhaw/hexboard/HexBoardTextView.java` | 317 | Use multiple calls to `append` instead of string concatenation | Minor |
| `src/main/java/ch/zhaw/hexboard/HexBoardTextView.java` | 319 | Use multiple calls to `append` instead of string concatenation | Minor |

The human maintainability list is much less dramatic:

- **No cognitive-complexity findings** were visible in the screenshots.
- **No reliability issues in `SiedlerGame`** were flagged.
- Most findings are style, deprecation-hygiene, or small API-conformance issues.

That lines up with the structural comparison: the human codebase is larger, but it spreads logic across more classes and pays less of a "god method" penalty.

## Density read

If we normalize by SonarQube's own LOC figure:

- AI maintainability issues: about **10.0 per kLOC** (`16 / 1.6`)
- Human maintainability issues: about **4.5 per kLOC** (`9 / 2.0`)
- AI reliability issues: about **1.9 per kLOC** (`3 / 1.6`)
- Human reliability issues: about **0.5 per kLOC** (`1 / 2.0`)

That is a small-sample comparison, but the direction is clear: the AI implementation has more static-analysis findings even on the tool's more favorable size denominator.

## Interpretation for the case study

This SonarQube run partially supports the Task 1 claim that AI-generated code carries more quality debt than human-written code:

- **Supported on reliability and maintainability.** The AI implementation scores worse on reliability and has more maintainability findings, despite being smaller.
- **Not supported on direct security findings.** Both projects are effectively blank from a vulnerability perspective. That is unsurprising for two offline Java student projects with tiny dependency surfaces and no real secret-handling path.

So the honest read is not "AI code is visibly less secure here." The honest read is narrower: **on this assignment, SonarQube sees more static bug and smell pressure in the AI version, but no meaningful security delta.**

More specifically, the AI-side findings match the structural comparison almost embarrassingly well:

- the flattish architecture pushes logic into oversized methods
- `SiedlerGame` becomes the hotspot for both maintainability and reliability findings
- the warnings are mostly about rushed implementation shape, not deep algorithmic failure

The human-side list points the other way:

- its smells are real, but mostly low-grade cleanup and API-usage debt
- the single reliability issue is isolated
- the scan does not show the same concentration of complexity debt in core gameplay methods

## Important caveats

- SonarQube's LOC figure is **not** the same baseline as `structural-comparison.md`. SonarQube reports project-level Java/XML code size, while the structural comparison intentionally excludes the shared `ch.zhaw.hexboard` library and separates test vs main source.
- SonarQube does **not** validate game-rule correctness. It cannot tell whether the AI's choices around road placement, robber handling, or founding-phase interpretation are semantically right.
