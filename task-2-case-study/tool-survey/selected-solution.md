# Selected tool

## Choice

**SonarQube** (community edition, run locally against the Maven build).

## Why this tool

SonarQube is a static code analysis tool with first-class Java support, a Maven plugin, and rule packs covering bugs, code smells, security hotspots, vulnerabilities, duplication, and complexity. It is the right shape for an offline Java Maven codebase like Catan, where we compare two finished artefacts rather than a live development workflow.

That workflow distinction is the real reason it won. The GitHub-stack alternatives we benched are mostly strong when a repository is moving:

- Dependabot and Dependency Review need dependency change events.
- Copilot code review needs a PR diff.
- Secret Protection needs an actual secret exposure surface.

Our case study has none of that. It is two static code snapshots. For that, SonarQube is the more honest tool.

## What was discarded and why

See [`solutions-analysis.md`](solutions-analysis.md) for the full GitHub-stack capability table. Summary of why each was discarded for the Catan case study:

- **Dependabot:** the Catan POM has only TextIO and JUnit; nothing to flag.
- **GitHub Advanced Security / CodeQL:** strong, and the closest runner-up. We still picked SonarQube because this study is not just about vulnerabilities. Reliability and maintainability matter too, and SonarQube exposes those directly in one scan.
- **Secret Protection:** Catan has no credentials or tokens.
- **Copilot code review:** designed for PR diffs; the catan-ai code is a single shipped artefact, not a PR.
- **Dependency Review:** also PR-diff oriented; no PR.

## Known gaps

SonarQube measures static properties: bugs, smells, duplication, complexity, security hotspots in code shape. It does **not** measure rule-of-the-game correctness, so it will not catch the five interpretation uncertainties Claude self-flagged in `../implementation/catan-ai/GENERATION_LOG.md` (founding road connectivity, founding bank depletion, road extension through opponents, 7-roll discard distribution, text view fidelity). Those need human review or behavioural tests, not static analysis. The reported finding counts must also be read alongside the size asymmetry documented in `../results/structural-comparison.md` — the AI side is 40% the size of the human side, so a smaller raw count is not automatically better.

The actual run confirmed the expected tradeoff. SonarQube produced useful reliability and maintainability differences between the two codebases, but it produced no direct security findings on either side. That is not a failure of the tool; it is a property of the input. Small offline student Java projects simply do not expose much for secret or vulnerability-oriented tooling to bite on.
