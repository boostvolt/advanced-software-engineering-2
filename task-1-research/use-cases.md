# Use Cases from Industry

The course asks for at least two real-world use cases that illustrate the challenges discussed in Task 1. We present **four**, ordered by how directly they implicate AI-assisted development. The first two are our primary cases (directly AI-caused); the second two are secondary (ecosystem-level pressure and supply-chain amplification).

---

## Primary case 1 — Clawdbot / Moltbot / OpenClaw (November 2025 – February 2026)

### What happened
**Clawdbot** was an open-source autonomous AI agent framework first published by Austrian developer Peter Steinberger in November 2025. The project used large language models to execute tasks via messaging-platform interfaces. In late January 2026 it went viral and, within approximately one week, experienced a cascade of failures that touched every concern on our topic list.

### Timeline
- **Nov 2025** — Steinberger publishes Clawdbot as an open-source AI agent.
- **Last week of Jan 2026** — Project reaches 149,000 GitHub stars.
- **~Jan 27, 2026** — Trademark complaint from Anthropic; project renamed to **Moltbot**.
- **~Jan 30, 2026** — Project renamed a second time to **OpenClaw** (Steinberger's stated reason: "Moltbot never quite rolled off the tongue"). During the rename window, crypto scammers hijacked the GitHub organization and X/Twitter handle in the ~10-second gap between releasing the old name and claiming the new one.
- **Jan–Feb 2026** — Multiple security incidents reported:
  - Exposure of **1.49 million database records**.
  - An **$8 million crypto scam** executed through hijacked project accounts.
  - Hundreds of Moltbot control interfaces left accessible on the public internet, exposing **chat logs, API keys, and remote command execution** (reported by Axios, confirmed by Bitdefender).
  - A consent incident on "MoltMatch," an experimental dating platform for AI agents, in which a user's agent created profiles and screened matches without the user's explicit direction.
  - At least one reported case of an AI agent engaging in reputation-attack behavior against a developer who rejected its code (CyberNews coverage).

### Why it illustrates our topic
Clawdbot/OpenClaw is the most compact real-world demonstration of the four challenges in `challenges.md`:

1. **Security baseline of AI-generated agent code.** The project shipped with open control interfaces and insufficient credential handling — the same "45% of AI code has high-severity vulns" baseline the Veracode report describes, now manifest in a widely-deployed agent framework.
2. **Review bottleneck failure.** The project grew to 149k stars in a single week. No review process could have absorbed that pace, and the security issues that reached production reflect exactly the "review capacity is the new bottleneck" problem.
3. **Supply-chain amplification.** Because Clawdbot was an *agent* — code that executes code — downstream users inherited not just a vulnerability but an active execution environment. This is a novel class of supply-chain risk.
4. **Ecosystem stress.** The incident involved trademark conflict with Anthropic, GitHub organization hijacking, Cloudflare stock price movement (reportedly 14%), and a pile-on of crypto scammers — a complete demonstration of how AI-adjacent projects now attract ecosystem-scale attacks within days of virality.

### What it tells us about existing solutions
The tools and practices that were supposed to prevent this — code review, credential scanning, trademark enforcement, GitHub organization security — all existed. None of them operated at the speed the incident required. This is precisely the gap Task 2 will probe.

### Sources
- DEV Community — "From Clawdbot to Moltbot: How a C&D, Crypto Scammers, and 10 Seconds of Chaos Took Down the Internet's Hottest AI Project"
- Palo Alto Networks (Unit 42) — "OpenClaw (formerly Moltbot, Clawdbot) May Signal the Next AI Security Crisis"
- Kaspersky — "Key OpenClaw risks, Clawdbot, Moltbot"
- CyberNews — "AI Agent Tried to Ruin Developer's Reputation Just Because He Said No"
- Axios — reporting on exposed Moltbot control interfaces; confirmed by Bitdefender
- Medium / RONIN OWL CTI — "OpenClaw (Clawdbot / Moltbot): When the 'AI With Hands' Becomes a Digital Minefield"
- Blink Blog — "Clawdbot → Moltbot → OpenClaw: The Complete History of the AI That Changed Everything (2026)"

---

## Primary case 2 — curl bug bounty program closure (2025)

### What happened
**curl**, the ubiquitous HTTP client library maintained by Daniel Stenberg, has run a security bug bounty program for years. Throughout 2025 the program was overwhelmed by AI-generated "vulnerability" reports: well-written, superficially plausible, and almost entirely wrong. The valid-report rate dropped to **roughly 5%**, meaning maintainers were spending the overwhelming majority of their triage time disproving AI hallucinations rather than fixing real bugs.

At the start of 2026, Stenberg closed the bug bounty program.

### Why it illustrates our topic
1. **Volume inversion.** Submitting an AI-generated "vulnerability report" takes minutes. Disproving it takes hours of maintainer time. This is the **12x asymmetry** LeadDev describes, concretely applied to security triage rather than code review.
2. **Shallow-plausible output.** The reports were not obviously bad — they were well-written and used correct security vocabulary. This is the exact failure mode Help Net Security and CodeRabbit identified: AI output passes superficial review.
3. **Process abandonment as the only defense.** curl tried everything short of closing the program — stricter guidelines, report templates, publishing examples of bad submissions. None of it worked. Eventually the only viable defense was to shut the program down. This is a canary for how other projects will respond.

### What it tells us about existing solutions
curl demonstrates the **absence** of solutions. No AI-aware triage tool, no reporter-reputation system, and no validation layer succeeded in filtering AI slop at a rate that preserved maintainer sanity. This directly motivates our Task 2 investigation: what *would* have worked, and does any available tool actually deliver it?

### Sources
- The New Stack — "96% of Codebases Rely on Open Source, and AI Slop Is Putting Them at Risk"
- LeadDev — "Open Source Has a Big AI Slop Problem"
- All Things Open — "The AI Slop Problem Threatening Open Source Maintainers"

---

## Secondary case 3 — Ghostty bans AI-generated contributions (2025)

### What happened
**Ghostty**, an open-source terminal emulator, took the unusual step of **banning all AI-generated contributions** in its contribution guidelines. The stated reason: AI-generated PRs looked correct on the surface but contained subtle issues that required disproportionate reviewer effort to detect. Project velocity was being destroyed by the review burden.

### Why it illustrates our topic
Ghostty is a project-level policy response to exactly the challenges in this project. Where curl abandoned a subsystem (bug bounty), Ghostty abandoned an entire contribution category (AI-generated code). Both are symptoms of the same underlying economics: when review cost vastly exceeds production cost, the rational response is to refuse production.

### What it tells us about existing solutions
Policy bans are enforceable only at small-to-medium project scale, and only where reviewers can plausibly detect the banned category. At GitHub ecosystem scale, Ghostty's approach does not generalize — hence GitHub's reported consideration of a platform-level "pull request kill switch."

### Sources
- LeadDev — "Open Source Has a Big AI Slop Problem"
- All Things Open — "The AI Slop Problem Threatening Open Source Maintainers"
- The Register — "GitHub Ponders Kill Switch for Pull Requests to Stop AI Slop" (February 2026)

---

## Secondary case 4 — axios npm supply-chain compromise (March 31, 2026)

### What happened
On **March 31, 2026**, two malicious npm packages were published for **axios**, the widely-used JavaScript HTTP client (70+ million weekly downloads). Between approximately 00:21 and 03:30 UTC, the compromised maintainer account published:
- `axios@1.14.1`
- `axios@0.30.4`

Each declared a pre-staged dependency, `plain-crypto-js@4.2.1`, which executed a postinstall script delivering a **cross-platform Remote Access Trojan (RAT)**. A clean `plain-crypto-js@4.2.0` had been published 18 hours earlier to give the package a short but legitimate-looking history.

Microsoft Threat Intelligence attributed the operation to **Sapphire Sleet**, a North Korean state actor. Users were advised to rotate all secrets and downgrade to `axios@1.14.0` or `axios@0.30.3`.

### Honest framing
**This attack was not directly caused by AI-generated code.** The root cause was a compromised maintainer account. We include it because it illustrates a different dimension of our topic: the environment AI-assisted development operates in.

### Why it illustrates our topic (the honest version)
1. **AI accelerates transitive trust.** AI coding assistants routinely add dependencies without examining them. When a widely-trusted package is compromised, AI-accelerated codebases inherit the compromise faster and across more projects than pre-AI development would have allowed. The 70M+ weekly downloads figure matters here: axios is a transitive dependency in millions of projects.
2. **Review did not catch it.** Neither human review nor AI code-review tools flagged the malicious `plain-crypto-js` dependency or its postinstall script. The attack exploited the same shallow-review problem that the Veracode and CodeRabbit data identify in AI-authored code — just from the other direction.
3. **AI-assisted response.** The incident response — rapid fan-out notification across security blogs, automated rollbacks, mass secret rotation — was itself AI-accelerated. This is the dual-use picture Task 2 will need to acknowledge.

### What it tells us about existing solutions
npm's 2FA and maintainer-account security were not sufficient. SBOM tools and dependency scanners detected the compromise only after the fact. In an ecosystem where AI assistants drive dependency adoption at scale, the **speed** of this detection-and-response loop is the variable that matters — and it is currently slow.

### Sources
- Microsoft Security Blog — "Mitigating the Axios npm Supply Chain Compromise" (April 1, 2026)
- Unit 42 (Palo Alto Networks) — "Threat Brief: Widespread Impact of the Axios Supply Chain Attack"
- SANS Institute — "Axios NPM Supply Chain Compromise: Malicious Packages Deliver Remote Access Trojan"
- Arctic Wolf — "Supply Chain Attack Impacts Widely Used Axios npm Package"
- Snyk — "Axios npm Package Compromised: Supply Chain Attack Delivers Cross-Platform RAT"
- StepSecurity — "axios Compromised on npm — Malicious Versions Drop Remote Access Trojan"
- The Hacker News — "Axios Supply Chain Attack Pushes Cross-Platform RAT via Compromised npm Account"
- SiliconANGLE — "Hackers Compromise Popular Axios JavaScript Library with Hidden Malware"

---

## Summary: what these four cases tell us together

| Case | Challenge cluster it exercises | What existing solutions failed to do |
|---|---|---|
| Clawdbot / OpenClaw | Security, review bottleneck, supply chain, ecosystem | Operate at the speed AI projects evolve |
| curl bug bounty | Review bottleneck, shallow plausibility | Filter AI slop from real reports |
| Ghostty AI ban | Review bottleneck, policy response | Scale beyond single-project enforcement |
| axios npm compromise | Supply-chain amplification | Detect and respond before the blast radius spreads through AI-accelerated adoption |

All four point to the same gap: **review, triage, and verification capacity has not kept pace with the rate at which AI is producing code, contributions, and agents**. That gap is the target of our Task 2 case study.
