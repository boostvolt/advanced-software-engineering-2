# Literature Review

This review prioritizes **2025 and 2026** sources because the phenomena we study (open coding agents, the AI code review bottleneck, AI-generated supply-chain attacks) have evolved substantially since 2024. Earlier sources are included only where they provide essential baselines.

Each entry gives: *what the source is*, *the specific claim we use from it*, and *how it supports our argument*.

---

## A. Industry studies on AI code quality

### 1. GitClear — "AI Copilot Code Quality: 2025 Data Suggests 4x Growth in Code Clones"
- **What it is.** A longitudinal study of 211 million lines changed between 2020 and 2024, sampling from Google, Microsoft, Meta, and enterprise repositories. Published by GitClear (the team behind the 2024 "downward pressure on code quality" report).
- **Key findings we use.**
  - 4x increase in duplicated code blocks since 2020.
  - For the first time in the dataset, "copy/paste" exceeds "moved" (refactored) code.
  - "Moved lines" share dropped from 24.1% (2020) → 9.5% (2024).
  - Two-week churn rose from 5.5% → 7.9%.
  - Bill Harding's term: **"AI-induced tech debt"**.
- **Why it matters for us.** This is the strongest longitudinal evidence that AI adoption correlates with measurable code-quality degradation in real enterprise repositories, not just lab benchmarks. URL: https://www.gitclear.com/ai_assistant_code_quality_2025_research
- **Limitations.** Correlational, not causal. GitClear's methodology is proprietary and not peer-reviewed.

### 2. CMU 2025 study (as reported by Rob Bowley / Dec 2025)
- **What it is.** Carnegie Mellon study, late 2025, confirming GitClear's direction with an academic methodology.
- **Key finding we use.** Independent confirmation that AI adoption correlates with rising code churn and duplication.
- **Why it matters.** Adds an academic counterpart to GitClear's industry dataset.

### 3. LeadDev — "How AI Generated Code Accelerates Technical Debt" (2025)
- **What it is.** Practitioner-focused analysis by LeadDev based on interviews and review of industry data.
- **Key claim we use.** AI assistants systematically shift cost from *writing* to *maintaining*, with the mechanism being the erosion of refactoring discipline.
- **Why it matters.** Connects the GitClear numbers to a practitioner-level explanation of *why* it happens.

---

## B. Security studies

### 4. Veracode — "2025 GenAI Code Security Report" (October 2025 update)
- **What it is.** Analysis of 100+ large language models across Java, JavaScript, Python, and C#. The most comprehensive industry security study of generated code published in 2025.
- **Key findings we use.**
  - **45% of AI-generated code contains at least one high-severity vulnerability.**
  - Java is the riskiest language: **72% security failure rate**.
  - XSS defenses missing in **86%** of relevant code samples.
  - Security performance is **flat across model generations** — larger, newer models are not safer.
  - Functional correctness and security correctness have decoupled.
- **Why it matters.** This is the headline security number we use throughout the project. URL: https://www.veracode.com/resources/analyst-reports/2025-genai-code-security-report/
- **Limitations.** Benchmark-based; generated code was evaluated in test harnesses, not always in full project context.

### 5. Snyk — AI co-authored PR vulnerability data (2025)
- **What it is.** Pull-request telemetry from Snyk customers.
- **Key finding we use.** AI co-authored PRs contain **2.74x more vulnerabilities** than human-only PRs.
- **Why it matters.** Real production PR data (not benchmarks), complementing Veracode's benchmark numbers.

### 6. CodeRabbit — "State of AI vs Human Code Generation" (2025)
- **What it is.** Analysis of 470 PRs comparing AI-authored and human-authored changes.
- **Key findings we use.**
  - AI PRs produced 10.83 issues per PR vs 6.45 for human PRs.
  - Critical issues up ~40% in AI PRs.
  - Major issues up ~70% in AI PRs.
- **Why it matters.** Ties severity distribution to authorship and supports our "shallow review misses AI's specific failure modes" argument.

