# Literature Review

Annotated source list for the Task 1 draft and the upcoming Task 3 short report. Each entry gives what the source is, the specific claim we use it for, the methodology caveat, and the reasoning behind the verdict. Sources we evaluated but rejected are listed at the end with one-line reasons. Full BibTeX in `references/bibliography.bib`.

We prioritise **2025 and 2026 sources** because the phenomena we study (the code quality and security effects of AI coding assistants, and the review bottleneck they create) have evolved substantially since 2024. Earlier sources are kept only as essential anchors.

---

## A. Code quality

**GitClear (2025) — *AI Copilot Code Quality: 2025 Data Suggests 4x Growth in Code Clones***
Longitudinal study of 211M changed lines (2020–2024) across Google, Microsoft, Meta and enterprise repos.
- 4x increase in cloned blocks; copy/paste exceeds "moved" (refactored) code for the first time.
- Moved-lines share dropped from 24.1% (2020) to 9.5% (2024).
- Two-week churn: 5.5% to 7.9%. Bill Harding's term: **"AI-induced tech debt"**.
- Limitations: correlational, proprietary methodology, not peer-reviewed.
- URL: https://www.gitclear.com/ai_assistant_code_quality_2025_research

## B. Code security

**Veracode (2025) — *2025 GenAI Code Security Report*** *(headline source)*
Evaluation of 100+ LLMs across Java, JavaScript, Python, C#.
- **45% of AI-generated code contains at least one high-severity vulnerability.**
- Java is the riskiest language (72% security failure rate).
- XSS defenses missing in 86% of relevant samples.
- **Security performance is flat across model generations** — bigger models are not safer.
- URL: https://www.veracode.com/resources/analyst-reports/2025-genai-code-security-report/

## C. Code review and delivery metrics

**Google Cloud DORA (2025) — *State of AI-Assisted Software Development***
- 90% AI adoption among software professionals; median 2 hours/day of AI use.
- Central thesis: **"AI amplifies what is already there"** — strong teams benefit, weak teams degrade.
- AI adoption has a *negative* relationship with software delivery stability.
- Caveat: we are reading this through summaries (InfoQ). We need to read the full report before the Task 3 short report.
- URL: https://dora.dev/research/2025/dora-report/

## D. Academic / human factors

**Kabir, Udo-Imeh, Kou, Zhang (2024) — *Is Stack Overflow Obsolete? An Empirical Study of the Characteristics of ChatGPT Answers to Stack Overflow Questions*** (CHI 2024)
Peer-reviewed academic paper. The only peer-reviewed source we currently lean on. Evaluated 517 programming questions.
- 52% of ChatGPT answers contain incorrect information.
- 77% of answers are verbose.
- Despite this, users still preferred ChatGPT answers 35% of the time and overlooked the misinformation 39% of the time.
- Why we cite it: explains the *human* mechanism behind why insecure AI code reaches production. Pairs with DORA's "AI amplifies" framing — humans accept AI output too easily, so weak teams degrade faster.
- URL: https://arxiv.org/pdf/2308.02312

## E. Adoption baseline and proposed solution (Dependabot)

**GitHub Octoverse 2025 — *A New Developer Joins GitHub Every Second as AI Leads TypeScript to #1***
We use this source for two separate claims:
- **Adoption baseline.** 180M+ developers on GitHub; 36M joined in 2025 alone. Nearly 80% of new developers use GitHub Copilot in their first week. Sharper "AI is the default for new developers" framing than DORA's 90% number — it shows AI is the *first* thing junior developers learn, not something they migrate to.
- **Proposed solution for quality and security drift (Dependabot).** Across 2.66 million repositories with Dependabot enabled, automated dependency vulnerability fix times collapsed from 200–300 days down to 30–50 days. Used in the draft as the proposed-solution case under Challenge 1, and as an honest qualifier to our mostly negative security framing.
- URL: https://github.blog/news-insights/octoverse/octoverse-a-new-developer-joins-github-every-second-as-ai-leads-typescript-to-1/

## F. Open source ecosystem

**The New Stack (2025) — *96% of Codebases Rely on Open Source, and AI Slop Is Putting Them at Risk***
- 96% of modern codebases depend on open-source components.
- 60% of OSS maintainers are unpaid volunteers.
- curl closed its bug bounty after the valid-report rate fell to ~5%.

**LeadDev (2025) — *Open Source Has a Big AI Slop Problem***
Source of the most quoted line on the maintainer economics: **"it takes a reviewer 12 times longer to review and correct a pull request than to generate one with AI."**

## G. Incident reporting (Clawdbot / OpenClaw)

Primary sources we lean on:
- **Palo Alto Networks Unit 42** — security analysis, the most authoritative source.
- **DEV Community timeline post** — most complete narrative reconstruction of the rename / hijack / cascade week.

Secondary corroborating sources (Kaspersky, CyberNews, Axios news outlet, Bitdefender) are supporting context only.

## H. Proposed solution for review bottleneck (Google)

