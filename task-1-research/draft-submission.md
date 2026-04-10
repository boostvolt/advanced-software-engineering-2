# The Effects of AI Assisted Software Engineering on Code Quality and Security


## Topic & Motivation
We study how AI coding assistants affect code quality and security in real projects. AI made writing code cheap, but checking it is not. A large share of AI generated code still has high severity vulnerabilities, and that has not significantly improved as the tools get better. Teams that adopt AI ship more code than reviewer capacity can handle, so the bottleneck is moving from writing to reviewing.

### Challenge 1: Quality and security drift
What AI puts into the codebase is buggier and more duplicated than what it replaced. For this challenge we found a struggle case and a proposed solution in the industry:

- (*Struggle*) **Clawdbot / OpenClaw** Viral open source AI agent project. Their GitHub organisation hijacked by crypto scammers and a large database was exposed. The code shipped with open control interfaces and exposed credentials, and viral growth meant nobody had time to fix it. Every prevention tool that should have caught it already existed, but none operated at the speed required.
- (*Proposed solution*) **GitHub Dependabot at scale.** Github Octoverse 2025 says that across 2.66 million repositories with Dependabot enabled, automated dependency vulnerability fix times collapsed from 200 to 300 days down to 30 to 50 days. A working example of automation closing a security gap at scale.

### Challenge 2: Review cannot keep up
When bad code is produced, the people meant to catch it are buried in volume. Open source maintainers are hit hardest, and this is how the bad code reaches production. For this challenge we found a struggle case and a proposed solution in the industry:

- (*Struggle*) **curl bug bounty closure (2025).** curl had a bug report program where people could report security bugs for a reward. The program got flooded with AI generated reports that sounded professional but were almost all wrong. The maintainer tried adding stricter rules and examples of what not to submit, but nothing helped, so he shut the program down entirely.
- (*Proposed solution*) **Google's internal review tooling.** Google's code review tooling reports 97% engineer satisfaction. They have layered ML on top: an AutoCommenter trained on around 3 billion examples to flag best practice violations, and a "critic" feature in their Jules coding assistant that critiques AI generated code while it is being produced.

### Discussion

Both solutions work but only cover part of their challenge. Dependabot fixes known dependency vulnerabilities, but the Clawdbot case was exposed credentials and open interfaces, things no dependency scanner would catch. Google's review tooling shows what automation can do, but it depends on Google's scale, something a one person project like curl cannot replicate. No single solution covers a whole challenge on its own, and the ones that exist require resources the projects most at risk do not have. This is what we want to explore further in Task 2.