### 7. Microsoft Security / Unit 42 / Arctic Wolf / Snyk — axios npm compromise reporting (March–April 2026)
- **What it is.** Coordinated incident reporting on the March 31, 2026 axios npm supply-chain attack.
- **Key facts we use.**
  - Malicious versions `axios@1.14.1` and `axios@0.30.4` published via compromised maintainer account.
  - Pre-staged malicious dependency `plain-crypto-js@4.2.1` delivered a cross-platform RAT via postinstall script.
  - Microsoft Threat Intelligence attribution: **Sapphire Sleet** (North Korean state actor).
  - axios is a transitive dependency in "millions of applications" — 70M+ weekly downloads.
- **Why it matters.** Canonical recent example of how a single compromised package ripples through an AI-accelerated ecosystem. See `use-cases.md` for the full treatment.
- **Sources.** Microsoft Security Blog, Unit 42 Threat Brief, SANS ISC, Arctic Wolf, Snyk, StepSecurity, The Hacker News, SiliconANGLE.

---

## C. Code review bottleneck studies

### 8. Faros AI — "Key Takeaways from the DORA Report 2025"
- **What it is.** Faros AI's analysis of 10,000+ developers, cross-referenced with the 2025 DORA report findings.
- **Key findings we use.**
  - 98% increase in PR volume post-AI adoption.
  - 91% increase in review time per PR.
  - 18% increase in PR size.
  - 21% more tasks completed per developer.
- **Why it matters.** The clearest quantification of the review bottleneck shift. URL: https://www.faros.ai/blog/key-takeaways-from-the-dora-report-2025

### 9. DORA 2025 — "State of AI-Assisted Software Development" (Google Cloud)
- **What it is.** The 2025 edition of the DORA report, focused entirely on AI-assisted software development. Survey-based, published late 2025.
- **Key findings we use.**
  - 90% AI adoption among software professionals; median 2 hours/day of AI use.
  - Central thesis: **"AI amplifies what is already there"** — strong teams benefit, weak teams degrade.
  - AI adoption has a negative relationship with software delivery *stability*.
  - Seven team archetypes, each with different AI response patterns.
  - DORA AI Capabilities Model — 90% of orgs have adopted at least one platform; platform quality correlates with AI benefit capture.
- **Why it matters.** The closest thing to an authoritative industry baseline. Its nuanced framing ("amplifier, not uniform force") shapes the core argument in `motivations.md`. URL: https://dora.dev/research/2025/dora-report/

### 10. LogRocket — "Why AI Coding Tools Shift the Real Bottleneck to Review" (2025)
- **What it is.** Practitioner-focused blog post consolidating the bottleneck-shift argument.
- **Key claim we use.** "If your team adopts AI coding tools without restructuring how code review works, expect *slower* releases, not faster ones." Senior engineers spend 4.3 minutes reviewing AI suggestions vs. 1.2 minutes for human-written code.
- **Why it matters.** Direct, quotable framing of the bottleneck inversion.

### 11. Logilica — "The Shifting Bottleneck Conundrum" (2025)
- **What it is.** Engineering-metrics vendor analysis. Parallel evidence to LogRocket.

### 12. Help Net Security / CodeRabbit — "AI Code Looks Fine Until the Review Starts" (Dec 2025)
- **What it is.** Coverage of CodeRabbit's AI-assisted PR report.
- **Key claim.** AI code passes superficial review but fails deeper analysis — supporting the "reviewer fatigue → shallow review" argument.

---

## D. Open source and ecosystem impact

### 13. The New Stack — "96% of codebases rely on open source, and AI slop is putting them at risk" (2025)
- **What it is.** Reporting on the AI slop crisis in open-source ecosystems.
- **Key facts we use.**
  - 96% of modern codebases depend on open-source components.
  - 60% of OSS maintainers are unpaid volunteers.
  - curl closed its bug bounty program after valid-report rate fell to ~5%.

### 14. LeadDev — "Open Source Has a Big AI Slop Problem" (2025)
- **What it is.** Long-form feature on maintainer burnout from AI-generated contributions.
- **Key claim.** **"It takes a reviewer 12 times longer to review and correct a pull request than to generate one with AI."**
- **Why it matters.** The single most quotable line on the maintainer economic problem.

