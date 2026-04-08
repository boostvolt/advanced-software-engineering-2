# Motivations

## Why this topic matters right now
Between 2023 and 2026 AI coding assistants moved from novelty to default. The 2025 DORA report finds that **90% of software professionals now use AI in their daily work**, spending a median of two hours per day with it [DORA 2025]. GitHub Copilot, Cursor, Claude Code and autonomous agents are no longer experiments — they generate a meaningful share of the code shipped to production every day.

The industry debate has shifted accordingly. The question is no longer *"should we adopt AI coding assistants?"* but *"what is the true cost of the code they produce, and can our review and security processes keep up?"*. Three forces make this question urgent:

### 1. The code-review bottleneck is now the dominant constraint
The economics of software delivery have been inverted. Generating a pull request is cheap; reviewing it is not. Faros AI's 2025 analysis of 10,000+ developers measured a **98% increase in pull-request volume** alongside a **91% increase in review time per PR**, with PRs 18% larger on average [Faros 2025]. LogRocket and Logilica independently report the same pattern: the bottleneck has shifted from writing code to reviewing it, and teams that fail to restructure review capacity see *slower* releases despite faster generation [LogRocket 2025].

One developer in the All Things Open / LeadDev coverage summarized it bluntly: **"it takes a reviewer 12 times longer to review and correct a pull request than to generate one with AI"** [LeadDev 2025]. When the cost of producing work drops to zero while the cost of evaluation stays constant, the evaluator becomes the system's limiter.

### 2. AI-generated code carries measurable quality and security debt
- **Quality.** GitClear's 2025 study of 211 million changed lines across Google, Microsoft, Meta and enterprise repositories documents a **4x increase in code cloning** since 2020, with "copy/paste" exceeding "moved" (refactored) code for the first time in the dataset's history. Two-week churn rose from 5.5% (2020) to 7.9% (2024) [GitClear 2025]. A December 2025 CMU study reinforces the trend.
- **Security.** Veracode's 2025 GenAI Code Security Report — covering 100+ LLMs across Java, JavaScript, Python and C# — found **45% of AI-generated code contained at least one high-severity vulnerability**, with Java failing 72% of security tasks and XSS defenses missing in 86% of relevant samples [Veracode 2025]. Snyk's pull-request data shows **AI co-authored PRs contain 2.74x more vulnerabilities than human-only PRs** [Snyk 2025]. Critically, Veracode notes that as models have become better at *functional* correctness, security performance has **remained flat** — bigger models are not safer models.

### 3. Open-source maintainers are being overrun
The pressure is not evenly distributed. Open-source projects — 60% maintained by unpaid volunteers — are absorbing the largest share of the AI-generated content flood. "AI slop" was Macquarie Dictionary's 2025 word of the year. High-profile responses in late 2025 / early 2026:
- **curl** closed its bug bounty program after valid AI-submitted reports dropped to ~5% [The New Stack 2025; LeadDev 2025].
- **Ghostty** banned AI-generated contributions outright because subtle-but-wrong PRs were destroying reviewer throughput.
- **GitHub** is reportedly evaluating a "kill switch" to disable pull requests or restrict them to trusted contributors [The Register 2026].
- A $12.5M pledge from OpenAI, Anthropic, AWS, Google, Microsoft and GitHub was announced to fund Alpha-Omega / OSSF work on eliminating AI slop bug reports.

## Why our team cares
Each of the three of us has hit this wall in small ways: AI output that looks correct and saves time in the moment, but that our reviewers flag, our linters reject, or our tests discover too late. The question behind the project is personal: **what does it actually take to make AI-assisted development safe and maintainable, and are the tools we have today enough?** Task 2 is our attempt to answer that concretely, not by trusting vendor claims but by running a solution against an open-source codebase ourselves.

## Stake in the broader conversation
This is not a "is AI good or bad for code" project. Both the DORA 2025 report and the Veracode report make the same nuanced point from different angles: **AI amplifies what is already there.** Strong teams with mature review and security practices get stronger; weak teams accumulate debt and vulnerabilities faster than before. Our contribution is to study where the amplification tips into damage, and which interventions meaningfully change the slope.
