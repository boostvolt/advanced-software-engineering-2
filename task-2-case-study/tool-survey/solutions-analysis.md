# Tool survey: candidate analysis solutions

We evaluated GitHub's security stack against a small Node.js bench project, then selected one tool to apply to both Catan implementations. The real decision was not "which tool is best overall?" but "which tool is the right shape for comparing two already-existing Java Maven codebases?"

That distinction matters. Most GitHub-native security features are strongest inside a development workflow:

- pull requests and diffs
- dependency manifest changes
- secret leaks in commits or history

Our Catan case study is not that. We are comparing two static snapshots of the same assignment, one human-written and one Claude Opus generated. That setup strongly favors a static analyzer over workflow-driven tooling.

## Capability fit for the case study

| Tool | What it finds | Best input surface | Why it is weak or strong for Catan | Verdict |
|---|---|---|---|---|
| Dependabot | Known vulnerabilities in declared dependencies | `pom.xml`, `package.json`, lockfiles | Good at dependency hygiene, but our Catan projects have tiny dependency surfaces and the study is about code quality/security in the code itself, not update automation. | Discarded |
| GitHub Advanced Security / CodeQL | Static analysis findings from query packs | Repository source code | Strongest GitHub-native alternative because it can analyze Java source directly. Still, SonarQube is a better fit here because it exposes maintainability and reliability signals alongside security, which matters more than pure vulnerability scanning in a small student-project comparison. | Runner-up |
| Secret Protection | Exposed tokens, API keys, credentials | Commit history, diffs, repository contents | Wrong surface. The Catan projects are offline Java games with no real credentials or tokens. A zero-result here would say more about the input than the code quality. | Discarded |
| Copilot code review | AI review comments and suggestions | Pull request diff | Wrong workflow. We are not reviewing an active PR but two finished codebases. This would test Copilot's review UX, not the artefacts themselves. | Discarded |
| Dependency Review | Vulnerable dependencies newly introduced by a PR | Pull request diff of manifest and lockfile changes | Same problem as Copilot review: it is a PR guardrail, not a static comparison tool for already-existing repositories. | Discarded |
| SonarQube | Static code analysis across bugs, code smells, hotspots, duplication, complexity | Full Java Maven project | Best fit for two static Java snapshots. It runs directly on the built project and produces comparable bug/reliability/maintainability output without needing a PR, a secret leak, or a dependency change. | Selected |

## Why the Node.js bench still mattered

The bench project existed to give each GitHub tool a fair shot on an input where it could actually trigger. Without that, Secret Protection or Dependency Review would look useless simply because Catan is the wrong target.

Bench design:

- one outdated dependency with a known CVE for Dependabot and Dependency Review
- one hardcoded API key for Secret Protection
- one obvious code-level bug or security pattern for CodeQL
- one open pull request for Copilot code review

The bench answers "can this tool do anything useful at all?" The Catan run answers the narrower course question: which tool still produces useful comparison signal on two static Java implementations of the same assignment?

## Selection criterion for Catan

Among tools that can still say something non-trivial about a small offline Java Maven codebase, which one is strongest? Catan has:

- no meaningful network-facing attack surface
- almost no third-party dependencies
- no secrets
- no active PR diff

That immediately weakens Dependabot, Secret Protection, Copilot review, and Dependency Review. CodeQL remains viable, but SonarQube gives the broader signal this case study actually needs: whether the AI implementation carries more static quality debt than the human one.

## Outcome

See `selected-solution.md`.
