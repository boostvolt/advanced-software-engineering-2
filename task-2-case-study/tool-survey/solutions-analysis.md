# Tool survey: GitHub security stack

We evaluate five GitHub security tools against a small Node.js bench project, then select one to apply to both Catan implementations. Selection criterion: among tools that actually produce findings on a Java codebase like Catan, which is strongest.

## Capabilities

| Tool | What it finds | Input scope | Output format | Java support | Cost |
|---|---|---|---|---|---|
| Dependabot | Known vulnerabilities in declared dependencies | `pom.xml` / `package.json` / other manifests | GitHub security alerts plus auto update PRs | *[verify on bench]* | Free on public repos |
| Code Security (CodeQL) | Static analysis findings from query packs | Repository source code | SARIF plus code scanning alerts | *[verify on bench]* | Free on public repos |
| Secret Protection (Secret Scanning) | Exposed tokens, API keys, credentials | Commit history and diffs | Secret alerts | Language agnostic | Free on public repos |
| Copilot code review | AI generated review comments and suggestions | Pull request diff | Inline PR comments | Language agnostic | Requires Copilot subscription |
| Dependency Review | New or modified vulnerable dependencies in a PR | PR diff of manifests and lockfiles | PR status check | *[verify on bench]* | Free |

## Node.js bench

A small Node.js project with intentional issues so each tool has something to detect:

- One outdated dependency with a known CVE (for Dependabot and Dependency Review)
- One hardcoded API key in a config file (for Secret Protection)
- One SQL injection or XSS pattern (for Code Security)
- One open pull request for Copilot code review to comment on

For each tool, record: finding count, time to first finding, false positives, output format.

Bench location: *[to be added]*.

## Selection criterion

Among tools that actually produce findings on a Java codebase like Catan, which is strongest. Catan is an offline Java Maven game with no network calls, minimal external dependencies, and no user supplied secrets, so tools that need a specific input surface may produce zero findings on it. The Node.js bench is what lets us evaluate the tools fairly before applying one to Catan.

## Outcome

See `selected-solution.md`.
