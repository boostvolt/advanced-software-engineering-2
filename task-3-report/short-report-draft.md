# The Effects of AI Assisted Software Engineering on Code Quality and Security

## Topic & Motivation
We study how AI coding assistants affect code quality and security in real projects. AI made writing code cheap, but checking it is not. A large share of AI generated code still has high severity vulnerabilities, and that has not significantly improved as the tools get better [1]. Teams that adopt AI ship more code than reviewer capacity can handle, so the bottleneck is moving from writing to reviewing [2].

### Challenge 1: Quality and security drift
What AI puts into the codebase is buggier and more duplicated than what it replaced [3, 4]. We found two independent cases in the industry:

- (*Failure case*) **Clawdbot / OpenClaw** Viral open source AI agent project. Their GitHub organisation hijacked by crypto scammers and a large database was exposed. The code shipped with open control interfaces and exposed credentials, and viral growth meant nobody had time to fix it. Every prevention tool that should have caught it already existed, but none operated at the speed required [5, 6].
- (*Working case*) **GitHub Dependabot at scale.** Github Octoverse 2025 says that across 2.66 million repositories with Dependabot enabled, automated dependency vulnerability fix times collapsed from 200 to 300 days down to 30 to 50 days [7]. A working example of automation closing a security gap at scale.

### Challenge 2: Review cannot keep up
These quality problems get worse because review cannot keep up. When bad code is produced, the people meant to catch it are buried in volume [2]. Open source maintainers are hit hardest, and this is how the bad code reaches production. We found two independent cases in the industry:

- (*Failure case*) **curl bug bounty closure (2025).** curl had a bug report program where people could report security bugs for a reward. The program got flooded with AI generated reports that sounded professional but were almost all wrong. The maintainer tried adding stricter rules and examples of what not to submit, but nothing helped, so he shut the program down entirely [2, 8].
- (*Working case*) **Google's internal review tooling.** Google's code review tooling reports 97% engineer satisfaction. They have layered ML on top: an AutoCommenter trained on around 3 billion examples to flag best practice violations, and a "critic" feature in their Jules coding assistant that critiques AI generated code while it is being produced [9].

### Discussion

Both working cases only cover part of their challenge. Dependabot fixes known dependency vulnerabilities, but the Clawdbot case was exposed credentials and open interfaces, things no dependency scanner would catch. Google's review tooling shows what automation can do, but it depends on Google's scale, something a one person project like curl cannot replicate. No single solution covers a whole challenge on its own, and the ones that exist require resources the projects most at risk do not have. This is what we want to explore further in Task 2.

### Literature

[1] Veracode, *2025 GenAI Code Security Report* (2025). Vulnerability rates across 100+ LLMs. https://www.veracode.com/resources/analyst-reports/2025-genai-code-security-report/

[2] LeadDev, *Open Source Has a Big AI Slop Problem* (2025). 12x reviewer asymmetry. https://leaddev.com/software-quality/open-source-has-a-big-ai-slop-problem

[3] GitClear, *AI Copilot Code Quality: 2025 Data Suggests 4x Growth in Code Clones* (2025). Code duplication trends across 211M changed lines. https://www.gitclear.com/ai_assistant_code_quality_2025_research

[4] Snyk, *AI Co Authored Pull Request Vulnerability Analysis* (2025). 2.74x more vulnerabilities in AI co authored PRs.

[5] Palo Alto Networks Unit 42, *OpenClaw May Signal the Next AI Security Crisis* (2026). Clawdbot security analysis. https://www.paloaltonetworks.com/blog/network-security/why-moltbot-may-signal-ai-crisis/

[6] Sivaram, P.G., *From Clawdbot to Moltbot* (2026). DEV Community. Clawdbot incident timeline. https://dev.to/sivarampg/from-clawdbot-to-moltbot-how-a-cd-crypto-scammers-and-10-seconds-of-chaos-took-down-the-4eck

[7] GitHub, *Octoverse 2025* (2025). Dependabot adoption and fix time data. https://github.blog/news-insights/octoverse/octoverse-a-new-developer-joins-github-every-second-as-ai-leads-typescript-to-1/

[8] The New Stack, *96% of Codebases Rely on Open Source, and AI Slop Is Putting Them at Risk* (2025). curl bug bounty context. https://thenewstack.io/ai-slop-open-source/

[9] Engineer's Codex, *How Google Takes the Pain Out of Code Reviews, with 97% Dev Satisfaction* (2025). Google Critique, AutoCommenter, Jules critic. https://read.engineerscodex.com/p/how-google-takes-the-pain-out-of