### 15. All Things Open — "The AI Slop Problem Threatening Open Source Maintainers" (2025)
- **What it is.** Community-facing analysis of specific projects hit hardest (curl, Ghostty).

### 16. GitHub Blog — "What to Expect for Open Source in 2026"
- **What it is.** GitHub's own projection of how AI will reshape open-source contribution norms in 2026.
- **Key claim.** GitHub is evaluating restrictions on pull requests as a systemic response.

### 17. The Register — "GitHub Ponders Kill Switch for Pull Requests to Stop AI Slop" (Feb 2026)
- **What it is.** News coverage of GitHub's internal deliberations on disabling or restricting PR functionality.
- **Why it matters.** Concrete sign that ecosystem-level responses are being seriously considered.

### 18. Open Source For You — "GitHub Weighs Pull Request Kill Switch As AI Slop Floods Open Source" (Feb 2026)
- Parallel reporting on the same GitHub kill-switch discussion.

### 19. CodeRabbit — "AI Is Burning Out the People Who Keep Open Source Alive"
- **What it is.** Long-form analysis of the maintainer mental-health dimension of AI slop.

### 20. ITPro — "Big Tech Is Clamping Down on Open Source 'AI Slop' Reports"
- **Key fact.** OpenAI, Anthropic, AWS, Google, Microsoft and GitHub have committed $12.5M to Alpha-Omega / OpenSSF to eliminate AI slop bug reports.

---

## E. The Clawdbot / Moltbot / OpenClaw incident (late 2025 – early 2026)
This incident is significant enough that we treat it as its own case in `use-cases.md`. Key sources:

### 21. Palo Alto Networks (Unit 42) — "OpenClaw (formerly Moltbot, Clawdbot) May Signal the Next AI Security Crisis"
- Security-vendor analysis of the architectural risks.

### 22. Kaspersky — "Key OpenClaw risks, Clawdbot, Moltbot"
- Enterprise risk management framing.

### 23. CyberNews — "AI Agent Tried to Ruin Developer's Reputation Just Because He Said No"
- Incident report on agent-driven harassment behavior.

### 24. DEV Community — "From Clawdbot to Moltbot: How a C&D, Crypto Scammers, and 10 Seconds of Chaos Took Down the Internet's Hottest AI Project"
- Timeline and social-engineering dimension.

### 25. Axios (news outlet) — Reporting that hundreds of Moltbot control interfaces were left accessible on the open internet, exposing chat logs, API keys, and remote command execution capability. Confirmed independently by Bitdefender.

---

## F. Academic baselines (pre-2025) referenced for context only
- Perry, D. et al. — "Do Users Write More Insecure Code with AI Assistants?" (Stanford, 2023). Early academic evidence that AI assistant users produce more insecure code while believing the opposite.
- GitClear 2024 — "Coding on Copilot: 2023 Data Suggests Downward Pressure on Code Quality" — the precursor to the 2025 report; establishes the multi-year trend line.

---

## Synthesis

Taken together, the 2025–2026 literature supports a consistent four-part story:

1. **Quality.** AI-generated code is measurably more duplicated, churned, and less refactored than pre-AI code — and the effect has grown year over year (GitClear, CMU, LeadDev).
2. **Security.** ~45% of AI-generated code has high-severity vulnerabilities; AI PRs contain 2.74x more vulns than human PRs; this hasn't improved with model scale (Veracode, Snyk, CodeRabbit).
3. **Review.** Review capacity is the new bottleneck — PR volume up 98%, review time up 91% (Faros, DORA 2025, LogRocket).
4. **Ecosystem.** Open-source is bearing the brunt; several high-profile projects have made extreme defensive responses (curl, Ghostty, GitHub's kill-switch deliberation), and $12.5M of industry funding is being directed at the slop problem (LeadDev, The New Stack, The Register, ITPro).

These four threads define the problem space Task 2 will probe with a concrete case study.
