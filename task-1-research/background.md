# Background notes: topic, motivation, challenges, use cases

Internal working document. Raw material the team can pull from when writing the Task 3 short report in May. Do not submit. The polished short version we are handing in for Task 1.3 lives in `draft-submission.md`. Source list lives in `literature-review.md`.

---

## 1. Topic and Scope

### Title
**The Effects of AI Assisted Software Engineering on Code Quality and Security in Real World Projects**

### Scope
We investigate how mainstream AI coding assistants (GitHub Copilot, Cursor, Claude Code, ChatGPT, autonomous agents) are reshaping two interdependent properties of production software:

1. **Code quality**: maintainability, duplication, churn, refactoring discipline, technical debt.
2. **Code security**: rate and class of vulnerabilities in AI generated or AI co authored code, and the downstream blast radius.

The unifying thread is the **shift of the bottleneck from code production to code review**. AI has lowered the cost of writing code to almost zero. It has not lowered the cost of verifying that the code is correct, maintainable, or secure. The gap between what is generated and what is trustworthy is the space we want to explore.

### Research questions
1. How does AI assisted generation affect measurable code quality signals (churn, duplication, refactoring, technical debt) in real repositories?
2. What vulnerability patterns are introduced or amplified by AI assistants?
3. How are code review processes and open source maintainers adapting (or failing to adapt) to the volume of AI generated contributions?
4. Which existing tools meaningfully close the quality and security gap, and where do they still fall short?

### Out of scope
Generic productivity claims, training data ethics, prompt engineering, model architecture.

### Team
Dao Trong-Nghia (daotro01) · Mata Marco (matamar) · Galindo Lopez Pablo Emiliano (galinpab)

---

## 2. Motivation

The 2025 DORA report finds that **around 90% of software professionals now use AI in their daily work**, spending a median of about two hours per day with it. The question is no longer "should we adopt AI assistants" but "what is the true cost of the code they produce, and can our review and security processes keep up". Three forces make this question urgent.

### 2.1 The code review bottleneck is the new dominant constraint
Faros AI's 2025 analysis of more than 10,000 developers measured an **+98% increase in PR volume** alongside a **+91% increase in review time per PR**, with PRs around 18% larger on average. LeadDev's quoted economics: "it takes a reviewer **12 times longer** to review and correct a pull request than to generate one with AI." When the cost of producing code drops to almost zero and the cost of evaluating it stays constant, the evaluator becomes the limiter.

### 2.2 AI generated code carries measurable quality and security debt
- **Quality.** GitClear (2025), based on 211 million changed lines from 2020 to 2024 across Google, Microsoft, Meta and enterprise repos, reports a **4 times increase in code clones**, with copy and paste exceeding refactoring ("moved" lines) for the first time. Two week churn rose from 5.5% to 7.9%. Bill Harding's term: **"AI induced tech debt"**.
- **Security.** Veracode's 2025 GenAI Code Security Report (more than 100 LLMs across Java, JavaScript, Python and C#) finds that **around 45% of AI generated code contains at least one high severity vulnerability**, with Java failing 72% of security tasks and XSS defenses missing in 86% of relevant samples. The same report finds that **AI generated code carries 2.74 times more vulnerabilities** than human written code. Crucially, security performance has been **flat since 2022** even as model size has grown massively. Bigger models are not safer models.

### 2.3 Open source maintainers are being overrun
60% of open source maintainers are unpaid volunteers. The "AI slop" flood has driven extreme responses: **curl** closed its bug bounty program (valid report rate around 5%), **Ghostty** banned AI generated contributions outright, and **GitHub** is reportedly evaluating a pull request "kill switch". OpenAI, Anthropic, AWS, Google, Microsoft and GitHub have together pledged $12.5M to OpenSSF and Alpha Omega to address slop bug reports.

### 2.4 Why this matters to us
We have each shipped AI output that looked correct in the moment and was caught too late by reviewers, linters, or tests. The driving question is therefore concrete: **what does it actually take to make AI assisted development safe and maintainable, and are the tools we have today enough?** The 2025 DORA report's central finding shapes our framing: *AI amplifies what is already there*. Strong teams improve, weak teams degrade faster than before. Our contribution is to study where that amplification tips into damage, and which interventions meaningfully change the slope.

---

## 3. Key Challenges

Four clusters, each with the two or three challenges that carry the strongest evidence in 2025 and 2026 literature.

### 3.1 Code Quality

**Quality drift / "AI induced tech debt".** Cloning up 4 times. Refactoring down from 24.1% (2020) to 9.5% (2024) of changes. Two week churn up from 5.5% to 7.9% (GitClear 2025). AI optimises for plausible code, not maintainable code.

**Larger, harder to review changes.** AI authored PRs are on average **18% larger** than human only PRs and touch more architectural surfaces (Faros 2025). Larger PRs correlate with lower defect detection in review, a finding that pre dates AI but is now systematically amplified.

**Quality signals miss the failure mode.** Tests pass, types check, linters are green. None of those detect duplication, shallow abstractions, fabricated APIs, or plausible but wrong logic. Teams that trust "green build = good code" miss the debt AI adds.

### 3.2 Code Security