**Google's internal review tooling (Critique + AutoCommenter + Jules critic)**
- Google's code review tool Critique reports 97% engineer satisfaction.
- AutoCommenter: ML system trained on around 3 billion examples to flag best practice violations during review.
- Jules "critic" feature: critiques AI generated code while it is being produced, catching issues before review.
- Used in the draft as the proposed-solution case under Challenge 2.
- Source: Engineer's Codex, *How Google Takes the Pain Out of Code Reviews, with 97% Dev Satisfaction* (2025). URL: https://read.engineerscodex.com/p/how-google-takes-the-pain-out-of

---

## Borderline calls — candidates for Task 3, not in the current draft

These were evaluated and judged useful enough to revisit when expanding the draft into the short report.

**Gartner (2025) — *Top Strategic Trends in Software Engineering for 2025 and Beyond***
Introduces **"AI-Native Software Engineering"** and projects 90% of enterprise engineers will use AI assistants by 2028 (up from <14% in early 2024). Pair with DORA: Gartner predicted rapid adoption, DORA confirmed it has already happened. Useful jargon ("AI-Native SWE") for the short report.
URL: https://www.gartner.com/en/newsroom/press-releases/2025-07-01-gartner-identifies-the-top-strategic-trends-in-software-engineering-for-2025-and-beyond

**Peng et al. (2023) — *The Impact of AI on Developer Productivity: Evidence from GitHub Copilot*** (arxiv 2302.06590)
The headline 55.8% speedup study. Cite *exactly once* as a foil: "the most cited number on AI assisted coding measures task completion time only, not whether the resulting code is maintainable or secure." Funded by GitHub — call out the vendor tie when citing.
URL: https://arxiv.org/pdf/2302.06590

**Deloitte (2026) — *Global Software Industry Outlook***
Adds the *offensive* security dimension our thread is missing: in late 2025 attackers used jailbroken AI tools to run attacks where 80–90% of the agentic chain was conducted with no human involvement. One sentence in the security section would round out the picture.
URL: https://www.deloitte.com/us/en/insights/industry/technology/technology-media-telecom-outlooks/software-industry-outlook.html

**Bloomberg (May 2023) — *Samsung Bans ChatGPT and Other Generative AI Use by Staff After Leak***
Historical anchor. Samsung engineers pasted proprietary semiconductor source three times in three weeks; Samsung banned generative AI on company devices. Predates our 2025–2026 focus window but strengthens the argument that the security concerns are not new — they are an old known problem the industry has not solved. PCMag covers the same incident as a corroborating outlet.
URLs: https://www.bloomberg.com/news/articles/2023-05-02/samsung-bans-chatgpt-and-other-generative-ai-use-by-staff-after-leak · https://www.pcmag.com/news/samsung-bans-chatgpt-after-engineers-use-it-to-fix-proprietary-code

---

## Sources we evaluated and rejected

These came up during research but are not load-bearing.

| Source | Reason rejected |
|---|---|
| Faros AI (2025) | Vendor blog summarising DORA — redundant once we cite DORA directly |
| CodeRabbit (2025) 470 PR study | Vendor PR study, less authority than Veracode for the same point |
| LogRocket (2025) | Practitioner blog, no primary data |
| Help Net Security / CodeRabbit (Dec 2025) | Same |
| All Things Open (2025) | Covers the same incidents as The New Stack and LeadDev |
| ITPro (2026) on the $12.5M OpenSSF pledge | We don't cite the pledge in the body any more |
| CMU study (Dec 2025) via Bowley blog | We never read the original paper |
| LeadDev (2025) "How AI Generated Code Accelerates Technical Debt" | Redundant with GitClear |
| Pragmatic Engineer (March 2026) "AI Tooling for Software Engineers in 2026" | Adoption data only — redundant with DORA and Octoverse 2025 |
| Eventually Making (Feb 2026) | Practitioner blog, no primary data |
| Baytech Consulting (2025) | Vendor pitch; the 91% figure traces back to Faros AI we already cite |
| Gartner "AI Agents Transforming Software Engineering" | Too generic — DORA already covers the consensus framing |
| PCMag Samsung coverage (2023) | Secondary outlet for the same incident Bloomberg covered (kept as corroborator above) |

## Sources we still want to read before the short report

- **Perry et al. (CCS 2023, Stanford) — *Do Users Write More Insecure Code with AI Assistants?*** The classic academic baseline. Citing it without having read the original is the kind of thing a sharp lecturer might call out, so we are deferring it until we read the paper.
- **The full DORA 2025 report.** We are currently working from summaries.

---

## Synthesis
Five threads converge across the literature we are using:

1. **Quality is drifting down** (GitClear).
2. **Security is flat at a bad baseline** — ~45%, unchanged with model scale; AI generated code carries 2.74x more vulnerabilities than human written code (Veracode).
3. **Humans accept wrong AI output** — the mechanism by which the bad baseline reaches production (Kabir et al.).
4. **Review is the new bottleneck** (DORA).
5. **Open source absorbs the largest share of the cost** (LeadDev, The New Stack, The Register).

These define the problem space Task 2 will probe with a hands-on case study.
