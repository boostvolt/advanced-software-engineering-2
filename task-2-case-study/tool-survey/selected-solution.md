# Selected tool

## Choice

**SonarQube** (community edition, run locally against the Maven build).

## Why this tool

SonarQube is a static code analysis tool with first-class Java support, a Maven plugin, and rule packs covering bugs, code smells, security hotspots, vulnerabilities, duplication, and complexity. It is the right shape for an offline Java Maven codebase like Catan, where the GitHub-stack alternatives we benched (Dependabot, CodeQL, Secret Protection, Copilot code review, Dependency Review) had little to find: no third-party dependencies beyond TextIO, no network calls, no secrets, no PR diff to review.

## What was discarded and why

See [`solutions-analysis.md`](solutions-analysis.md) for the full GitHub-stack capability table. Summary of why each was discarded for the Catan case study:

- **Dependabot:** the Catan POM has only TextIO and JUnit; nothing to flag.
- **Code Security (CodeQL):** strong, but SonarQube's rule pack covers the same Java surface plus quality and duplication signals we want for the human-vs-AI angle.
- **Secret Protection:** Catan has no credentials or tokens.
- **Copilot code review:** designed for PR diffs; the catan-ai code is a single shipped artefact, not a PR.
- **Dependency Review:** also PR-diff oriented; no PR.

## Known gaps

SonarQube measures static properties: bugs, smells, duplication, complexity, security hotspots in code shape. It does **not** measure rule-of-the-game correctness, so it will not catch the five interpretation uncertainties Claude self-flagged in `../implementation/catan-ai/GENERATION_LOG.md` (founding road connectivity, founding bank depletion, road extension through opponents, 7-roll discard distribution, text view fidelity). Those need human review or behavioural tests, not static analysis. The reported finding counts must also be read alongside the size asymmetry documented in `../results/structural-comparison.md` — the AI side is 40% the size of the human side, so a smaller raw count is not automatically better.
