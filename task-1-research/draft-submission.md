# The Effects of AI Assisted Software Engineering on Code Quality and Security


## Topic & Motivation
We study how AI coding assistants affect code quality and security in real projects. AI made writing code cheap but not checking it, so the bottleneck is moving from writing to reviewing. DORA 2025 says most software professionals use AI daily. Each of us has shipped AI code that got caught too late, so the question is personal as well as academic.

Teams that adopt AI ship more code than reviewer capacity can handle. A large share of AI generated code has high severity vulnerabilities, and that has not improved as the AI gets bigger. Code clones are growing year over year. And reviewers do not catch the difference: a peer reviewed CHI study from 2023 (Kabir et al.) found that ChatGPT users accept incorrect programming answers often. The bad code gets produced faster than the people meant to catch it can keep up.

### Challenge 1: Quality and security drift
The first kind of failure: what AI puts into the codebase is buggier and more duplicated than what it replaced.

- *Struggle.* **Clawdbot / OpenClaw (Nov 2025 to Feb 2026).** Viral open source AI agent project, renamed twice in four days, GitHub organisation hijacked by crypto scammers, large database exposed. The code shipped with open control interfaces and exposed credentials, and viral growth meant nobody had time to fix it. Every prevention tool that should have caught it already existed. None operated at the speed required.
- *Proposed solution.* **GitHub Dependabot at scale.** Octoverse 2025 says that across 2.66 million repositories with Dependabot enabled, automated dependency vulnerability fix times collapsed from 200 to 300 days down to 30 to 50 days. Not a fix for the original AI generated bugs, but a working example of automation closing a security gap at scale.

### Challenge 2: Review cannot keep up
The second kind of failure: even when bad code is produced, the people meant to catch it are buried in volume. Open source maintainers are hit hardest, and this is how the bad code reaches production. 
Octoverse 2024 says pull request rejection rates did not rise that year. Our guess: rejection rates stay flat when maintainers stop reviewing carefully, so the better metric is reviewer effort per PR.

- *Struggle.* **curl bug bounty closure (2025).** Daniel Stenberg shut down curl's bug bounty after AI generated "vulnerability" reports drowned the program. Producing AI output was cheap, triaging it was not. curl tried stricter guidelines, templates, and bad submission examples. None of it worked.
- *Proposed solution.* **Google's internal review tooling.** Google's code review tool Critique reports 97% engineer satisfaction. They have layered ML on top: an AutoCommenter trained on around 3 billion examples to flag best practice violations, and a "critic" feature in their Jules coding assistant that critiques AI generated code while it is being produced. Code authors at Google now apply ML suggested edits to about 7.5% of all reviewer comments, which is meaningful at Google's scale.
