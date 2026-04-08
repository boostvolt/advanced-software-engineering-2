# Key Challenges

The challenges below are grouped into four clusters: code quality, security, process (review), and organizational/ecosystem. Each challenge links to evidence from 2025–2026 literature reviewed in `literature-review.md`.

---

## 1. Code Quality Challenges

### 1.1 AI-induced technical debt
AI assistants optimize for producing plausible code, not maintainable code. GitClear's 2025 study reports a 4x rise in cloned code blocks and a collapse in refactoring activity — "moved" lines dropped from 24.1% of changes (2020) to 9.5% (2024). Code churn within two weeks of authoring rose from 5.5% to 7.9% over the same period. The net effect is that AI shifts cost forward: fast today, expensive to maintain tomorrow.

### 1.2 Copy-paste culture and lost refactoring discipline
Because suggestions are generated per-context and per-file, assistants rarely propose extracting a shared abstraction. Developers accept what the tool offers instead of refactoring an existing helper. The long-term effect is measurable: duplication rises, and the proportion of code that gets improved (rather than added or rewritten) falls.

### 1.3 Larger, harder-to-review changes
AI-authored pull requests are on average **18% larger** and touch more architectural surfaces than human-only PRs [Faros 2025]. Larger PRs correlate with lower defect-detection rates in review — a well-established pre-AI finding now amplified by a systematic increase in PR size.

### 1.4 Quality signals that do not catch the problem
Traditional CI signals — tests pass, types check, linters green — are poor detectors of the specific failure modes AI code introduces (subtle duplication, shallow abstractions, fabricated API calls, plausible-but-wrong logic). Teams that rely on "green build = good code" are systematically missing the debt AI adds.

---

## 2. Security Challenges

### 2.1 High baseline vulnerability rate in generated code
Veracode's 2025 GenAI Code Security Report (100+ LLMs, 4 languages) finds **45% of AI-generated code contains at least one high-severity vulnerability**. Java fails security tests 72% of the time; XSS defenses are missing in 86% of relevant samples. The rate has been statistically **flat since 2022** despite model scale increases — bigger models are not safer models.

### 2.2 Vulnerability density in AI co-authored PRs
Snyk's pull-request data finds AI co-authored PRs contain **2.74x more vulnerabilities** than human-only PRs. CodeRabbit's analysis of 470 PRs found 10.83 issues per AI PR vs 6.45 per human PR, with critical issues up ~40% and major issues up ~70%.

### 2.3 Hallucinated dependencies and "slopsquatting"
Models frequently invent package names that don't exist. Attackers have begun registering those hallucinated names as malicious packages, waiting for AI-assisted developers to install them. This is a new supply-chain attack vector that did not exist before AI adoption.

### 2.4 Supply-chain amplification
AI-assisted development encourages pulling in transitive dependencies quickly and with minimal scrutiny. When a trusted package is compromised — the **axios npm compromise of March 2026** being the canonical recent example — AI-accelerated codebases inherit the poison faster and across more projects than pre-AI development would have allowed.

### 2.5 Secret and credential leakage
AI agents with shell and file-system access introduce a new attack surface: control interfaces, API tokens, and chat logs exposed on the public internet. The Clawdbot / Moltbot / OpenClaw incident (late 2025 – early 2026) exposed 1.49 million database records and hundreds of openly accessible control interfaces [Axios; Bitdefender].

### 2.6 Flat-curve security performance
The most uncomfortable finding in the Veracode data: **security performance has not improved with model scale**. Every generation of larger models writes more functional code but the same insecure code. This decouples "the models will fix it" optimism from the observed trend line.

---

## 3. Code Review Process Challenges

### 3.1 The inverted bottleneck
Review capacity is now the binding constraint. Faros AI measured **98% more PRs merged** alongside **91% more review time per PR**. Teams that don't restructure review fall behind — AI makes their intake grow, not their throughput.

### 3.2 Asymmetric effort
Generating a PR with AI takes minutes. Reviewing it thoroughly takes hours. The developer-maintainer power asymmetry has inverted: contributors can now out-produce reviewers by two orders of magnitude. This is especially toxic in open-source, where reviewers are unpaid.

### 3.3 Reviewer fatigue and shallow review
Faced with unmanageable volume, reviewers default to shallow checks (style, obvious bugs, CI status) and miss the subtler issues AI introduces. This is the mechanism by which the Veracode 45% vulnerability figure reaches production.

### 3.4 AI-on-AI review circularity
A popular response is to use AI to review AI-generated code. This helps at the surface level (linting, style, obvious security anti-patterns) but produces a circularity problem: the same blind spots that cause generation errors show up in review, and neither layer meaningfully catches the other's mistakes.

---

## 4. Organizational and Ecosystem Challenges

### 4.1 Open-source maintainer burnout
60% of OSS maintainers are unpaid volunteers. The flood of low-quality AI contributions ("AI slop") has pushed several high-profile projects to extreme responses: curl closed its bug bounty program (valid rate ~5%), Ghostty banned AI contributions outright, and GitHub is evaluating a pull-request "kill switch". Ecosystem-level interventions (OpenSSF, Alpha-Omega) are being funded at $12.5M to address the problem.

### 4.2 Accountability and ownership
When AI writes code and a human merges it, who is responsible for a resulting vulnerability? Current legal, organizational, and engineering processes do not have a shared answer. The Veracode report frames this as an unresolved governance question.

### 4.3 Uneven amplification effects
The 2025 DORA report's central finding: **AI amplifies what is already there**. Mature teams with strong review, testing, and platform practices use AI productively. Struggling teams accumulate debt and vulnerabilities faster than before. This means "is AI good for code?" has no universal answer — the answer depends on the preconditions of the team adopting it.

### 4.4 Tooling gap
AI-aware SAST, AI-specific linting, and AI-authored-change policy gates exist but are immature. No single tool closes the gap documented by Veracode or GitClear. Investigating what works is the core purpose of Task 2.

---

## Summary: the four challenges we will carry into Task 2
1. **Quality drift** — AI code increases duplication and churn; refactoring discipline erodes.
2. **Flat-curve vulnerability rate** — ~45% of AI code has high-severity vulnerabilities, unchanged across model generations.
3. **Review as the new bottleneck** — volume outgrows review capacity; shallow review becomes the norm.
4. **Ecosystem stress** — OSS maintainers and shared supply chains absorb the highest cost.

These four define the gap we will measure and, in Task 2, attempt to close (or at least narrow) with a concrete solution applied to a FOSS case study.
