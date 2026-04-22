# One-shot generation prompt — Catan (AI version)

This file is the **exact prompt** used to generate the `catan-ai/` implementation. It is preserved verbatim so the experiment is reproducible and so Task 2 has the reflection material it needs.

To reproduce: start a fresh Claude Code (Opus) session with the working directory set to `task-2-case-study/implementation/catan-ai/`, paste the prompt below as the first and only user message, and let the agent run to completion without any further interaction.

---

## Prompt

You are generating a text-based Java implementation of *Siedler von Catan* as a one-shot exercise. I will not interact with you again during this session — everything you produce is the final artefact. Work agentically: read, plan, write code, compile, test, fix, iterate until the project builds and tests pass.

### Inputs you must read

- `../../spec/PM1 Projekt 3 Anleitung.pdf` and `../../spec/PM1 Projekt 3 Kick-Off.pdf` — the **original assignment handouts** as given to the first-semester students. German. **These are the authoritative specification.** Read them in full. They contain visual material that markdown cannot fully capture: the turn flowchart (Anleitung p.3), the class diagram of the provided scaffold (p.4), and the board with coordinate grid (p.8).
- `../SPEC.md` — a supplementary English consolidation produced by our team to pin scope decisions (we are implementing Teilaufgabe 1 + 2 + 3 with the Robber variant; victory at 7 points) and to tabulate the fixed board coordinates in a form easier to code against. **In case of any conflict between SPEC.md and the PDFs, the PDFs win.**
- `src/main/java/ch/zhaw/hexboard/` — the fixed third-party library provided with the original assignment. **Do not modify any file in this package.** Read the source to understand the API you must use.
- `pom.xml` — the Maven build. Dependencies are already wired (JUnit 5, TextIO). Do not add new dependencies.

### Inputs you may NOT use

- **No web searches.** Do not look up Catan rules online, do not consult other implementations, do not search for "Java Catan github" or similar. The spec is the spec.
- **No other filesystem reads outside this folder and its parent.** In particular, there is a sibling folder `../catan-human/` containing another Catan implementation. Do **not** read, open, list, or otherwise consult it. The whole point of this experiment is that you produce the game independently from the spec.
- **No additional Maven dependencies.** Use only `java.util`, `java.awt.Point`, the TextIO library already in `pom.xml`, and the `ch.zhaw.hexboard` package.

### What to build

Everything described in SPEC.md: Teilaufgabe 1 (base game, 18 P), Teilaufgabe 2 (cities via inheritance, 5 P), and Teilaufgabe 3 robber extension (7 P). Target is a buildable Maven project where `mvn compile` and `mvn test` both succeed, including the three required tests named in SPEC.md Section 11.

### How to work

1. **Read SPEC.md end to end.** Then read the hexboard package to understand `HexBoard`, `HexBoardTextView`, `Edge`, `Label`, `FieldAnnotationPosition`.
2. **Plan a class structure** before writing code. At minimum you will need `Config`, `SiedlerBoard extends HexBoard<...>`, `SiedlerBoardTextView extends HexBoardTextView<...>`, `SiedlerGame` (implementing the public interface in Section 9), some representation of `Player` and `Bank`, and an `App`/`Main` entry point with the TextIO command loop. Structure-of-structures (settlement/city/road) is up to you — inheritance is required for cities per Teilaufgabe 2.
3. **Write the code**, respecting the allowed-constructs constraint in SPEC.md Section 12. Treat the ch.zhaw.hexboard package as read-only.
4. **Run the build**: `mvn -q -DskipTests compile` to catch compilation errors. Fix them. Then `mvn -q test`. Fix failing tests by fixing your implementation, not by weakening the tests.
5. **Do not polish.** Do not refactor for elegance beyond what the spec requires. Do not add features beyond Teilaufgabe 1+2+3. Do not add logging frameworks, CLI libraries, or defensive validation beyond what the spec requires. The experiment is comparing AI generated code to first-semester student code, so restraint is part of fidelity.
6. **Do not ask me questions.** Make decisions, document them briefly in `GENERATION_LOG.md` (see below), keep going.

### When you finish

Before ending the session, write `GENERATION_LOG.md` in this folder containing, tersely:

- Total wall-clock time for the session.
- Final file list (main + test), with line counts.
- `mvn compile` status, `mvn test` status, count of passing tests.
- The three to five most consequential design decisions you made (one line each), e.g. "Represented corners as `Point` keys on a HashMap in SiedlerBoard", "Chose random.nextInt for robber victim selection to keep determinism out of SiedlerGame", etc.
- The three to five things you are least confident about — rule interpretations you guessed, edge cases you didn't test, places a grader might push back. Be honest; this is feedback material for the human reviewer, not marketing copy.

Do **not** write a README, a tutorial, or any marketing-style documentation. GENERATION_LOG.md is the only reflection artefact.

### Definition of done

- `mvn compile` exits 0.
- `mvn test` exits 0 with at least the three required tests from SPEC.md Section 11 passing.
- No files modified in `src/main/java/ch/zhaw/hexboard/`.
- `GENERATION_LOG.md` exists and is filled in per the template above.

Begin.