**Around 45% high severity vulnerability rate, statistically flat since 2022.** Veracode 2025 (more than 100 LLMs across Java, JavaScript, Python and C#): Java fails 72% of security tasks. XSS defenses are missing in 86% of relevant samples. Bigger and newer models are not safer.

**2.74 times more vulnerabilities in AI generated code than human written code.** Veracode 2025 GenAI Code Security Report. CodeRabbit's 470 PR study reports critical issues up around 40% and major issues up around 70%.

**Supply chain amplification and slopsquatting.** AI assistants pull dependencies with minimal scrutiny, so compromised packages spread faster. Models also hallucinate package names and attackers register them. The axios npm compromise (March 2026) and the Clawdbot / OpenClaw incident illustrate the two ends of this spectrum (see §4).

### 3.3 Code Review Process

**The inverted bottleneck.** PR volume +98%, per PR review time +91% (Faros 2025). Teams that do not restructure review get *slower*, not faster.

**Asymmetric effort.** Generating a PR with AI takes minutes. Reviewing it thoroughly takes hours. The **12 times asymmetry** (LeadDev 2025). Especially toxic in open source where reviewers are unpaid.

**Reviewer fatigue, then shallow review.** Under volume pressure reviewers default to style and CI checks and miss the subtler issues. This is the mechanism by which Veracode's 45% baseline reaches production.

### 3.4 Organisational and Ecosystem

**Open source maintainer burnout.** 60% of maintainers are unpaid volunteers. Recent extreme responses: curl closed its bug bounty (valid report rate around 5%). Ghostty banned AI generated contributions. GitHub is evaluating a pull request "kill switch". $12.5M industry pledge to OpenSSF and Alpha Omega for slop triage.

**Uneven amplification.** The 2025 DORA report's central finding: **AI amplifies what is already there**. Strong teams improve. Weak teams degrade faster. There is no universal answer to "is AI good for code".

**Tooling gap.** AI aware static analysis and AI specific code review tools exist but are still immature. No single tool closes the documented gap on its own. That gap is what Task 2 will probe.

---

## 4. Use cases from industry

Two real-world cases that we use in the draft and will carry into the short report. Both directly implicate AI-assisted development.

### 4.1 Clawdbot / Moltbot / OpenClaw (Nov 2025 – Feb 2026) — *primary*

Open-source autonomous AI agent framework published by Peter Steinberger in November 2025. In the last week of January 2026 it reached **149,000 GitHub stars**, was renamed twice in four days (Anthropic trademark complaint → "Moltbot" → "OpenClaw"), and during the rename window crypto scammers hijacked the GitHub organisation and X handle in the ~10-second gap. The cascade exposed **1.49 million database records**, enabled an **$8M crypto scam**, and — as *Axios* reported and Bitdefender confirmed — left hundreds of control interfaces accessible on the public internet, exposing chat logs, API keys, and remote command execution.

**Why it matters.** Compresses all four challenge clusters into a single week: insecure-by-default AI-generated agent code, a review bottleneck no process could absorb at 149k stars/week, a novel supply-chain dimension (an *agent* is code that executes code — downstream users inherit an active execution environment), and ecosystem stress at a scale that drew trademark conflict, account hijacks, and a crypto-scam pile-on within days. Every prevention tool that should have caught it existed; none operated at the speed the incident required.

**Numbers to verify before the short report.** 149,000 GitHub stars, 1.49M database records, $8M crypto scam, 10-second hijack window. Currently sourced from secondary reporting. We need to cross-check against the primary Unit 42 analysis.

**Sources.** Unit 42; Kaspersky; CyberNews; DEV Community timeline; Axios (news); Bitdefender.

### 4.2 curl bug bounty closure (2025) — *primary*

curl, maintained by Daniel Stenberg, ran a security bug bounty for years. Throughout 2025 it was overwhelmed by AI-generated "vulnerability" reports — well-written, plausible, almost entirely wrong. The valid-report rate dropped to **~5%**. At the start of 2026, Stenberg closed the program.

**Why it matters.** The LeadDev 12× asymmetry applied to security triage instead of code review. Reports used correct security vocabulary so they passed the surface check. curl tried stricter guidelines, templates, and published bad-submission examples; nothing worked. The case demonstrates the **absence** of solutions: no AI-aware triage tool, no reporter-reputation system, and no validation layer succeeded at a rate that preserved maintainer sanity.

**Sources.** The New Stack; LeadDev; All Things Open.

### 4.3 What the two cases tell us together

| Case | Cluster exercised | What existing solutions failed to do |
|---|---|---|
| Clawdbot / OpenClaw | Security + review + supply chain + ecosystem | Operate at the speed AI projects evolve |
| curl bug bounty | Review + shallow plausibility | Filter AI slop from real reports |

Both point to the same gap: **review, triage, and verification capacity has not kept pace with the rate at which AI is producing code, contributions, and agents.** That gap is the target of our Task 2 case study.

### 4.4 Cases we considered but cut from the draft

- **Ghostty (2025)** — open source terminal emulator that banned all AI-generated contributions in its contribution guidelines. Cut because it is essentially a one-line corollary to curl: same economics, smaller scale.
- **axios npm supply-chain compromise (March 31, 2026)** — malicious `axios@1.14.1` and `axios@0.30.4` packages published from a compromised maintainer account, delivering a cross-platform RAT via a pre-staged `plain-crypto-js@4.2.1` postinstall script. Microsoft Threat Intelligence attributed it to Sapphire Sleet (North Korean state actor). Cut because the root cause was a hijacked maintainer account, not AI-generated code, so the connection to our thesis required defensive framing that costs more space than the case is worth in a draft. Could come back in the Task 3 short report as the supply-chain illustration if there is room.

---

## Carried into Task 2
1. Quality drift: measurable duplication and churn growth.
2. Flat curve vulnerability rate: around 45% high severity, unchanged with model scale.
3. Review as the new bottleneck: volume outgrows capacity, shallow review becomes the norm.
4. Ecosystem stress: open source and shared supply chains absorb the highest cost.
